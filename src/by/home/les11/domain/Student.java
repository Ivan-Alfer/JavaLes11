package by.home.les11.domain;

public class Student {
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	public Student(){
	}
	
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student(String firstName, String lastName,int id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "id=" + id + "  firstName= " + firstName + "  lastName= " + lastName;
	}
	
	
}
