/*
Bonus Problem: Destination City
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going
from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
destination city.

Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Example 3:

Input: paths = [["A","Z"]]
Output: "Z"

Understand: what are you asking exactly?
My understanding is they want us to return the destination city that has NO OUTGOING, this means they want us to return
the destination city that DOESN'T exist in the outgoing city of each arraylist.
Are all items unique?YES Each arrayList unique? Should we expect an arraylist of arraylist of Strings?
what are the constraints, how many aList are we getting?
Input: ArrayList of Arraylist, with two elements, outgoing city, destination city
Output: A string of the destination city that doesn't exist as an outgoing city on any of the Alist of Alist

Match:
from what I understand i think if we keep a set of hashmap/set of items we need to seperate the outgoing from the
destination city, then we can run a compare, check if the desintation city exist in the outgoing city map, if it
doesn't return that city. else keep going through the array

Plan:

Implement:

Review:

Evaluate:

 */

import java.util.HashSet;
import java.util.List;

public class DestinationCity {
    public static String destCity(List<List<String>> paths){
        HashSet<String> cities = new HashSet<>();       //create hashset, all items will be unique
        for (List<String> path : paths) {               //create foreach, add each element from [0] of aList
            cities.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dest = path.get(1);          //lets get the [1] from Alist, make it the "dest"
            if(!cities.contains(dest)){//if statement, looks at set, asks hey does this dest city exists in the set, if not we found it, return it.
                return dest;
            }
        }
        return "";      //if we get here we never found it.
    }

}
