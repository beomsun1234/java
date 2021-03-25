package ex1;

import java.util.Comparator;

public class IdRsort implements Comparator<Bicycle>{

	@Override
	public int compare(Bicycle o1, Bicycle o2) {
		// TODO Auto-generated method stub
		return o2.getId().compareTo(o1.getId());
	}
	

}
