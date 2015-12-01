package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.data.*;
import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.search.*;
import edu.cmu.tetrad.sem.SemIm;
import edu.cmu.tetrad.sem.SemPm;
import edu.cmu.tetrad.util.ChoiceGenerator;
import edu.cmu.tetrad.util.RandomUtil;
import edu.cmu.tetrad.util.StatUtils;
import edu.cmu.tetrad.util.TetradLogger;
import edu.cmu.tetradapp.model.GraphComparison;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;
import java.util.*;

///////////////////////////////////////////////////////////////////////////////
// For information as to what this class does, see the Javadoc, below.       //
// CopyBoth (C) 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006,       //
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
public class SkewSearch extends TestCase {

    /**
     * Standard constructor for JUnit test cases.
     */
    private String brain;
    private double discount;
    private int discountInt;

    public SkewSearch(String brain_specs, double penalty_discount){
        brain = brain_specs;
        discount = penalty_discount;
        discountInt = (int)discount;
    }

    public void test1() {
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

            List<List> shdLists = new ArrayList<>();

            DataReader reader = new DataReader();
            DataSet data;
            File dataFile;
            String graphFile;
            String name;
            Graph graph;
            Graph skewGraph;
            FastGes ges;
            Lofs2 skew;
            List<DataSet> dummyList;
            FileWriter writer;
            BufferedWriter graphWriter;
            List<Graph> interpolGraphs;

            int prep = 0;
            int subj;


            for (int i = 0; i < 8; i++){

                subj = 0;

                interpolGraphs = new ArrayList<>();

                for (int j = 0; j < 10; j++){
                    name = "normal_ROI_data_" + interpols.get(i) + "_" + numbers.get(j) + ".txt";

                    dataFile = new File(directories.get(i), name);
                    data = reader.parseTabular(dataFile);
                    dummyList = new ArrayList<>();
                    dummyList.add(data);

                    ges = new FastGes(data);
                    ges.setPenaltyDiscount(discount);
                    ges.setVerbose(false);
                    ges.setLog(false);
                    graph = ges.search();

                    skew = new Lofs2(graph, dummyList);
                    skew.setRule(Lofs2.Rule.Skew);
                    skew.setScore(Lofs.Score.andersonDarling);
                    skew.setAlpha(1.0);
                    skewGraph = skew.orient();
                    interpolGraphs.add(skewGraph);
               //     System.out.println(upperInterpols.get(i) + " " + Integer.toString(j) + ": " + interpolGraphs.isEmpty());

                    graphFile = directories.get(i) + "/" + interpols.get(i) + "_GES_skew_3_graph_" + numbers.get(j) + ".txt";
                    writer = new FileWriter(new File(graphFile));
                    graphWriter = new BufferedWriter (writer);

                    graphWriter.write(skewGraph.toString());
                    graphWriter.flush();
                    graphWriter.close();

                    subj++;
                }
                graphLists.add(interpolGraphs);
                System.out.println("Searched " + Integer.toString(subj) + " subjects!");
                prep++;

            }

      //      System.out.println("Searched " + Integer.toString(prep) + " BRAIN THINGS!");

       //     System.out.println("AND ANOTHER THING!");

            List<Integer> interpolSHDs;

         //   System.out.println("LISTEN LADY!");

            Graph graph1;
            Graph graph2;

            for (int i = 0; i < interpols.size(); i++){
                interpolGraphs = graphLists.get(i);
                interpolSHDs = new ArrayList<Integer>();
                for (int j = 0; j < 10; j++){
                    graph1 = interpolGraphs.get(j);
                    for (int k = j + 1; k < 10; k++){
                        graph2 = interpolGraphs.get(k);
                        int first = graph1.getNumEdges();
                        int second = graph2.getNumEdges();
                        System.out.println(first == second);
                        System.out.println(Integer.toString(Math.abs(SearchGraphUtils.structuralHammingDistance(graph1, graph2))));
                        interpolSHDs.add(Math.abs(SearchGraphUtils.structuralHammingDistance(graph1, graph2)));
                    }
                }
                shdLists.add(interpolSHDs);
            }

         //   System.out.println("This is some BULLSHIT!");

            List<Double> averages = new ArrayList<>();
            List<Double> variances = new ArrayList<>();

            double sum;
            double diff;

            for (int i = 0; i < interpols.size(); i++){
                sum = 0;
                interpolSHDs = shdLists.get(i);
                for (int j = 0; j < interpolSHDs.size(); j++){
                    sum += (double)interpolSHDs.get(j);
                }
                averages.add(sum/(double)interpolSHDs.size());
            }

            for (int i = 0; i < interpols.size(); i++){
                sum = 0;
                interpolSHDs = shdLists.get(i);
                for (int j = 0; j < interpolSHDs.size(); j++){
                    diff = Math.pow((averages.get(i) - (double)interpolSHDs.get(j)), 2.0);
                    sum += diff;
                }
                variances.add(sum/(double)interpolSHDs.size());
            }

            FileWriter avgWriter = new FileWriter(new File("/Users/user/Documents/FMRI/Tetrad/" + brain + "/SHD_" + Integer.toString(discountInt) + ".txt"));
            BufferedWriter bavgWriter = new BufferedWriter(avgWriter);

            for (int i = 0; i < interpols.size(); i++){
                bavgWriter.write(upperInterpols.get(i) + " Average: " + Double.toString(averages.get(i)) + "\n");
                bavgWriter.write(upperInterpols.get(i) + " Variance: " + Double.toString(variances.get(i)) + "\n\n");
            }

            bavgWriter.flush();
            bavgWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * This method uses reflection to collect up all of the test methods from this class and return them to the test
     * runner.
     */
    public static void main(String...args){
        SkewSearch both2 = new SkewSearch("USM_Both", 2.0);
        SkewSearch both4 = new SkewSearch("USM_Both", 4.0);
        SkewSearch both6 = new SkewSearch("USM_Both", 6.0);

        SkewSearch left2 = new SkewSearch("USM_Left", 2.0);
        SkewSearch left4 = new SkewSearch("USM_Left", 4.0);
        SkewSearch left6 = new SkewSearch("USM_Left", 6.0);

        SkewSearch right2 = new SkewSearch("USM_Right", 2.0);
        SkewSearch right4 = new SkewSearch("USM_Right", 4.0);
        SkewSearch right6 = new SkewSearch("USM_Right", 6.0);

        SkewSearch aut_both2 = new SkewSearch("USM_Aut_Both", 2.0);
        SkewSearch aut_both4 = new SkewSearch("USM_Aut_Both", 4.0);
        SkewSearch aut_both6 = new SkewSearch("USM_Aut_Both", 6.0);

        SkewSearch aut_left2 = new SkewSearch("USM_Aut_Left", 2.0);
        SkewSearch aut_left4 = new SkewSearch("USM_Aut_Left", 4.0);
        SkewSearch aut_left6 = new SkewSearch("USM_Aut_Left", 6.0);

        SkewSearch aut_right2 = new SkewSearch("USM_Aut_Right", 2.0);
        SkewSearch aut_right4 = new SkewSearch("USM_Aut_Right", 4.0);
        SkewSearch aut_right6 = new SkewSearch("USM_Aut_Right", 6.0);

        both2.test1();
        System.out.println("Whole Brain Penalty Discount 2 Done!");
        both4.test1();
        both6.test1();

        left2.test1();
        left4.test1();
        left6.test1();

        right2.test1();
        right4.test1();
        right6.test1();

        aut_both2.test1();
        aut_both4.test1();
        aut_both6.test1();

        aut_left2.test1();
        aut_left4.test1();
        aut_left6.test1();

        aut_right2.test1();
        aut_right4.test1();
        aut_right6.test1();
    }
}




