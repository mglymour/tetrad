///////////////////////////////////////////////////////////////////////////////
// For information as to what this class does, see the Javadoc, below.       //
// Copyright (C) 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006,       //
// 2007, 2008, 2009, 2010, 2014, 2015 by Peter Spirtes, Richard Scheines, Joseph   //
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

package edu.cmu.tetradapp.editor;

import edu.cmu.tetrad.graph.Graph;
import edu.cmu.tetrad.graph.Node;
import edu.cmu.tetrad.sem.SemIm;
import edu.cmu.tetrad.sem.SemUpdater;
import edu.cmu.tetrad.util.NumberFormatUtil;
import edu.cmu.tetradapp.workbench.DisplayNode;
import edu.cmu.tetradapp.workbench.GraphWorkbench;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Lets the user visually add and remove evidence, perform updates, and view
 * Bayes updating results.
 *
 * @author William Taysom -- Jun 14, 2003
 * @author Joseph Ramsey
 */
public class SemEvidenceWizardMultiple extends JPanel {
    private SemUpdater semUpdater;
    private GraphWorkbench workbench;
    private final SemEvidenceEditor evidenceEditor;
    private JTextArea textArea = new JTextArea("Nothing to display");

    /**
     * This is the wizard for the BayesUpdateEditor class.  It allows you to add
     * and remove evidence, and to updater based on it.  Parameters are of the
     * form P(Node=c1|Parent1=c2, Parent2=c2,...); values for these parameters
     * are probabilities ranging from 0.0 to 1.0.
     */
    public SemEvidenceWizardMultiple(SemUpdater semUpdater,
            GraphWorkbench workbench) {
        if (semUpdater == null) {
            throw new NullPointerException();
        }

        if (workbench == null) {
            throw new NullPointerException();
        }

        // Components.
        this.semUpdater = semUpdater;
        this.workbench = workbench;

        workbench.setAllowDoubleClickActions(false);
        setBorder(new MatteBorder(10, 10, 10, 10, getBackground()));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton calcMarginalsAndJointButton =
                new JButton("Calculate Marginals and Joint");

        // Do Layout.
        Box b0 = Box.createHorizontalBox();
        b0.add(new JLabel("<html>" +
                "Select a set of nodes (by holding down the shift key) whose" +
                "<br>marginals you would like to see given the evidence indicated" +
                "<br>above.  Click the 'Calculate Marginals' button to view" +
                "<br>marginals and log odds results."));
        b0.add(Box.createHorizontalGlue());
        add(b0);
        add(Box.createVerticalStrut(10));
        evidenceEditor = new SemEvidenceEditor(semUpdater.getEvidence());
        add(evidenceEditor);
        add(Box.createVerticalStrut(10));

        Box b2 = Box.createHorizontalBox();
        b2.add(Box.createHorizontalGlue());
        b2.add(calcMarginalsAndJointButton);
        add(b2);
        add(Box.createVerticalGlue());

        // Add listeners.
        calcMarginalsAndJointButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List selectedGraphNodes = getWorkbench().getSelectedNodes();

                getSemUpdater().setEvidence(evidenceEditor.getEvidence());

                Graph updatedGraph = getSemUpdater().getManipulatedGraph();
                getWorkbench().setGraph(updatedGraph);

                List selectedNodes = new LinkedList();

                for (Object selectedGraphNode : selectedGraphNodes) {
                    DisplayNode graphNode = (DisplayNode) selectedGraphNode;
                    Node tetradNode = graphNode.getModelNode();
                    String selectedNodeName = tetradNode.getName();
                    Node selectedNode = updatedGraph.getNode(selectedNodeName);
                    selectedNodes.add(selectedNode);
                }

                for (Object selectedNode1 : selectedNodes) {
                    Node node = (Node) selectedNode1;
                    getWorkbench().selectNode(node);
                }

                Collections.sort(selectedNodes, new Comparator<Node>() {
                    public int compare(Node o1, Node o2) {
                        String name1 = o1.getName();
                        String name2 = o2.getName();
                        return name1.compareTo(name2);
                    }
                });

                JTextArea marginalsArea = new JTextArea();
                marginalsArea.setEditable(false);

                NumberFormat nf = NumberFormatUtil.getInstance().getNumberFormat();

                if (selectedNodes.size() == 0) {
                    marginalsArea.append("\nNo nodes selected.");
                }
                else {
//                    appendMarginals(selectedNodes, marginalsArea,
//                            manipulatedIm, nf);
//                    appendJoint(selectedNodes, marginalsArea,
//                            manipulatedIm, nf);
                }

                textArea = marginalsArea;
                firePropertyChange("updateButtonPressed", null, null);
            }
        });
    }

//    private void appendMarginals(List selectedNodes, JTextArea marginalsArea,
//            SemIm manipulatedIm, NumberFormat nf) {
//        SemPm bayesPm = manipulatedIm.getEstIm();
//
//        marginalsArea.append("MARGINALS FOR SELECTED VARIABLES:\n");
//
//        for (int i = 0; i < selectedNodes.size(); i++) {
//            Node selectedNode = (Node) selectedNodes.get(i);
//            marginalsArea.append(
//                    "\nVariable " + selectedNode.getName() + ":\n");
//
//            int nodeIndex = manipulatedIm.getNodeIndex(selectedNode);
//
//            for (int j = 0;
//                 j < bayesPm.getNumSplits(selectedNode); j++) {
//                double prob = getSemUpdater().getMarginal(nodeIndex,
//                        j);
//                double logOdds = Math.log(prob / (1. - prob));
//
//                marginalsArea.append("Category " +
//                        bayesPm.getCategory(selectedNode, j) +
//                        ": p = " +
//                        nf.format(prob) +
//                        ",  log odds = " +
//                        nf.format(logOdds) +
//                        "\n");
//            }
//
//        }
//    }

//    private void appendJoint(List selectedNodes, JTextArea marginalsArea,
//            BayesIm manipulatedIm, NumberFormat nf) {
//        if (!getSemUpdater().isJointMarginalSupported()) {
//            marginalsArea.append("\n\n(Calculation of joint not supported " +
//                    "for this updater.)");
//            return;
//        }
//
//        BayesPm bayesPm = manipulatedIm.getBayesPm();
//        int numNodes = selectedNodes.size();
//        int[] dims = new int[numNodes];
//        int[] variables = new int[numNodes];
//        int numRows = 1;
//
//        for (int i = 0; i < numNodes; i++) {
//            Node node = (Node) selectedNodes.get(i);
//            int numCategories = bayesPm.getNumSplits(node);
//            variables[i] = manipulatedIm.getNodeIndex(node);
//            dims[i] = numCategories;
//            numRows *= numCategories;
//        }
//
//        marginalsArea.append("\n\nJOINT OVER SELECTED VARIABLES:\n\n");
//
//        for (int i = 0; i < numNodes; i++) {
//            marginalsArea.append(selectedNodes.get(i) + "\t");
//        }
//
//        marginalsArea.append("Joint\tLog odds\n");
//
//        for (int row = 0; row < numRows; row++) {
//            int[] values = getSplitNames(row, dims);
//            double prob = getSemUpdater().getJointMarginal(variables,
//                    values);
//            double logOdds = Math.log(prob / (1. - prob));
//
//            marginalsArea.append("\n");
//
//            for (int j = 0; j < numNodes; j++) {
//                Node node = (Node) selectedNodes.get(j);
//                marginalsArea.append(bayesPm.getCategory(node, values[j]));
//                marginalsArea.append("\t");
//            }
//
//            marginalsArea.append(nf.format(prob) + "\t");
//            marginalsArea.append(nf.format(logOdds));
//        }
//    }

//    private int[] getSplitNames(int row, int[] dims) {
//        int[] values = new int[dims.length];
//
//        for (int i = dims.length - 1; i >= 0; i--) {
//            values[i] = row % dims[i];
//            row /= dims[i];
//        }
//
//        return values;
//    }

    public SemIm getSemIm() {
        return getSemUpdater().getUpdatedSemIm();
    }

    private SemUpdater getSemUpdater() {
        return semUpdater;
    }

    private GraphWorkbench getWorkbench() {
        return workbench;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}




