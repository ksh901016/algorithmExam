package interview.ch01;

public class Practice {
    // 1.1
    public boolean checkStr(String str) {
        boolean[] ascii = new boolean[256];
        
        char[] character = str.toCharArray();
        for(char c : character) {
            if(ascii[c]) {
                return false;
            }
            ascii[c] = true;
        }
        
        return true;
    }
}
