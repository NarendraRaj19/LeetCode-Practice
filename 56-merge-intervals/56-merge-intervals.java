class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> output = new ArrayList<>();
        int[] currentInterval = intervals[0];
        output.add(currentInterval);
        
        for(int[] interval : intervals){
            int currBegin = currentInterval[0];
            int currEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if(currEnd >= nextBegin){
                currentInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currentInterval = interval;
                output.add(currentInterval);
            }
        }
        return output.toArray(new int [output.size()][]);
    }
}