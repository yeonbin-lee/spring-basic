package basic_project.core;

import basic_project.core.member.Grade;
import basic_project.core.member.Member;
import basic_project.core.member.MemberService;
import basic_project.core.member.MemberServiceImpl;
import basic_project.core.order.Order;
import basic_project.core.order.OrderService;
import basic_project.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
