package com.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.entity.Course;

public class CourseService {

	public CourseService() {
		super();
	}
	
	public List<Course> getAllCourse() {
		List<Course> listAllCourse = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusterApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "SELECT c FROM Course c";
		Query query = entityManager.createQuery(sql);
		listAllCourse = query.getResultList();
		return listAllCourse;
	}
	
	
}
