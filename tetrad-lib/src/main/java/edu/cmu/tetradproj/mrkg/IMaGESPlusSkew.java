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
public class IMaGESPlusSkew extends TestCase {

    /**
     * Standard constructor for JUnit test cases.
     */
    public IMaGESPlusSkew(String name) {
        super(name);
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

            List<String> normDirectories = new ArrayList<>();
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Smooth_Clean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Smooth_Clean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Smooth_Unclean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Smooth_Unclean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Unsmooth_Clean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Unsmooth_Clean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Native_Unsmooth_Unclean");
            normDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Both/Spline_Unsmooth_Unclean");

            List<String> autDirectories = new ArrayList<>();
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Smooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Smooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Smooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Smooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Unsmooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Unsmooth_Clean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Native_Unsmooth_Unclean");
            autDirectories.add("/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/Spline_Unsmooth_Unclean");

            DataReader normReader = new DataReader();
            DataReader autReader = new DataReader();
            DataSet normData;
            DataSet autData;
            File normDataFile;
            File autDataFile;
            String normGraphName;
            String autGraphName;
            String normGraphFile;
            String autGraphFile;
            String name;
            Graph normGraph;
            Graph autGraph;
            Graph normSkewGraph;
            Graph autSkewGraph;
            Lofs2 normSkew;
            Lofs2 autSkew;
            List<DataSet> normList;
            List<DataSet> autList;
            FileWriter normWriter;
            BufferedWriter normGraphWriter;
            FileWriter autWriter;
            BufferedWriter autGraphWriter;
            FileWriter compWriter;
            BufferedWriter compBufferedWriter;
            String compFile;
            GraphUtils.GraphComparison comp;

            for (int i = 0; i < 8; i++){
                normList = new ArrayList<>();
                autList = new ArrayList<>();

                for (int j = 0; j < 10; j++){
                    name = "normal_ROI_data_" + interpols.get(i) + "_" + numbers.get(j) + ".txt";

                    normDataFile = new File(normDirectories.get(i), name);
                    autDataFile = new File(autDirectories.get(i), name);
                    normData = normReader.parseTabular(normDataFile);
                    autData = autReader.parseTabular(autDataFile);

                    normList.add(normData);
                    autList.add(autData);
                }

                normGraphName = normDirectories.get(i) + "/Twenty/" + interpols.get(i) + "_master_graph.txt";
                autGraphName = autDirectories.get(i) + "/Twenty/" + interpols.get(i) + "_master_graph.txt";

                normGraph = GraphUtils.loadGraphTxt(new File(normGraphName));
                autGraph = GraphUtils.loadGraphTxt(new File(autGraphName));

                normSkew = new Lofs2(normGraph, normList);
                autSkew = new Lofs2(autGraph, autList);
                normSkew.setRule(Lofs2.Rule.valueOf("Skew"));
                autSkew.setRule(Lofs2.Rule.valueOf("Skew"));
                normSkew.setScore(Lofs.Score.valueOf("andersonDarling"));
                autSkew.setScore(Lofs.Score.valueOf("andersonDarling"));
                normSkew.setAlpha(1.0);
                autSkew.setAlpha(1.0);

                normSkewGraph = normSkew.orient();
                autSkewGraph = autSkew.orient();

                normGraphFile = normDirectories.get(i) + "/" + interpols.get(i) + "_master_skew_graph.txt";
                autGraphFile = autDirectories.get(i) + "/" + interpols.get(i) + "_master_skew_graph.txt";
                normWriter = new FileWriter(new File(normGraphFile));
                autWriter = new FileWriter(new File(autGraphFile));
                normGraphWriter = new BufferedWriter(normWriter);
                autGraphWriter = new BufferedWriter(autWriter);

                normGraphWriter.write(normSkewGraph.toString());
                normGraphWriter.close();
                autGraphWriter.write(autSkewGraph.toString());
                autGraphWriter.close();

                compFile = "/Users/user/Documents/FMRI/Tetrad/USM_Aut_Both/" + interpols.get(i) + "_comp.txt";
                comp = SearchGraphUtils.getGraphComparison(autSkewGraph, normSkewGraph);
                compWriter = new FileWriter(new File(compFile));
                compBufferedWriter = new BufferedWriter(compWriter);

                compBufferedWriter.write("ADJ Correct: " + Integer.toString(comp.getAdjCorrect()) + "\nADJ FN: " +
                        Integer.toString(comp.getAdjFn()) + "\nADJ FP: " + Integer.toString(comp.getAdjFp()) + "\n AHD Correct: " +
                        Integer.toString(comp.getArrowptCorrect()) + "\n AHD FN: " + Integer.toString(comp.getArrowptFn()) + "\n AHD FP: " +
                        Integer.toString(comp.getArrowptFp()) + "\n Norm Edges: " + Integer.toString(normSkewGraph.getNumEdges()) +
                        "\n Aut Edges: " + Integer.toString(autSkewGraph.getNumEdges()));
                compBufferedWriter.close();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * This method uses reflection to collect up all of the test methods from this class and return them to the test
     * runner.
     */
    public static junit.framework.Test suite() {

        // Edit the name of the class in the parens to match the name
        // of this class.
        return new TestSuite(IMaGESPlusSkew.class);
    }
}




