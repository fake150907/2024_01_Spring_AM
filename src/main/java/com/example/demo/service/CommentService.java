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

	public ResultData userCanDelete(int loginedMemberId, Comment comment) {
		if (comment.getMemberId() != loginedMemberId) {
			return ResultData.from("F-2", "해당 댓글에 대한 삭제 권한이 없습니다");
		}

		return ResultData.from("S-1", Ut.f("해당 댓글이 삭제 되었습니다", comment.getId()));
	}

	public void deleteComment(int commentId) {
		commentRepository.deleteComment(commentId);

	}

}
