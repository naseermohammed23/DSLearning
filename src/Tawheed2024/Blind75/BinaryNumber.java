package Tawheed2024.Blind75;

public class BinaryNumber {
    
    public static void main(String[] args) {
        //System.out.println(addBinary("111", "1"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        
        int carry = 0;    
    
        for (int i=a.length()-1, j=b.length()-1;i>=0 || j >= 0;i--, j--) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }        
 
        if (carry != 0) res.append(carry);

        return res.reverse().toString();
   }

   // this code need some tweeking... its not working in all scenario's 
   public static String multiplyBinary(String a, String b) {

    StringBuilder res = new StringBuilder();
    
    int carry = 0;    

    for (int i=a.length()-1, j=b.length()-1;i>=0 || j >= 0;i--, j--) {
        int sum = carry != 0 ? carry : 1;
        if (i >= 0) sum *= a.charAt(i) * '1';
        if (j >= 0) sum *= b.charAt(j) * '1';
        
        carry = sum > 1 ? 1 : 0;
        res.append(sum % 2);
    }        

    if (carry != 1) res.append(carry);

    return res.reverse().toString();
}

   
}
