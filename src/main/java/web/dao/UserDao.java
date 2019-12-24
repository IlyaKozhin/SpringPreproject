package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> listUsers();
   void deleteUser(long id);
   void updateUser(User user);
}
