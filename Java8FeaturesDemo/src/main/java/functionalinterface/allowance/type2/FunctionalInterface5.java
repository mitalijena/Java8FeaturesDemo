package functionalinterface.allowance.type2;

@FunctionalInterface
public interface FunctionalInterface5 extends FunctionalInterface3, FunctionalInterface4 {
	
	//Allowed
	//As the method has exactly same name and signature in both Implemented Interfaces
	//public void functionalInterfaceMethod1(String str);
	
	//Allowed
	//As the method has exactly same name and signature in both Implemented Interfaces
	public void functionalInterfaceMethod1(String str);

}
