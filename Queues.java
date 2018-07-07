import java.util.*;
public class Queues {

	/*Leetcode 239. Sliding Window Maximum
	 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
		
		Example:
		
		Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
		Output: [3,3,5,5,6,7] 
		Explanation: 
		
		Window position                Max
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7
		Note: 
		You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
		
		Follow up:
		Could you solve it in linear time?
	 */
	class Node
    {
        int val;
        int index;
    }
    public int[] maxSlidingWindow(int[] arr, int w)
    {   
       if(w==0 || arr.length == 0)
           return new int[0];
           
       int i=0,index=0;
       Deque<Node> q = new LinkedList<Node>();
       int[] result = new int[arr.length-w+1];
       
       while(i<arr.length)
       {
           Node temp = new Node();
           temp.val = arr[i];
           temp.index = i;
           
           //case0: The queue is full, remove stale element
           if(!q.isEmpty() && (q.size() == w || q.peekFirst().index <= i-w))
           {
               //remove first element of queue
               q.removeFirst();
           }
           
           //if queue is empty, just insert the element.
           if(q.isEmpty())
           {
               q.addFirst(temp);
           }
           
           //case 2:The incoming element is greater than the first element of queue
           //Remove all the elements of the queue and store just the new incoming element
           else if(q.peekFirst().val < arr[i])
           {
               q.clear();
               q.addFirst(temp);
           }
           
           //case 3: The incoming element is greater than the tail of the queue
           //Keep removing all the elements from the tail of the queue until the 
           //queue does not contain any element lesser than the current element
           else if(q.peekLast().val < arr[i])
           {
               while(!q.isEmpty() && q.peekLast().val < arr[i])
               {
                   q.removeLast();
               }
               q.addLast(temp);
           }
           
           //case 4: the incoming element is lesser than the last element
           else if(q.peekLast().val > arr[i])
           {
               q.addLast(temp);
           }
           
           if(i>=w-1)
               result[index++] = q.peekFirst().val;
          i++;
       }
        
       System.out.println("result array size" + result.length);
       System.out.println("incoming array size" + arr.length);
       return result;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
