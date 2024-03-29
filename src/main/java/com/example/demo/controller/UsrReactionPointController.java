package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ReactionPointService;
import com.example.demo.vo.Rq;

@Controller
public class UsrReactionPointController {
	@Autowired
	private ReactionPointService reactionPointService;
	@Autowired
	private Rq rq;

	@RequestMapping("/usr/reactionPoint/increaseGoodRp")
	@ResponseBody
	public int increaseGoodRp(String relTypeCode, int id) {
		// article 테이블에서 해당 게시물의 좋아요 1 증가
		// article 테이블에서 해당 게시물의 최신화된 좋아요 수 불러오기
		int goodRp = reactionPointService.getGoodRpCount(id);

		// reactionPoint 테이블에 리액션 정보(게시판 id, 게시물 id, 사용자 id)를 기록
		reactionPointService.addIncreasingGoodRpInfo(relTypeCode, id, (int) rq.getLoginedMemberId());

		return goodRp;
	}

	@RequestMapping("/usr/reactionPoint/decreaseGoodRp")
	@ResponseBody
	public int decreaseGoodRp(String relTypeCode, int id) {
		// article 테이블에서 해당 게시물의 좋아요 1 감소
		// article 테이블에서 해당 게시물의 최신화된 좋아요 수 불러오기
		int goodRp = reactionPointService.getGoodRpCount(id);

		// reactionPoint 테이블에 리액션 정보(게시판 id, 게시물 id, 사용자 id) 기록을 삭제
		reactionPointService.deleteGoodRpInfo(relTypeCode, id, (int) rq.getLoginedMemberId());

		return goodRp;
	}

	@RequestMapping("/usr/reactionPoint/increaseBadRp")
	@ResponseBody
	public int increaseBadRp(String relTypeCode, int id) {
		int badRp = reactionPointService.getBadRpCount(id);

		reactionPointService.addIncreasingBadRpInfo(relTypeCode, id, (int) rq.getLoginedMemberId());

		return badRp;
	}

	@RequestMapping("/usr/reactionPoint/decreaseBadRp")
	@ResponseBody
	public int decreaseBadRp(String relTypeCode, int id) {
		int badRp = reactionPointService.getBadRpCount(id);

		reactionPointService.deleteBadRpInfo(relTypeCode, id, (int) rq.getLoginedMemberId());

		return badRp;
	}
}
