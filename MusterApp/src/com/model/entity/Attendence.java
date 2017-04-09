package com.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the attendence database table.
 * 
 */
@Entity
@NamedQuery(name="Attendence.findAll", query="SELECT a FROM Attendence a")
public class Attendence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="course_session_id")
	private int courseSessionId;

	@Column(name="user_id")
	private int userId;

	public Attendence() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseSessionId() {
		return this.courseSessionId;
	}

	public void setCourseSessionId(int courseSessionId) {
		this.courseSessionId = courseSessionId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}