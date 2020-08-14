package staticmethod;

public class StaticMethodImpl implements StaticMethodInterface {
	
	//Not overridden method from StaticMethodInterface
	//Cant be overridden as it is a static method
	//Only signature same, will be treated as just another method with same signature
	static void staticMethod(String str) {
		System.out.println("Static method in Implementing Class");
		StaticMethodInterface.staticMethod("in child class");
	}
	
	
}
