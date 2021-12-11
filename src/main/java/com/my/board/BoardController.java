package com.my.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
@Autowired
BoardDAO boardDAO;

@RequestMapping(value = "/board/list", method = 
RequestMethod.GET)
public String boardlist(Model model) {
	model.addAttribute("list", boardDAO.getBoardList());
	return "covidList";
}

@RequestMapping(value = "/board/add", method = 
RequestMethod.GET)
public String addPost() {
	return "addpostform";
}

@RequestMapping(value = "/board/addok", method = 
RequestMethod.POST)
public String addPostOk(BoardVO vo) {
	int i = boardDAO.insertBoard(vo);
	if(i == 0)
		System.out.println("data add fail");
	else
		System.out.println("data add success");
	return "redirect:list";
}

@RequestMapping(value = "/addok", method = 
RequestMethod.POST)
public String addPostok(BoardVO vo) {
	int i = boardDAO.insertBoard(vo);
	if(i == 0)
		System.out.println("data add fail");
	else
		System.out.println("data add success");
	return "redirect:list";
}

@RequestMapping(value = "/board/editform/{id}",
method = RequestMethod.GET)
public String editPost(@PathVariable("id") int id, Model model) {
	BoardVO boardVO = boardDAO.getBoard(id);
	model.addAttribute("boardVO", boardVO);
	return "editform";
}

//수정데이터처리
@RequestMapping(value = "/board/editok", method = 
RequestMethod.POST)
public String editPostOk(BoardVO vo) {
	int i = boardDAO.updateBoard(vo);
	if(i == 0)
		System.out.println("data update fail");
	else
		System.out.println("data update success");
	return "redirect:list";
}

@RequestMapping(value = "/editok", method = 
RequestMethod.POST)
public String editPostok(BoardVO vo) {
	int i = boardDAO.updateBoard(vo);
	if(i == 0)
		System.out.println("data update fail");
	else
		System.out.println("data update success");
	return "redirect:list";
}

//삭제처리?
//@RequestMapping(value = "/board/deleteform/{id}", 
//method = RequestMethod.GET)
//public String deletePost(@PathVariable("id") int id, Model model) {
//	BoardVO boardVO = boardDAO.getBoard(id);
//	model.addAttribute("boardVO", boardVO);
//	return "deleteform";
//}

@RequestMapping(value = "/board/deleteok/{id}", 
method = RequestMethod.GET)
public String deletepost(@PathVariable("id") int seq) {
	int i = boardDAO.deleteBoard(seq);
	if(i == 0)
		System.out.println("data delete fail");
	else
		System.out.println("data delete success");
	return "redirect:../list";
}
	
}
