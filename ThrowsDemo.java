import java.io.*;
import java.sql.*;

class A {

	public void abc() throws SQLException, UserException{
		int a = 50;

		
		for(int i =1; i<=20; i++){
			System.out.println(i);
			int res = a/(a-i);
			if(i==150){
				throw new NullPointerException();
			}
			if(i==120){
				//throw new IOException();
			}
			if(i==100){
				throw new SQLException();
			}
			if(i==80){
				return;
			}
			if(i==60){
				System.exit(0);
			}
			if(i==40){
				throw new UserException("when i is 4");
			}
			if(i==200){
				throw new UserException("when i is 2");
			}

		}
			
		System.out.println("Program continues..");

	}

	public void xyz() throws SQLException, UserException, NullPointerException{
		try{
			atoz();
		}
		catch(Exception e){
			System.out.println("Default Exception handler, handled in xyz()");
		}
		
	}

	public void atoz() throws  SQLException, UserException{
		abc();
	}
}

public class ThrowsDemo{
	
	
	public static void main(String args[]) {
		try{
			A a1 = new A();
			a1.xyz();
		}
		catch(Exception e){
			System.out.println("Default Exception handler");
		}
		finally{
			System.out.println("Thank You");
		}

		System.out.println("Program continues");

		try{
			int arr[] = arr[0]/0;
		}
	}
}


class UserException extends Exception //or RuntimeException 
{

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