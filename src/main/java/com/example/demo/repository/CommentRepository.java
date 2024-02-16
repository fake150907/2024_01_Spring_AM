package com.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Article;
import com.example.demo.vo.Comment;

@Mapper
public interface CommentRepository {

	@Insert("""
			INSERT INTO
			`comment` SET
			regDate = NOW(),
			updateDate = NOW(),
			memberId = #{memberId},
			articleId = #{articleId}, `body` = #{body}
			""")
	public void writeComment(int memberId, int articleId, String body);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
			FROM comment
			WHERE id = #{id}
			""")
	public Comment getComment(int id);

}
