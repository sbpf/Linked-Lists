
public class LinkedList{
	
	class Node{

		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public Node head;
	
	public LinkedList()
	{
		head = null;
	}	
	
	//insert at head
	public void insertAtHead(int data)
	{
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	
	/*insert at tail
	public void insertAtTail(int data, Node tail)
	{
		tail.next = new Node(data);
	}*/
	
	//insert at the end of list
	public void insertAtEnd(int data)
	{
		if(head == null)
		{
			head = new Node(data);
			return;
		}
		
		Node cur = head;
		
		while(cur != null && cur.next != null)
		{
			cur = cur.next;
		}
				
		cur.next = new Node(data);
	}
	
	//print list
	public void printList()
	{
		Node cur = head;
		System.out.println();
		while(cur != null)
		{
			System.out.print("->" + cur.data);
			cur = cur.next;
		}
	}
	
	//delete a node
	public void deleteNode(int data)
	{
		if (head == null) return;
		if (head.data == data)
		{
			head = head.next;
			return;
		}
		
		Node cur = head;
		Node prev = head;
		while(cur!= null)
		{
			if(cur.data == data)
			{
				prev.next = cur.next;
				return;
			}
			prev = cur;
			cur = cur.next;
		}		
	}
	
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		
		l1.insertAtEnd(10);
		l1.insertAtEnd(20);
		l1.insertAtEnd(30);
		l1.insertAtEnd(40);
		l1.insertAtEnd(50);
		
		l1.printList();
		l1.deleteNode(40);
		l1.printList();
		
		l1.insertAtHead(90);
		l1.printList();		
	}
}
