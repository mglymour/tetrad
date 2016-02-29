package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;
import java.util.*;
import java.io.*;

/**
 * Created by user on 1/12/16.
 */
public class AllRoundGreatClassifier {

    private double percent = 0.05;

    public AllRoundGreatClassifier(){

    }

    public AllRoundGreatClassifier(double percent_needed){
        percent = percent_needed;
    }

    public void setPercent(double percent_needed){
        percent = percent_needed;
    }

    public String classify(String testGraphFileName){

        String autisticFileName = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/cerebellum_off_unique_autistic_unanimous_ssc_2.txt";
        File autisticFile = new File(autisticFileName);

        String neurotypicalFileName = "/Users/user/Documents/FMRI/Tetrad/USM_Both/cerebellum_off_unique_neurotypical_unanimous_ssc_2.txt";
        File neurotypicalFile = new File(neurotypicalFileName);

        Graph autisticGraph = GraphUtils.loadGraphTxt(autisticFile);
        Graph neurotypicalGraph = GraphUtils.loadGraphTxt(neurotypicalFile);

        Set<Edge> autisticEdges = autisticGraph.getEdges();
        int numAutisticEdges = autisticEdges.size();

        Set<Edge> neurotypicalEdges = neurotypicalGraph.getEdges();
        int numNeurotypicalEdges = neurotypicalEdges.size();

        File testGraphFile = new File(testGraphFileName);
        Graph testGraph = GraphUtils.loadGraphTxt(testGraphFile);
        testGraph = GraphUtils.undirectedGraph(testGraph);

        Set<Edge> testEdges = testGraph.getEdges();

        Iterator<Edge> neurotypicalIterator = neurotypicalEdges.iterator();
        Iterator<Edge> autisticIterator = autisticEdges.iterator();

        Edge neurotypicalEdge;
        Edge autisticEdge;

        int typEdgesInTest = 0;
        int autEdgesInTest = 0;

        while(neurotypicalIterator.hasNext()){

            neurotypicalEdge = neurotypicalIterator.next();
            if (testEdges.contains(neurotypicalEdge)){
                typEdgesInTest++;
            }

        }

        while(autisticIterator.hasNext()){

            autisticEdge = autisticIterator.next();
            if (testEdges.contains(autisticEdge)){
                autEdgesInTest++;
            }
        }

        double autPercent = (double)autEdgesInTest/(double)numAutisticEdges;
        double typPercent = (double)typEdgesInTest/(double)numNeurotypicalEdges;

        if ((autPercent - typPercent) > percent){
            return "Autistic";
        } else if ((typPercent - autPercent) > percent){
            return "Neurotypical";
        } else {
            return "No Comment";
        }

    }

    public static void main(String...args){

        AllRoundGreatClassifier classifier = new AllRoundGreatClassifier();

        String autisticStart = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Group_2/FGS_graph_spline_smooth_clean_";
        String neurotypicalStart = "/Users/user/Documents/FMRI/Tetrad/USM_Group_2/FGS_graph_spline_smooth_clean_";

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

        classifier.setPercent(0.05);

        for (int i = 0; i < 25; i++){
            System.out.println(classifier.classify(autisticStart + numbers.get(i) + "_2.txt"));
        }

        System.out.println("\n");

        for (int i = 0; i < 19; i++){
            System.out.println(classifier.classify(neurotypicalStart + numbers.get(i) + "_2.txt"));
        }

    }
}
