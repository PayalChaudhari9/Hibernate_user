package hibernate_user.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_person2.dto.Person;
import hibernate_user.dto.User;

public class UserDao {

    Scanner scanner = new Scanner(System.in);
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("shivani").createEntityManager();
	}

	public void saveUser(User user) {

		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}
   //positional parameter
	
//	public User getUser(String email) {
//		EntityManager manager = getEntityManager();
//		Query query = manager.createQuery("SELECT u FROM User u WHERE u.email =?1");
//		query.setParameter(1, email);
//		try {
//			User user = (User) query.getSingleResult();
//			return user;
//		} catch (Exception e) {
//			return null;
//		}
//
//	}
	
	//named parameter
	
	public User getUser(String email) {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("SELECT u FROM User u WHERE u.email =:email");
		query.setParameter("email",email);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}

	}
	
	
	public void update(String email) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Query query = manager.createQuery("SELECT u FROM User u WHERE u.email=?1");

		query.setParameter(1, email);

		User user = (User) query.getSingleResult();
		
		if(user!=null) {
			System.out.println("Enter the fb password");
			user.setFbPass(scanner.next());
			System.out.println("Enter the insta password");
			user.setInstaPass(scanner.next());
			System.out.println("Enter the snap password");
			user.setSnapPass(scanner.next());
			
			transaction.begin();
			manager.merge(user);
			transaction.commit();
			System.out.println("Data Updated!");
			
			getUser(email);
		}
		else 
		{
			System.out.println("User not found!");
		}
	}
	
	
	
}
