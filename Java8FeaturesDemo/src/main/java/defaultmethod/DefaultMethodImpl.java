package defaultmethod;

public class DefaultMethodImpl implements DefaultMethodInterface {
	
	//Doesnt necessary to override the default method in the implemented Interface
	public void test() {
		DefaultMethodInterface.super.defaultMethod("Message1");
	}
	
	public void defaultMethod(String str) {
		DefaultMethodInterface.super.defaultMethod("Message1");
		System.out.println("Welcome to Default Method Introduction in Java 8 in child class: "+str);
		DefaultMethodInterface.super.defaultMethod("Message1");
	}
}
