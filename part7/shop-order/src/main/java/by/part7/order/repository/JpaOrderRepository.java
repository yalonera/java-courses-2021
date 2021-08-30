package by.part7.order.repository;

import by.part7.order.model.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaOrderRepository implements OrderRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Order> findAll() {
    final CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Order> cr = cb.createQuery(Order.class);
    Root<Order> root = cr.from(Order.class);
    cr.select(root);
    return em.createQuery(cr).getResultList();
  }
}
