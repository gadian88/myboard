package com.myapp.board.domain;
 
import java.util.Date;
 
public class BoardVO {
 
    private int bno; //글번호
    private String subject; //제목
    private String content; //글내용
    private String writer; //글쓴이
    private String username; //회원아이디
    private Date reg_date; //글쓴일
    
   
    
    private int hit;
 


	public int getBno() {
        return bno;
    }
 
    public void setBno(int bno) {
        this.bno = bno;
    }
 
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public String getWriter() {
        return writer;
    }
 
    public void setWriter(String writer) {
        this.writer = writer;
    }
 
    public Date getReg_date() {
        return reg_date;
    }
 
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
 
    public int getHit() {
        return hit;
    }
 
    public void setHit(int hit) {
        this.hit = hit;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
 
}