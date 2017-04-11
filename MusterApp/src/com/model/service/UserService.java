package com.model.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.entity.User;

public class UserService {

	public UserService() {

	}
	
	public List<User> getAllUser() {
		List<User> listAllUser = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusterApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String hsql = "select u from User u";
		Query query = entityManager.createQuery(hsql);
		listAllUser = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return listAllUser;
	}
	
	public boolean isLoginSuccess(String username, String password) {
		boolean isSuccess = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusterApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String hsql = "select u from User u where username = :uname and password = :pass";
		Query query = entityManager.createQuery(hsql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<User> list_user = query.getResultList();
		if (list_user.size() == 1) {
			isSuccess = true;
		}
		entityManager.close();
		entityManagerFactory.close();
		return isSuccess;
	}
}
