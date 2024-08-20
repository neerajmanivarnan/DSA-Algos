class A{

	public void display(){
		System.out.println("This is A");
	}


} 


class B extends A{

	public void display(){
		System.out.println("This is B");
	}


} 


public class oerriding {

		public static void main(String args[]){
			A a = new A();
			System.out.println("Reference and object of A");
			a.display();

			B b = new B();
			System.out.println("Reference and object of B");
			b.display();

//			B ba = new A();
//			System.out.println("Reference of B and Object of A");
//			b.display();

			A ab = new B();
			System.out.println("Reference of A and Object of B");
			ab.display();


		}

}

