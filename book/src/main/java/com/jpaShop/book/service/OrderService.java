package com.jpaShop.book.service;

import com.jpaShop.book.domain.*;
import com.jpaShop.book.domain.item.Item;
import com.jpaShop.book.repository.ItemRepository;
import com.jpaShop.book.repository.MemberRepository;
import com.jpaShop.book.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    public List<Order> findOrders(){
        return orderRepository.findAll();
    }

    // 주문 생성
    public Long order(Long memberId, Long itemId, int count){
        // Item, Member entity 가져오기
        Item item = itemRepository.findOne(itemId);
        Member member = memberRepository.findOne(memberId);

        // delivery 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        // 주문 상품 (OrderItem) 생성
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(item.getPrice());
        orderItem.setCount(count);
        orderItem.setItem(item);

        // Item의 stockQuantity를 count만큼 줄여줘야한다.
        item.removeStock(count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    // 주문 취소
    // id를 전달 받아서 주문 엔티티 조회하고 해당 주문 취소
    public void cancelOrder(Long orderId){
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        // 주문 취소
        order.cancel();
    }
}
