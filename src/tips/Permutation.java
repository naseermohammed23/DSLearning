package tips;

import java.util.Arrays;

public class Permutation {
    
    public static void main(String[] args) {
        int[] input = {5,6,7};
        System.out.println("Input Array -------> "+Arrays.toString(input));
        perm(input);

        int[] input1 = {5,6,7,8};
        System.out.println("Input Array -------> "+Arrays.toString(input1));
        perm(input1);

    }


    public static void perm(int[] input) {
        perm(input, 0);
    }

    private static void perm(int[] input, int i) {

        if (i == input.length) {
            System.out.println(Arrays.toString(input));
            return;
        }

        for(int j=i;j<input.length;j++) {
            swap(input, i, j);
            perm(input, i+1);
            swap(input, i, j);
        }

    }

    static void swap(int[] input, int x, int y) {
        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }
}
