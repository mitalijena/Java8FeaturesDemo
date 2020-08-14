package functionalinterface.allowance.type1;

@FunctionalInterface
public interface FunctionalInterface2 {
	
	public void functionalInterfaceMethod1();
	
	//Not Allowed
	//public void functionalInterfaceMethod2();
	
	//Allowed
	//functional because equals is already an implicit member (Object class)
	boolean equals(Object obj);
	
	//Not Allowed as this doesnt refer to the clone() method in Object class 
	//as its not public in Object Class
	//Will be considered as just another method whose signature is same as clone() method of Object class
	//Object clone();
	
	

}
