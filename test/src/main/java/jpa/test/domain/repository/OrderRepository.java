package jpa.test.domain.repository;

import jpa.test.domain.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;
    public void save(Orders orders){
        em.persist(orders);
    }
}
