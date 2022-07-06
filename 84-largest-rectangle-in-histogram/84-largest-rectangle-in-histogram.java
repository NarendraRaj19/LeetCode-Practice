class Solution {
    public int largestRectangleArea(int[] heights) {
        
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int res = 0;
        int sz = heights.length;
        int[] ps = new int[sz];
        int[] ns = new int[sz];
        
        //To Find Previous Smaller Element of Each Element (Ref: Stock Span Problem GFG)
        s.push(0);
        ps[0] = -1;
        
        for(int i=1; i<sz; i++)
        {
            while(s.isEmpty() == false && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            
            ps[i] = (s.isEmpty() ? -1 : s.peek());
            s.push(i);
        }
        
        //Empty the Stack
        while(s.isEmpty() == false){
            s.pop();
        }
        
        //To Find Next Smaller Element of Each Element (Ref: Stock Span Problem GFG)
        s.push(sz -1);
        ns[sz -1] = sz;
        
        for(int i=sz-2; i>=0; i--)
        {
            while(s.isEmpty() == false && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            
            ns[i] = (s.isEmpty() ? sz : s.peek());
            s.push(i);
        }
        
        for(int i=0;i<sz;i++){
            int curr=heights[i];
            curr+=(i-ps[i]-1)*heights[i];
            curr+=(ns[i]-i-1)*heights[i];
            res=Math.max(res,curr);
        }
        return res;
            
    }
}