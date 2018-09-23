package data;
import java.util.List;

import model.*;
public interface UserDao {

	List<User> getUsers()throws Exception;
	boolean saveUser(User user)throws Exception;
	boolean updateUser(User user)throws Exception;
	boolean deleteUser(String userId)throws Exception;
	
}
