package staticmethod;

public class StaticMethodDemo {

	public static void main(String[] args) {
		
		//Calls static method in the Interface
		StaticMethodInterface.staticMethod("Mitali");
		//Calls static method in the Implementing class(StaticMethodImpl)
		//It will just be a method of class...Not the overridden method from Interface
		StaticMethodImpl.staticMethod("Manoj");
	}

}
