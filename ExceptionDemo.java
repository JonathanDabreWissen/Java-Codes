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
				if(i==4){
					throw new UserException("when i is 4");
				}

			}
			
		}
		catch(IOException  e){
			System.out.println("IO Exception handler");	
		}
		catch(NullPointerException  e){
			System.out.println("Null pointer exception handler");
		}
		catch(UserException e){
			System.out.println("Custom Exception Handler...");;
			System.out.println("Reason: " +e.getMessage());
			e.display();
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


class UserException extends Exception{

	public UserException(){
		super();
	}
	public UserException(String msg){
		super(msg);
	}
	public void display(){
		System.out.println("My custom display() logic");
	}
	
}