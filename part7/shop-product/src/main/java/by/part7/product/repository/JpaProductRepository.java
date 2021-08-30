package by.part7.product.repository;

import by.part7.product.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaProductRepository implements ProductRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Product> findAll() {
    final CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Product> cr = cb.createQuery(Product.class);
    Root<Product> root = cr.from(Product.class);
    cr.select(root);
    return em.createQuery(cr).getResultList();
  }

  @Override
  public Product findById(int id) {
    final CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Product> cr = cb.createQuery(Product.class);
    Root<Product> root = cr.from(Product.class);
    cr.select(root).where(cb.equal(root.get("id"), id));
    return em.createQuery(cr).getSingleResult();
  }
}
