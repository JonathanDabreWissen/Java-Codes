public class RunnableInterfaceDemo{

	//भारत
	//07e8e951bb846c3670a5f77213a6c2445376f6e9
	public static void main(String [] args){
		MyRunnable r1 = new MyRunnable();

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		Thread t3 = new Thread(r1);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyRunnable implements Runnable{
	
	int randomNum = (int) (Math.random()*10);

	public void run(){
		
		for(int i = 1; i<randomNum; i++){
			System.out.println("Running thread " +Thread.currentThread().getName());
		}
	}
}