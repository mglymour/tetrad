package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.data.DataReader;
import edu.cmu.tetrad.data.DataSet;
import edu.cmu.tetrad.graph.Edge;
import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.graph.GraphUtils;
import edu.cmu.tetrad.search.Fgs;
import edu.cmu.tetrad.search.PatternToDag;

import java.io.*;
import java.util.*;

/**
 * Created by user on 2/10/16.
 */
public class DeltaBICsSingleDataset {

    public DeltaBICsSingleDataset(){

    }

    public void createDataset(){
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

            NodeEqualityMode.setEqualityMode(NodeEqualityMode.Type.NAME);

            String top150 = "/Users/user/Documents/FMRI/Tetrad/Top_150_graph.txt";
            File top150File = new File(top150);
            Graph top150Graph = GraphUtils.loadGraphTxt(top150File);

            List<Edge> top150Edges = new ArrayList<>();

            Set<Edge> top150EdgeSet = top150Graph.getEdges();

            Iterator<Edge> top150Iter = top150EdgeSet.iterator();

          /*  while (top150Iter.hasNext()){
                top150Edges.add(top150Iter.next());
            }*/

            Hashtable<Integer, Edge> idiot = new Hashtable<>();
            int num = 1;
            while (top150Iter.hasNext()){
                idiot.put(num, top150Iter.next());
                num++;
            }


            String edgeNumbering = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2_Edge_Numbering.txt";
            File edgeNumFile = new File(edgeNumbering);
            FileWriter edgeNumWriter = new FileWriter(edgeNumFile);
            BufferedWriter buffEdgeNumWriter = new BufferedWriter(edgeNumWriter);

            for(int i = 0; i < idiot.size(); i++){
                buffEdgeNumWriter.write(Integer.toString(i + 1) + "\t" + idiot.get(i+1).toString() + "\n");

            }

            buffEdgeNumWriter.flush();
            buffEdgeNumWriter.close();


            String dataName;
            File dataFile;
            DataReader reader;
            DataSet data;
            PatternToDag dagSelect;
            Pattern pattern;
            Graph dag;

            double bic;
            double edgeBIC;

            Fgs fgs;

            Graph graph;
            Graph tempDAG;
            Graph singleEdge;
            List<Node> edgeNodes;
            Edge undirectedEdge;

            String dataset = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2_Top_150_Edge_dBICs.txt";
            File datasetFile = new File(dataset);
            FileWriter datasetWriter = new FileWriter(datasetFile);
            BufferedWriter buffDatasetWriter = new BufferedWriter(datasetWriter);

            Hashtable<Edge, Double> graphTable;

            Iterator<Edge> edgeIterator;
            Set<Edge> graphEdges;

            Edge graphEdge;


            for (int i = 0; i < 25; i++){
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

                graphEdges = dag.getEdges();

                edgeIterator = graphEdges.iterator();

                graphTable = new Hashtable<>();

                while(edgeIterator.hasNext()){
                    graphEdge = edgeIterator.next();
                    edgeNodes = new ArrayList<>();
                    edgeNodes.add(graphEdge.getNode1());
                    edgeNodes.add(graphEdge.getNode2());

                    singleEdge = dag.subgraph(edgeNodes);
                    singleEdge = GraphUtils.undirectedGraph(singleEdge);
                    undirectedEdge = singleEdge.getEdge(graphEdge.getNode1(), graphEdge.getNode2());

                    if(top150EdgeSet.contains(undirectedEdge)){

                       // System.out.println("We made it!");
                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        edgeBIC = fgs.scoreDag(tempDAG);

                        graphTable.put(undirectedEdge, edgeBIC);
                    }
                }

                for (int j = 0; j < 150; j++){
                    if(graphTable.containsKey(idiot.get(j+1))){

                        System.out.println("We made it!");
                         buffDatasetWriter.write(Double.toString(bic - graphTable.get(idiot.get(j+1))) + "\t");
                    } else {
                        System.out.println("This sucks.");
                          buffDatasetWriter.write(Integer.toString(0) + "\t");
                    }
                }

                  buffDatasetWriter.write(Integer.toString(1) + "\n");
            }

            for (int i = 0; i < 19; i++){
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

                graphEdges = dag.getEdges();

                edgeIterator = graphEdges.iterator();

                graphTable = new Hashtable<>();

                while(edgeIterator.hasNext()){
                    graphEdge = edgeIterator.next();
                    edgeNodes = new ArrayList<>();
                    edgeNodes.add(graphEdge.getNode1());
                    edgeNodes.add(graphEdge.getNode2());

                    singleEdge = dag.subgraph(edgeNodes);
                    singleEdge = GraphUtils.undirectedGraph(singleEdge);
                    undirectedEdge = singleEdge.getEdge(graphEdge.getNode1(), graphEdge.getNode2());

                    if(top150EdgeSet.contains(undirectedEdge)){
                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        edgeBIC = fgs.scoreDag(tempDAG);

                        graphTable.put(undirectedEdge, edgeBIC);
                    }
                }

                for (int j = 0; j < 150; j++){
                    if(graphTable.containsKey(idiot.get(j+1))){
                         buffDatasetWriter.write(Double.toString(bic - graphTable.get(idiot.get(j+1))) + "\t");
                    } else {
                          buffDatasetWriter.write(Integer.toString(0) + "\t");
                    }
                }

                  buffDatasetWriter.write(Integer.toString(0) + "\n");
            }

            buffDatasetWriter.flush();
            buffDatasetWriter.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String...args){
        DeltaBICsSingleDataset set = new DeltaBICsSingleDataset();
        set.createDataset();
    }
}
