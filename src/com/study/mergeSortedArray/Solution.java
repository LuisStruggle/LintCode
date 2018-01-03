package com.study.mergeSortedArray;

public class Solution {
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int m, int[] B, int n) {
        // Write your code here
    	
        for (int i = 0; i<n; i++) {
        	A[m+i] = B[i];
        }
        
        int num = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] < A[j]) {
                    num = A[i];
                    A[i] = A[j];
                    A[j] = num;
                }
            }
        }

        return A;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		int[] A = new int[4];
		A[0] = 1;
		A[1] = 2;
		int[] B = {2,4};
		for (int i : solution.mergeSortedArray(A,2,B,2)) {
			System.out.print(i + ",");
		}
		
	}
}
