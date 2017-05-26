package com.myapp.admin.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.board.domain.BoardConfigVO;
import com.myapp.board.service.BoardService;

//관리자 맵핑
@Controller
@RequestMapping("/admin")
@MapperScan(value = {"com.myapp.board.mapper"})
public class AdminController {
	
	@Autowired
    private BoardService boardService;
	
	
	//관리자 기본
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView index() throws Exception{
    	
    	
    	//모델겍체 생성
        ModelAndView modelandview = new ModelAndView("/admin/index");
    	
        //뷰파일 불려오기
        return modelandview;
    }
    
    //게시판 관리 - 게시판 생성
    @RequestMapping(value="/board_new", method=RequestMethod.GET)
    public ModelAndView writeForm() throws Exception{
    	
    	//모델겍체 생성
        ModelAndView modelandview = new ModelAndView("/admin/board/boardNew");
    	
        //뷰파일 불려오기
        return modelandview;
    }
    
   //게시판 관리 - 게시판 생성
    @RequestMapping(value="/board_new", method=RequestMethod.POST)
    public String write(@ModelAttribute("BoardConfigVO")BoardConfigVO boardconfig) throws Exception{
    	
    	//게시판 생성
    	boardService.boardConfigInsert(boardconfig);
    	
    	
        //뷰파일 불려오기
        return "redirect:/admin/board/";
    }
    
    
    //게시판 관리 - 게시판 목록
    @RequestMapping(value="/board", method=RequestMethod.GET)
    public ModelAndView board_list() throws Exception{
    	
    	//게시판 테이블 불려오기
    	List<BoardConfigVO>list = boardService.boardConfigList();
    	
    	//모델겍체 생성
        ModelAndView modelandview = new ModelAndView("/admin/board/boardList");
        modelandview.addObject("list",list);
    	
        //뷰파일 불려오기
        return modelandview;
    }
    
    //게시판 관리 - 게시판 설정
    @RequestMapping(value="/board/{board_table}", method=RequestMethod.GET)
    public ModelAndView board_view(@PathVariable("board_table") String board_table) throws Exception{
    	
    	//게시판 속성보기
        BoardConfigVO boardconfig = boardService.boardConfigView(board_table);
    	
    	//모델겍체 생성
        ModelAndView modelandview = new ModelAndView("/admin/board/boardView");
        modelandview.addObject("boardconfig",boardconfig);
    	
        //뷰파일 불려오기
        return modelandview;
    }
    
    
}