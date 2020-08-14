package streamapi.intemediateoperations.sorted;

import java.util.Comparator;

public class MyComparator implements Comparator<Product> {
	
	@Override
	public int compare(Product p1, Product p2) {
		if(p1.getPid() < p2.getPid()) {
			return 1;
		} else if(p1.getPid() > p2.getPid()) {
			return -1;
		} else
			return 0;
	}

}
