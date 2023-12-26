package org.doit.ky.controller;

import java.util.List;
import java.util.Map;

import org.doit.ky.domain.BookDTO;
import org.doit.ky.mapper.BookMapper;
import org.doit.ky.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/book/*")
public class BookController {

   @Autowired
   private BookMapper bookMapper;

   @Autowired
   private BookRepository repo;


   /*//  목록보기 1
   @GetMapping(value="/list")
   public void list(Model model) {

      List<BookDTO> list = this.bookMapper.list();      
      model.addAttribute("list", list);

   }
    */
   // 목록보기 2
   @GetMapping(value="list")
   public void list(Model model, String word) {

      if (word == null || word.equals("")) {
         List<BookDTO> list = this.bookMapper.list();
         model.addAttribute("list", list);
      } else {
         List<Map<String,Object>> list = this.repo.search(word);
         model.addAttribute("list", list);
         model.addAttribute("word", word);
      }
 
   }

   //추가하기(폼)
   @GetMapping(value="add")
   public void add() {

   }

   /* //추가하기(처리) 1
   @PostMapping(value="/add")
   public String add(Model model, BookDTO dto) {

      this.bookMapper.add(dto);
      return "redirect:/book/list";
   }
   */
   
   //추가하기(처리) 2
   @PostMapping(value="add")
   public String add(Model model, BookDTO dto) {

      this.bookMapper.add(dto);
      this.repo.add(dto);
      
      return "redirect:/book/list";
   }
   

   //상세보기
   @GetMapping(value="view")
   public void view(Model model, String seq) {

      BookDTO dto = this.bookMapper.get(seq);      
      model.addAttribute("dto", dto);

   } 

}