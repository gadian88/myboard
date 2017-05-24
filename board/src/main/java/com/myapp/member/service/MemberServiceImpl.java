package com.myapp.member.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapp.member.domain.MemberVO;
import com.myapp.member.mapper.MemberMapper;
 

 
@Service
@MapperScan(value = {"com.myapp.member.mapper"})
public class MemberServiceImpl implements MemberService {
     
     @Autowired MemberMapper memberMapper;
     private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
     
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	  //System.out.println(username);
    	  MemberVO member = readUser(username);
    	  //System.out.println(member.toString());
    	  member.setAuthorities(getAuthorities(username));
          
          return member;
     }
     
     @Override
     public List<GrantedAuthority> getAuthorities(String username) {
    	 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    	 List<String> rolelist = memberMapper.readAuthority(username);
    	 for (String string : rolelist) {
    		 authorities.add(new SimpleGrantedAuthority(string));
    	 }
    	 
    	 //List<GrantedAuthority> authorities = memberMapper.readAuthority(username);
    	  //System.out.println(username);
    	  
          return authorities;
     }

	@Override
	public MemberVO readUser(String username) {
		// TODO Auto-generated method stub
//		MemberVO member = memberMapper.readUser(username);
//		member.setAuthorities(memberMapper.readAuthority(username));
//		return member;
		// TODO Auto-generated method stub
		MemberVO member = memberMapper.readUser(username);
		List<String> rolelist = memberMapper.readAuthority(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String string : rolelist) {
			authorities.add(new SimpleGrantedAuthority(string));
		}
		//member.setAuthorities(memberMapper.readAuthority(username));
		member.setAuthorities(authorities);
		return member;
	}

	@Override
	public void createUser(MemberVO user) {
		// TODO Auto-generated method stub
		String rawPassword = user.getPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        user.setPassword(encodedPassword);
        memberMapper.createUser(user);
        memberMapper.createAuthority(user);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		memberMapper.deleteUser(username);
		memberMapper.deleteAuthority(username);
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return this.passwordEncoder;
	}
}