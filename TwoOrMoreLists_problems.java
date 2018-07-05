
public class TwoOrMoreLists_problems extends LinkedList {

	/*
	 * Leetcode: 2. Add Two Numbers
	 * You are given two non-empty linked lists representing two non-negative integers.
	 *  The digits are stored in reverse order and each of their nodes contain a single digit.
	 *  Add the two numbers and return it as a linked list.

		You may assume the two numbers do not contain any leading zero, except the number 0 itself.	
			
		Example		
		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
		Explanation: 342 + 465 = 807.
	 */
	public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2)
	{
		Node cur1 = l1.head, cur2 = l2.head;
	    LinkedList result = new LinkedList();	    
	    int carry = 0;
	    while(cur1 != null || cur2 !=null)
	    {
	        int sum = 0;
	        if(cur1 != null)
	        {
	            sum += cur1.data;
	            cur1 = cur1.next;
	        }
	        if(cur2 != null)
	        {
	            sum += cur2.data;
	            cur2 = cur2.next;
	        }
	        
	        sum += carry;
	        carry = 0;
	        
	        if(sum >= 10)
	        {
	            sum = sum%10;
	            carry = 1;
	        }
	        result.insertAtEnd(sum);
	    }
    
	    if(carry == 1)
	    	result.insertAtEnd(1);

	    return result;    
	}
	
	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		l1.insertAtEnd(2);
		l1.insertAtEnd(3);
		l1.insertAtEnd(8);
		
		LinkedList l2 = new LinkedList();
		l2.insertAtEnd(4);
		l2.insertAtEnd(5);
		l2.insertAtEnd(6);
		
		addTwoNumbers(l1,l2).printList();
	}
}
