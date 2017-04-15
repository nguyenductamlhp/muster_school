package com.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course_session database table.
 * 
 */
@Entity
@Table(name="course_session")
@NamedQuery(name="CourseSession.findAll", query="SELECT c FROM CourseSession c")
public class CourseSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="course_id")
	private int courseId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String state;

	public CourseSession() {
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public List<User> getJoinedUser() {
		List<User> listJoinedUser = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusterApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String hsql = "select u from User as u, CourseSession as cs where u.id =: u_id";
		Query query = entityManager.createQuery(hsql);
		listJoinedUser = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return listJoinedUser;
	}
}