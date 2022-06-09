// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class DLLNode
{
    DLLNode prev, next;
    int key, value;
    
    DLLNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache
{
    private  HashMap<Integer, DLLNode> map;
     DLLNode head, tail;
     int count, cap;
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.cap = cap;
        count = 0;
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        map = new HashMap<>();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }
    
    public  void deleteNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public  void addToHead(DLLNode node){
        DLLNode headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(map.get(key) != null){
            DLLNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    //Function for storing key-value pair.
    public  void set(int key, int value)
    {
        // your code here
        
        if(map.get(key) != null){
            DLLNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            DLLNode node = new DLLNode(key, value);
            map.put(key, node);
            
            if(count < cap){
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
            
        }
    }
}
