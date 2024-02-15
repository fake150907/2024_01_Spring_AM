package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.Ut;
import com.example.demo.vo.Article;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrCommentController {
	
	@RequestMapping("/usr/comment/commentWrite")
	public String commentWrite(int id, int memberId) {
		
		return "/usr/comment/write";
	}
	/*
	 * @RequestMapping("/usr/article/write") public String
	 * showJoin(HttpServletRequest req) {
	 * 
	 * return "usr/article/write"; }
	 * 
	 * @RequestMapping("/usr/article/doWrite")
	 * 
	 * @ResponseBody public String doWrite(HttpServletRequest req, String title,
	 * String body) {
	 * 
	 * Rq rq = (Rq) req.getAttribute("rq");
	 * 
	 * if (Ut.isNullOrEmpty(title)) { return Ut.jsHistoryBack("F-1", "제목을 입력해주세요");
	 * } if (Ut.isNullOrEmpty(body)) { return Ut.jsHistoryBack("F-2", "내용을 입력해주세요");
	 * }
	 * 
	 * ResultData<Integer> writeArticleRd =
	 * articleService.writeArticle(rq.getLoginedMemberId(), title, body);
	 * 
	 * int id = (int) writeArticleRd.getData1();
	 * 
	 * Article article = articleService.getArticle(id);
	 * 
	 * return Ut.jsReplace(writeArticleRd.getResultCode(), writeArticleRd.getMsg(),
	 * "../article/detail?id=" + id);
	 * 
	 * }
	 */
}
