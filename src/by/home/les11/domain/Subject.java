package by.home.les11.domain;

public class Subject {

	private Integer id;
	private String subjectName;

	public Subject() {
	}

	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public Subject(String subjectName,int id) {
		this.subjectName = subjectName;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "id= " + id + " subjectName= " + subjectName;
	}

}
