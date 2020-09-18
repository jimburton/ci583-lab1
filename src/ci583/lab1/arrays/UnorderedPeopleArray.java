package ci583.lab1.arrays;


public class UnorderedPeopleArray extends PeopleArray {

	public UnorderedPeopleArray(int max) {
		super(max);
	}

	/**
	 * Insert a new person to the end of the array.
	 * Throw ArrayIndexOutOfBoundsException if arr is full
	 * @param first
	 * @param last
	 * @param age
	 */
	public boolean insert(String first, String last, int age) {
		if(nElems == arr.length) {
			return false;
		}
		Person p = new Person(first, last, age);
		arr[nElems] = p;
		nElems++;
		return true;
	}

	/**
	 * Return the Person with lastName, or null. Use SequentialSearch to find the target.
	 * @param lastName
	 * @return
	 */
	public Person find(String lastName) {
		for(int i = 0; i< nElems; i++) {
			Person p = arr[i];
			if (p.getLastName().equals(lastName)) {
				return p;
			}
		}
		return null;
	}

}

