package com.demo.Library_Management_System.services;
import com.demo.Library_Management_System.entities.Member; 
import java.util.List;

public interface MemberService {
	Member createMember(Member member);
    List<Member> getAllMember();
    Member getMemberById(int MemberId);
    Member updateMember(int MemberId, Member updatedMember);
    String deleteMember(int MemberId);
}
