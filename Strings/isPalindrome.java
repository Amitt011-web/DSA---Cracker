 boolean isPalindrome(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        String s = reverse(s2);
        int i = 0, j = 0;
        while(i < s1.length() && j < s.length()){
            if(s1.charAt(i) != s.charAt(j)) return false;
            if(s1.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }
        }
        return true;

    }
