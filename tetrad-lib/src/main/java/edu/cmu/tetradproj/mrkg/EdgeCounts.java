package edu.cmu.tetradproj.mrkg;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import edu.cmu.tetrad.graph.*;

/**
 * Created by user on 1/4/16.
 */
public class EdgeCounts {

    private String brain;
    private double discount;
    private int discountInt;
    private int numGraphs;

    public EdgeCounts(String brain_specs, double penalty_discount, int num){
        brain = brain_specs;
        brain = brain_specs;
        discount = penalty_discount;
        discountInt = (int)discount;
        numGraphs = num;
    }

    public void countEdges(){
        try {
            List<String> hemispheres = new ArrayList<>();
            hemispheres.add("USM_Both");
            hemispheres.add("USM_Aut_Both");
            hemispheres.add("USM_Left");
            hemispheres.add("USM_Aut_Left");
            hemispheres.add("USM_Right");
            hemispheres.add("USM_Aut_Right");

            List<String> interpols = new ArrayList<>();
            interpols.add("native_smooth_clean");
            interpols.add("spline_smooth_clean");
            interpols.add("native_smooth_unclean");
            interpols.add("spline_smooth_unclean");
            interpols.add("native_unsmooth_clean");
            interpols.add("spline_unsmooth_clean");
            interpols.add("native_unsmooth_unclean");
            interpols.add("spline_unsmooth_unclean");

            List<String> upperInterpols = new ArrayList<>();
            upperInterpols.add("Native_Smooth_Clean");
            upperInterpols.add("Spline_Smooth_Clean");
            upperInterpols.add("Native_Smooth_Unclean");
            upperInterpols.add("Spline_Smooth_Unclean");
            upperInterpols.add("Native_Unsmooth_Clean");
            upperInterpols.add("Spline_Unsmooth_Clean");
            upperInterpols.add("Native_Unsmooth_Unclean");
            upperInterpols.add("Spline_Unsmooth_Unclean");

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

            List<String> directories = new ArrayList<>();
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Unclean");

            List<List> graphLists = new ArrayList<>();
            List<Graph> interpolList;

            File graphFile;
            String graphName;
            Graph graph;

                interpolList = new ArrayList<>();
                for (int j = 0; j < numGraphs; j++) {
                    graphName = "/Users/user/Documents/FMRI/Tetrad/" + brain + "/FGS_graph_spline_smooth_clean_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    graphFile = new File(graphName);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    graph = GraphUtils.undirectedGraph(graph);
                    interpolList.add(graph);
                }


            FileWriter writer;
            BufferedWriter bufferedWriter;
            File outputFile;
            String fileName;
            Set<Edge> edges;
            Edge edge;
            Iterator<Edge> edgeIterator;
            int sum;
            Hashtable<Integer, List<Edge>> table;
            List<Edge> tempList;


                edges = new HashSet<Edge>();

                for (int j = 0; j < numGraphs; j++){
                    graph = interpolList.get(j);
                    edges.addAll(graph.getEdges());
                }

                edgeIterator = edges.iterator();
                table = new Hashtable<>();
                for(int j = 0; j < numGraphs; j++){
                    table.put(j+1, new ArrayList<Edge>());
                }

                while (edgeIterator.hasNext()){
                    edge = edgeIterator.next();
                    sum = 0;
                    for (int k = 0; k < numGraphs; k++){
                        graph = interpolList.get(k);
                        if (graph.containsEdge(edge)){
                            sum++;
                        }
                    }
                    tempList = table.get(sum);
                    tempList.add(edge);
                }

                fileName = "/Users/user/Documents/FMRI/Tetrad/" + brain + "/aaa_spline_smooth_clean_edge_counts_" + Integer.toString(discountInt) + ".txt";
                outputFile = new File(fileName);

                writer = new FileWriter(outputFile);
                bufferedWriter = new BufferedWriter(writer);

                for (int j = 0; j < numGraphs; j++){

                    tempList = table.get(j+1);
                    bufferedWriter.write("In " + Integer.toString(j+1) + " Graphs:\n");

                    for (int k = 0; k < tempList.size(); k++){
                        bufferedWriter.write(tempList.get(k).toString());
                        bufferedWriter.write("\n");
                    }
                    bufferedWriter.write("\n");
                }

                bufferedWriter.flush();
                bufferedWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        EdgeCounts typ = new EdgeCounts("USM_Group_2", 2.0, 19);
        EdgeCounts aut = new EdgeCounts("USM_Aut_Group_2", 2.0, 25);

        typ.countEdges();
        aut.countEdges();
    }
}
