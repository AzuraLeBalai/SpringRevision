package fr.nextoo.nextflix.back.demo.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user",schema = "nextflix")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_name")
	private String userName ;

	@Column
	private String password;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Preference> preferences;

	public Integer getId() {
		return Integer.parseInt(this.id.toString());
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {return password;}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
}