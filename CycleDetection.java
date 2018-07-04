import java.util.*;

public class CycleDetection extends LinkedList {
	
	//Problem statement: Detect if there are any cycles/loop in a linked list

	/*Leetcode 141. Linked List Cycle
	 * Given a linked list, determine if it has a cycle in it.
	   Follow up:
	   Can you solve it without using extra space?
	 */
	
	/*Approach 1 using HashSet
	  As and when you traverse through the linkedlist,
	  check if the hashset already contains the current node, if yes, return true. 
	  if not, add the current node to the hashset.
	  
	  Pros: Using HashSet is a fast way to check if the node was visited earlier
	  Cons: Usage of extra memory - overhead in case of very huge linkedlists
	*/
	public static boolean hasCycle(LinkedList l)
	{
		HashSet<Node> set = new HashSet<Node>();
		Node cur = l.head;
		while(cur != null)
		{
			if(set.contains(cur))
				return true;
			set.add(cur);
			cur = cur.next;
		}
		return false;
	}
	
	/*Approach 2: two pointer method
	 * Have two pointers - slow and fast.
	 * the slow pointer moves one step at a time
	 * the fast pointer moves two steps at a time
	 * If there is a cycle, the slow and fast pointers eventually meet in the loop
	 * 
	 * pros: No extra memory needed (unlike approach 1) 
	 * 
	*/
	public static boolean hasCycle2(LinkedList l)
	{
		Node slow = l.head;
		Node fast = l.head;
		
		while(fast != null && fast.next !=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		
		l1.insertAtEnd(10);
		l1.insertAtEnd(20);
		l1.insertAtEnd(30);
		l1.insertAtEnd(40);
		l1.insertAtEnd(50);
		
		//This prints false as the List is not cyclic
		System.out.println(hasCycle(l1));
		
		//creating a cycle here
		Node cur = l1.head;
		while(cur.next != null)
			cur = cur.next;
		cur.next = l1.head;
		
		//prints true
		System.out.println(hasCycle(l1));
		
		System.out.println("Testing second approach:");
		LinkedList l = new LinkedList();
		l.insertAtHead(1);
		l.insertAtHead(2);
		l.insertAtHead(3);
		l.insertAtHead(4);
		l.insertAtHead(5);
		
		System.out.println(hasCycle2(l));
		//creating a cycle here
		Node cur1 = l.head;
		while(cur1.next != null)
			cur1 = cur1.next;
		cur1.next = l.head;
		
		System.out.println(hasCycle2(l));
	}

}
