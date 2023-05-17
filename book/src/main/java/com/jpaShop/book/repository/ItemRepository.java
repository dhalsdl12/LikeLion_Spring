package com.jpaShop.book.repository;


import com.jpaShop.book.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    // 저장 기능
    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        }
        else{
            em.merge(item); // null이 있으면 그대로 바뀌니까 조심하기
        }
    }

    // 아이템 하나 찾기
    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    // 아이템 전체 찾기
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
