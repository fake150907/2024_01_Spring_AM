package com.example.demo.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReactionPointRepository {

	@Insert("""
			INSERT INTO reactionPoint
			SET regDate = NOW(),
			updateDate =
			NOW(),
			boardId = #{boardId},
			articleId = #{articleId},
			memberId = #{memberId},
			relTypeCode = #{relTypeCode},
			`point` = 1
			""")
	public void addIncreasingGoodRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND `point` = 1
			AND relTypeCode = #{relTypeCode}
			""")
	public void deleteGoodRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Insert("""
			INSERT INTO reactionPoint
			SET regDate = NOW(),
			updateDate =
			NOW(),
			boardId = #{boardId},
			articleId = #{articleId},
			memberId = #{memberId},
			relTypeCode = #{relTypeCode},
			`point` = -1
			""")
	public void addIncreasingBadRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND `point` = -1
			AND relTypeCode = #{relTypeCode}
			""")
	public void deleteBadRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Select("""
			SELECT `point`
			FROM reactionPoint
			WHERE articleId = #{articleId} AND memberId = #{memberId};
			""")
	public Integer getRpInfoByMemberId(int articleId, int memberId);

	@Select("""
			SELECT IFNULL(SUM(RP.point),0)
			FROM reactionPoint AS RP
			WHERE RP.relTypeCode = #{relTypeCode}
			AND RP.id = #{commentId}
			AND RP.memberId = #{memberId}
			""")
	public int getSumReactionPoint(int memberId, String relTypeCode, int commentId);
}
