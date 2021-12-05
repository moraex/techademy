package lists;

import java.util.ArrayList;
import java.util.ListIterator;

public class Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Iterator is used when we want to enumerate elements
		 * of list
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		ListIterator i = list.listIterator();
		
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}

}
