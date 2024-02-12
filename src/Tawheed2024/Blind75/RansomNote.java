package Tawheed2024.Blind75;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
    

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() < magazine.length())
            return false;

        if (ransomNote.equals(magazine))
            return true;
        
        boolean canConstruct = true;

        for (int i=0;i<ransomNote.length();i++) {
            String str = String.valueOf(ransomNote.charAt(i));
            if (magazine.contains(str)) {
                magazine = magazine.replaceFirst(str, "/");
            } else {
                canConstruct = false;
                break;
            }
        }

        return canConstruct;

    }
}
