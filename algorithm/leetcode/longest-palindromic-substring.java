class Solution {
    public String longestPalindrome(String s) {
        String palindrom = "";
        int length = s.length();
        if (length > 0)
            palindrom = s.substring(0,1);
        for (int i=0; i<length; i++){
            int j = i;
            int k = 0;
            int l = 0;
            if (i+1<length && s.charAt(i) == s.charAt(i+1)){
                k = i+1;
                l = 2;
                while (j-1 >= 0 && k+1 < length
                      && s.charAt(j-1) == s.charAt(k+1)){
                    l+=2;
                    j--;
                    k++;
                }
                if (palindrom.length() < l)
                    palindrom = s.substring(j, k+1);
            }
            if (i+2<length && s.charAt(i) == s.charAt(i+2)){
                j = i;
                k = i+2;
                l = 3;
                while (j-1 >= 0 && k+1 < length
                      && s.charAt(j-1) == s.charAt(k+1)){
                    l+=2;
                    j--;
                    k++;
                }
                if (palindrom.length() < l)
                    palindrom = s.substring(j, k+1);
            }
        }        
        return palindrom;
    }
}
