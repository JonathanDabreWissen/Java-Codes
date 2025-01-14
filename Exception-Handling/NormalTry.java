class A{

	A(){
		System.out.println("Allocating resources for A class object ...");
	}

	public void process(){
		System.out.println("Performing the required processing on A object");
	}
	public void release(){
		System.out.println("Releasing resources for A class object...");
	}
}



public class NormalTry{

	public static void main(String args[]){
		A a1 = new A();

		try{

			
			a1.process();
			if(true){
				throw new NullPointerException();
			}
			a1.release();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			a1.release();
		}	
	}

}