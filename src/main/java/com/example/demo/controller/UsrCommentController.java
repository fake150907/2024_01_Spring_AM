package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.CommentService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrCommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/usr/comment/commentWrite")
	@ResponseBody
	public String commentWrite(HttpServletRequest req, int articleId, String body) {
		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isNullOrEmpty(body)) {
			return Ut.jsHistoryBack("F-2", "댓글내용을 입력해주세요");
		}

		ResultData<Integer> writeCommentRd = commentService.writecomment(rq.getLoginedMemberId(), articleId, body);

		int id = (int) writeCommentRd.getData1();

		Comment comment = commentService.getcomment(id);

		return Ut.jsReplace(writeCommentRd.getResultCode(), writeCommentRd.getMsg(), "../article/detail?id=" + id);
	}
}
