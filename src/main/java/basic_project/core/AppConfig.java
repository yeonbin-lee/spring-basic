package basic_project.core;

import basic_project.core.discount.DiscountPolicy;
import basic_project.core.discount.FixDiscountPolicy;
import basic_project.core.discount.RateDiscountPolicy;
import basic_project.core.member.MemberService;
import basic_project.core.member.MemberServiceImpl;
import basic_project.core.member.MemoryMemberRepository;
import basic_project.core.order.OrderService;
import basic_project.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //리팩터링 전
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    //리팩터링 후 -> 역할과 구현 클래스가 한눈에 들어온다.
//    public MemberService memberService(){
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    public static MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy(){
//        return new RateDiscountPolicy();
//    }

    // 스프링 기반 변경
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
