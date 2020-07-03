public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 1)
            return s;
        if (s.equals(""))
            return "";
        int mid = s.length()/2;
        int end = s.length()/2;
        int start = end-1;
        int check = 0;
        for (int i=2; i<=length; i++){
            String substring = s.substring(0,i);
            String reverse =
                new StringBuffer(substring.substring(0,i/2)).reverse().toString();
            if (i % 2 == 0){
                if (s.startsWith(reverse, i/2))
                    check = i;
            }else {
                if (s.startsWith(reverse, (i/2)+1))
                    check = i;
            }
        }
        String answer = "";
        if (check == 0){
            answer = 
                new StringBuffer(s.substring(1,s.length())).reverse().toString() + s;
        }else{
            System.out.println(check);
            String add = "";
            for (int i=check; i<length; i++){
                add = s.charAt(i) + add;
            }
            answer = add + s;
        }
        return answer;
    }
