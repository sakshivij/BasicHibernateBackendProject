package codemazebackend.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import codemazebackend.dao.UserDaoImpl;
import codemazebackend.model.User;



public class UserTest {

	static SessionFactory sf;
	public static void main(String[] args) throws Exception {
	
		UserDaoImpl d=new UserDaoImpl();
		User ur=new User("John",98997656L,"john@gmail.com","21/12/2017");
		d.add(ur);
	}
	
	
}
