package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Map join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {

		Member existsMember = getMemberByLoginId(loginId);

		Map<String, Object> rs = new HashMap<>();

		if (existsMember != null) {

			rs.put("msg", Ut.f("이미 사용중인 아이디(%s)입니다", loginId));
			rs.put("code", "F-7");

			return rs;
		}

		existsMember = getMemberByNameAndEmail(name, email);

		if (existsMember != null) {

			rs.put("msg", Ut.f("이미 사용중인 이름(%s)과 이메일(%s)입니다", name, email));
			rs.put("code", "F-8");

			return rs;
		}

		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNum, email);

		int id = memberRepository.getLastInsertId();

		rs.put("MemberId", id);
		rs.put("msg", Ut.f("회원가입이 완료되었습니다. %s님 환영합니다.", name));
		rs.put("code", "S-1");

		return rs;

	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMember(int id) {
		return memberRepository.getMember(id);
	}

}
