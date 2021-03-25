package ex1;

import java.util.Comparator;

public class FeeComparator implements Comparator<Bicycle>{

	@Override
	public int compare(Bicycle o1, Bicycle o2) {
		// TODO Auto-generated method stub
		if(o1.getPrice()<o2.getPrice()) return 1;
		if(o1.getPrice()>o2.getPrice()) return -1;
		return 0;
	}

}
