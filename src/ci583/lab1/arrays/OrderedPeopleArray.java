package ci583.lab1.arrays;

public class OrderedPeopleArray extends PeopleArray {
	
	public OrderedPeopleArray(int max) {
		super(max);
	}

	/**
	 * Insert a new person maintaining the order of the data.
	 * Throw ArrayIndexOutOfBoundsException if arr is full
	 * @param first
	 * @param last
	 * @param age
	 */
	public boolean insert(String first, String last, int age) {
		if(nElems == arr.length) return false;
		Person p = new Person(first, last, age);
		for (int i=0;i<nElems;i++) {
			Person iP = arr[i];
			int comp = iP.getLastName().compareTo(last);
			if (comp >= 0) {
				for(int j=nElems;j>i;j--) {
					arr[j] = arr[j-1];
				}
				arr[i] = p;
				nElems++;
				return true;
			}
		}
		arr[nElems] = p;
		nElems++;
		return true;
	}

	/**
	 * Return the Person with lastName, or null. Use BinarySearch to to do the finding.
	 * @param lastName
	 * @return
	 */
	public Person find(String lastName) {
		int start = 0;
		int end = nElems;
		int mid;
		while (start != end) {
			mid = (start + end) /2;
			Person p = arr[mid];
			int comp = p.getLastName().compareTo(lastName);
			if(comp<0) {
				start = mid+1;
			} else if(comp>0) {
				end = mid-1;
			} else {
				return p;
			}
		}
		return null;
	}

}

