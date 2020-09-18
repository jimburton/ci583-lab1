package ci583.lab1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ci583.lab1.arrays.Person;
import ci583.lab1.arrays.UnorderedPeopleArray;

public class TestUPeopleArray {
	
	private UnorderedPeopleArray a = null;
	private final int MAX = 10;
	private Person p = new Person("Don", "Knuth", 75);

	@Before
	public void setUp() throws Exception {
		a = new UnorderedPeopleArray(MAX);
	}

	@Test
	public void testEmpty() {
		a = new UnorderedPeopleArray(MAX);
		Person p2 = a.find(p.getLastName());
		assertNull(p2);
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
		assertEquals(insertP(), false);
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
	
	private boolean insertP() {
		return a.insert(p.getFirstName(), p.getLastName(), p.getAge());
	}
	
	@Test
	public void testClear() {
		a.clear();
		UnorderedPeopleArray empty = new UnorderedPeopleArray(MAX);
		assertEquals(a, empty);
	}

}

