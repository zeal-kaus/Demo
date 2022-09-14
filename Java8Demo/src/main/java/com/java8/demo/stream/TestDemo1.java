package com.java8.demo.stream;


/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 * 
 * Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

class Solution {
    public static int[] twoSum(int[] nums, int target) {
       int indexes[] = {-1,-1};
       
       for (int i=0; i<nums.length-1; i++) {
    	   for (int j=i+1; j<nums.length; j++) {
        	   if(nums[i] + nums[j] == target) {
        		   indexes[0] = i;
        		   indexes[1] = j;
        		   return indexes;
        	   }
           }
       }
    	
    	return indexes;
    }
}

public class TestDemo1 {
	
	public static void main(String[] args) {
		int numbs[] = {2,7,11,15};
		int solution[] = Solution.twoSum(numbs, 27);
		System.out.println(solution[0]+" : "+solution[1]);
	

	}

}
