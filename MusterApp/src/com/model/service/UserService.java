package com.model.service;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.model.entity.User;

public class UserService {

	public UserService() {

	}
	
	public boolean isLoginSuccess(String username, String password) {
		boolean isSuccess = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusterApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String hsql = "select * from User where username = :uname and password = :pass";
		Query query = entityManager.createQuery(hsql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<User> list_user = query.getResultList();
		if (list_user.size() == 1) {
			isSuccess = true;
		}
		return isSuccess;
	}
}
