package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public ResultData<Integer> writecomment(int memberId, int articleId, String body) {
		commentRepository.writeComment(memberId, articleId, body);

		int id = commentRepository.getLastInsertId();

		return ResultData.from("S-1", Ut.f("%d번 댓글이 생성되었습니다", id), "id", id);
	}

	public Comment getComment(int id) {
		return commentRepository.getComment(id);
	}

}
