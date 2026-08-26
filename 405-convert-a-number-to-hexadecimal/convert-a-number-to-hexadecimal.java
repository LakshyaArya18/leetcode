class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hexMap = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            // Get the last 4 bits
            int last4Bits = num & 15;
            sb.append(hexMap[last4Bits]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}