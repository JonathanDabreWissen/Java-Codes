package p1;

public class A{

	public static void main(String args[]){
		
		public int x = 10;
		private int y = 20;
		protected int z = 30;
		int q = 40;

		public void display(){

			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println(q);
			
		}
		
	}
}

class B extends A{

	public void display(){

		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(q);
			
	}

}
