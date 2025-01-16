/*
final class Principal{
	static private final Principal p1 = new Principal();
	private Principal(){

		System.out.println("Principal(Early) objected created");
	}

	public static Principal getPrincipal(){
		return p1;
	}

}

*/
final class Principal{
	
	private static Principal p1 = null;

	private Principal(){
		System.out.println("Principal(Lazy) object created");
	
	}

	public static Principal getPrincipal(){
		if(p1==null){
			p1 = new Principal();
		}
		return p1;
		
	};
}

public class Singleton{

	static{

		try{
			Class.forName("Principal");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String args[]){
		Principal p1 = Principal.getPrincipal();		Principal p2 = Principal.getPrincipal();
		Principal p3 = Principal.getPrincipal();

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}