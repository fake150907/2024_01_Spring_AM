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
			pointTypeCode = 1
			""")
	public void addIncreasingGoodRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND pointTypeCode = 1
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
			pointTypeCode = 2
			""")
	public void addIncreasingBadRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE boardId = #{boardId}
			AND articleId = #{articleId}
			AND memberId = #{memberId}
			AND pointTypeCode = 2
			AND relTypeCode = #{relTypeCode}
			""")
	public void deleteBadRpInfo(String relTypeCode, int boardId, int articleId, int memberId);

	@Select("""
			SELECT pointTypeCode
			FROM reactionPoint
			WHERE articleId = #{articleId} AND memberId = #{memberId};
			""")
	public Integer getRpInfoByMemberId(int articleId, int memberId);
}
