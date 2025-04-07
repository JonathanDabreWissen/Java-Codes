public class ThreadClassDemo{

	public static void main(String [] args){
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();
		
		t1.setName("Jonathan");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("Main ended here...");
	}
}

class MyThread extends Thread{

	public void run(){
		
		int randomNum = (int) (Math.random() * 101); //0 to 100;
		
		for(int i =0; i<randomNum; i++){
			System.out.println("Running Thread: " + Thread.currentThread().getName() +" " +this.getName() +" " +randomNum +" times");
		}
		
	}
}