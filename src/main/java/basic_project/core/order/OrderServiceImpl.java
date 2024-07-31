package basic_project.core.order;

import basic_project.core.discount.DiscountPolicy;
import basic_project.core.discount.FixDiscountPolicy;
import basic_project.core.member.Member;
import basic_project.core.member.MemberRepository;
import basic_project.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
