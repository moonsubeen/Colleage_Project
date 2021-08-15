package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import college_management.my.api.config.Permission;

@Entity
@Table(name = "user")
public class User implements Serializable{
	@Id
	@Column(name = "id")
	private String id; // 아이디
	
	@Column(name = "password")
	private String pwd = "0000"; // 비밀번호
	
	@Column(name = "name")
	private String name; // 이름
	
	@Column(name = "residentNumber")
	private String residentNumber; // 주민번호
	
	@Column(name = "birthdate")
	private String birthdate; // 생년월일
	
	@Column(name = "address")
	private String address; // 주소
	
	@Column(name = "email")
	private String email; // 이메일
	
	@Column(name = "phoneNumber")
	private String phoneNumber; // 전화번호
	
	@Column(name = "nationality")
	private String nationality; // 국적
	
	@Column(name ="sex")
	private String sex; // 성별
	
	@Column(name = "role")
	private Permission role; // 역활
	
	public Permission getRole() {
		return role;
	}
	public void setRole(Permission role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString(){
		return "role : " + role + " id : " + id + ", name : " + name + ", pwd : " + pwd + ", email : " + email + ", nationality : " + nationality + 
				", phonenumber : " + phoneNumber + ", address : " + address + ", birthdate : " + birthdate + ", residentnumber : " + residentNumber +
				", sex : " + sex;
	}
}