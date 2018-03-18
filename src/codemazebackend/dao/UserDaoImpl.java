package codemazebackend.dao;

import java.util.Iterator;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Configuration;








import codemazebackend.model.User;



//UserDaoImpl class implements the UserDao class to enable CRUD operations
public class UserDaoImpl implements UserDao{
	
	static private SessionFactory sessionFactory;
	static private Session s;
	protected static void setUp() throws Exception
	
	{
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		.configure() // configures settings from hibernate.cfg.xml
		.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			throw new RuntimeException(e);
		}

	}
	protected void tearDown() throws Exception
	{
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
	public UserDaoImpl() throws Exception
	{
		setUp();
	}
	public void add(User u){
		
		s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
	}
	public List<User> getlist()
	{
		s=sessionFactory.openSession();
		s.beginTransaction();
		List<User> result=s.createQuery("from User").list();
		s.getTransaction().commit();
		s.close();
		return result;
	}
	public List<User> getbyId(Long id)
	{
		s=sessionFactory.openSession();
		s.beginTransaction();
		List<User> result=s.createQuery("from User where id='"+id+"'").list();
		s.getTransaction().commit();
		s.close();
		return result;
	}
	//to be checked
	public void update(User u){
		s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(u);
		s.getTransaction().commit();
		s.close();

	}
	public void delete(Long id){
		s=sessionFactory.openSession();
		s.beginTransaction();
		User us;
		us=s.load(User.class,id);
		s.delete(us);
		s.getTransaction().commit();
		s.close();
	}
	public static void main(String[] args) throws Exception {
		UserDaoImpl u=new UserDaoImpl();
		List <User>l=u.getbyId(2L);
		/*for(User uh:(List<User>)l)
		{
			System.out.println("id: "+uh.getId()+"Name: "+uh.getName()+"Number: "+uh.getNumber()+"Email: "+uh.getEmail()+"Date: "+uh.getDate());
			
		}*/
	     
		
	}
}
