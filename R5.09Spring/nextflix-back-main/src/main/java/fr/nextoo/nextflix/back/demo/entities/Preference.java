package fr.nextoo.nextflix.back.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preferences",schema = "nextflix")
public class Preference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_id",referencedColumnName = "id")
	private User user;

	@Column
	private String name;

	@Column
	private String type;

	public Preference(Integer id, User user, String name, String type) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.type = type;
	}

	public Preference() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
