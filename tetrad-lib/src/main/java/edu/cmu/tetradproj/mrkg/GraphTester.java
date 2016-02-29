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
            Graph graph2 = GraphUtils.emptyGraph(4);

            List<Node> nodes = graph2.getNodes();

            graph2.addDirectedEdge(nodes.get(0), nodes.get(1));
            graph2.addDirectedEdge(nodes.get(1), nodes.get(2));
            graph2.addDirectedEdge(nodes.get(0), nodes.get(2));

            graph1.transferNodesAndEdges(graph2);

            graph1.addDirectedEdge(nodes.get(2), nodes.get(3));

            Set<Edge> edges = new HashSet<>();

            edges.addAll(graph2.getEdges());
            edges.addAll(graph1.getEdges());

            System.out.println(edges);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String...args) {


        new GraphTester().test1();
    }
}




