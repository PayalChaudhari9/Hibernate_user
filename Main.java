package hibernate_user.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import hibernate_user.dao.UserDao;
import hibernate_user.dto.User;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Press \n1.SignUp \n2.Login");
		UserDao dao = new UserDao();
		User user = new User();

		switch (scanner.nextInt()) {
		case 1: {
			System.out.println("Enter the id : ");
			user.setId(scanner.nextInt());
			System.out.println("Enter the name : ");
			user.setName(scanner.next());
			System.out.println("Enter the phone : ");
			user.setPhone(scanner.nextLong());
			System.out.println("Enter the email : ");
			user.setEmail(scanner.next());
			System.out.println("Enter the password : ");
			user.setPassword(scanner.next());

			dao.saveUser(user);

		}
			break;

		case 2: {
			System.out.println("Enter the email : ");
			String email = scanner.next();
			System.out.println("Enter the password : ");
			String password = scanner.next();

			User dbUser = dao.getUser(email);

			if (dbUser != null) {
				if (password.equals(dbUser.getPassword())) {
					System.out.println("Login success!");
					System.out.println("Press \n1.display passwords \n2.update passwords");
					switch (scanner.nextInt()) {
					case 1: {
//                          dao.getAllPasswords(dbUser);
						
						User user3 = dao.getUser(email);
						System.out.println("passwords are");
						System.out.println("fbPass = " + user3.getFbPass() );
						System.out.println("instaPass = " + user3.getInstaPass() );
						System.out.println("fbPass = " + user3.getSnapPass() );
					}

						break;
                    //Update passwords
						
					case 2:{
						dao.update(email);
					}
					default:
						break;
					}
				} else {
					System.out.println("Invalid password!");
				}
			} else {
				System.out.println("User not found!");
			}

		}

		default:
			break;
		}
	}
}
