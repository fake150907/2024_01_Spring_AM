package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public ResultData<Integer> writecomment(int memberId, int articleId, String body) {
		commentRepository.writeComment(memberId, articleId, body);

		int id = commentRepository.getLastInsertId();

		return ResultData.from("S-1", "댓글이 생성되었습니다", "id", id);
	}

	public Comment getComment(int id) {
		return commentRepository.getComment(id);
	}

	public List<Comment> getForPrintcomments(int articleId) {
		
		return commentRepository.getForPrintcomments(articleId);
	}

	public void deleteComment(int commentId) {
		commentRepository.deleteComment(commentId);

	}

	public void modifyComment(int commentId, int articleId, String body) {
		commentRepository.modifyComment(commentId, articleId, body);
	}

	public Comment getForPrintComment(int loginedMemberId, int commentId) {
		Comment comment = commentRepository.getForPrintComment(commentId);

		controlForPrintData(loginedMemberId, comment);

		return comment;
	}

	private void controlForPrintData(int loginedMemberId, Comment comment) {
		if (comment == null) {
			return;
		}
		ResultData userCanModifyRd = userCanModify(loginedMemberId, comment);
		comment.setUserCanModify(userCanModifyRd.isSuccess());

		ResultData userCanDeleteRd = userCanDelete(loginedMemberId, comment);
		comment.setUserCanDelete(userCanDeleteRd.isSuccess());
	}

	public ResultData userCanDelete(int loginedMemberId, Comment comment) {

		if (comment.getMemberId() != loginedMemberId) {
			return ResultData.from("F-2", Ut.f("%d번 댓글에 대한 삭제 권한이 없습니다", comment.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 댓글이 삭제 되었습니다", comment.getId()));
	}

	public ResultData userCanModify(int loginedMemberId, Comment comment) {

		if (comment.getMemberId() != loginedMemberId) {
			return ResultData.from("F-2", Ut.f("%d번 댓글에 대한 수정 권한이 없습니다", comment.getId()));
		}

		return ResultData.from("S-1", Ut.f("%d번 댓글이 수정했습니다", comment.getId()));
	}
	
	public void increaseGoodRp(int id) {
		commentRepository.increaseGoodRp(id);
	}

	public void increaseBadRp(int id) {
		commentRepository.increaseBadRp(id);
	}

	public void decreaseGoodRp(int id) {
		commentRepository.decreaseGoodRp(id);
	}

	public void decreaseBadRp(int id) {
		commentRepository.decreaseBadRp(id);
	}

	public int getGoodRpCount(int id) {

		return commentRepository.getGoodRpCount(id);
	}

	public int getBadRpCount(int id) {
		return commentRepository.getBadRqCount(id);
	}

	public int getBoardIdByArticle(int commentId) {
		return commentRepository.getBoardIdByComment(commentId);
	}

}
