/*
find the element that only appears once in the array

Understand:
Input, confirming we are only getting Numbers?
Constraints, what is the length of the array of numbers we are getting. what is the -/+ of the int at index i
Output, confirming we are getting array of integers with duplicates find the integer that appears only once

Match:
Array Patters: 2 pointer technique, sliding windows, hashmap to store items from the array

Plan:
what time/space are you requesting? O(N)^2, O(N), O(1)
i think we can run a nested for loop that can check the whole array, keep an integer and adding to it if we find
another element, if none found return that element at index. this is slow and probably going to have timeout issue

Implement:
implementing O(N) Time/Space, using a hashtable to store all elements as keys and appearances as values
create hashmap, put all items from array, make keys the elements and elements += 1 everytime they are seen
run another for each loop, with an if statement if(hashmap.get(i) == 1), return i;

Review:

Evaluate:
Time: O(N), where N is thee amount of elements in the array
Space: O(N), we are using a hashmap datastructure to store N amount of elements

 */

import java.util.HashMap;

public class ArraySingleElement {
    public static int singleElement(int[] arr){
        HashMap<Integer, Integer> myHash = new HashMap<>();
        for (int i : arr) {
            myHash.put(i, myHash.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            if(myHash.get(i) == 1){
                return i;
            }
        }
        return -1;
    }

}
