package college_management.my.db.model;

public class StudentDisability extends Student{ 
	private String disability; // 장애유무
	private String document; // 증빙서류
	
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
}
