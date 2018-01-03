package com.study.queryTarget;

public class Solution {
	
	public boolean isExistInArray(int[][] array, int target){
		int i = 0;
		int j = 0;
		return isExist(array, target, i, j);
	}
	
	private boolean isExist(int[][] array, int target, int i, int j){
		if(i>array.length-1) {
			return false;
		}
		
		if(array[i][j] == target) {
			return true;
		}
		
		if(array[i][j] > target) {
			return false;
		}else{
			if(j==(array[0].length)-1){
				return isExist(array, target, i+1, 0);
			}else{
				return isExist(array, target, i, j+1);
			}			
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] array = {{1,2,3},{4,6,8},{10,12,13}};
		
		System.out.println(solution.isExistInArray(array, 14));
	}

}
