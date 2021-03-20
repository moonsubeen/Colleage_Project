package college_management.my.db.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="soldier")
public class StudentSoldier{
	@Column(name="state")
	private boolean state; // 군입대 유무
	
	@Column(name="solider_number")
	private String soldierNumber; // 군번
	
	@Column(name="specific")
	private String militatySpecific; // 군별
	
	@Column(name="specifies")
	private String militayspecifies; // 역종
	
	@Column(name="speciality")
	private String militatySpeciality; // 군대주특기
	
	@Column(name="servicesite")
	private String militaryServiceSite; // 병적지
	
	@Column(name="rakj")
	private String rank; // 계급
	
	@Column(name="enlistdate")
	private String enlistDate; // 입대일자
	
	@Column(name="dischangedate")
	private String dischageDate; // 전역일자
	
	@Column(name="servicedate")
	private String militaryServiceDate; // 복무일자
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getSoldierNumber() {
		return soldierNumber;
	}
	public void setSoldierNumber(String soldierNumber) {
		this.soldierNumber = soldierNumber;
	}
	public String getMilitatySpecific() {
		return militatySpecific;
	}
	public void setMilitatySpecific(String militatySpecific) {
		this.militatySpecific = militatySpecific;
	}
	public String getMilitayspecifies() {
		return militayspecifies;
	}
	public void setMilitayspecifies(String militayspecifies) {
		this.militayspecifies = militayspecifies;
	}
	public String getMilitatySpeciality() {
		return militatySpeciality;
	}
	public void setMilitatySpeciality(String militatySpeciality) {
		this.militatySpeciality = militatySpeciality;
	}
	public String getMilitaryServiceSite() {
		return militaryServiceSite;
	}
	public void setMilitaryServiceSite(String militaryServiceSite) {
		this.militaryServiceSite = militaryServiceSite;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getEnlistDate() {
		return enlistDate;
	}
	public void setEnlistDate(String enlistDate) {
		this.enlistDate = enlistDate;
	}
	public String getDischageDate() {
		return dischageDate;
	}
	public void setDischageDate(String dischageDate) {
		this.dischageDate = dischageDate;
	}
	public String getMilitaryServiceDate() {
		return militaryServiceDate;
	}
	public void setMilitaryServiceDate(String militaryServiceDate) {
		this.militaryServiceDate = militaryServiceDate;
	}
	
}
