package de.softwartechnik.lucifer.user;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public final class UserService {

  private UserDao userDao = new UserDao();

  public void create(String name) {
    userDao.create(new User(name));
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

  public User readByName(String name) {
    return userDao.readByName(name);
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public List<User> readAll() {
    return userDao.readAll();
  }
}
