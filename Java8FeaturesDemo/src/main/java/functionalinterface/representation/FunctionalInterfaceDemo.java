package functionalinterface.representation;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		//Instantiation of FunctionalInterface in traditional way
		FunctionalInterface1Impl i1 = new FunctionalInterface1Impl();
		i1.functionalInterfaceMethod1();
		
		//Instantiation of FunctionalInterface in Anonymous class way
		FunctionalInterface1 i2 = new FunctionalInterface1() {

			@Override
			public void functionalInterfaceMethod1() {
				System.out.println("Welcome to FunctionalInterface Introduction in Java 8 : functionalInterfaceMethod1 : Anonymous class way");
			}
			
		};
		i2.functionalInterfaceMethod1();
		
		//Instantiation of FunctionalInterface using Lambda Expression
		FunctionalInterface1 i3 = () -> System.out.println("Welcome to FunctionalInterface Introduction in Java 8 : functionalInterfaceMethod1 : Lambda expression");
		i3.functionalInterfaceMethod1();
	}

}
