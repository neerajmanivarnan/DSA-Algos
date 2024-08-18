class demo{

	static 	int x;
	int y;

	public void increment(){
		this.x++;
	}

	public void display(){
		System.out.println(this.x);
	}

}



public class Main {

	

	public static void main(String[] args) {
		demo t = new demo();
		t.increment();
		t.display();

		demo g = new demo();
		g.increment();
		g.display();
	}
 

}

