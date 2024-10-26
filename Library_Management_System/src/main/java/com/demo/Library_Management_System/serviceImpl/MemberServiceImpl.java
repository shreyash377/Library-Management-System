package com.demo.Library_Management_System.serviceImpl;

import com.demo.Library_Management_System.dao.MemberDao;
import com.demo.Library_Management_System.entities.Member;
import com.demo.Library_Management_System.services.MemberService;


import java.util.List;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	@Override
	public Member createMember(Member member) {
		return memberDao.createMember(member);  
	}

	@Override
	public List<Member> getAllMember() {
		return memberDao.getAllMember();
	}

	@Override
	public Member getMemberById(int adminId) {
		return memberDao.getMemberById(adminId);
	}

	@Override
	public Member updateMember(int adminId, Member updatedAdmin) {
		return memberDao.updateMember(adminId, updatedAdmin); 
	}

	@Override
	public String deleteMember(int adminId) {
		memberDao.deleteMember(adminId);
		return "User deleted successfully!";
	}
}
