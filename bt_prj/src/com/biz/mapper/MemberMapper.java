package com.biz.mapper;

import org.apache.ibatis.annotations.Select;

import com.biz.member.MemberVO;

public interface MemberMapper {

	
	 @Select("SELECT user_gubun as userGubun FROM member WHERE user_id = #{value}")
	 MemberVO selectMember(String userId);
	
}
