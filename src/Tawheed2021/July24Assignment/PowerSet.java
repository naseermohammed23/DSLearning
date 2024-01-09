package July24Assignment;

/**
 * Tawheed TIPS Summer 2021
 * July, 26, 2021 - Assignment
 * 
 * PowerSet -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzczNDMwNTExMjQ5/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PowerSet {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        int[] nums1 = {1,2,3,4,5};
        powerSet(nums);
        System.out.println("=====================");
        powerSet(nums1);
        
    }


    /**
     * To print all the subset of a given set.. 
     * @param input
     */
    public static void powerSet(int[] input) {
   
        int[] output = new int[input.length];
        powerSetHelper(input, output, 0);
        
    }

    /**
     * Helper method to call recursively to print all the subset of a given set. 
     * @param input
     * @param output
     * @param index
     */
    static void powerSetHelper(int[] input, int[] output, int index) {


        if (index == input.length) {
            //print
            System.out.print("{");
            for(int i=0;i<output.length;i++) {
                if (output[i] != -1) 
                    System.out.print(output[i]+" ");
            }
            System.out.println("}");
        } else {
            output[index] = input[index];
            powerSetHelper(input, output, index+1);
            output[index] = -1;
            powerSetHelper(input, output, index+1);
            
        }


    }

   
    /* Nice try but this logic is not working out.. please rethink on this. */
    /* static void powerSet1(int[] input, int start, int end) {

        if (start == end) {
            System.out.println("{"+input[start]+"}");
        } else {
            System.out.println("{"+input[start]+" "+input[end]+"}");

            if (end < input.length-1) {
                System.out.print("{");
                for(int i=start;i<=input.length-end;i++) {
                    System.out.print(input[i]+" ");
                }
                System.out.println("}");
            }

            powerSet1(input, start, end-1);
            powerSet1(input, start+1, end);
        }
    } */
    
}
