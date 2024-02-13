package com.example.demo.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ReactionPointRepository {

	@Insert("""
			INSERT INTO reactionPoint
			SET regDate = NOW(),
			updateDate =
			NOW(),
			boardId = #{boardId},
			articleId = #{articleId},
			memberId = #{memberId},
			pointTypeCode = 1
			""")
	public void addIncreasingGoodRpInfo(int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND pointTypeCode = 1
			""")
	public void deleteGoodRpInfo(int boardId, int articleId, int memberId);

	@Insert("""
			INSERT INTO reactionPoint
			SET regDate = NOW(),
			updateDate =
			NOW(),
			boardId = #{boardId},
			articleId = #{articleId},
			memberId = #{memberId},
			pointTypeCode = 2
			""")
	public void addIncreasingBadRpInfo(int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND pointTypeCode = 2
			""")
	public void deleteBadRpInfo(int boardId, int articleId, int memberId);

	@Select("""
			SELECT pointTypeCode
			FROM reactionPoint
			WHERE articleId = #{articleId} AND memberId = #{memberId};
			""")
	public Integer getRpInfoByMemberId(int articleId, int memberId);

}
