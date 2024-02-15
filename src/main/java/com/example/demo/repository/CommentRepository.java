package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Comment;

@Mapper
public interface CommentRepository {

	@Insert("""

			""")
	public void writeComment(int memberId, int articleId, String body);

	@Select("""

			""")
	public int getLastInsertId();

	@Select("""
			
			""")
	public Comment getArticle(int id);

}
