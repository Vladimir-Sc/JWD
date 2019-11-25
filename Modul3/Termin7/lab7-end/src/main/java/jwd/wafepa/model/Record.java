package jwd.wafepa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblRecord")
public class Record {

	@Id
	@GeneratedValue
	@Column
	private Long Id;

	@Column
	private String time;

	@Column
	private int duration;

	@Column
	private String intesity;

	@ManyToOne(fetch = FetchType.LAZY)
			//, cascade = CascadeType.ALL)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
			//, cascade = CascadeType.ALL)
	private Activity activity;

	public Record() {
		super();
	}

	
	public Record(String time, int duration, String intesity, Activity activity) {
		super();
		this.time = time;
		this.duration = duration;
		this.intesity = intesity;
		this.activity = activity;
	}
	
	public Record(String time, int duration, String intesity, User user, Activity activity) {
		super();
		this.time = time;
		this.duration = duration;
		this.intesity = intesity;
		this.user = user;
		this.activity = activity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getIntesity() {
		return intesity;
	}

	public void setIntesity(String intesity) {
		this.intesity = intesity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
