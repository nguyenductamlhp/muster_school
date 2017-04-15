package com.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the class database table.
 * 
 */
@Entity
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="course_id")
	private int courseId;

	@Column(name="user_id")
	private int userId;

	public Class() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}