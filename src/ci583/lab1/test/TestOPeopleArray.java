package ci583.lab1.test;

import ci583.lab1.arrays.OrderedPeopleArray;
import ci583.lab1.arrays.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestOPeopleArray {
	
	private OrderedPeopleArray a = null;
	private final int MAX = 31;
	private Person p = new Person("Don", "Knuth", 75);

	@Before
	public void setUp() throws Exception {
		a = new OrderedPeopleArray(MAX);
	}

	@Test
	public void testOrdered() {
		a.clear();
		a.insert("Alice", "Coltrane", 42);
		a.insert("Thelonius", "Monk", 42);
		a.insert("Miles", "Davis", 42);
		a.insert("John", "Coltrane", 42);
		a.insert("Sun", "Ra", 42);
		a.insert("Ornette", "Coleman", 42);
		String s = "Coleman\n" +
				"Coltrane\n" +
				"Coltrane\n" +
				"Davis\n" +
				"Monk\n" +
				"Ra\n";
		assertEquals(a.getLastNames(), s);
	}

	@Test
	public void testFind() {
		a.clear();
		insertP();
		Person p2 = a.find(p.getLastName());
		assertEquals(p, p2);
		assertEquals(a.find("bananas"), null);

		String s = randomName();
		a.insert("Fred", s, 42);

		for(int i=0;i<30;i++) {
			a.insert("Fred", randomName(), 42);
		}

		Person p3 = a.find(s);
		assertEquals(p3.getLastName(), s);
	}

	@Test
	public void testMax() {
		a.clear();
		for(int i=0;i<MAX;i++) {
			a.insert(p.getFirstName(), p.getLastName()+i, p.getAge());
		}
		assertEquals(insertP(),false);
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
		OrderedPeopleArray empty = new OrderedPeopleArray(MAX);
		assertEquals(a, empty);
	}

	private String randomName() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

}

