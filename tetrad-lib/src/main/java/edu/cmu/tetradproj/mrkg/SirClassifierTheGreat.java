package edu.cmu.tetradproj.mrkg;

import java.util.*;
import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.data.*;
import java.io.*;
import edu.cmu.tetrad.search.*;

/**
 * Created by user on 1/20/16.
 */
public class SirClassifierTheGreat {

    public SirClassifierTheGreat(){

    }

    public void getBICs(){
        try {

            String autisticStart = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Group_2/test_normal_ROI_data_spline_smooth_clean_";
            String typicalStart = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2/test_normal_ROI_data_spline_smooth_clean_";

            List<String> numbers = new ArrayList<>();
            numbers.add("001");
            numbers.add("002");
            numbers.add("003");
            numbers.add("004");
            numbers.add("005");
            numbers.add("006");
            numbers.add("007");
            numbers.add("008");
            numbers.add("009");
            numbers.add("010");
            numbers.add("011");
            numbers.add("012");
            numbers.add("013");
            numbers.add("014");
            numbers.add("015");
            numbers.add("016");
            numbers.add("017");
            numbers.add("018");
            numbers.add("019");
            numbers.add("020");
            numbers.add("021");
            numbers.add("022");
            numbers.add("023");
            numbers.add("024");
            numbers.add("025");

            List<Graph> autisticGraphs = new ArrayList<>();
            List<Graph> typicalGraphs = new ArrayList<>();

            List<Double> autisticBICs = new ArrayList<>();
            List<Double> typicalBICs = new ArrayList<>();

            Set<Edge> allEdges = new HashSet<>();

            Hashtable<Edge, List<Double>> autisticDeltaBICs = new Hashtable<>();
            Hashtable<Edge, List<Double>> typicalDeltaBICs = new Hashtable<>();

            String dataName;
            File dataFile;
            DataReader reader;
            DataSet data;
            PatternToDag dagSelect;
            Pattern pattern;
            Graph dag;

            Set<Edge> edges;
            Iterator<Edge> edgeIterator;
            double bic;
            double edgeBIC;

            Edge edge;

            Fgs fgs;

            Graph graph;
            Graph tempDAG;
            Graph singleEdge;
            List<Node> edgeNodes;
            Edge undirectedEdge;

            List<Double> tempList;

            for (int i = 0; i < 25; i++) {

                dataName = autisticStart + numbers.get(i) + ".txt";
                dataFile = new File(dataName);
                reader = new DataReader();
                data = reader.parseTabular(dataFile);
                fgs = new Fgs(data);
                fgs.setPenaltyDiscount(2.0);
                graph = fgs.search();

                pattern = new Pattern(graph);
                dagSelect = new PatternToDag(pattern);
                dag = dagSelect.patternToDagMeekRules();

                bic = fgs.scoreDag(dag);
                autisticBICs.add(bic);

                edges = dag.getEdges();
                edgeIterator = edges.iterator();

                while(edgeIterator.hasNext()){
                    edge = edgeIterator.next();
                    tempDAG = GraphUtils.emptyGraph(0);
                    tempDAG.transferNodesAndEdges(dag);

                   // System.out.println(tempDAG.toString());

                    tempDAG.removeEdge(edge);

                    edgeBIC = fgs.scoreDag(tempDAG);

                    edgeNodes = new ArrayList<>();
                    edgeNodes.add(edge.getNode1());
                    edgeNodes.add(edge.getNode2());

                    singleEdge = dag.subgraph(edgeNodes);
                    singleEdge = GraphUtils.undirectedGraph(singleEdge);

                  //  System.out.println(singleEdge.toString());

                    undirectedEdge = singleEdge.getEdge(edge.getNode1(), edge.getNode2());

                  //  System.out.println(undirectedEdge.toString());

                    if (autisticDeltaBICs.containsKey(undirectedEdge)){
                        tempList = autisticDeltaBICs.get(undirectedEdge);
                        tempList.add(bic - edgeBIC);
                    } else {
                        autisticDeltaBICs.put(undirectedEdge, new ArrayList<Double>());
                        tempList = autisticDeltaBICs.get(undirectedEdge);
                        tempList.add(bic - edgeBIC);
                    }

                }


                autisticGraphs.add(graph);

                graph = GraphUtils.undirectedGraph(graph);

                allEdges.addAll(graph.getEdges());
            }

            for (int i = 0; i < 19; i++) {

                dataName = typicalStart + numbers.get(i) + ".txt";
                dataFile = new File(dataName);
                reader = new DataReader();
                data = reader.parseTabular(dataFile);
                fgs = new Fgs(data);
                fgs.setPenaltyDiscount(2.0);
                graph = fgs.search();

                pattern = new Pattern(graph);
                dagSelect = new PatternToDag(pattern);
                dag = dagSelect.patternToDagMeekRules();

                bic = fgs.scoreDag(dag);
                typicalBICs.add(bic);

                edges = dag.getEdges();
                edgeIterator = edges.iterator();

                while(edgeIterator.hasNext()){
                    edge = edgeIterator.next();
                    tempDAG = GraphUtils.emptyGraph(0);
                    tempDAG.transferNodesAndEdges(dag);
                    tempDAG.removeEdge(edge);

                    edgeBIC = fgs.scoreDag(tempDAG);

                    edgeNodes = new ArrayList<>();
                    edgeNodes.add(edge.getNode1());
                    edgeNodes.add(edge.getNode2());

                    singleEdge = dag.subgraph(edgeNodes);
                    singleEdge = GraphUtils.undirectedGraph(singleEdge);
                    undirectedEdge = singleEdge.getEdge(edge.getNode1(), edge.getNode2());

                    if(typicalDeltaBICs.containsKey(undirectedEdge)){
                        tempList = typicalDeltaBICs.get(undirectedEdge);
                        tempList.add(bic - edgeBIC);
                    } else {
                        typicalDeltaBICs.put(undirectedEdge, new ArrayList<Double>());
                        tempList = typicalDeltaBICs.get(undirectedEdge);
                        tempList.add(bic - edgeBIC);
                    }
                }


                typicalGraphs.add(graph);

                graph = GraphUtils.undirectedGraph(graph);

                allEdges.addAll(graph.getEdges());
            }

            Iterator<Edge> allEdgeIterator = allEdges.iterator();
            FileWriter writer;
            BufferedWriter bufferedWriter;
            File bicFile;
            String bicFileName;

            while (allEdgeIterator.hasNext()){

                edge = allEdgeIterator.next();
                bicFileName = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2_Edge_BICs/Autistic/" + edge.getNode1().toString() + "___" + edge.getNode2().toString() + "_autistic_BICs.txt";
                bicFile = new File(bicFileName);

             //   System.out.println(bicFile.exists());

                writer = new FileWriter(bicFile);
                bufferedWriter = new BufferedWriter(writer);

                if (autisticDeltaBICs.containsKey(edge)){
                    tempList = autisticDeltaBICs.get(edge);
                    for (int i = 0; i < tempList.size(); i++){
                        bufferedWriter.write(Double.toString(tempList.get(i)) + "\n");
                    }
                } else {
                    bufferedWriter.write("\n");
                }

                bufferedWriter.flush();
                bufferedWriter.close();

                bicFileName = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2_Edge_BICs/Typical/" + edge.getNode1().toString() + "___" + edge.getNode2().toString() + "_typical_BICs.txt";
                bicFile = new File(bicFileName);

                writer = new FileWriter(bicFile);
                bufferedWriter = new BufferedWriter(writer);

                if (typicalDeltaBICs.containsKey(edge)){
                    tempList = typicalDeltaBICs.get(edge);
                    for (int i = 0; i < tempList.size(); i++){
                        bufferedWriter.write(Double.toString(tempList.get(i)) + "\n");
                    }
                } else {
                    bufferedWriter.write("\n");
                }

                bufferedWriter.flush();
                bufferedWriter.close();

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String...args){

        SirClassifierTheGreat pedro = new SirClassifierTheGreat();
        pedro.getBICs();
    }
}
