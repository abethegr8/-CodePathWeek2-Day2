import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] arr1 = {8, 7, 9, 6, 7, 5, 1};
        int k = 2;

        //System.out.println("The number with the most frequent appearances of " + k + " is: " + ElementFreqOfK.freqOfK(arr1, k));
        System.out.println("The number with the most frequent appearances of " + k + " is: " + ElementFreqOfK.freqOfKOptimized(arr1, k));

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(MajorityElement.majorityElement(nums));

        String s = "TGTTCCAGGCCTAGTTCCAGGCCTTTCCAG";
        System.out.println(FindRepeatedSubString.findRepeated(s));

    }
}
