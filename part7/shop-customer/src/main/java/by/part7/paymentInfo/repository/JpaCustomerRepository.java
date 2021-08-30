package by.part7.paymentInfo.repository;

import by.part7.paymentInfo.model.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaCustomerRepository implements CustomerRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Customer> findAll() {
    final CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Customer> cr = cb.createQuery(Customer.class);
    Root<Customer> root = cr.from(Customer.class);
    cr.select(root);
    return em.createQuery(cr).getResultList();
  }

  @Override
  public Customer findById(int id) {
    final CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Customer> cr = cb.createQuery(Customer.class);
    Root<Customer> root = cr.from(Customer.class);
    cr.select(root).where(cb.equal(root.get("id"), id));
    return em.createQuery(cr).getSingleResult();
  }
}
