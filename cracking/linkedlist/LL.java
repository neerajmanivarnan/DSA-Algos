public class LL{
    public static void main(String args[]){
		LinkedList list = new LinkedList();

		

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

	public int deleteLast(){
		int num = tail.val;
		Node current = head;
		

		if(this.size == 0){
			return -1;
		}

		if(this.size == 1){
			num = head.val;
			head = null;
			tail = head;
			return num;
		}
	
		while(current.next!=tail){
			current = current.next;
		}

		current.next = null;
		tail = current;
		this.size-=1;
		return num;
	}

	public int deleteKey(int key){
		Node current = head;
		int num = -1;		
		
		if(head == null){
			return num;
			
		}		

	
		if(current.val == key){
			num = current.val;
			head = head.next;
			size-=1;
			return num;
		}		


		while(current!=null){
			if(current.next.val == key ){
				num = current.next.val;
				current.next = current.next.next;
				break;
				
			}

			current = current.next;
		}

		return num;
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


	public void insertAfter(int key,int val){
		if(head == null){
			//do nothing
		}else{
			Node newNode = new Node(val);

			Node current  = head;
			while(current!=null){
				if(current.val == key){
					newNode.next = current.next;
					current.next = newNode;
					size+=1;
					break;
				}

				current=current.next;
			}


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