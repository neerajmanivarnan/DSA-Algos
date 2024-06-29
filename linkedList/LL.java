public class LL{
    public static void main(String args[]){
		LinkedList list = new LinkedList();

		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.display();
		list.insertFirst(70);
		list.insertFirst(80);
		list.insertFirst(90);
		list.display();
    }

   
}

class LinkedList{

	private Node head;
	private Node tail;

	private int size;

	LinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null; 
	}

	public void insert(int val){
		if(head == null){
			Node newNode  =  new Node(val);
			head = newNode;	
			head.next=null;
			tail = head;
			this.size+=1;
			
		}else{
			Node newNode = new Node(val);
			if(tail == head){
				tail =  newNode;
				head.next = tail;
				tail.next = null;
				this.size+=1;
			}else{
				tail.next = newNode;
				tail = tail.next;
				this.size+=1;
			}
		}
	} 


	public void display(){
		Node current = head;

		while(current!=null){
			System.out.println(current.val);
			current = current.next;
		}
	}

	public void insertFirst(int val){
		if(head == null){
					
			Node newNode  =  new Node(val);
			head = newNode;	
			head.next=null;
			tail = head;
			this.size+=1;
		}else{
			Node newNode = new Node(val);
			newNode.next = head;
			head = newNode;
			this.size+=1;

		}
	}

	


    private class Node{
        private int val;
        private Node next;

	Node(int val){
		this.val = val;
	}

	Node(int val,Node next){
		this.val = val;
		this.next = next;
	}


    }
	
		


}
