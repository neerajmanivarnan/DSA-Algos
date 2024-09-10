import java.util.Scanner;

public class tree{

	private Node root; 

	public tree(){
	
	}



	private class Node{
		Node right;
		int val;
		Node left;

		Node(int val){
			this.val = val;
		}

		Node(int val,Node right,Node left){
			this.val = val;
			this.right = right;
			this.left = left;
		}

	}


	public static void populate(Scanner scanner){
		System.out.println("Enter the root node");
		int value = scanner.nextInt();
		root = new Node(value);

		populate(scanner,root);

	}

	private void populate(Scanner scanner,Node node){
	
		System.out.println("Do you want to enter left of "+ node.val);
		boolean left = scanner.nextBoolean();
		if(left){
			System.out.println("Enter the left value");
		}

	
	}


}
