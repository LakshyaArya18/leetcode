class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder nextString = new StringBuilder();
            int count = 1;
            int length = result.length();
            
            for (int j = 1; j < length; j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    nextString.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            
            }
            nextString.append(count).append(result.charAt(length - 1));
            
            result = nextString.toString();
        }
        return result;
    }
}