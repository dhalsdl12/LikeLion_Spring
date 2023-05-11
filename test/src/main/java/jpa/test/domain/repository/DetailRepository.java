package jpa.test.domain.repository;

import jpa.test.domain.OrderDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DetailRepository {
    private final EntityManager em;
    public void save(OrderDetails details){
        em.persist(details);
    }
}
