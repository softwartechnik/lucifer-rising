package de.softwartechnik.lucifer.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

final class UserDao {

  @PersistenceContext(unitName = "UserPersistenceUnit")
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
    var parameterExpression = criteriaBuilder.parameter(String.class);
    criteriaQuery.select(root)
      .where(criteriaBuilder.equal(root.get("user"), parameterExpression));
    return entityManager.createQuery(criteriaQuery)
      .setParameter(parameterExpression, name).getSingleResult();
  }
}
