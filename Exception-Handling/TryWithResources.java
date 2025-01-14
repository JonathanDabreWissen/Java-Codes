import java.io.*;

class A implements AutoCloseable{

	A(){
		System.out.println("Allocating resources for A class object ...");
	}

	public void process(){
		System.out.println("Performing the required processing on A object");
	}
	public void close(){
		System.out.println("Releasing resources for A class object...");
	}
}

class B implements AutoCloseable{

	B(){
		System.out.println("Allocating resources for B class object ...");
	}

	public void process(){
		System.out.println("Performing the required processing on B object");
	}
	
	//Interface has this close which is automatically called.
	public void close(){
		System.out.println("Releasing resources for B class object...");
	}
}



public class TryWithResources{

	public static void main(String args[]){
		
		try(A a1 = new A(); B b1 = new B();){

			
			a1.process();
			if(true){
				//throw new NullPointerException();
				//return;
			}
			b1.process();
			
		}
		//System.out.println(a1);
		System.out.println("Program Continues...");
					
	}

}