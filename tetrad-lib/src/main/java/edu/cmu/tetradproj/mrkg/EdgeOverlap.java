package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
 * Created by user on 1/4/16.
 */
public class EdgeOverlap {

    private double discount;
    private int discountInt;

    public EdgeOverlap(double penalty_discount){
        discount = penalty_discount;
        discountInt = (int)discount;
    }

    public void findOverlap(){
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

            List<String> autCompDirs = new ArrayList<>();
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Native_Smooth_Clean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Spline_Smooth_Clean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Native_Smooth_Unclean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Spline_Smooth_Unclean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Native_Unsmooth_Clean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Spline_Unsmooth_Clean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Native_Unsmooth_Unclean");
            autCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Aut_Both/Spline_Unsmooth_Unclean");

            List<String> typCompDirs = new ArrayList<>();
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Native_Smooth_Clean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Spline_Smooth_Clean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Native_Smooth_Unclean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Spline_Smooth_Unclean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Native_Unsmooth_Clean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Spline_Unsmooth_Clean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Native_Unsmooth_Unclean");
            typCompDirs.add("/Users/user/Documents/FMRI/Tetrad/USM_Edge_Comparisons/USM_Both/Spline_Unsmooth_Unclean");

            List<List> typGraphLists = new ArrayList<>();
            List<List> autGraphLists = new ArrayList<>();
            List<String> interpolList;

            File graphFile;
            String graphName;
            String graphText;
            Graph graph;

            for (int i = 0; i < 8; i++) {
                interpolList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    graphName = typDirectories.get(i) + "/cerebellum_off_FGS_graph_" + interpols.get(i) + "_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    graphFile = new File(graphName);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    graph = GraphUtils.undirectedGraph(graph);
                    graphText = graph.toString();
                    interpolList.add(graphText);
                }
                typGraphLists.add(interpolList);
            }

            for (int i = 0; i < 8; i++) {
                interpolList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    graphName = autDirectories.get(i) + "/cerebellum_off_FGS_graph_" + interpols.get(i) + "_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    graphFile = new File(graphName);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    graph = GraphUtils.undirectedGraph(graph);
                    graphText = graph.toString();
                    interpolList.add(graphText);
                }
                autGraphLists.add(interpolList);
            }

            File compFile;
            String compName;
            Scanner scanner;
            String line;
            CharSequence test = "---";
            int numGraphs;
            boolean passes;

            List<Integer> typNumGraphsList = new ArrayList<>();
            List<Integer> autNumGraphsList = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                interpolList = typGraphLists.get(i);
                compName = autDirectories.get(i) + "/aaa_cerebellum_off_" + interpols.get(i) + "_edge_counts_" + Integer.toString(discountInt) + ".txt";
                compFile = new File(compName);
                numGraphs = 0;

                for (int j = 0; j < 10; j++){
                    graphText = interpolList.get(j);
                    scanner = new Scanner(compFile);
                    passes = true;

                    while(scanner.hasNextLine()){
                        line = scanner.nextLine();
                        if (line.equals("In 10 Graphs:")){
                            break;
                        }
                    }

                    while (scanner.hasNextLine()){

                        line = scanner.nextLine();
                        if (!line.contains(test)){
                            break;
                        }
                        Scanner huh = new Scanner(line);
                        String node1 = huh.next();
                        huh.next();
                        String node2 = huh.next();

                        if (!graphText.contains(line) && !graphText.contains(node2 + " --- " + node1)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        numGraphs++;
                    }
                }

                typNumGraphsList.add(numGraphs);

            }

            for (int i = 0; i < 8; i++) {
                interpolList = autGraphLists.get(i);
                compName = typDirectories.get(i) + "/aaa_cerebellum_off_" + interpols.get(i) + "_edge_counts_" + Integer.toString(discountInt) + ".txt";
                compFile = new File(compName);
                numGraphs = 0;

                for (int j = 0; j < 10; j++){
                    graphText = interpolList.get(j);
                    scanner = new Scanner(compFile);
                    passes = true;

                    while(scanner.hasNextLine()){
                        line = scanner.nextLine();
                        if (line.equals("In 10 Graphs:")){
                            break;
                        }
                    }

                    while (scanner.hasNextLine()){
                        line = scanner.nextLine();
                        if (!line.contains(test)){
                            break;
                        }
                        Scanner huh = new Scanner(line);
                        String node1 = huh.next();
                        huh.next();
                        String node2 = huh.next();

                        if (!graphText.contains(line) && !graphText.contains(node2 + " --- " + node1)){
                            passes = false;
                            break;
                        }
                    }

                    if (passes){
                        numGraphs++;
                    }
                }

                autNumGraphsList.add(numGraphs);

            }

            String fileName = "/Users/user/Documents/FMRI/Tetrad/USM_Both/cerebellum_off_aut_overlap_" + Integer.toString(discountInt) + ".txt";
            File outputFile = new File(fileName);

            FileWriter writer = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Neurotypical Subjects w/ All Unanimous Autistic Edges\n");

            for (int i = 0; i < 8; i++){
                bufferedWriter.write(upperInterpols.get(i) + ": " + Integer.toString(typNumGraphsList.get(i)) + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            String fileName2 = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/cerebellum_off_typ_overlap_" + Integer.toString(discountInt) + ".txt";
            File outputFile2 = new File(fileName2);

            FileWriter writer2 = new FileWriter(outputFile2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);

            bufferedWriter2.write("Autistic Subjects w/ All Unanimous Neurotypical Edges\n");

            for (int i = 0; i < 8; i++){
                bufferedWriter2.write(upperInterpols.get(i) + ": " + Integer.toString(autNumGraphsList.get(i)) + "\n");
            }

            bufferedWriter2.flush();
            bufferedWriter2.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        EdgeOverlap two = new EdgeOverlap(2.0);
        EdgeOverlap four = new EdgeOverlap(4.0);
        EdgeOverlap six = new EdgeOverlap(6.0);

        two.findOverlap();
        four.findOverlap();
        six.findOverlap();
    }
}
