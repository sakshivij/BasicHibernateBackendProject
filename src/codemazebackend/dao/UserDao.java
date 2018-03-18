package codemazebackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import codemazebackend.model.User;


public interface UserDao {

	public void add(User u);            //create new user:   C
	public List<User> getlist(); 		//retrieve users:    R
	public List<User> getbyId(Long id);
	public void update(User u);         //update user:       U
	public void delete(Long id);        //delete user:       D
}
