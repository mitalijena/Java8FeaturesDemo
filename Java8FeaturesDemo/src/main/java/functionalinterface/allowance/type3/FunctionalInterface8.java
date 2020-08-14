package functionalinterface.allowance.type3;

@FunctionalInterface
public interface FunctionalInterface8 extends FunctionalInterface6, FunctionalInterface7 {
	
	//allowed
	//Functional: FunctionalInterface7.functionalInterfaceMethod1 is a subsignature & return-type-substitutable
	//Below method is same as the method in Implemented Interfaces, not different as its broader type
	public void functionalInterfaceMethod1(Iterable iterable);
	
	//Not Allowed
	//as its restrictive type
	//public void functionalInterfaceMethod1(Iterable<String> iterable);
}
