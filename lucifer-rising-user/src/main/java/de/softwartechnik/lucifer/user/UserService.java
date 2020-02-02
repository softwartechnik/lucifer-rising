package de.softwartechnik.lucifer.user;

import java.security.InvalidParameterException;
import javax.ejb.Stateless;

@Stateless
public class UserService {

  private UserDao userDao = new UserDao();

  public User registrate(String name, String password) {
    userDao.create(new User(name, password));
    return userDao.readByName(name);
  }

  public User signIn(String name, String password) {
    User user;
    if ((user = userDao.readByName(name)).getPassword().equals(password)) {
      return user;
    }
    throw new InvalidParameterException("Wrong User/Password combination!");
  }

  public User read(int id) {
    return userDao.read(id);
  }

  public void update(User user) {
    userDao.update(user);
  }

  public void delete(int id) {
    userDao.delete(id);
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
