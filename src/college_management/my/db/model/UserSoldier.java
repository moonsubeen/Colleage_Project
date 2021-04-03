package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="soldier")
public class UserSoldier implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private User user; // 학번
	
	@Column(name="state")
	private boolean state; // 군입대 유무
	
	@Column(name="military_number")
	private String militaryNumber; // 군번
	
	@Column(name="type")
	private String type; // 군별
	
	@Column(name="classification")
	private String classification; // 역종
	
	@Column(name="branch")
	private String branch; // 군대주특기(병과)
	
	@Column(name="rank")
	private String rank; // 계급
	
	@Column(name="joinDate")
	private String joinDate; // 입대일자
	
	@Column(name="dischangedate")
	private String dischageDate; // 전역일자

	public User getStudent() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMilitaryNumber() {
		return militaryNumber;
	}

	public void setMilitaryNumber(String militaryNumber) {
		this.militaryNumber = militaryNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDischageDate() {
		return dischageDate;
	}

	public void setDischageDate(String dischageDate) {
		this.dischageDate = dischageDate;
	}
	public String toString() {
		return "군입대 : " + state + ", 군번 : " + militaryNumber + "군별 : " + type + ", 역종 : " + classification + ", 병과 : " + branch + ", 계급 : " + rank + ", 입영일자 : " + joinDate + ", 전역일자 : " + dischageDate;
	}
}
