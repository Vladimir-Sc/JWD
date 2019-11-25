package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblUser")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="email",nullable=false, unique = true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany (mappedBy = "user")
			//, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE} )
	private  List<Record> records = new ArrayList<>();
	
	
	public User() {
		super();
	}
	
	
	
	public User(String email, String password, String firstName, String lastName, List<Record> records) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.records = records;
	}



	public User(String email, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address address){
		this.addresses.add(address);
		if(!this.equals(address.getUser())){
			address.setUser(this);
		}
	}
	
	public void addRecords(Record record){
		this.records.add(record);
		if(!this.equals(record.getUser())){
			record.setUser(this);
		}
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", records=" + records + "]";
	}
	
	
}
