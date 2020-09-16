package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class UserDetailsDaoImplementation implements UserDetailsDao{
	
	@Override
	public void addUser(String username,String password,String gender,int age,long c_num,String email) {
		try {
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session sess = sessionFactory.openSession();			
			UserDetails user = new UserDetails();
			user.setUsername(username);
			user.setPassword(password);
			user.setGender(gender);
			user.setAge(age);
			user.setC_num(c_num);
			user.setEmail(email);
			
			Transaction transaction = sess.beginTransaction();
			sess.persist(user);
			transaction.commit();
			System.out.println("\n\n DETAILS ADDED \n");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERROR...");
		}
	}

	@Override
	public List<UserDetails> fetchAllUsers() {
		try {
			SessionFactory sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
			Session sess;
			List<UserDetails> list = new ArrayList<UserDetails>(); 
			sess = sessFact.openSession();
			
		//	List<UserDetails> data = sess.createQuery("from UserDetails").list();
			
	    	Iterator<UserDetails> userIterator = data.iterator();
			//while(userIterator.hasNext()) {
			//	UserDetails user = userIterator.next();
			//	list.add(user);
			//}
	//		return list;
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERROR...");
			return null;
		}
		
	}

	@Override
	public boolean remove(int id) {
		try {
			SessionFactory sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
			Session sess = sessFact.openSession();
			sess.beginTransaction();
			Query query = sess.createQuery("delete from UserDetails where id='"+id+"'");
			int rs = query.executeUpdate();
			sess.getTransaction().commit();
			System.out.println("User Deleted...  " +rs);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERROR...");
			return false;
		}
	}

	@Override
	public UserDetails fetchUser(int id) {
		try {
			SessionFactory sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
			Session sess = sessFact.openSession();
			sess.beginTransaction();
			Query query = sess.createQuery("from UserDetails where id='"+id+"'");
			UserDetails user = null;
			Iterator<UserDetails> userIterator = query.iterate();
			while(userIterator.hasNext()) {
				user = userIterator.next();
			}
			sess.getTransaction().commit();
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERROR...");
			return null;
		}
		
	}

	@Override
	public boolean update(UserDetails user) {
		try {
			SessionFactory sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
			Session sess = sessFact.openSession();
			sess.beginTransaction();
			Query query = sess.createQuery("update UserDetails set username = '"+user.getUsername()+"', password = '"+user.getPassword()+"' ,"
					+ " age = '"+user.getAge()+"', gender = '"+user.getGender()+"', c_num = '"+user.getC_num()+"', email = '"+user.getEmail()
					+ "'where id = :x ");
			query.setParameter("x", user.getId());
			int rs = query.executeUpdate();
			sess.getTransaction().commit();
			System.out.println("User Updated...  " +rs);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERROR...");
			return false;
		}
		
	}
	
	
	
	
	

}
