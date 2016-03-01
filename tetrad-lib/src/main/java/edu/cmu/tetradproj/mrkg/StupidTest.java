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
 * Created by user on 2/29/16.
 */
public class StupidTest {

    public StupidTest(){

    }

    public void runTest(){

        NodeEqualityMode.setEqualityMode(NodeEqualityMode.Type.NAME);

        Graph graph1 = GraphUtils.loadGraphTxt(new File("/Users/user/Documents/FMRI/stupid_graph_1.txt"));
        Graph graph2 = GraphUtils.loadGraphTxt(new File("/Users/user/Documents/FMRI/stupid_graph_2.txt"));

        graph2 = GraphUtils.replaceNodes(graph2, graph1.getNodes());

        Set<Edge> edges1 = graph1.getEdges();
        Iterator<Edge> edges1Iter = edges1.iterator();
        Edge edge;
        Node node1;
        Node node2;

        Edge otherEdge;

        while(edges1Iter.hasNext()){
            edge = edges1Iter.next();
            node1 = edge.getNode1();
            node2 = edge.getNode2();

            System.out.println(graph2.containsEdge(edge));
            System.out.println(graph2.containsNode(node1));
            System.out.println(graph2.containsNode(node2));

            otherEdge = graph2.getEdge(node1, node2);
            System.out.println(otherEdge.toString());
        }
    }

    public static void main(String...args){

        StupidTest stupid = new StupidTest();
        stupid.runTest();

    }

}
