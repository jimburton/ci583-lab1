package ci583.lab1.arrays;

import java.util.Formatter;

public class Person {
    private String lastName;
    private String firstName;
    private int age;
    
    public Person(String first, String last, int age) {
    	this.firstName = first;
    	this.lastName = last;
    	this.age = age;
    }

	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getAge() {
		return age;
	}
    
    public String toString() {
    	return new Formatter().format("Last name: %s,  first name: %s, age: %d", 
    			getLastName(), firstName, age).toString();
    }
	
	public boolean equals(Object o) {
		if(!(o instanceof Person)) return false;
		Person that = (Person) o;
		return (firstName.equals(that.getFirstName()) 
				&& lastName.equals(that.getLastName()) 
				&& age == that.getAge());
	}
    
}


