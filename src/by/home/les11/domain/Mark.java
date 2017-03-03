package by.home.les11.domain;

public class Mark {
	private Integer id;
	private Integer mark;
	private Integer studentId;
	private String studentFirstName;
	private String studentLastName;
	private Integer subjectId;
	private String subjectName;

	public Mark() {
	}

	public Mark(int mark, int studentId, int subjectId) {
		this.mark = mark;
		this.studentId = studentId;
		this.subjectId = subjectId;
	}

	public Mark(int mark, int id) {
		this.mark = mark;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "mark= " + mark + " studentId= " + studentId + " studentFirstName= " + studentFirstName
				+ " studentLastName= " + studentLastName + " subjectId= " + subjectId + " subjectName= " + subjectName;
	}
}
