package com.aditya.mlabs.tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumManipulationsFor2Anagrams {

	/*
     * Complete the function below.
     */
    static int[] getMinimumDifference(String[] a, String[] b) {
        // Find Length of any Array.
        int lengthOfDiffArray = a.length;
        int[] diffArray = new int[lengthOfDiffArray];
        for(int j=0; j<a.length; j++){
        	if(a[j].length() != b[j].length()){
        		diffArray[j] = -1;
        	} else if(a[j].length() == b[j].length()) {
        		int count = 0;
        		char[] s1 = a[j].toCharArray();
        		char[] s2 = b[j].toCharArray();
        		
                int char_count[] = new int[26];
                for (int i = 0; i < s1.length; i++) {
                    char_count[s1[i] - 'a']++;        
                }
                for (int i = 0; i < s2.length; i++) {
                	if (char_count[s2[i] - 'a']-- <= 0) {
                		count++;
                	}
                }
                diffArray[j] = count;
        	}
        }
        
        return diffArray;
    }

    
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int[] res;
        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        String[] a = new String[a_size];
        for(int i = 0; i < a_size; i++) {
            String a_item;
            try {
                a_item = in.nextLine();
            } catch (Exception e) {
                a_item = null;
            }
            a[i] = a_item;
        }

        int b_size = 0;
        b_size = Integer.parseInt(in.nextLine().trim());

        String[] b = new String[b_size];
        for(int i = 0; i < b_size; i++) {
            String b_item;
            try {
                b_item = in.nextLine();
            } catch (Exception e) {
                b_item = null;
            }
            b[i] = b_item;
        }

        res = getMinimumDifference(a, b);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}

