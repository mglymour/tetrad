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
//import edu.cmu.tetradapp.model.GraphComparison;
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
public class NoCerebellumFGS extends TestCase {

    /**
     * Standard constructor for JUnit test cases.
     */
    private String brain;
    private double discount;
    private int discountInt;
    private int numGraphs;

    public NoCerebellumFGS(String brain_specs, double penalty_discount, int num){
        brain = brain_specs;
        discount = penalty_discount;
        discountInt = (int)discount;
        numGraphs = num;
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

            List<String> directories = new ArrayList<>();
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Unclean");

            DataReader reader = new DataReader();
            DataSet data;
            File dataFile;
            String graphFile;
            String name;
            Graph graph;
            Fgs ges;
            FileWriter writer;
            BufferedWriter graphWriter;


                for (int j = 0; j < numGraphs; j++) {
                    name = "test_normal_roi_data_spline_smooth_clean_" + numbers.get(j) + ".txt";

                    dataFile = new File("/Users/user/Documents/FMRI/Tetrad/" + brain, name);
                    data = reader.parseTabular(dataFile);

                    ges = new Fgs(data);
                    ges.setPenaltyDiscount(discount);
                    ges.setVerbose(false);
                    ges.setLog(false);
                    graph = ges.search();


                    graphFile = "/Users/user/Documents/FMRI/Tetrad/" + brain + "/FGS_graph_spline_smooth_clean_" + numbers.get(j) + "_" + Integer.toString(discountInt) + ".txt";
                    writer = new FileWriter(new File(graphFile));
                    graphWriter = new BufferedWriter(writer);

                    graphWriter.write(graph.toString());
                    graphWriter.flush();
                    graphWriter.close();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method uses reflection to collect up all of the test methods from this class and return them to the test
     * runner.
     */
    public static void main(String...args){
        NoCerebellumFGS typ = new NoCerebellumFGS("USM_Group_2", 2.0, 19);
        NoCerebellumFGS aut = new NoCerebellumFGS("USM_Aut_Group_2", 2.0, 25);

        typ.test1();
        aut.test1();
    }
}




