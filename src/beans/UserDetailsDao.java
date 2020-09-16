package beans;

import beans.UserDetails;
import java.util.List;

public interface UserDetailsDao {
	
	void addUser(String username,String password,String gender,int age,long c_num,String email);
	boolean remove(int id);
	UserDetails fetchUser(int id);
	boolean update(UserDetails user);
	List<UserDetails> fetchAllUsers();
	

}
