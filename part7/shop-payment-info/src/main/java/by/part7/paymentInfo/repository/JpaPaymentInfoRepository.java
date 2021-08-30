package by.part7.paymentInfo.repository;

import by.part7.paymentInfo.model.PaymentInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaPaymentInfoRepository implements PaymentInfoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PaymentInfo> findAll() {
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<PaymentInfo> cr = cb.createQuery(PaymentInfo.class);
        Root<PaymentInfo> root = cr.from(PaymentInfo.class);
        cr.select(root);
        return em.createQuery(cr).getResultList();
    }

    @Override
    public PaymentInfo findById(int id) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<PaymentInfo> cr = cb.createQuery(PaymentInfo.class);
        Root<PaymentInfo> root = cr.from(PaymentInfo.class);
        cr.select(root).where(cb.equal(root.get("id"), id));
        return em.createQuery(cr).getSingleResult();
    }
}
