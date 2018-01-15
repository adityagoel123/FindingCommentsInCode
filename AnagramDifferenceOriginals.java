package com.aditya.mlabs.tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramDifferenceOriginals {

	/*
     * Complete the function below.
     */
    static int[] getMinimumDifference(String[] a, String[] b) {
        // Find Length of any Array.
        int lengthOfDiffArray = a.length;
        int[] diffArray = new int[lengthOfDiffArray];
        for(int i=0; i<a.length; i++){
        	if(a[i].length() != b[i].length()){
        		diffArray[i] = -1;
        	} else if(a[i].length() == b[i].length()) {
        		// Find the difference of unique charachters between these 2 strings.
        		// ABC && DEF
        		int diffForThisPair = 0;
        		
        		char[] charArrayFor1stString = a[i].toCharArray();
        		char[] charArrayFor2ndString = b[i].toCharArray();
        		
        		Map<Character, Integer> charToOccurTimesFor1stString = new HashMap<Character, Integer>();
        		Map<Character, Integer> charToOccurTimesFor2ndString = new HashMap<Character, Integer>();
        		
        		for (char c: charArrayFor1stString) {
        			Integer currCountForThisCharInString = charToOccurTimesFor1stString.get(c);
        			if(null !=currCountForThisCharInString){
        				charToOccurTimesFor1stString.put(c, currCountForThisCharInString+1);
        			} else {
        				charToOccurTimesFor1stString.put(c, 1);
        			}
        		}
        		
        		for (char c: charArrayFor2ndString) {
        			Integer currCountForThisCharInString = charToOccurTimesFor2ndString.get(c);
        			if(null !=currCountForThisCharInString){
        				charToOccurTimesFor2ndString.put(c, currCountForThisCharInString+1);
        			} else {
        				charToOccurTimesFor2ndString.put(c, 1);
        			}
        		}
        		
        		for(char c :charToOccurTimesFor1stString.keySet()) {
        			if(!charToOccurTimesFor2ndString.containsKey(c)){
        				diffForThisPair = diffForThisPair + charToOccurTimesFor1stString.get(c);
        			} else {
        				int occurTimesOfThisCharInFirstString = charToOccurTimesFor1stString.get(c);
        				Integer occurTimesOfThisCharInSecndString = charToOccurTimesFor2ndString.get(c);
        				if(null == occurTimesOfThisCharInSecndString)
        					occurTimesOfThisCharInSecndString = 0;
        				if((occurTimesOfThisCharInSecndString > occurTimesOfThisCharInFirstString)){
        					diffForThisPair = diffForThisPair + (occurTimesOfThisCharInSecndString - occurTimesOfThisCharInFirstString); 
        				} 
        			}
        		}
        		
        		
        		diffArray[i] = diffForThisPair;
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

