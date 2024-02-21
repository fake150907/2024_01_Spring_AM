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
			relId = #{relId},
			memberId = #{memberId},
			relTypeCode = #{relTypeCode},
			`point` = 1
			""")
	public void addIncreasingGoodRpInfo(String relTypeCode, int relId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE relId = #{relId}
			AND memberId = #{memberId}
			AND `point` = 1
			AND relTypeCode = #{relTypeCode}
			""")
	public void deleteGoodRpInfo(String relTypeCode, int relId, int memberId);

	@Insert("""
			INSERT INTO reactionPoint
			SET regDate = NOW(),
			updateDate =
			NOW(),
			relId = #{relId},
			memberId = #{memberId},
			relTypeCode = #{relTypeCode},
			`point` = -1
			""")
	public void addIncreasingBadRpInfo(String relTypeCode, int relId, int memberId);

	@Delete("""
			DELETE FROM reactionPoint
			WHERE relId = #{relId}
			AND memberId = #{memberId}
			AND `point` = -1
			AND relTypeCode = #{relTypeCode}
			""")
	public void deleteBadRpInfo(String relTypeCode, int relId, int memberId);

	@Select("""
			SELECT `point`
			FROM reactionPoint
			WHERE relId = #{relId} AND memberId = #{memberId};
			""")
	public Integer getRpInfoByMemberId(int relId, int memberId);

	@Select("""
			SELECT IFNULL(SUM(RP.point),0)
			FROM reactionPoint AS RP
			WHERE RP.relTypeCode = #{relTypeCode}
			AND RP.relId = #{relId}
			AND RP.memberId = #{memberId}
			""")
	public int getSumReactionPoint(int memberId, String relTypeCode, int relId);
}
