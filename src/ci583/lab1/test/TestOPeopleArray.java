package ci583.lab1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import ci583.lab1.arrays.OrderedPeopleArray;
import ci583.lab1.arrays.Person;

public class TestOPeopleArray {
	
	private OrderedPeopleArray a = null;
	private final int MAX = 10;
	private Person p = new Person("Don", "Knuth", 75);

	@Before
	public void setUp() throws Exception {
		a = new OrderedPeopleArray(MAX);
	}

	@Test
	public void testFind() {
		a.clear();
		insertP();
		Person p2 = a.find(p.getLastName());
		assertEquals(p, p2);
	}

	@Test
	public void testMax() {
		a.clear();
		for(int i=0;i<MAX;i++) {
			a.insert(p.getFirstName(), p.getLastName()+i, p.getAge());
		}
		try {
			insertP();
		} catch (ArrayIndexOutOfBoundsException e){
			assertEquals(1,1);
			return;
		}
		assertEquals(1,0);
	}

	@Test
	public void testDelete() {
		a.clear();
		insertP();
		a.delete(p.getLastName());
		assertNull(a.find(p.getLastName()));
	}

	@Test
	public void testPrintElem() {
		a.clear();
		insertP();
		assertEquals(p.toString(), a.find(p.getLastName()).toString());
	}
	
	private void insertP() {
		a.insert(p.getFirstName(), p.getLastName(), p.getAge());
	}
	
	@Test
	public void testClear() {
		a.clear();
		OrderedPeopleArray empty = new OrderedPeopleArray(MAX);
		assertEquals(a, empty);
	}

}

