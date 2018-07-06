import java.util.*;

public class TwoPointersApproach_LinkedListProblems extends LinkedList {

	public static LinkedList weaveListFromEnd(LinkedList l)
	{
		if(l.head == null || l.head.next == null) return l;
	    
	    Node p = l.head, q = l.head, prev = null;
	    Stack<Node> stack = new Stack<Node>();
	    	    
	    //get the mid point of the list
	    while(q != null && q.next != null)
	    {
	        prev = p;
	        p = p.next;
	        q = q.next.next;
	    }
	
	    prev.next = null;
	    
	    //push the second half elements of list to stack
	    while(p!=null)
	    {
	        stack.push(p);
	        p = p.next;
	    }
	
	    //weave the elements together by popping stack
	    p = l.head;
	    Node tail = l.head;
	    while(p!=null && !stack.isEmpty())
	    {
	        
	        Node temp = stack.pop();
	        temp.next = p.next;
	        p.next = temp;
	        tail = temp;
	        p = temp.next;
	    }
	   
	   //take care of odd length lists. stack contains one extra element
	    if(!stack.isEmpty())
	     {
	         tail.next = stack.pop();
	         tail = tail.next;
	         tail.next = null;
	     }
        
	    return l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		
		l1.insertAtEnd(10);
		l1.insertAtEnd(20);
		l1.insertAtEnd(30);
		l1.insertAtEnd(40);
		l1.insertAtEnd(50);
				
		weaveListFromEnd(l1).printList();
		
	}

}
