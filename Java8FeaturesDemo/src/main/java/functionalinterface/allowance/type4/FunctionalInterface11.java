package functionalinterface.allowance.type4;

@FunctionalInterface
public interface FunctionalInterface11 extends FunctionalInterface9, FunctionalInterface10 {
	
	//allowed
	//Below method is same as the method in Implemented Interfaces, 
	//not different as its broader type of both the interfaces
	public void functionalInterfaceMethod1(Iterable iterable);
	
	//without any method it wont be a FunctionalInterface
}
