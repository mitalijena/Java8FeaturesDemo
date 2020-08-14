package defaultmethod;

public interface DefaultMethodInterface {
	
	default void defaultMethod(String str) {
		System.out.println("Welcome to Default Method Introduction in Java 8 : "+str);
	}
	
	//This is not allowed as this method exists in Object class so cant be overridden
	/*default boolean equals(Object obj){
		System.out.println("Welcome to Default Method Introduction in Java 8 : equals");
	}*/
}
