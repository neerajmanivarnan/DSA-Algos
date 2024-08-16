public class newLL{



	public static void main(String args[]){

	
	}



	private Node head;
	private Node tail;

	private int size;

	newLL(){
		this.size = 0;
		this.head = null;
		this.tail = null; 
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
