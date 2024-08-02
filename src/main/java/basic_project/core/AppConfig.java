package basic_project.core;

import basic_project.core.discount.DiscountPolicy;
import basic_project.core.discount.FixDiscountPolicy;
import basic_project.core.discount.RateDiscountPolicy;
import basic_project.core.member.MemberRepository;
import basic_project.core.member.MemberService;
import basic_project.core.member.MemberServiceImpl;
import basic_project.core.member.MemoryMemberRepository;
import basic_project.core.order.OrderService;
import basic_project.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 스프링 기반 변경
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
