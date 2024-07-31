package basic_project.core;

import basic_project.core.member.Grade;
import basic_project.core.member.Member;
import basic_project.core.member.MemberService;
import basic_project.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " +findMember.getName());

    }

}
