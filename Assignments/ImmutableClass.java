class Student{

	int rollNo;
	String name;
	int standard;
}

public class Immutableclass{

	public static void main(String args[]){

		Student s1 = new Student();
		s1.name = "Rinku";
		System.out.println(s1.name);
		s1.name = "Pintu";
		System.out.println(s1.name);
	}
}