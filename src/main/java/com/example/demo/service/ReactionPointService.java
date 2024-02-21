package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ReactionPointRepository;
import com.example.demo.vo.Rq;

@Service
public class ReactionPointService {

	@Autowired
	private ReactionPointRepository reactionPointRepository;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private Rq rq;

	@Autowired
	private CommentService commentService;

	// detail.jsp의 ajax 관련 메서드(article 테이블에 진입해야 하므로 articleService로 넘김)
	public void increaseGoodRp(int id) {
		articleService.increaseGoodRp(id);
	}

	public void increaseBadRp(int id) {
		articleService.increaseBadRp(id);
	}

	public void decreaseGoodRp(int id) {
		articleService.decreaseGoodRp(id);
	}

	public void decreaseBadRp(int id) {
		articleService.decreaseBadRp(id);
	}

	public int getGoodRpCount(int id) {
		return articleService.getGoodRpCount(id);
	}

	public int getBadRpCount(int id) {
		return articleService.getBadRpCount(id);
	}

	// reactionPoint 테이블에 좋아요/싫어요 로그 기록 관련 메서드
	public void addIncreasingGoodRpInfo(String relTypeCode, int relId, int memberId) {
		// 현재 게시물이 소속된 게시판 id를 가져옴

		switch (relTypeCode) {
		case "article":
			articleService.increaseGoodRp(relId);
			break;
		case "comment":
			commentService.increaseGoodRp(relId);
			break;
		}
		reactionPointRepository.addIncreasingGoodRpInfo(relTypeCode, relId, memberId);
	}

	public void deleteGoodRpInfo(String relTypeCode, int relId, int memberId) {
		switch (relTypeCode) {
		case "article":
			articleService.decreaseGoodRp(relId);
			break;
		case "comment":
			commentService.decreaseGoodRp(relId);
			break;
		}
		reactionPointRepository.deleteGoodRpInfo(relTypeCode, relId, memberId);
	}

	public void addIncreasingBadRpInfo(String relTypeCode, int relId, int memberId) {
		// 현재 게시물이 소속된 게시판 id를 가져옴

		switch (relTypeCode) {
		case "article":
			articleService.increaseBadRp(relId);
			break;
		case "comment":
			commentService.increaseBadRp(relId);
			break;
		}

		reactionPointRepository.addIncreasingBadRpInfo(relTypeCode, relId, memberId);
	}

	public void deleteBadRpInfo(String relTypeCode, int relId, int memberId) {
		switch (relTypeCode) {
		case "article":
			articleService.decreaseBadRp(relId);
			break;
		case "comment":
			commentService.decreaseBadRp(relId);
			break;
		}
		reactionPointRepository.deleteBadRpInfo(relTypeCode, relId, memberId);
	}

	public boolean isAlreadyAddGoodRp(int memberId, int commentId, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionPointRepository.getSumReactionPoint(memberId, relTypeCode, commentId);

		if (getPointTypeCodeByMemberId > 0) {
			return true;
		}

		return false;
	}

	public boolean isAlreadyAddBadRp(int memberId, int commentId, String relTypeCode) {
		int getPointTypeCodeByMemberId = reactionPointRepository.getSumReactionPoint(memberId, relTypeCode, commentId);

		if (getPointTypeCodeByMemberId < 0) {
			return true;
		}

		return false;
	}
}
