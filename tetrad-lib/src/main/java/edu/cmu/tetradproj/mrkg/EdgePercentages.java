package edu.cmu.tetradproj.mrkg;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import edu.cmu.tetrad.graph.*;

/**
 * Created by user on 1/4/16.
 */
public class EdgePercentages {

    private double discount;
    private int discountInt;

    public EdgePercentages(double penalty_discount){
        discount = penalty_discount;
        discountInt = (int)discount;
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

            List<String> typDirectories = new ArrayList<>();
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Smooth_Clean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Smooth_Clean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Smooth_Unclean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Smooth_Unclean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Unsmooth_Clean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Unsmooth_Clean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Unsmooth_Unclean");
            typDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Unsmooth_Unclean");

            List<String> autDirectories = new ArrayList<>();
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Smooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Smooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Smooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Smooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Unsmooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Unsmooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Unsmooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Unsmooth_Unclean");

            List<List> typGraphLists = new ArrayList<>();
            List<List> autGraphLists = new ArrayList<>();
            List<Graph> interpolList;

            File graphFile;
            String graphName;
            Graph graph;

            for (int i = 0; i < 8; i++) {
                interpolList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    graphName = typDirectories.get(i) + "/" + interpols.get(i) + "_GES_skew_3_graph_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    graphFile = new File(graphName);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    graph = GraphUtils.undirectedGraph(graph);
                    interpolList.add(graph);
                }
                typGraphLists.add(interpolList);
            }

            for (int i = 0; i < 8; i++) {
                interpolList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    graphName = autDirectories.get(i) + "/" + interpols.get(i) + "_GES_skew_3_graph_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    graphFile = new File(graphName);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    graph = GraphUtils.undirectedGraph(graph);
                    interpolList.add(graph);
                }
                autGraphLists.add(interpolList);
            }

            FileWriter writer;
            BufferedWriter bufferedWriter;
            File outputFile;
            String fileName;
            Set<Edge> typEdges;
            Set<Edge> autEdges;
            Edge edge;
            Iterator<Edge> typEdgeIterator;
            Iterator<Edge> autEdgeIterator;
            int sum;
            List<Hashtable<Integer, List<Edge>>> typTableList = new ArrayList<>();
            List<Hashtable<Integer, List<Edge>>> autTableList = new ArrayList<>();
            Hashtable<Integer, List<Edge>> typTable;
            Hashtable<Integer, List<Edge>> autTable;
            List<Edge> typTempList;
            List<Edge> autTempList;

            for (int i = 0; i < 8; i++) {

                typEdges = new HashSet<Edge>();
                interpolList = typGraphLists.get(i);

                for (int j = 0; j < 10; j++){
                    graph = interpolList.get(j);
                    typEdges.addAll(graph.getEdges());
                }

                typEdgeIterator = typEdges.iterator();
                typTable = new Hashtable<>();
                for(int j = 0; j < 10; j++){
                    typTable.put(j+1, new ArrayList<Edge>());
                }

                while (typEdgeIterator.hasNext()){
                    edge = typEdgeIterator.next();
                    sum = 0;
                    for (int k = 0; k < 10; k++){
                        graph = interpolList.get(k);
                        if (graph.containsEdge(edge)){
                            sum++;
                        }
                    }
                    typTempList = typTable.get(sum);
                    typTempList.add(edge);
                }
                typTableList.add(typTable);
            }

            for (int i = 0; i < 8; i++) {

                autEdges = new HashSet<Edge>();
                interpolList = autGraphLists.get(i);

                for (int j = 0; j < 10; j++){
                    graph = interpolList.get(j);
                    autEdges.addAll(graph.getEdges());
                }

                autEdgeIterator = autEdges.iterator();
                autTable = new Hashtable<>();
                for(int j = 0; j < 10; j++){
                    autTable.put(j+1, new ArrayList<Edge>());
                }

                while (autEdgeIterator.hasNext()){
                    edge = autEdgeIterator.next();
                    sum = 0;
                    for (int k = 0; k < 10; k++){
                        graph = interpolList.get(k);
                        if (graph.containsEdge(edge)){
                            sum++;
                        }
                    }
                    autTempList = autTable.get(sum);
                    autTempList.add(edge);
                }
                autTableList.add(autTable);
            }

            fileName = "/Users/user/Documents/FMRI/Tetrad/70_30_edge_percent_overlaps_" + Integer.toString(discountInt) + ".txt";
            outputFile = new File(fileName);

            writer = new FileWriter(outputFile);
            bufferedWriter = new BufferedWriter(writer);

            boolean passes;

            Hashtable<Integer, List<Edge>> typTempTable;
            Hashtable<Integer, List<Edge>> autTempTable;

            for (int i = 0; i < 8; i++){
                bufferedWriter.write(upperInterpols.get(i) + "\n\n");

                typTempTable = typTableList.get(i);
                autTempTable = autTableList.get(i);

                bufferedWriter.write("Unanimous neurotypical edges in no autistics:\n");

                typTempList = typTempTable.get(10);

                for (int j = 0; j < typTempList.size(); j++){

                    edge = typTempList.get(j);

                    if(edge.isNull()){
                        System.out.println("NULL EDGE!");
                    }

                    passes = true;

                    for (int k = 0; k < 10; k++){
                        autTempList = autTempTable.get(k+1);


                        if (autTempList.contains(edge)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("Unanimous neurotypical edges in 10% of autistics:\n");

                for (int j = 0;j < typTempList.size(); j++){

                    edge = typTempList.get(j);
                    autTempList = autTempTable.get(1);

                    if (autTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% neurotypical edges in no autistics:\n");
                typTempList = typTempTable.get(7);

                for (int j = 0; j < typTempList.size(); j++){

                    edge = typTempList.get(j);

                    passes = true;

                    for (int k = 0; k < 10; k++){
                        autTempList = autTempTable.get(k+1);
                        if (autTempList.contains(edge)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% neurotypical edges in 10% autistics:\n");

                for (int j = 0;j < typTempList.size(); j++){

                    edge = typTempList.get(j);
                    autTempList = autTempTable.get(1);

                    if (autTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% neurotypical edges in 20% autistics:\n");

                for (int j = 0;j < typTempList.size(); j++){

                    edge = typTempList.get(j);
                    autTempList = autTempTable.get(2);

                    if (autTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% neurotypical edges in 30% autistics:\n");

                for (int j = 0;j < typTempList.size(); j++){

                    edge = typTempList.get(j);
                    autTempList = autTempTable.get(3);

                    if (autTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("Unanimous autistic edges in no neurotypicals:\n");
                autTempList = autTempTable.get(10);

                for (int j = 0; j < autTempList.size(); j++){

                    edge = autTempList.get(j);

                    passes = true;

                    for (int k = 0; k < 10; k++){
                        typTempList = typTempTable.get(k+1);
                        if (typTempList.contains(edge)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("Unanimous autistic edges in 10% of neurotypicals:\n");

                for (int j = 0;j < autTempList.size(); j++){

                    edge = autTempList.get(j);
                    typTempList = typTempTable.get(1);

                    if (typTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% autistic edges in no neurotypicals:\n");
                autTempList = autTempTable.get(7);

                for (int j = 0; j < autTempList.size(); j++){

                    edge = autTempList.get(j);

                    passes = true;

                    for (int k = 0; k < 10; k++){
                        typTempList = typTempTable.get(k+1);
                        if (typTempList.contains(edge)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% autistic edges in 10% neurotypicals:\n");

                for (int j = 0;j < autTempList.size(); j++){

                    edge = autTempList.get(j);
                    typTempList = typTempTable.get(1);

                    if (typTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% autistic edges in 20% neurotypicals:\n");

                for (int j = 0;j < autTempList.size(); j++){

                    edge = autTempList.get(j);
                    typTempList = typTempTable.get(2);

                    if (typTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");

                bufferedWriter.write("70% autistic edges in 30% neurotypicals:\n");

                for (int j = 0;j < autTempList.size(); j++){

                    edge = autTempList.get(j);
                    typTempList = typTempTable.get(3);

                    if (typTempList.contains(edge)){
                        bufferedWriter.write(edge.toString() + "\n");
                    }
                }

                bufferedWriter.write("\n");
                bufferedWriter.write("\n");


            }

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        EdgePercentages norm2 = new EdgePercentages(2.0);
        EdgePercentages norm4 = new EdgePercentages(4.0);
        EdgePercentages norm6 = new EdgePercentages(6.0);

        norm2.countEdges();
        norm4.countEdges();
        norm6.countEdges();
    }
}
