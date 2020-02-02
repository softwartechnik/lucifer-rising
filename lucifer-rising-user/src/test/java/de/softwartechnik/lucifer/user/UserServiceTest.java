package de.softwartechnik.lucifer.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
final class UserServiceTest {

  @Mock
  private EntityManager entityManager;

  @InjectMocks
  private UserDao userDao;

  private UserService userService;

  @BeforeEach
  void setUp() {
    userService = new UserService();
    userService.setUserDao(userDao);
  }

  @Test
  void readTest() {
    int id = 42;
    String name = "name";
    String password = "password";
    int gamesPlayed = 42;
    int gamesWon = 10;
    User user = new User(name, password);
    user.setId(id);
    user.setGamesPlayed(gamesPlayed);
    user.setGamesWon(10);
    when(entityManager.find(User.class, user.getId())).thenReturn(user);
    User result = userService.read(id);
    Assertions.assertEquals(id, result.getId());
    Assertions.assertEquals(name, result.getName());
    Assertions.assertEquals(password, result.getPassword());
    Assertions.assertEquals(gamesPlayed, result.getGamesPlayed());
    Assertions.assertEquals(gamesWon, result.getGamesWon());
  }

  @Test
  void updateTest() {
    User user = new User();
    userService.update(user);
    Mockito.verify(entityManager).merge(user);
  }

  @Test
  void deleteTest() {
    int id = 42;
    userService.delete(id);
    Mockito.verify(entityManager).remove(Mockito.any());
  }
}
