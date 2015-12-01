package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.search.FastImages;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;
import java.util.*;

///////////////////////////////////////////////////////////////////////////////
// For information as to what this class does, see the Javadoc, below.       //
// Copyright (C) 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006,       //
// 2007, 2008, 2009, 2010, 2014 by Peter Spirtes, Richard Scheines, Joseph   //
// Ramsey, and Clark Glymour.                                                //
//                                                                           //
// This program is free software; you can redistribute it and/or modify      //
// it under the terms of the GNU General Public License as published by      //
// the Free Software Foundation; either version 2 of the License, or         //
// (at your option) any later version.                                       //
//                                                                           //
// This program is distributed in the hope that it will be useful,           //
// but WITHOUT ANY WARRANTY; without even the implied warranty of            //
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the             //
// GNU General Public License for more details.                              //
//                                                                           //
// You should have received a copy of the GNU General Public License         //
// along with this program; if not, write to the Free Software               //
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA //
///////////////////////////////////////////////////////////////////////////////

/**
 * Tests the PC search.
 *
 * @author Joseph Ramsey
 */
public class ContainsTest {

    private String brain;
    private double discount;
    private int discountInt;

    public ContainsTest(String brain_specs, double penalty_discount){
        brain = brain_specs;
        discount = penalty_discount;
        discountInt = (int)discount;
    }

    public void test1() {
        try {

            // list of preprocessing methods
            List<String> interpols = new ArrayList<>();
            interpols.add("native_smooth_clean");
            interpols.add("spline_smooth_clean");
            interpols.add("native_smooth_unclean");
            interpols.add("spline_smooth_unclean");
            interpols.add("native_unsmooth_clean");
            interpols.add("spline_unsmooth_clean");
            interpols.add("native_unsmooth_unclean");
            interpols.add("spline_unsmooth_unclean");

            // list of graph directories
            List<String> directories = new ArrayList<>();
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Unclean");

            // list of 100 IMaGES graphs for each preprocessing method, limited to interhemispheric edges
            List<Graph> nativeSmoothCleanGraphs = new ArrayList<>();
            List<Graph> splineSmoothCleanGraphs = new ArrayList<>();
            List<Graph> nativeSmoothUncleanGraphs = new ArrayList<>();
            List<Graph> splineSmoothUncleanGraphs = new ArrayList<>();
            List<Graph> nativeUnsmoothCleanGraphs = new ArrayList<>();
            List<Graph> splineUnsmoothCleanGraphs = new ArrayList<>();
            List<Graph> nativeUnsmoothUncleanGraphs = new ArrayList<>();
            List<Graph> splineUnsmoothUncleanGraphs = new ArrayList<>();

            List<List> graphLists = new ArrayList<>();
            graphLists.add(nativeSmoothCleanGraphs);
            graphLists.add(splineSmoothCleanGraphs);
            graphLists.add(nativeSmoothUncleanGraphs);
            graphLists.add(splineSmoothUncleanGraphs);
            graphLists.add(nativeUnsmoothCleanGraphs);
            graphLists.add(splineUnsmoothCleanGraphs);
            graphLists.add(nativeUnsmoothUncleanGraphs);
            graphLists.add(splineUnsmoothUncleanGraphs);

            // list of 100 IMaGES graphs for each preprocessing method, limited to interhemispheric homotopic edges
            List<Graph> nativeSmoothCleanHomotopic = new ArrayList<>();
            List<Graph> splineSmoothCleanHomotopic = new ArrayList<>();
            List<Graph> nativeSmoothUncleanHomotopic = new ArrayList<>();
            List<Graph> splineSmoothUncleanHomotopic = new ArrayList<>();
            List<Graph> nativeUnsmoothCleanHomotopic = new ArrayList<>();
            List<Graph> splineUnsmoothCleanHomotopic = new ArrayList<>();
            List<Graph> nativeUnsmoothUncleanHomotopic = new ArrayList<>();
            List<Graph> splineUnsmoothUncleanHomotopic = new ArrayList<>();

            List<List> homotopicLists = new ArrayList<>();
            homotopicLists.add(nativeSmoothCleanHomotopic);
            homotopicLists.add(splineSmoothCleanHomotopic);
            homotopicLists.add(nativeSmoothUncleanHomotopic);
            homotopicLists.add(splineSmoothUncleanHomotopic);
            homotopicLists.add(nativeUnsmoothCleanHomotopic);
            homotopicLists.add(splineUnsmoothCleanHomotopic);
            homotopicLists.add(nativeUnsmoothUncleanHomotopic);
            homotopicLists.add(splineUnsmoothUncleanHomotopic);

            // list of 100 IMaGES graphs for each preprocessing method, limited to interhemispheric heterotopic edges
            List<Graph> nativeSmoothCleanHeterotopic = new ArrayList<>();
            List<Graph> splineSmoothCleanHeterotopic = new ArrayList<>();
            List<Graph> nativeSmoothUncleanHeterotopic = new ArrayList<>();
            List<Graph> splineSmoothUncleanHeterotopic = new ArrayList<>();
            List<Graph> nativeUnsmoothCleanHeterotopic = new ArrayList<>();
            List<Graph> splineUnsmoothCleanHeterotopic = new ArrayList<>();
            List<Graph> nativeUnsmoothUncleanHeterotopic = new ArrayList<>();
            List<Graph> splineUnsmoothUncleanHeterotopic = new ArrayList<>();

            List<List> heterotopicLists = new ArrayList<>();
            heterotopicLists.add(nativeSmoothCleanHeterotopic);
            heterotopicLists.add(splineSmoothCleanHeterotopic);
            heterotopicLists.add(nativeSmoothUncleanHeterotopic);
            heterotopicLists.add(splineSmoothUncleanHeterotopic);
            heterotopicLists.add(nativeUnsmoothCleanHeterotopic);
            heterotopicLists.add(splineUnsmoothCleanHeterotopic);
            heterotopicLists.add(nativeUnsmoothUncleanHeterotopic);
            heterotopicLists.add(splineUnsmoothUncleanHeterotopic);

            // interhemispheric, homotopic, and heterotopic graphs, reinstantiated for each parent graph
            Graph graph;
            Graph homotopic;
            Graph heterotopic;

            List<Graph> stupidHomotopic;
            List<Graph> stupidHeterotopic;

            // for each preprocessing method, loads each parent graph, locates and removes all intrahemispheric edges, and stores the
            // result in graph. Then locates homotopic edges and stores in homotopic, and locates heterotopic edges and stores in
            // heterotopic.
            for (int j = 0; j < interpols.size(); j++){
                for (int k = 0; k < 100; k++) {

                    // load parent graph
                    if (k < 9) {
                        graph = GraphUtils.loadGraphTxt(new File(directories.get(j) + "/" + interpols.get(j) + "_graph_00" + Integer.toString(k + 1) + "_" + Integer.toString(discountInt) + ".txt"));
                    } else if (k < 99){
                        graph = GraphUtils.loadGraphTxt(new File(directories.get(j) + "/" + interpols.get(j) + "_graph_0" + Integer.toString(k+1) + "_" + Integer.toString(discountInt) + ".txt"));
                    } else {
                        graph = GraphUtils.loadGraphTxt(new File(directories.get(j) + "/" + interpols.get(j) + "_graph_" + Integer.toString(k+1) + "_" + Integer.toString(discountInt) + ".txt"));
                    }

                    // get list of graph nodes, and copy into lefNodes and rightnodes; these will be reduced to single-hemisphere nodes
                    List<Node> nodes = graph.getNodes();

                    List<Node> leftNodes = new ArrayList<Node>(nodes);
                    List<Node> rightNodes = new ArrayList<Node>(nodes);

                    // for each of the 108 nodes, removes from rightNodes if index in node list is even, and from leftNodes if index
                    // is odd
                    for (int i = 107; i >= 0; i--){
                        if (Integer.remainderUnsigned(i, 2) == 0) {
                            rightNodes.remove(i);
                        } else {
                            leftNodes.remove(i);
                        }
                    }

                    // creates graphs containing only left and right hemisphere nodes, finds the edges in each, and removes them from
                    // the parent graph
                    Graph leftGraph = graph.subgraph(leftNodes);
                    Graph rightGraph = graph.subgraph(rightNodes);

                    Set<Edge> leftEdges = leftGraph.getEdges();
                    Set<Edge> rightEdges = rightGraph.getEdges();

                    Iterator<Edge> leftIterator = leftEdges.iterator();
                    Iterator<Edge> rightIterator = rightEdges.iterator();

                    while(leftIterator.hasNext()){
                        graph.removeEdge(leftIterator.next());
                    }

                    while(rightIterator.hasNext()){
                        graph.removeEdge(rightIterator.next());
                    }

                    System.out.println("Your iterators haven't failed!");

                    // adds stripped graph to list of interhemispheric graphs
                    graphLists.get(j).add(graph);

                    // copies interhemispheric graph to homotopic and heterotopic
                    homotopic = GraphUtils.emptyGraph(0);
                    heterotopic = GraphUtils.emptyGraph(0);
                    homotopic.transferNodesAndEdges(graph);
                    heterotopic.transferNodesAndEdges(graph);

                    // matching right and left nodes, a potential edge between them, and a list of nodes adjacent to them;
                    // reinstantiated for each ROI
                    Node lTempNode;
                    Node rTempNode;

                    Edge potentialEdge;

                    List<Node> leftTempNodeList;
                    List<Node> rightTempNodeList;

                    // for each ROI, determines whether the right node is in the list of nodes adjacent to the left; if so, removes the
                    // edge between them from heterotopic; then, removes all other edges in the right and left adjacency lists from
                    // homotopic; then, adds stripped heterotopic and homotopic graphs to their respective lists
                    for (int i = 0; i < 54; i++){
                        lTempNode = leftNodes.get(i);
                        rTempNode = rightNodes.get(i);

                        System.out.println(rTempNode.getName());

                        leftTempNodeList = heterotopic.getAdjacentNodes(lTempNode);
                        rightTempNodeList = heterotopic.getAdjacentNodes(rTempNode);
                        if (leftTempNodeList.contains(rTempNode)){
                            potentialEdge = graph.getEdge(lTempNode, rTempNode);
                            heterotopic.removeEdge(potentialEdge);
                        }

                        Node wtf;

                        System.out.println("Size: " + Integer.toString(rightTempNodeList.size()));
                        for (int w = 0; w < rightTempNodeList.size(); w++){

                            wtf = rightTempNodeList.get(w);
                            //System.out.println(wtf.getName());
                            if (!wtf.equals(lTempNode)){
                                homotopic.removeEdge(graph.getEdge(rTempNode, wtf));

                                //System.out.println(wtf.getName());
                            }
                        }


                        for (int w = 0; w < leftTempNodeList.size(); w++){
                            if (!leftTempNodeList.get(w).equals(rTempNode)){
                                homotopic.removeEdge(graph.getEdge(lTempNode, leftTempNodeList.get(w)));
                            }
                        }

                        System.out.println("ROI " + Integer.toString(i) + " done!");
                    }

                    stupidHomotopic = homotopicLists.get(j);
                    stupidHeterotopic = heterotopicLists.get(j);

                    stupidHomotopic.add(homotopic);
                    stupidHeterotopic.add(heterotopic);

                    System.out.println("Graph " + Integer.toString(k) + " done!");

                }

                System.out.println(interpols.get(j) + " created!");
            }

            System.out.println("Graphs created!");

            // list of average numbers of interhemispheric, homotopic, and heterotopic edges in each preprocessing method
            List<Double> graphAverage = new ArrayList<>();
            List<Double> homotopicAverage = new ArrayList<>();
            List<Double> heterotopicAverage = new ArrayList<>();

            // sums of edge numbers, reinstantiated for each preprocessing method
            int graphSum;
            int homotopicSum;
            int heterotopicSum;

            // placeholder graph lists, reinstantiated for each preprocessing method
            List<Graph> tempGraphs;
            List<Graph> tempHomotopic;
            List<Graph> tempHeterotopic;

            // averages the number of edges in each interhemispheric, homotopic, and heterotopic graph for each preprocessing method
            for (int i = 0; i < interpols.size(); i++){

                tempGraphs = graphLists.get(i);
                tempHomotopic = homotopicLists.get(i);
                tempHeterotopic = heterotopicLists.get(i);


                graphSum = 0;
                homotopicSum = 0;
                heterotopicSum = 0;

                for (int j = 0; j < 100; j++){
                    graphSum = graphSum + tempGraphs.get(j).getNumEdges();
                    homotopicSum = homotopicSum + tempHomotopic.get(j).getNumEdges();
                    heterotopicSum = heterotopicSum + tempHeterotopic.get(j).getNumEdges();
                }

                graphAverage.add(((double)graphSum)/100);
                homotopicAverage.add(((double)homotopicSum)/100);
                heterotopicAverage.add(((double)heterotopicSum)/100);
            }

            System.out.println("All averaged up!");

            // file name and writer for comparison; reinstantiated for each preprocessing method and graph type
            String compFile;
            PrintWriter compOut;

            // compare the 100 interhemispheric graphs for each preprocessing methods, and write to file
            for (int i = 0; i < interpols.size(); i++) {
                compFile = directories.get(i) + "/" + interpols.get(i) + "_interhemispheric_comp_" + Integer.toString(discountInt) + ".txt";
                compOut = new PrintWriter(compFile);
                compOut.println(GraphUtils.getIntersectionComparisonString(graphLists.get(i)));

                compOut.flush();
                compOut.close();
            }

            // compare the 100 homotopic graphs for each preprocessing method, and write to file
            for (int i = 0; i < interpols.size(); i++) {
                compFile = directories.get(i) + "/" + interpols.get(i) + "_homotopic_comp_" + Integer.toString(discountInt) + ".txt";
                compOut = new PrintWriter(compFile);
                compOut.println(GraphUtils.getIntersectionComparisonString(homotopicLists.get(i)));

                compOut.flush();
                compOut.close();
            }

            // compare the 100 heterotopic graphs for each preprocessing method, and write to file
            for (int i = 0; i < interpols.size(); i++) {
                compFile = directories.get(i) + "/" + interpols.get(i) + "_heterotopic_comp_" + Integer.toString(discountInt) + ".txt";
                compOut = new PrintWriter(compFile);
                compOut.println(GraphUtils.getIntersectionComparisonString(heterotopicLists.get(i)));

                compOut.flush();
                compOut.close();
            }

            // write averages to file
            FileWriter writer = new FileWriter(new File("/Users/user/Documents/FMRI/Tetrad/" + brain + "/interhemispheric_averages_" + Integer.toString(discountInt) + ".txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Interhemispheric Averages\n");

            for (int i = 0; i < interpols.size(); i++){
                bufferedWriter.write(interpols.get(i) + " " + Double.toString(graphAverage.get(i)) + "\n");
            }

            bufferedWriter.write("\nHomotopic Averages\n");

            for (int i = 0; i < interpols.size(); i++){
                bufferedWriter.write(interpols.get(i) + " " + Double.toString(homotopicAverage.get(i)) + "\n");
            }

            bufferedWriter.write("\nHeterotopic Averages\n");

            for (int i = 0; i < interpols.size(); i++){
                bufferedWriter.write(interpols.get(i) + " " + Double.toString(heterotopicAverage.get(i)) + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * This method uses reflection to collect up all of the test methods from this class and return them to the test
     * runner.
     */
    public static void main(String...args){

        ContainsTest both2 = new ContainsTest("USM_Both", 2.0);
        ContainsTest both4 = new ContainsTest("USM_Both", 4.0);
        ContainsTest both6 = new ContainsTest("USM_Both", 6.0);

        ContainsTest aut_both2 = new ContainsTest("USM_Aut_Both", 2.0);
        ContainsTest aut_both4 = new ContainsTest("USM_Aut_Both", 4.0);
        ContainsTest aut_both6 = new ContainsTest("USM_Aut_Both", 6.0);

        both2.test1();
        both4.test1();
        both6.test1();

        aut_both2.test1();
        aut_both4.test1();
        aut_both6.test1();
    }
}




