package codemazebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class User {

	private Long id;
	private String name;
	private Long number;
	private String email;
	private String date;
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="NAME")
	//@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="NUMBER")
	//@NotNull
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="DATE")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User()
	{
		name=null;
		number=0L;
		email=null;
		date=null;
	}
	public User(String name,Long number,String email,String date){
		//this.id=id;
		this.name=name;
		this.number=number;
		this.email=email;
		this.date=date;
		
	}

}
