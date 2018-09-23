package data;

import java.util.List;
import model.User;

public abstract interface UserDao
{
  public abstract List<User> getUsers()
    throws Exception;
  
  public abstract boolean saveUser(User paramUser)
    throws Exception;
  
  public abstract boolean updateUser(User paramUser)
    throws Exception;
  
  public abstract boolean deleteUser(String paramString)
    throws Exception;
}