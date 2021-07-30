package July31Assignment;

/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * Wild-Card -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNzA4/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class WildCard {
    
    public static void main(String[] args) {

        System.out.println(printWildCard("?"));
        System.out.println(printWildCard("1?"));
        System.out.println(printWildCard("10?"));
        System.out.println(printWildCard("1?0?"));
        System.out.println(printWildCard("1?0?0?"));
        System.out.println(printWildCard("??????")); // edge scenario with all wild card..

        System.out.println(printWildCard("10101010")); //edge scenario without any wild card.. 
    }



    /**
     * Optimized Recursive solution to printWildCard for a given string.
     * @param str
     * @return
     */
    public static String printWildCard(String str) {

        // base scenario - print if no wild card is found in the string. 
        if (str.indexOf("?") == -1) {
            return str;
        } else { // call recursively for every wild card with 0, 1 
            int idx = str.indexOf("?");
            return printWildCard(str.substring(0, idx)+"0"+str.substring(idx+1, str.length())) + " " + printWildCard(str.substring(0, idx)+"1"+str.substring(idx+1, str.length()));
        }
    }
}
