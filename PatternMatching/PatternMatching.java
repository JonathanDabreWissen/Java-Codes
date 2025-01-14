import java.util.regex.*;

class PatternMatching{

	public static void main(String args[]){

		String s1 = "Wissen Technology";
		String s2 = "Tech";

		Pattern p1 = Pattern.compile(s2);
		Matcher m1 = p1.matcher(s1);

		System.out.println("'"+s1 +"' contains '" +s2 +"' : " +m1.find());
		System.out.println("----------------------------------------------");
		
		String email = "abc@xyz.com";
		Pattern p2 = Pattern.compile("[a-zA-Z0-9.]+@[a-zA-Z]+\\.com");
		Matcher m2 = p2.matcher(email);
		System.out.println(m2.matches());

		long mobileNo = 9876543298L;
		Patter p3 = Pattern.compile("[8-9][0-9]{9}");
		Matcher m3 = p3.matcher(mobileNo+"");
		System.out.println(m3.matches());

		System.out.println("----------------------------------------");
		Pattern p4a = Pattern.compile("[a-d][p-r]";
		Pattern p4b = Pattern.compile("[a-d&&[p-r]]");
		Matcher m4a = p4a.matcher(str);
 		Matcher m4b = p4b.matcher(str);
		System.out.println(m4a.matches());
		System.out.println(m4b.matches());
		
		
	}
}