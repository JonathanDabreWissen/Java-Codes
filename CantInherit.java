
sealed class Manager permits SalesManager, MarketingManager{
	int x = 10;
	public void abc(){
		System.out.println("Hi");
	}
}

class Peun //extends Manager
{

}

non-sealed class SalesManager extends Manager{
	
}

sealed class MarketingManager extends Manager permits DistributionManager{

}

final class DistributionManager extends MarketingManager{

}

class Globalmanager extends SalesManager{

}

public class CantInherit{

	public static void main(String args[]){
		
			GlobalManager gm = new GlobalManager();
			gm.abc();	
	}
}