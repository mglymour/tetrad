package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.graph.GraphUtils;

import java.util.*;
import java.io.*;

/**
 * Created by user on 1/29/16.
 */
public class EdgeCorrelationDatasets {

    public EdgeCorrelationDatasets(){

    }

    public void getDatasets(){
        try {

            String autisticStart = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Group_2/FGS_graph_spline_smooth_clean_";
            String typicalStart = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2/FGS_graph_spline_smooth_clean_";

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

            Graph tempGraph;
            String tempGraphString;
            File tempGraphFile;

            Set<Edge> allEdges = new HashSet<>();

            for (int i = 0; i < 25; i++) {

                tempGraphString = autisticStart + numbers.get(i) + "_2.txt";
                tempGraphFile = new File(tempGraphString);
                tempGraph = GraphUtils.loadGraphTxt(tempGraphFile);

                tempGraph = GraphUtils.undirectedGraph(tempGraph);

                autisticGraphs.add(tempGraph);

                allEdges.addAll(tempGraph.getEdges());
            }

            for (int i = 0; i < 19; i++) {

                tempGraphString = typicalStart + numbers.get(i) + "_2.txt";
                tempGraphFile = new File(tempGraphString);
                tempGraph = GraphUtils.loadGraphTxt(tempGraphFile);

                tempGraph = GraphUtils.undirectedGraph(tempGraph);

                typicalGraphs.add(tempGraph);

                allEdges.addAll(tempGraph.getEdges());
            }

            Iterator<Edge> edgeIterator = allEdges.iterator();
            Edge edge;
            String tempDataString;
            File tempDataFile;
            FileWriter writer;
            BufferedWriter bufferedWriter;

            while (edgeIterator.hasNext()) {

                edge = edgeIterator.next();

                tempDataString = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2_Edge_Correlations/" + edge.getNode1().toString() + "___" + edge.getNode2().toString() + "_correlations.txt";
                tempDataFile = new File(tempDataString);
                writer = new FileWriter(tempDataFile);
                bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.write("Autistic\tHas_Edge\n");

                for (int i = 0; i < autisticGraphs.size(); i++){

                    tempGraph = autisticGraphs.get(i);

                    if (tempGraph.containsEdge(edge)){
                        bufferedWriter.write(Integer.toString(1) + "\t" + Integer.toString(1) + "\n");
                    } else {
                        bufferedWriter.write(Integer.toString(1) + "\t" + Integer.toString(0) + "\n");
                    }

                }

                for (int i = 0; i < typicalGraphs.size(); i++){

                    tempGraph = typicalGraphs.get(i);

                    if (tempGraph.containsEdge(edge)){
                        bufferedWriter.write(Integer.toString(0) + "\t" + Integer.toString(1) + "\n");
                    } else {
                        bufferedWriter.write(Integer.toString(0) + "\t" + Integer.toString(0) + "\n");
                    }

                }

                bufferedWriter.flush();
                bufferedWriter.close();

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String...args){

        EdgeCorrelationDatasets freddie = new EdgeCorrelationDatasets();
        freddie.getDatasets();

    }
}
