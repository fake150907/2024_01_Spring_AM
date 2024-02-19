package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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

	@Select("""
			SELECT C.*, M.nickname AS extra__writer
			FROM `comment` AS C
			INNER JOIN `member` AS M
			ON C.memberId = M.id
			WHERE articleId = 1
			ORDER BY C.id DESC;
			""")
	public List<Comment> getForPrintcomments(int articleId);

	@Delete("DELETE FROM `comment` WHERE id = #{commentId}")
	public void deleteComment(int commentId);

}
