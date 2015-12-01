package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.search.*;

import java.io.*;
import java.util.*;


/**
 * Computes average number of edges in a set of similarly-named graphs.
 *
 * @author Madelyn Glymour
 */
public class GraphTester {

    public GraphTester(){

    }

    public void test1() {
        try {

            Graph graph1 = GraphUtils.emptyGraph(0);
            Graph graph2 = GraphUtils.emptyGraph(3);

            List<Node> nodes = graph2.getNodes();

            graph2.addDirectedEdge(nodes.get(0), nodes.get(1));
            graph2.addDirectedEdge(nodes.get(1), nodes.get(2));
            graph2.addDirectedEdge(nodes.get(0), nodes.get(2));

            graph1.transferNodesAndEdges(graph2);

            System.out.println(graph1.toString());

            graph2.removeEdge(nodes.get(0), nodes.get(1));

            System.out.println(graph1.toString());

            System.out.println(graph1 == graph2);

            System.out.println(Integer.toString(SearchGraphUtils.structuralHammingDistance(graph1, graph2)));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String...args) {


        new GraphTester().test1();
    }
}




