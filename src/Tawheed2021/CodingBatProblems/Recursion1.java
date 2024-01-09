package CodingBatProblems;
import java.util.ArrayList;
import java.util.List;

public class Recursion1 {

    int n0 = 0, n1 = 1, n2 = -1;

    public static void main(String[] args) throws Exception {

        // System.out.println(factorial(4));
        // System.out.println(bunnyEars(32));
        // System.out.println(bunnyEars2(32));
        // System.out.println(fibonacci(10));
        // System.out.println(sumDigits(10110));
        // System.out.println(count7(7700));
        // System.out.println(count8(8888));
        // System.out.println(triangle(3));
        // System.out.println(countX("xx2323xx"));
        // System.out.println(countHi("hihi"));
        // System.out.println(changeXY("xxhixx"));
        //System.out.println(countPairs("ihihhh"));
        //System.out.println(noX(""));
        //System.out.println(pairStar("aaaa"));

        //int[] nums6 = {1,6,4};
        //System.out.print(array6(nums6, 0));

        //int[] nums11 = {};
       // System.out.print(array11(nums11, 0));

      // System.out.print(changePi("pip"));

     // System.out.print(strCopies("catcowcat", "cat", 2));

        //System.out.println(allStar("a"));

        //System.out.println(stringClean("Hello"));

        //System.out.println(endX("xhixhix"));

        //System.out.println(countHi2("ahibhi"));

        //int[] array220 = {1, 2, 4, 20};
        //System.out.println(array220(array220, 0));
        //System.out.println(nestParen("(((x)))"));

        //System.out.println(countHi2("xhixhi"));


        //int[] numsLeaders = {16, 17, 4, 3, 12, 11, 12, 5, 2};
        //List<Integer> leaders = findLeader(numsLeaders);
        //System.out.println(leaders.stream().collect(Collectors.toList()));


    }


    // find leaders in the list , leader = element who is greater or equal to the numbers in right of it. 
    public static List<Integer> findLeader(int[] nums) {

        int leader = -1;
        List<Integer> leaderList = new ArrayList<>();

        for(int i=nums.length; i>0; i--) {

            if (nums[i-1] < leader) {
                continue;
            }

            //if (i == nums.length) { 
                leader = nums[i-1];
                leaderList.add(0, leader);
            //} else if (nums[i-1] > leader) {
              //  leader = nums[i-1];
                //leaderList.add(0, leader);
            //}
        }        

        return leaderList;
    }

    public static int countHi2(String str) {
  
        if (str.length() <= 2) return (str.length() == 2 & str.equals("hi")) ? 1 : 0;

        int idx = str.indexOf("hi");
        if (idx > 0) {
            return str.charAt(idx-1) != 'x' ? 1 + countHi2(str.substring(idx+2)) : countHi2(str.substring(idx+2));
        } else if (idx == 0) {
            return 1 + countHi2(str.substring(idx+2));
        }   else {
            return 0;
        }    
        
      }
      

    public static boolean nestParen(String str) {
        
        if(str.length() == 0) return true;

        if(str.length() ==1 ) return !str.equals("(") && !str.equals(")") ? true : false;

        return str.startsWith("(") && str.endsWith(")") ? nestParen(str.substring(1, str.length()-1)) : false;
    }
    

    public int strDist(String str, String sub) {

        if (str.startsWith(sub) && str.endsWith(sub)) {
            return str.length();
        }

        if(str.length() == sub.length()) {
            return 0;
        }

        
        return strDist(str.substring(1, str.length()-1), sub);
        
      }
      

    public int countAbc(String str) {
  
        if (str.length() <= 2) return 0;
        
        return (str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba")) ? 1 + countAbc(str.substring(1)) : countAbc(str.substring(1));
      }
      
    public static String endX(String str) {
  
        if (str.length() <= 1) return str;
        
        return str.charAt(0) != 'x' ? str.substring(0,1) + endX(str.substring(1)) : endX(str.substring(1)) + 'x';
      }
      

    public static String stringClean(String str) {

        if (str.length() <= 1) return str;

        return str.charAt(0) == str.charAt(1) ? stringClean(str.substring(1)) : str.substring(0,1) + stringClean(str.substring(1));
  
    }

    public static String allStar(String str) {
  
        if (str.length() <= 1) return str;

        return str.substring(0,1) + "*" + allStar(str.substring(1));
      }
      

      public static boolean array220(int[] nums, int index) {
        if(index==nums.length-1)
          return false;
      
          if(nums[index+1] == nums[index]*10)
          return true;
          
          return array220(nums,index+1);
      }
    

    public static boolean strCopies(String str, String sub, int n) {

        return strCopies1(str, sub, n) >= n ? true : false;

    }

    public static int strCopies1(String str, String sub, int n) {
  
        if (str.length() < sub.length()) return 0;
        
        return str.substring(0, sub.length()).equals(sub) ? 1 + strCopies1(str.substring(1), sub, n) : strCopies1(str.substring(1), sub, n);
      }


      
      

    public static String changePi(String str) {
  
        if(str.length() <= 1) return str;
        
        return str.substring(0,2).equals("pi") ? "3.14" + changePi(str.substring(2)) : 
                          str.substring(0,1) + changePi(str.substring(1));
      }
      

    public static int array11(int[] nums, int index) {
        if (nums.length < 1) return 0;
      
        if (index + 1 <= nums.length) {
            return (nums[index] == 11) ? 1 + array11(nums, index + 1) : array11(nums, index + 1);
        } else {
            return 0;
        }
    }

    public static boolean array6(int[] nums, int index) {

        if (nums.length < 1) return false;
  
        if (nums[index] == 6) return true;

        return (index+1 < nums.length) ? array6(nums, index+1) : false;     

    }

    public static String pairStar(String str) {
        if (str.length() <= 1) return str;

        return str.charAt(0) + (str.charAt(0) == str.charAt(1) ? "*" : "") + pairStar(str.substring(1));


    }

    public static String noX(String str) {
        if (str.length() == 0) return "";

        return str.charAt(0) != 'x' ? str.charAt(0) + noX(str.substring(1)) : noX(str.substring(1));
    }

    public static int countPairs(String str) {
        
        if (str.length() < 3) return 0;

        char ch1 = str.charAt(0);
        return str.charAt(2) == ch1 ? 1 + countPairs(str.substring(1)) : countPairs(str.substring(1));

    }

    public static String changeXY(String str) {

        if (str.length() == 0) return "";

        return str.charAt(0) == 'x' ? 'y' + changeXY(str.substring(1)) : str.charAt(0) + changeXY(str.substring(1));

        //return str.replace('x', 'y');
    }

    public static int countHi(String str) {

        if (str.length() > 2) {
            return str.substring(0, 2).equals("hi") ? 1 + countHi(str.substring(1, str.length()))
                    : countHi(str.substring(1, str.length()));
        } else if (str.length() == 2) {
            return str.substring(0, 2).equals("hi") ? 1 : 0;
        } else {
            return 0;
        }

        /*
         * if (str.length() <= 1) return 0; int count = 0; if (str.substring(0,
         * 2).equals("hi")) count = 1; // could use startsWith() return count +
         * countHi(str.substring(1));
         */
    }

    public static int countX(String str) {
        char str1[] = str.toCharArray();
        if (str1.length > 0) {
            return str1[str1.length - 1] == 'x' ? 1 + countX(str.substring(0, str1.length - 1))
                    : countX(str.substring(0, str1.length - 1));
        } else {
            return 0;
        }
    }

    public static int triangle(int rows) {
        return rows > 0 ? rows + triangle(rows - 1) : 0;
    }

    public static int count8(int n) {
        if (n % 10 == 8) {
            return (n % 100) / 10 == 8 ? 2 + count8(n / 10) : 1 + count8(n / 10);
        } else {
            if (n / 10 < 10) {
                return n / 10 == 8 ? 1 : 0;
            }

            return count8(n / 10);
        }
    }

    public static int count7(int n) {

        if (n % 10 == 7) {
            return 1 + count7(n / 10);
        } else {
            if (n / 10 < 10) {
                return n / 10 == 7 ? 1 : 0;
            }

            return count7(n / 10);
        }
    }

    public static int sumDigits(int n) {

        if (n < 10)
            return n;

        return (n / 10 > 0) ? n % 10 + sumDigits(n / 10) : 0;
    }

    static int count = 10;

    public static int fibonacci(int num) {

        //Time Complexity = O([Number of Branches to the power] of [depth of a tree]) = O(2^n)
        // Space Complexity = O(n)
        // if num is 10 then the T.C = O(2 ^ 10), S.C = O(10)

        return num <= 1 ? num : fibonacci(num -1) + fibonacci(num - 2);
    }

    public static int bunnyEars2(int bunnies) {
        return bunnies == 0 ? 0 : ((bunnies % 2 == 0 ? 3 : 2) + bunnyEars2(bunnies - 1));
    }

    public static int bunnyEars(int bunnies) {
        return bunnies == 0 ? 0 : (2 + bunnyEars(bunnies - 1));
    }

    public static int factorial(int n) {
        return n > 0 ? n * factorial(n - 1) : 1;
    }

}
