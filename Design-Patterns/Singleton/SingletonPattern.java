public class SingletonPattern{

	public static void main(String args[]){
		Browser b1 = Browser.getInstance();
		Browser b2 = Browser.getInstance();

		b1.displayMessage();
		b2.displayMessage();
		
		Runnable task = ()-> {Browser.getInstance().displayMessage();};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		Thread t4 = new Thread(task);
		Thread t5 = new Thread(task);
			
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();


		try{

			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();		
		}catch(InterruptedException e){
			e.printStackTrace();

		}

	}
}

class Browser{
	
	//1. Private volatile static instance of the class
	private volatile static Browser browser;

	//2. Private constructor to prevent instantiation
	private Browser(){};
	
	//3. Public static getInstance method to provide acccess to the instance 
	public static Browser getInstance(){

		if(browser == null){
			
			synchronized (Browser.class){
				if(browser == null){
					browser = new Browser();
				}

			}
		}
		
		return browser;
	}

	//Individual Public method of the class
	public void displayMessage(){

		System.out.println("Browser info");
	}
	
}


/*

Steps

1. Private volatile Static instance of the class
2. Private constructor to prevent instantiation
3. Public static method to provide access to the instance/ object
4. Individual public method of the class


Why volatile?
Volatile keyword ensures that update is immediately visible to all threads


*/