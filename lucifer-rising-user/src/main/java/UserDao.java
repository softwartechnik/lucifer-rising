import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

//TODO: Unittests
class UserDao {

  @PersistenceContext (unitName = "UserPersistenceUnit")
  private EntityManager entityManager;

  void create(User user) {
    entityManager.persist(user);
  }

  User read(int id) {
    return entityManager.find(User.class, id);
  }

  void update(User user) {
    entityManager.merge(user);
  }

  void delete(int id) {
    User user = read(id);
    entityManager.remove(user);
  }

  User readByName(String name) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
    Root<User> root = criteriaQuery.from(User.class);
    ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class);
    criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("user"), parameterExpression));
    TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
    typedQuery.setParameter(parameterExpression, name);
    return typedQuery.getSingleResult();

    //Query query = entityManager.createQuery("SELECT id,name,gamesPlayed,gamesWon FROM user WHERE name = :username", User.class).setParameter("username", name);
    //return (User) query.getSingleResult();
  }
}
