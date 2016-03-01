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
public class DeltaBICsSVM {

    public DeltaBICsSVM(){

    }

    public void createDataset(){
        try {

            String autisticStart = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Group_2/test_normal_ROI_data_spline_smooth_clean_";
            String typicalStart = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2/test_normal_ROI_data_spline_smooth_clean_";

            String autisticG1Start = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Smooth_Clean/cerebellum_off_normal_ROI_data_spline_smooth_clean_";
            String typicalG1Start = "/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Smooth_Clean/cerebellum_off_normal_ROI_data_spline_smooth_clean_";

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

            String dataset = "/Users/user/Documents/FMRI/Tetrad/USM_full_dBICs_SVM.txt";
            File datasetFile = new File(dataset);
            FileWriter datasetWriter = new FileWriter(datasetFile);
            BufferedWriter buffDatasetWriter = new BufferedWriter(datasetWriter);

            Hashtable<Edge, Double> graphTable;

            Iterator<Edge> edgeIterator;
            Set<Edge> graphEdges;

            Edge graphEdge;

            Graph interestingEdgesGraph = GraphUtils.loadGraphTxt(new File("/Users/user/Documents/FMRI/Tetrad/interesting_edges_graph.txt"));
            Set<Edge> interestingEdges = interestingEdgesGraph.getEdges();
            List<Edge> interestingEdgeList = new ArrayList<>();
            Iterator<Edge> interestingIter = interestingEdges.iterator();

            Hashtable<Integer, Edge> idiot = new Hashtable<>();
            int num = 1;
            while (interestingIter.hasNext()){
                idiot.put(num, interestingIter.next());
                num++;
            }

            String edgeKey = "/Users/user/Documents/FMRI/Tetrad/delta_bic_edge_key.txt";
            File edgeKeyFile = new File(edgeKey);
            FileWriter keyWriter = new FileWriter(edgeKeyFile);
            BufferedWriter buffKeyWriter = new BufferedWriter(keyWriter);

            for (int i = 0; i < 6; i++){
                buffKeyWriter.write(Integer.toString(i+1) + "\t" + idiot.get(i+1).toString() + "\n");
            }

            buffKeyWriter.flush();
            buffKeyWriter.close();

            List<Node> interestingNodes = interestingEdgesGraph.getNodes();
            Graph unGraph;


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

                dag = GraphUtils.replaceNodes(dag, interestingEdgesGraph.getNodes());

                unGraph = GraphUtils.undirectedGraph(dag);

                buffDatasetWriter.write("1\t");

                for (int j = 0; j < 6; j++){

                    buffDatasetWriter.write(Integer.toString(j) + ":");

                    if(unGraph.containsEdge(idiot.get(j+1))){
                        Edge interEdge = idiot.get(j+1);
                        Node node1 = interEdge.getNode1();
                        Node node2 = interEdge.getNode2();
                        graphEdge = dag.getEdge(node1, node2);

                        System.out.println(graphEdge.toString());

                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        tempDAG = GraphUtils.replaceNodes(tempDAG, graph.getNodes());

                        System.out.println(tempDAG.toString());

                        edgeBIC = fgs.scoreDag(tempDAG);
                        buffDatasetWriter.write(Double.toString(bic-edgeBIC) + "\t");
                    } else {
                        buffDatasetWriter.write("0\t");
                    }

                }

                buffDatasetWriter.write("\n");
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

                dag = GraphUtils.replaceNodes(dag, interestingEdgesGraph.getNodes());

                unGraph = GraphUtils.undirectedGraph(dag);

                buffDatasetWriter.write("0\t");

                for (int j = 0; j < 6; j++){

                    buffDatasetWriter.write(Integer.toString(j) + ":");

                    if(unGraph.containsEdge(idiot.get(j+1))){
                        Edge interEdge = idiot.get(j+1);
                        Node node1 = interEdge.getNode1();
                        Node node2 = interEdge.getNode2();
                        graphEdge = dag.getEdge(node1, node2);

                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        tempDAG = GraphUtils.replaceNodes(tempDAG, graph.getNodes());

                        edgeBIC = fgs.scoreDag(tempDAG);
                        buffDatasetWriter.write(Double.toString(bic-edgeBIC) + "\t");
                    } else {
                        buffDatasetWriter.write("0\t");
                    }

                }

                buffDatasetWriter.write("\n");
            }

            for (int i = 0; i < 10; i++){
                dataName = autisticG1Start + numbers.get(i) + ".txt";
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

                dag = GraphUtils.replaceNodes(dag, interestingEdgesGraph.getNodes());

                unGraph = GraphUtils.undirectedGraph(dag);

                buffDatasetWriter.write("1\t");

                for (int j = 0; j < 6; j++){

                    buffDatasetWriter.write(Integer.toString(j) + ":");

                    if(unGraph.containsEdge(idiot.get(j+1))){
                        Edge interEdge = idiot.get(j+1);
                        Node node1 = interEdge.getNode1();
                        Node node2 = interEdge.getNode2();
                        graphEdge = dag.getEdge(node1, node2);

                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        tempDAG = GraphUtils.replaceNodes(tempDAG, graph.getNodes());

                        edgeBIC = fgs.scoreDag(tempDAG);
                        buffDatasetWriter.write(Double.toString(bic-edgeBIC) + "\t");
                    } else {
                        buffDatasetWriter.write("0\t");
                    }

                }

                buffDatasetWriter.write("\n");

            }

            for (int i = 0; i < 10; i++){
                dataName = typicalG1Start + numbers.get(i) + ".txt";
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


                dag = GraphUtils.replaceNodes(dag, interestingEdgesGraph.getNodes());


                unGraph = GraphUtils.undirectedGraph(dag);

                buffDatasetWriter.write("0\t");

                for (int j = 0; j < 6; j++){

                    buffDatasetWriter.write(Integer.toString(j) + ":");

                    if(unGraph.containsEdge(idiot.get(j+1))){
                        Edge interEdge = idiot.get(j+1);
                        Node node1 = interEdge.getNode1();
                        Node node2 = interEdge.getNode2();
                        graphEdge = dag.getEdge(node1, node2);

                        tempDAG = GraphUtils.emptyGraph(0);
                        tempDAG.transferNodesAndEdges(dag);
                        tempDAG.removeEdge(graphEdge);

                        tempDAG = GraphUtils.replaceNodes(tempDAG, graph.getNodes());

                        edgeBIC = fgs.scoreDag(tempDAG);
                        buffDatasetWriter.write(Double.toString(bic-edgeBIC) + "\t");
                    } else {
                        buffDatasetWriter.write("0\t");
                    }

                }

                buffDatasetWriter.write("\n");
            }

            buffDatasetWriter.flush();
            buffDatasetWriter.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String...args){
        DeltaBICsSVM set = new DeltaBICsSVM();
        set.createDataset();    
    }
}
