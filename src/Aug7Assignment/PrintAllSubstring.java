package Aug7Assignment;

import java.util.List;
import java.util.ArrayList;

public class PrintAllSubstring {
    

    public static void main(String[] args) {
        printAllSubString_helper("hello");
    }

    static void printAllSubString_helper(String str) {
        List<String> result = new ArrayList<>();
        printAllSubString(str, result, 0);

    }
    

    static void printAllSubString(String str, List<String> result, int idx) {

        if (str.length() == idx) {
            System.out.println(result);
            return;
        }

        /* for(int start=0;start<str.length();start++) {

            String subStr = 
            printAllSubString(str, result, start);
        } */



    }
}
