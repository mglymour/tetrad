package edu.cmu.tetradproj.mrkg;

import edu.cmu.tetrad.data.*;
import edu.cmu.tetrad.graph.*;
import edu.cmu.tetrad.search.FastImages;

import java.io.*;
import java.util.*;

/**
 * Runs the robustness analysis.
 *
 * @author Joseph Ramsey
 */
public class Test {

    private String brain;
    private double discount;
    private int discountInt;

    public Test(String brain_specs, double penalty_discount){
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

            // list of data directories
            List<String> directories = new ArrayList<>();
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Smooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Clean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Native_Unsmooth_Unclean");
            directories.add("/Users/user/Documents/FMRI/Tetrad/" + brain + "/Spline_Unsmooth_Unclean");

            //  lists of lists of data sets for each of the 100 subsets of seven
            List<List> nativeSmoothCleanDataSets = new ArrayList<>();
            List<List> splineSmoothCleanDataSets = new ArrayList<>();
            List<List> nativeSmoothUncleanDataSets = new ArrayList<>();
            List<List> splineSmoothUncleanDataSets = new ArrayList<>();
            List<List> nativeUnsmoothCleanDataSets = new ArrayList<>();
            List<List> splineUnsmoothCleanDataSets = new ArrayList<>();
            List<List> nativeUnsmoothUncleanDataSets = new ArrayList<>();
            List<List> splineUnsmoothUncleanDataSets = new ArrayList<>();

            // list of data sets for each preprocessing method; will be reinstantiated for each subset of 7
            List<DataSet> nativeSmoothCleanData;
            List<DataSet> splineSmoothCleanData;
            List<DataSet> nativeSmoothUncleanData;
            List<DataSet> splineSmoothUncleanData;
            List<DataSet> nativeUnsmoothCleanData;
            List<DataSet> splineUnsmoothCleanData;
            List<DataSet> nativeUnsmoothUncleanData;
            List<DataSet> splineUnsmoothUncleanData;

            // list of all ten data sets for each preprocessing method
            List<DataSet> master_nativeSmoothCleanData = new ArrayList<>();
            List<DataSet> master_splineSmoothCleanData = new ArrayList<>();
            List<DataSet> master_nativeSmoothUncleanData = new ArrayList<>();
            List<DataSet> master_splineSmoothUncleanData = new ArrayList<>();
            List<DataSet> master_nativeUnsmoothCleanData = new ArrayList<>();
            List<DataSet> master_splineUnsmoothCleanData = new ArrayList<>();
            List<DataSet> master_nativeUnsmoothUncleanData = new ArrayList<>();
            List<DataSet> master_splineUnsmoothUncleanData = new ArrayList<>();

            // file name, file, data reader, and data set variables; reinstantiated for each data set
            String name;
            DataReader reader = new DataReader();
            DataSet data;
            File file;

            // populate the master list of all 10 data sets for each preprocessing method
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < interpols.size(); k++) {
                    if (i < 9) {
                        name = "normal_ROI_data_" + interpols.get(k) + "_00" + Integer.toString(i + 1) + ".txt";
                    } else if (i < 100) {
                        name = "normal_ROI_data_" + interpols.get(k) + "_0" + Integer.toString(i + 1) + ".txt";
                    } else {
                        name = "normal_ROI_data_" + interpols.get(k) + "_" + Integer.toString(i + 1) + ".txt";
                    }

                    file = new File(directories.get(k), name);
                    data = reader.parseTabular(file);

                    switch (interpols.get(k)) {
                        case "native_smooth_clean":
                            master_nativeSmoothCleanData.add(data);
                            break;
                        case "spline_smooth_clean":
                            master_splineSmoothCleanData.add(data);
                            break;
                        case "native_smooth_unclean":
                            master_nativeSmoothUncleanData.add(data);
                            break;
                        case "spline_smooth_unclean":
                            master_splineSmoothUncleanData.add(data);
                            break;
                        case "native_unsmooth_clean":
                            master_nativeUnsmoothCleanData.add(data);
                            break;
                        case "spline_unsmooth_clean":
                            master_splineUnsmoothCleanData.add(data);
                            break;
                        case "native_unsmooth_unclean":
                            master_nativeUnsmoothUncleanData.add(data);
                            break;
                        case "spline_unsmooth_unclean":
                            master_splineUnsmoothUncleanData.add(data);
                            break;
                    }
                }
            }

            // file name, IMaGES search, graph, and file writers for the master IMaGES graph of all 10 data sets; reinstantiated for
            // each preprocessing method
            String master_graphFile;
            FastImages master_images;
            Graph master_imagesGraph = null;
            FileWriter master_writer;
            BufferedWriter master_graphWriter;

            // search for and save the master IMaGES graph of all 10 data sets, for each preprocessing method
            for (int i = 0; i < interpols.size(); i++) {

                master_graphFile = directories.get(i) + "/" + interpols.get(i) + "_master_graph_" + Integer.toString(discountInt) + ".txt";

                master_writer = new FileWriter(new File(master_graphFile));

                master_graphWriter = new BufferedWriter(master_writer);

                switch (interpols.get(i)) {
                    case "native_smooth_clean":
                        master_images = new FastImages(master_nativeSmoothCleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "spline_smooth_clean":
                        master_images = new FastImages(master_splineSmoothCleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "native_smooth_unclean":
                        master_images = new FastImages(master_nativeSmoothUncleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "spline_smooth_unclean":
                        master_images = new FastImages(master_splineSmoothUncleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "native_unsmooth_clean":
                        master_images = new FastImages(master_nativeUnsmoothCleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "spline_unsmooth_clean":
                        master_images = new FastImages(master_splineUnsmoothCleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "native_unsmooth_unclean":
                        master_images = new FastImages(master_nativeUnsmoothUncleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    case "spline_unsmooth_unclean":
                        master_images = new FastImages(master_splineUnsmoothUncleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        master_imagesGraph = master_images.search();
                        break;
                    default:
                        master_images = new FastImages(master_nativeSmoothCleanData, true);
                        master_images.setPenaltyDiscount(discount);
                        System.out.println("Error");
                }

                master_graphWriter.write(master_imagesGraph.toString());
                master_graphWriter.close();

            }

            // read in the list of (10 choose 7) combinations, and shuffle the list
            Scanner numScan = new Scanner(new File("/Users/user/Documents/FMRI/Tetrad/combinations_7_10.txt"));
            List<List> combos = new ArrayList<>();
            List<Integer> newCombo;
            int temp;

            for (int i = 0; i < 120; i++) {
                newCombo = new ArrayList<>();
                for (int j = 0; j < 7; j++) {
                    temp = numScan.nextInt();
                    newCombo.add(temp);
                }
                combos.add(newCombo);
            }

            Collections.shuffle(combos);

            // create 100 lists of 7 data sets for each of the preprocessing methods
            for (int i = 1; i < 101; i++) {

                nativeSmoothCleanData = new ArrayList<>();
                splineSmoothCleanData = new ArrayList<>();
                nativeSmoothUncleanData = new ArrayList<>();
                splineSmoothUncleanData = new ArrayList<>();
                nativeUnsmoothCleanData = new ArrayList<>();
                splineUnsmoothCleanData = new ArrayList<>();
                nativeUnsmoothUncleanData = new ArrayList<>();
                splineUnsmoothUncleanData = new ArrayList<>();

                List<Integer> set = combos.get(i);

                //get 7 data sets for each preprocessing method
                for (int k = 0; k < 7; k++) {

                    for (int j = 0; j < interpols.size(); j++) {

                        if (set.get(k) < 10) {
                            name = "normal_ROI_data_" + interpols.get(j) + "_00" + Integer.toString(set.get(k)) + ".txt";
                        } else {
                            name = "normal_ROI_data_" + interpols.get(j) + "_0" + Integer.toString(set.get(k)) + ".txt";
                        }

                        file = new File(directories.get(j), name);
                        data = reader.parseTabular(file);

                        switch (interpols.get(j)) {
                            case "native_smooth_clean":
                                nativeSmoothCleanData.add(data);
                                break;
                            case "spline_smooth_clean":
                                splineSmoothCleanData.add(data);
                                break;
                            case "native_smooth_unclean":
                                nativeSmoothUncleanData.add(data);
                                break;
                            case "spline_smooth_unclean":
                                splineSmoothUncleanData.add(data);
                                break;
                            case "native_unsmooth_clean":
                                nativeUnsmoothCleanData.add(data);
                                break;
                            case "spline_unsmooth_clean":
                                splineUnsmoothCleanData.add(data);
                                break;
                            case "native_unsmooth_unclean":
                                nativeUnsmoothUncleanData.add(data);
                                break;
                            case "spline_unsmooth_unclean":
                                splineUnsmoothUncleanData.add(data);
                                break;
                        }

                    }

                }

                // add the 7 data sets to the list of list of data sets for each preprocessing method
                nativeSmoothCleanDataSets.add(nativeSmoothCleanData);
                splineSmoothCleanDataSets.add(splineSmoothCleanData);
                nativeSmoothUncleanDataSets.add(nativeSmoothUncleanData);
                splineSmoothUncleanDataSets.add(splineSmoothUncleanData);
                nativeUnsmoothCleanDataSets.add(nativeUnsmoothCleanData);
                splineUnsmoothCleanDataSets.add(splineUnsmoothCleanData);
                nativeUnsmoothUncleanDataSets.add(nativeUnsmoothUncleanData);
                splineUnsmoothUncleanDataSets.add(splineUnsmoothUncleanData);
            }
            // list of 100 IMaGES graphs for each preprocessing method
            List<Graph> nativeSmoothCleanGraphs = new ArrayList<>();
            List<Graph> splineSmoothCleanGraphs = new ArrayList<>();
            List<Graph> nativeSmoothUncleanGraphs = new ArrayList<>();
            List<Graph> splineSmoothUncleanGraphs = new ArrayList<>();
            List<Graph> nativeUnsmoothCleanGraphs = new ArrayList<>();
            List<Graph> splineUnsmoothCleanGraphs = new ArrayList<>();
            List<Graph> nativeUnsmoothUncleanGraphs = new ArrayList<>();
            List<Graph> splineUnsmoothUncleanGraphs = new ArrayList<>();

            // file name, IMaGES search, graph, and file writer for the IMaGES graphs; reinstantiated for each graph
            String graphFile;
            FastImages images;
            Graph imagesGraph = null;
            FileWriter writer;
            BufferedWriter graphWriter;

            // search each data set using IMaGES and save the resulting graph
            for (int i = 0; i < nativeSmoothCleanDataSets.size(); i++) {

                for (int j = 0; j < interpols.size(); j++) {

                    if (i < 9) {
                        graphFile = directories.get(j) + "/" + interpols.get(j) + "_graph_00" + Integer.toString(i + 1) + "_" + Integer.toString(discountInt) + ".txt";
                    } else if (i < 99) {
                        graphFile = directories.get(j) + "/" + interpols.get(j) + "_graph_0" + Integer.toString(i + 1) + "_" + Integer.toString(discountInt) + ".txt";
                    } else {
                        graphFile = directories.get(j) + "/" + interpols.get(j) + "_graph_" + Integer.toString(i + 1) + "_" + Integer.toString(discountInt) + ".txt";
                    }

                    writer = new FileWriter(new File(graphFile));

                    graphWriter = new BufferedWriter(writer);


                    switch (interpols.get(j)) {
                        case "native_smooth_clean":
                            images = new FastImages(nativeSmoothCleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            nativeSmoothCleanGraphs.add(imagesGraph);
                            break;
                        case "spline_smooth_clean":
                            images = new FastImages(splineSmoothCleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            splineSmoothCleanGraphs.add(imagesGraph);
                            break;
                        case "native_smooth_unclean":
                            images = new FastImages(nativeSmoothUncleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            nativeSmoothUncleanGraphs.add(imagesGraph);
                            break;
                        case "spline_smooth_unclean":
                            images = new FastImages(splineSmoothUncleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            splineSmoothUncleanGraphs.add(imagesGraph);
                            break;
                        case "native_unsmooth_clean":
                            images = new FastImages(nativeUnsmoothCleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            nativeUnsmoothCleanGraphs.add(imagesGraph);
                            break;
                        case "spline_unsmooth_clean":
                            images = new FastImages(splineUnsmoothCleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            splineUnsmoothCleanGraphs.add(imagesGraph);
                            break;
                        case "native_unsmooth_unclean":
                            images = new FastImages(nativeUnsmoothUncleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            nativeUnsmoothUncleanGraphs.add(imagesGraph);
                            break;
                        case "spline_unsmooth_unclean":
                            images = new FastImages(splineUnsmoothUncleanDataSets.get(i), true);
                            images.setPenaltyDiscount(discount);
                            imagesGraph = images.search();
                            splineUnsmoothUncleanGraphs.add(imagesGraph);
                            break;
                        default:
                            images = new FastImages(nativeSmoothCleanDataSets.get(i), true);
                            System.out.println("Error");
                    }

                    graphWriter.write(imagesGraph.toString());
                    graphWriter.close();
                }
            }

            // file name and writer for the 100-subset comparison; reinstantiated for each preprocessing method
            String compFile;
            PrintWriter compOut;

            // compare the IMaGES graphs of the 100 subsets for each preprocessing method, and save the results
            for (int i = 0; i < 8; i++) {
                compFile = directories.get(i) + "/" + interpols.get(i) + "_comp_" + Integer.toString(discountInt) + ".txt";
                compOut = new PrintWriter(compFile);

                switch (interpols.get(i)) {
                    case "native_smooth_clean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(nativeSmoothCleanGraphs));
                        break;
                    case "spline_smooth_clean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(splineSmoothCleanGraphs));
                        break;
                    case "native_smooth_unclean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(nativeSmoothUncleanGraphs));
                        break;
                    case "spline_smooth_unclean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(splineSmoothUncleanGraphs));
                        break;
                    case "native_unsmooth_clean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(nativeUnsmoothCleanGraphs));
                        break;
                    case "spline_unsmooth_clean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(splineUnsmoothCleanGraphs));
                        break;
                    case "native_unsmooth_unclean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(nativeUnsmoothUncleanGraphs));
                        break;
                    case "spline_unsmooth_unclean":
                        compOut.println(GraphUtils.getIntersectionComparisonString(splineUnsmoothUncleanGraphs));
                        break;
                }

                compOut.flush();
                compOut.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String...args) {

        Test leftNormal2 = new Test("USM_Left", 2.0);
        Test leftNormal4 = new Test("USM_Left", 4.0);
        Test leftNormal6 = new Test("USM_Left", 6.0);

        Test rightNormal2 = new Test("USM_Right", 2.0);
        Test rightNormal4 = new Test("USM_Right", 4.0);
        Test rightNormal6 = new Test("USM_RIght", 6.0);

        Test bothNormal2 = new Test("USM_Both", 2.0);
        Test bothNormal4 = new Test("USM_Both", 4.0);
        Test bothNormal6 = new Test("USM_Both", 6.0);

        Test leftAut2 = new Test("USM_Aut_Left", 2.0);
        Test leftAut4 = new Test("USM_Aut_Left", 4.0);
        Test leftAut6 = new Test("USM_Aut_Left", 6.0);

        Test rightAut2 = new Test("USM_Aut_Right", 2.0);
        Test rightAut4 = new Test("USM_Aut_Right", 4.0);
        Test rightAut6 = new Test("USM_Aut_Right", 6.0);

        Test bothAut2 = new Test("USM_Aut_Both", 2.0);
        Test bothAut4 = new Test("USM_Aut_Both", 4.0);
        Test bothAut6 = new Test("USM_Aut_Both", 6.0);

        leftNormal2.test1();
        leftNormal4.test1();
        leftNormal6.test1();

        rightNormal2.test1();
        rightNormal4.test1();
        rightNormal6.test1();

        bothNormal2.test1();
        bothNormal4.test1();
        bothNormal6.test1();

        leftAut2.test1();
        leftAut4.test1();
        leftAut6.test1();

        rightAut2.test1();
        rightAut4.test1();
        rightAut6.test1();

        bothAut2.test1();
        bothAut4.test1();
        bothAut6.test1();

    }
}




