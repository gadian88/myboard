package com.myapp.member.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.myapp.member.domain.MemberVO;

public interface MemberMapper {
	
	//회원가입
    public void memberInsert(HashMap<String, Object> map)throws Exception;
    
    //회원정보
    public MemberVO readUser(String username);
    
    //회원권한
    public List<String> readAuthority(String username);

	public void createUser(MemberVO user);

	public void createAuthority(MemberVO user);

	public void deleteUser(String username);

	public void deleteAuthority(String username);
	
	//회원리스트
	public List<MemberVO> memberList() throws Exception;

	//회원정보 수정
	public void memberUpdate(HashMap<String, Object> map) throws Exception;
}
