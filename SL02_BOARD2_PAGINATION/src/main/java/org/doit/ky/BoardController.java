package org.doit.ky;

import org.doit.ky.domain.BoardVO;
import org.doit.ky.domain.Criteria;
import org.doit.ky.domain.PageDTO;
import org.doit.ky.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	
//	@RequestMapping("/list")
//	public void list(Model model) {
//		log.info("> /board/list");
//			
//		model.addAttribute("list", this.boardService.getList() );
//	}
	
	@RequestMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info("> /board/list");			
		model.addAttribute("list", this.boardService.getListWithPaging(criteria) );
		int total = this.boardService.getTotal(criteria);
		model.addAttribute("pageMaker",new PageDTO(criteria, total));
		
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("> /board/register");
		
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("> /board/register");
		this.boardService.insert(board);
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addFlashAttribute("register", "register");
		return "redirect:/board/list"; // 스프링 리다이렉트 코딩
	}
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("> /board/view or modify");
		model.addAttribute("board",this.boardService.get(bno));
	}
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("> /board/modify");
		if(this.boardService.modify(board)) {			
			rttr.addFlashAttribute("result", board.getBno());	
			rttr.addFlashAttribute("modify", "modify");
		}
		return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("> /board/remove");
		this.boardService.remove(bno);
		rttr.addFlashAttribute("result", bno);
		rttr.addFlashAttribute("remove", "remove");
		return "redirect:/board/list"; // 스프링 리다이렉트 코딩
	}
	
}
