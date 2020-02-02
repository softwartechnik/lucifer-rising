package de.softwartechnik.lucifer.user;

import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class UserDaoTest {

  @Mock
  private EntityManager entityManager;

  @InjectMocks
  private UserDao userDao;

  @Test
  void createTest() {
    User user = new User();
    userDao.create(user);
    Mockito.verify(entityManager).persist(user);
  }

  @Test
  void readTest() {
    User user = new User();
    user.setName("name");
    when(entityManager.find(User.class, user.getId())).thenReturn(user);
    final User result = userDao.read(user.getId());
    Assertions.assertEquals(user, result);
  }

  @Test
  void updateTest() {
    User user = new User();
    when(entityManager.merge(user)).thenReturn(null);
    userDao.update(user);
    Mockito.verify(entityManager).merge(user);
  }

  @Test
  void deleteTest() {
    User user = new User();
    when(entityManager.find(User.class, user.getId())).thenReturn(user);
    userDao.delete(user.getId());
    Mockito.verify(entityManager).remove(user);
  }
}
