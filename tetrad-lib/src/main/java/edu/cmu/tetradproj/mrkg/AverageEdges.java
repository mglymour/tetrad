package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;

import java.io.*;
import java.util.*;


/**
 * Computes average number of edges in a set of similarly-named graphs.
 *
 * @author Madelyn Glymour
 */
public class AverageEdges {

    public AverageEdges(){

    }

    public void test1() {
        try {

            List<String> interpols = new ArrayList<>();
            interpols.add("native_smooth_clean");
            interpols.add("spline_smooth_clean");
            interpols.add("native_smooth_unclean");
            interpols.add("spline_smooth_unclean");
            interpols.add("native_unsmooth_clean");
            interpols.add("spline_unsmooth_clean");
            interpols.add("native_unsmooth_unclean");
            interpols.add("spline_unsmooth_unclean");

            List<String> directories = new ArrayList<>();
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Native_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Spline_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Native_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Spline_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Native_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Spline_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Native_Unsmooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Right/Spline_Unsmooth_Unclean");

            File graphFile;

            Graph graph;

            String graphDir;
            String graphURL;

            List<Double> averages = new ArrayList<>();

            int sum;
            double average;

            for (int i = 0; i < 8; i++) {
                graphDir = directories.get(i);

                sum = 0;

                for (int j = 1; j < 11; j++) {

                    if (j < 10) {
                        graphURL = graphDir + "/" + interpols.get(i) + "_GES_skew_3_graph_00" + Integer.toString(j) + "_6.txt";
                    } else if (j < 100) {
                        graphURL = graphDir + "/" + interpols.get(i) + "_GES_skew_3_graph_0" + Integer.toString(j) + "_6.txt";
                    } else {
                        graphURL = graphDir + "/" + interpols.get(i) + "_GES_skew_3_graph_" + Integer.toString(j) + "_6.txt";
                    }

                    graphFile = new File(graphURL);
                    graph = GraphUtils.loadGraphTxt(graphFile);
                    sum += graph.getNumEdges();
                }

                average = ((double) sum) / 10;
                averages.add(average);

                System.out.print(interpols.get(i) + ": ");
                System.out.println(average);
            }

            for (int i = 0; i < 8; i++) {
                System.out.print(directories.get(i));
                System.out.println(averages.get(i));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String...args) {


        new AverageEdges().test1();
    }
}




