package com.kwm.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRepository {

//	public Member getMember(@Param("loginId") String loginId);
//	
//	public List<Member> getMembers();
//	
//	public void insertMember(@Param("loginId")String loginId, @Param("loginPw")String loginPw,@Param("name")String name,
//			@Param("nickname")String nickname, @Param("cellphoneNo")String cellphoneNo, @Param("email")String email);
//	
//	public void modifyMember(@Param("loginPw")String loginPw,@Param("name")String name);
//
//	public void deleteMember(@Param("loginId")String loginId);
//	
//	public int getLastInsertId();
	
	@Insert("""
			
			INSERT INTO `member`
			SET regDate = NOW(),
			updateDate = NOW(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name},
			nickname = #{nickname},
			cellphoneNo = #{cellphoneNo},
			email = #{email}""")

	void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
			@Param("nickname") String nickname, @Param("cellphoneNo") String cellphoneNo, @Param("email") String email);

}
