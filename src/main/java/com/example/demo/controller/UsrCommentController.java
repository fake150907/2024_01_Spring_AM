package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ArticleService;
import com.example.demo.service.CommentService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.Board;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrCommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/comment/doCommentWrite")
	@ResponseBody
	public String doCommentWrite(Model model, HttpServletRequest req, int id, String body) {
		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isNullOrEmpty(body)) {
			return Ut.jsHistoryBack("F-2", "댓글내용을 입력해주세요");
		}

		ResultData<Integer> writeCommentRd = commentService.writecomment(rq.getLoginedMemberId(), id, body);
		Article article = articleService.getForPrintArticle(rq.getLoginedMemberId(), id);

		int CommentId = (int) writeCommentRd.getData1();

		Comment comment = commentService.getComment(CommentId);

		model.addAttribute("isLogined", rq.isLogined());
		model.addAttribute("article", article);
		model.addAttribute("comment", comment);

		return Ut.jsReplace(writeCommentRd.getResultCode(), writeCommentRd.getMsg(), "../article/detail?id=" + id);
	}

	@RequestMapping("/usr/comment/commentList")
	@ResponseBody
	public List<Comment> showCommentList(HttpServletRequest req, Model model, int articleId) {

		Rq rq = (Rq) req.getAttribute("rq");

		List<Comment> comments = commentService.getForPrintcomments(articleId);

		model.addAttribute("comments", comments);

		return comments;
	}

	// 로그인 체크 -> 유무 체크 -> 권한 체크 -> 삭제2
	@RequestMapping("/usr/comment/doCommentDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req, int articleId, int commentId) {
		Rq rq = (Rq) req.getAttribute("rq");

		Comment comment = commentService.getForPrintComment(rq.getLoginedMemberId(), commentId);

		if (comment == null) {
			return Ut.jsHistoryBack("F-1", "해당 댓글이 존재하지 않습니다");
		}

		ResultData loginedMemberCanDeleteRd = commentService.userCanDelete(rq.getLoginedMemberId(), comment);

		if (loginedMemberCanDeleteRd.isSuccess()) {
			commentService.deleteComment(commentId);
		}

		return Ut.jsReplace(loginedMemberCanDeleteRd.getResultCode(), loginedMemberCanDeleteRd.getMsg(),
				"../article/detail?id=" + articleId);
	}

	@RequestMapping("/usr/comment/modify")
	public String showCommentModify(HttpServletRequest req, Model model, int articleId, int commentId) {
		Rq rq = (Rq) req.getAttribute("rq");

		Comment comment = commentService.getForPrintComment(rq.getLoginedMemberId(), commentId);

		if (comment == null) {
			return Ut.jsHistoryBack("F-1", "해당 댓글은 존재하지 않습니다");
		}

		model.addAttribute("comment", comment);

		return "usr/comment/modify";
	}

	@RequestMapping("/usr/comment/doCommentModify")
	@ResponseBody
	public String doModify(HttpServletRequest req, int articleId, int commentId, String body) {
		Rq rq = (Rq) req.getAttribute("rq");

		Comment comment = commentService.getForPrintComment(rq.getLoginedMemberId(), commentId);

		if (comment == null) {
			return Ut.jsHistoryBack("F-1", "해당 댓글이 존재하지 않습니다");
		}

		ResultData loginedMemberCanModifyRd = commentService.userCanModify(rq.getLoginedMemberId(), comment);

		if (loginedMemberCanModifyRd.isSuccess()) {
			commentService.modifyComment(commentId, articleId, body);
		}

		return Ut.jsReplace(loginedMemberCanModifyRd.getResultCode(), loginedMemberCanModifyRd.getMsg(),
				"../article/detail?id=" + articleId);
	}
}
