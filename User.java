package hibernate_user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class User {
    
	@Column(name="userid")
	@Id
	private int id;
	private String name;
	@Column(name="phone_no",unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String password;
	private String fbPass;
	private String instaPass;
	private String snapPass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFbPass() {
		return fbPass;
	}
	public void setFbPass(String fbPass) {
		this.fbPass = fbPass;
	}
	public String getInstaPass() {
		return instaPass;
	}
	public void setInstaPass(String instaPass) {
		this.instaPass = instaPass;
	}
	public String getSnapPass() {
		return snapPass;
	}
	public void setSnapPass(String snapPass) {
		this.snapPass = snapPass;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password
				+ ", fbPass=" + fbPass + ", instaPass=" + instaPass + ", snapPass=" + snapPass + "]";
	}
	
	
	
	
}
