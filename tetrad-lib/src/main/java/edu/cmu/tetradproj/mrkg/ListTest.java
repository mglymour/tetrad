package edu.cmu.tetradproj.mrkg;

import java.io.*;
import java.util.*;

/**
 * Created by user on 11/19/15.
 */
public class ListTest {

    public ListTest(){

    }

    public void test1(){
        try {

            List<List> graphs = new ArrayList<>();

            for (int i = 0; i < 5; i++){
                graphs.add(new ArrayList<Integer>());
            }

            List<Integer> temp;

            for (int i = 0; i < 5; i++){
                temp = graphs.get(i);
                for (int k = 0; k < 5; k++){
                    temp.add(i + k);
                }
            }

            for (int i = 0; i < 5; i++){
                for (int j = i + 1; j < 5; j++){

                    System.out.println(graphs.get(i));
                    System.out.println(graphs.get(j));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        ListTest test = new ListTest();
        test.test1();
    }
}
