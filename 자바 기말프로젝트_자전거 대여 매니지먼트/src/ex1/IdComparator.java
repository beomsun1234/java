package ex1;

import java.util.Comparator;

public class IdComparator implements Comparator<Bicycle>{

	@Override
	public int compare(Bicycle o1, Bicycle o2) {
		// TODO Auto-generated method stub
		return o1.getId().compareTo(o2.getId());
	}

}
