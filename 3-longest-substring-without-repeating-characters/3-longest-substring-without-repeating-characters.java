class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int pointer1 = 0, pointer2 = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        
        while(pointer2 < s.length()){
            
            if(!(set.contains(s.charAt(pointer2)))){
                set.add(s.charAt(pointer2));
                max = Math.max(set.size(), max);
                pointer2++;
            }else {
                set.remove(s.charAt(pointer1));
                pointer1++;
            }
        }
        return max;
    }
}