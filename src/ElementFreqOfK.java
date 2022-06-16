/* https://www.geeksforgeeks.org/find-k-most-frequent-in-linear-time/
Problem 1 - Element with a frequency of K
Find the element that appears k number of times in an array.

Examples:

Input: [8, 7, 9, 6, 7, 5, 1], k = 2
Output: 7

UNDERSTAND:
We assume that we are just getting numbers in the array?
what are the constraints? how many numbers will be in the array. How big or small is the number going to be at each index?
Biggest/smallest number of K
do you want us to return the very first elements
Are there memory constraints?
What’s the required time complexity?
What should we return if there is more than one element of K frequency?
What should we return if there are no numbers of K frequency?

MATCH:
I think maybe if we sort the array, we'll have them in sorted order we'll know right away if there are k elements by checking if the next element is the same
to me what I think of right away is fill up a hastable with the elements from the array for keys and the number of elements of the key as values
run a for each loop, if the element exists in the hashtable increment the value on it. most likely we'll have to return an array of the elements that have k elements
ort
Sorting the array could help us group together the same elements making it easy to count the number of occurrences the element k appears.
Two pointer solutions (left and right pointer variables)
Two pointer approach could work in determining when the element value changes, but would be dependent on a sorted array
Storing the elements of the array in a HashMap or a Set
We could use a HashMap to keep track of a counter for each element k as we traverse the array for the first time.
Traversing the array with a sliding window
A solution may not be two adjacent numbers, so a fixed sliding window won’t solve the problem in all cases.

PLAN:
O(nlogn)
O(1)
if sorted, or we sort using Arrays.sort(arr);
if arr[i] == arr[i-1], n+=1
else
if n==k, return arr[i]
else n=0;

O(N), O(N)
hashtable called myhash
run a for each on arr
if !myhash.contains(arr[num]),myhash.put(arr[num], 1)
else myhash.put(arr[num], myhash.getOrDefault(arr[num],0) + 1);

now check the hashmap to see what key has a value of k
myhash.contains(arr[num]) == k, return num;

 */


import java.util.Arrays;
import java.util.HashMap;

public class ElementFreqOfK {
    //T:O(nlogn), Space:O(1), returns the first time we see k amount of the element
    public static int freqOfK(int[] arr, int k){
        int N = 0;
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            N=1;
            if(arr[i] == arr[i-1]){
                N++;
                if (N == k){
                    return arr[i];
                }
            }
            else{
                N = 0;
            }
        }
        return -1;
    }

    public static int freqOfKOptimized(int[] arr, int k){

        HashMap<Integer, Integer> myHash = new HashMap<>();

        for (int num : arr) {
            if(!myHash.containsKey(num)){
                myHash.put(num, 1);
            }
            else{
                myHash.put(num, myHash.getOrDefault(num, 0) + 1);
            }
        }

        for (int num : arr) {
            if(myHash.get(num) == k){
                return num;
            }
        }

        return -1;
    }

}
