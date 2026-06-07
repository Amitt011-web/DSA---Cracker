class Solution {
    public String profession(int level, int pos) {
        int flipCount = 0;
        while (pos > 1) {
            if (pos % 2 == 0) {
                flipCount++;
            }
            pos = (pos + 1) / 2;
        }
        if (flipCount % 2 != 0) return "Doctor";
        else return "Engineer";
        
        
    }
}
