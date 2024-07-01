public class DLL{
    public static void main(String args[]){
		LinkedList list = new LinkedList();
		
		list.insertLast(10);
		list.insertLast(20);
		list.insertLast(30);
		list.insertLast(40);
//		list.displayInOrder();
//		System.out.println("Deleting key");
//		list.deleteKey(10);    
		list.displayInOrder();

}

   
}

class LinkedList{

	private Node head;
	private Node tail;

	private int size;

	LinkedList(){
		this.size = 0;
		head = null;
		tail = head;
	}	


	public void insertFirst(int val){

		Node newNode = new Node(val);
		if(head == null ){
			head = newNode;
			tail = head;
			head.next = null;
			head.prev = null;
			this.size+=1;
			
		}else{
			newNode.next = head;
			head.prev = newNode;	
			head = head.prev;
			this.size+=1;

		}
	}
	
	//This code has to be tested for optimisation
	public void deleteKey(int key){

		if(this.size == 1){
			head = null;
		}
 
		if(head == null ){
			//throw new Exception("List is empty");
		}else{
			Node current = head;
			while(current!=null){
				if(current.val == key){
					current.prev.next = current.next;
					
				}

				current = current.next;
			}
		}
	}


	
	public void insertLast(int val){
		Node newNode = new Node(val);
		if(head == null){
			head = newNode;
			tail = head;
			head.next = null;
			head.prev = null;
			this.size+=1;
		}else{
			newNode.prev = tail;
			tail.next = newNode;
			tail = tail.next;
			this.size+=1;
		}
	
	}

	public void displayInOrder(){
		Node current = head;
		while(current!=null){
			System.out.print(current.val + " -> ");
			current = current.next;
		}
	}

	public void displayRev(){
		Node current = tail;
		
		while(current!=null){
			System.out.println(current.val + " <- ");
			current = current.prev;
		}
	}

	private class Node{
		Node prev;
		int val;
		Node next;

		Node(int val){
			this.val = val;
		}

		Node(Node prev,Node next,int val){
			this.prev = prev;
			this.next = next;
			this.val = val;
		}


	}






}
