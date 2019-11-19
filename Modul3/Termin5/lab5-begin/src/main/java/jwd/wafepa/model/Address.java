package jwd.wafepa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String streat;
	
	@Column
	private String number;
	
	//EAGER cim dobavi ovu stranu veze dobaviti i povezani entitet  (cim se dobavi jedna stvar odmah se dobije u memoriji)
	//toOne kod HIb je eager, a toMany je lazy
	//LAZY ce dobaviti povezani entitet tek kada zatreba (mora da traje transakcija)
	// cascade - sta ce se desiti ako pokusamo da obrisemo entitet koji je owner
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private User user;
	
	
	
	
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
		if(!user.getAddresses().contains(this)){
			user.getAddresses().add(this);
		}
	}
	
	
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreat() {
		return streat;
	}
	public void setStreat(String streat) {
		this.streat = streat;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
