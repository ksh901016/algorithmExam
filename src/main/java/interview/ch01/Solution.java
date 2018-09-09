package interview.ch01;

public class Solution {
    // 1.1
    public boolean checkStr(String str) {
        if(str.length() > 256) return false;
        
        boolean[] char_set = new boolean[256];
        for(int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        
        return true;
    }
}
