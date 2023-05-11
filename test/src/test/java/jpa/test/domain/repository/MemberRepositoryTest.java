package jpa.test.domain.repository;

import jpa.test.domain.Member;
import jpa.test.domain.OrderDetails;
import jpa.test.domain.Orders;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DetailRepository detailRepository;

    @Test
    @Rollback(value = false)
    void create(){
        Member member1 = new Member();
        member1.setMemberName("memberA");
        member1.setAddress("Seoul");
        memberRepository.save(member1);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setColor("Purple");
        orderDetails.setQuantity(10);
        detailRepository.save(orderDetails);

        Orders orders = new Orders();
        orders.setOrderDate(LocalDateTime.now());
        orders.setMember(member1);
        orders.setDetails(orderDetails);
        orderRepository.save(orders);
    }
}