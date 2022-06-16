/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Examples:
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Understand:

Match:

Plan:

Implement:

Review:

Evaluate:

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.HashMap;

public class MajorityElement {
    //T:O(N), S:O(1) Info
    //Boyer-Moore Voting Algorithm used to find the majority element among the given elements that have more than N/ 2 occurrences.
    //This algorithm works on the fact that if an element occurs more than N/2 times, it means that the remaining elements other than this would definitely be less than N/2. So let us check the proceeding of the algorithm.
    //First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes. Otherwise, decrease the votes if votes become 0, select another new element as the new candidate
    //e.i: [2,2,1,1,1,2,2], N=7, 7/2=3, majorityCount=3. The amount of times an element to be considered majorityCount has to be greater than 3
    public static int majorityElement(int[] arr){

        int candidate = Integer.parseInt(null);
        int count = 0;

        for (int num : arr) {
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }

    //T:O(N)^2, Space:O(1)
    public static int majorityElementBruteForce(int[] arr){
        //e.i: [2,2,1,1,1,2,2], N=7, 7/2=3, majorityCount=3. The amount of times an element to be considered majorityCount has to be greater than 3
        //As we can see there are 4 2's, and 3 1's. We need to return element 2 because 4 > 3; 4=2's > 3(majorityCount).
        int majorityCount = arr.length/2;

        //nested for loop, holds the integer then checks to see how many times it exist in the array, increment count everytime we see it
        for (int num : arr) {
            int count = 0;
            for (int elem : arr) {
                if(elem == num) {
                    count += 1;
                }
            }
            if(count > majorityCount){      //at anytime if we see count > majorityCount return num
                return num;
            }
        }
        return -1;  //we only get here if we don't find the majority count
    }
}
