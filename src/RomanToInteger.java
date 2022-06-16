/*
Problem 2: Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Understand:
What constraints exists? Are we limited to a certain time/space? Can you give me or can I lookup the letters to numbers?
What exactly is our input? Its a string that has roman numeral letters = "III" = '3'
What exactly is our output? we need to return the number that the roman numerals add up to.
Match:
Since we are matching letters to numbers, I am thinking we can create a Hashmap, Letters as keys, numbers as values
Since its string and we need to traverse through it like an Array, we'll use a pointer, preferrably a pointer
starting at the back of the String or Array.
Roman numberals usually work checking the previous letter to subract example 'IV' = four, 1-5 = four
Pattern:
String to hold the last symbol of the string, String lastSymbol = s.substring(s.length()-1)
integer to take that string that has the lastsymbol, lookup in the hashtable the symbol to retrieve the key
add that key to the total, int lastValue = hashmap.get(lastSymbol);
create an integer to hold a number that will add up all the roman numerals
Lets use a hashmap, we'll use it to check the String at that certain pointer, first we'll check if the previous letter
has a value that is smaller than the current letter/value. if it does then lets subract that value from the total if
not lets add it.
Implement:
create hashmap, use put methods to store given roman numerals to numbers e.i: put("I", 1), put("V", 5)
create an integer called total, lets add the last roman number, value to it.
create String lastSymbol = s.substring(s.length-1)
        Int   lastValue = hashmap.get(lastSymbol)
        int   total = lastValue

        forloop = for(int i = s.length-2; i>0; i--), since we are going from behind and we already get s.length-1
        create String currentSymbol = s.substring(i, i+1);
                int currentValue = hashmap.get(currentsymbol)
                if(currentValue < lastValue)
                    total -= currentValue
                else
                    total += currentValue

                lastValue = currentValue
       return total;
Review:

Evaluate: The Time since we already know theres a max of 3999 posibilities, its O(1), Space O(1), no additional DS used
 */


import java.util.HashMap;

public class RomanToInteger {
    public static int romanInteger(String s){
        HashMap<String, Integer> myHash = new HashMap<>();
        myHash.put("I", 1);
        myHash.put("V", 5);
        myHash.put("X", 10);
        myHash.put("L", 50);
        myHash.put("C", 100);
        myHash.put("D", 500);
        myHash.put("M", 1000);

        //e.i: III = 3, MCMXCIV = 1994 = M = 1000, CM = 900, XC = 90 and IV = 4
        String lastSymbol = s.substring(s.length() -1);
        int lastValue = myHash.get(lastSymbol);
        int total = lastValue;

        for (int i = s.length()-2; i >= 0; i--) {
            String currentSymbol = s.substring(i, i+1);
            int currentValue = myHash.get(currentSymbol);
            if(currentValue < lastValue){
                total -= currentValue;
            }
            else{
                total += currentValue;
            }
            lastValue = currentValue;

        }
        return total;
    }
}
