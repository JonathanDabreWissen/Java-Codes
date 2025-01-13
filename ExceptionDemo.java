import java.io.*;

public class ExceptionDemo{

	public static void main(String args[]){
		int a = 50;

		try {
			for(int i =1; i<=20; i++){
				System.out.println(i);
				int res = a/(a-i);
				if(i==15){
					throw new NullPointerException();
				}
				if(i==12){
					throw new IOException();
				}
				if(i==10){
					throw new ArithmeticException();
				}
				if(i==8){
					return;
				}
				if(i==6){
					System.exit(0);
				}

			}
			
		}
		catch(IOException  e){
			System.out.println("IO Exception handler");	
		}
		catch(NullPointerException  e){
			System.out.println("Null pointer exception handler");
		}
		catch(Exception e){
			System.out.println("Default Exception Handling");
		}
		finally{
			System.out.println("Thank You");
		}
		System.out.println("Program continues..");
	}
}