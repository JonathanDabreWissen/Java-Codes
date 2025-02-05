class A
{
	public void print1to10()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println("Range : "+i);
		}
	}
}
class B
{
	public void evenTill50()
	{
		for(int i=0; i<=50; i+=2)
		{
			System.out.println("Even : "+i);
		}
	}
}
class C
{
	public void fibonacciFrom1to1000()
	{
		int t1 = 0;
		int t2 = 1;

		int fiboTerm = 0;

		do{
			fiboTerm = t1 + t2;
			t1 = t2;
			t2 = fiboTerm;
			System.out.println("Fibo: " + fiboTerm);
		}
		while(fiboTerm <1000);
	}
}

public class ThreadsWithout {

	public static void main(String[] args) {
		Runnable r1 = new A():: print1to10;
		Runnable r2 = new B():: evenTill50;
		Runnable r3 = new C():: fibonacciFrom1to1000;

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t1.start();
		t2.start();
		t3.start();




	}
    
}
