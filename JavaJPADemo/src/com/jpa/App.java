package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADB");
		EntityManager entityManager = emFactoryObj.createEntityManager();
		
		String jpql = "SELECT user FROM UserEntity user WHERE user.username=:username "
				+ "AND user.password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("username", "anand");
		query.setParameter("password", "anand123");
		List<UserEntity> userList = query.getResultList();
		System.out.println("userList = " + userList);
	}

}
