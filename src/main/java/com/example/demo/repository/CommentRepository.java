package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
			WHERE articleId = #{articleId}
			ORDER BY C.id DESC;
			""")
	public List<Comment> getForPrintcomments(int articleId);

	@Delete("DELETE FROM `comment` WHERE id = #{commentId}")
	public void deleteComment(int commentId);

	@Update("""
			UPDATE `comment`
			SET `body` = #{body},
			updateDate = NOW()
			WHERE id = #{commentId}
			AND articleId = #{articleId}
			""")
	public void modifyComment(int commentId, int articleId, String body);

	@Select("""
			SELECT C.*, M.nickname AS extra__writer
			FROM `comment` AS C
			INNER JOIN `member` AS M
			ON C.memberId = M.id
			WHERE C.id = #{commentId}
			""")
	public Comment getForPrintComment(int commentId);

	@Update("""
			UPDATE comment
			SET goodReactionPoint = goodReactionPoint + 1
			WHERE id = #{id}
			""")
	public void increaseGoodRp(int id);

	@Update("""
			UPDATE comment
			SET badReactionPoint = badReactionPoint + 1
			WHERE id = #{id}
			""")
	public void increaseBadRp(int id);

	@Update("""
			UPDATE comment
			SET goodReactionPoint = goodReactionPoint - 1
			WHERE id = #{id}
			""")
	public void decreaseGoodRp(int id);

	@Update("""
			UPDATE comment
			SET badReactionPoint = badReactionPoint - 1
			WHERE id = #{id}
			""")
	public void decreaseBadRp(int id);

	@Select("""
			SELECT goodReactionPoint
			FROM comment
			WHERE id = #{id}
			""")
	public int getGoodRpCount(int id);

	@Select("""
			SELECT badReactionPoint
			FROM comment
			WHERE id = #{id}
			""")
	public int getBadRqCount(int id);

	@Select("""
			SELECT A.boardId
			FROM comment AS A
			WHERE id = #{commentId}
			""")
	public int getBoardIdByComment(int commentId);

}
