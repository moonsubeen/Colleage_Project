package college_management.my.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="userfamily")
public class UserFamily implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName="id", unique=true)
	private User user; // 유저 아이디
	
	@Column(name="realtion")
	private String relation; // 가족관계
	
	@Column(name="name")
	private String name; // 이름
	
	@Column(name="phonenumber")
	private String phoneNumber; // 전화번호
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String toString() {
		return "이름 : " + name + ", 관계 : " + relation + ", 전화번호 : " + phoneNumber; 
	}
}
