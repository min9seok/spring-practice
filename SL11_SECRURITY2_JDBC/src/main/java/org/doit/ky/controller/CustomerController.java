package org.doit.ky.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ky.domain.NoticeVO;
import org.doit.ky.mapper.NoticeMapper;
import org.doit.ky.service.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private NoticeMapper dao;

	@Autowired
	private MemberShipService service;
	
	// ?dir=customer/upload&file=${ notice.filesrc  }
    @RequestMapping( "download.htm")
    public void download(
          @RequestParam("dir")   String d
          , @RequestParam("file") String fname
          , HttpServletResponse response
          , HttpServletRequest request
          ) throws Exception{ 

       response.setHeader("Content-Disposition","attachment;filename="+ new String(fname.getBytes(), "ISO8859_1"));      

       String fullPath = request.getServletContext().getRealPath(   d + "/" + fname);

       FileInputStream fin = new FileInputStream(fullPath);
       ServletOutputStream sout = response.getOutputStream();  
       byte[] buf = new byte[1024];
       int size = 0;
       while((size = fin.read(buf, 0, 1024)) != -1) {
          sout.write(buf, 0, size); 
       }
       fin.close();
       sout.close();

    }
	
	@GetMapping("noticeDel.htm")
	public String noticeDel(@RequestParam("seq") String seq, @RequestParam("filesrc") String delFilesrc, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
		File delFile = new File(uploadRealPath,delFilesrc);
		if(delFile.exists())delFile.delete();
		
		int count = this.dao.delete(seq);
		if(count == 1) {
			return "redirect:notice.htm";	
		}else {
			return "redirect:noticeDetail.htm?seq="+seq+"&error";
		}		
	} 

	@PostMapping("noticeEdit.htm")
	public String noticeEdit(NoticeVO vo, @RequestParam("o_file")String oFilesrc, HttpServletRequest request) throws ClassNotFoundException, SQLException, IllegalStateException, IOException {

		CommonsMultipartFile multipartFile = vo.getFile();
		String uploadRealPath = null;
//		if (!multipartFile.isEmpty()) {
		if (multipartFile != null) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");

			System.out.println("uploadRealPath : " + uploadRealPath);
//			File delFile = new File(uploadRealPath,oFilesrc);
//			if(delFile.exists()) {
//				delFile.delete();
//			}
			String originalFilename =  multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);			
			File dest = new File(uploadRealPath,filesystemName);
			multipartFile.transferTo(dest);
			vo.setFilesrc(filesystemName);
		}else {
			vo.setFilesrc(oFilesrc);
		}
		int count = this.dao.update(vo);
		if(count == 1) {
			return "redirect:noticeDetail.htm?seq="+vo.getSeq();	
		}else {
			return "redirect:notice.htm";
		}		
	}

	@GetMapping("noticeEdit.htm")
	public String noticeEdit(@RequestParam("seq") String seq, Model model  ) throws ClassNotFoundException, SQLException {

		NoticeVO vo = this.dao.getNotice(seq);
		model.addAttribute("vo",vo);
		return "customer.noticeEdit";
	}
	private String getFileNameCheck(String uploadRealPath, String originalFilename) {
	      int index = 1;      
	      while( true ) {         
	         File f = new File(uploadRealPath, originalFilename);         
	         if( !f.exists() ) return originalFilename;         
	         // upload 폴더에 originalFilename 파일이 존재한다는 의미         a.txt (4자리)
	         String fileName = originalFilename.substring(0, originalFilename.length() - 4 );  //   a
	         String ext =  originalFilename.substring(originalFilename.length() - 4 );  // .txt
	         // asdfasf-3.txt
	         originalFilename = fileName+"-"+(index)+ext;

	         index++;
	      } // while 
	   }
	@PostMapping("noticeReg.htm")
	public String noticeReg(NoticeVO vo, HttpServletRequest request) throws ClassNotFoundException, SQLException, IllegalStateException, IOException {
		CommonsMultipartFile multipartFile  =  vo.getFile();
		String uploadRealPath = null;
//		if (!multipartFile.isEmpty()) {
		if (multipartFile != null) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
//			File saveDir = new File(uploadRealPath);
//			if( !saveDir.exists()) saveDir.mkdirs();
			System.out.println("uploadRealPath : " + uploadRealPath);
			String originalFilename =  multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);			
			File dest = new File(uploadRealPath,filesystemName);
			multipartFile.transferTo(dest);
			vo.setFilesrc(filesystemName);
		}
		
		vo.setWriter("kmys");

		int count = this.dao.insert(vo);
//		this.dao.insertAndPointUpOfMember(vo, "kmys");
//		this.service.insertAndPointUpOfMember(vo, "kmys");
//		int count = 1;
		if(count == 1) {
			return "redirect:notice.htm";	
		}else {
			return "noticeReg.jsp?error";
		}

	}

	@GetMapping("noticeReg.htm")
	public String noticeReg() throws ClassNotFoundException, SQLException {

		return "customer.noticeReg";		
	}

	@GetMapping("noticeDetail.htm")
	public String noticeDetail(@RequestParam("seq") String seq, Model model  ) throws ClassNotFoundException, SQLException {
		this.dao.hithp(seq);
		NoticeVO vo = this.dao.getNotice(seq);
		model.addAttribute("vo",vo);
		return "customer.noticeDetail";
	}
	@GetMapping("notice.htm")
	public String notice(@RequestParam(value = "page", defaultValue = "1") int page
			, @RequestParam(value = "field", defaultValue = "title" ) String field
			, @RequestParam(value = "query" ,defaultValue = "") String query, Model model ) throws ClassNotFoundException, SQLException {
		
		List<NoticeVO> list = this.dao.getNotices(page, field, query);
		model.addAttribute("list",list);				
		return "customer.notice";
	}
	//	@GetMapping("notice.htm")
	//	public ModelAndView notice(Locale locale, Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
	//		ModelAndView mv = new ModelAndView("notice.jsp");
	//		
	//		String ppage = request.getParameter("page");
	//		String pfield = request.getParameter("field");
	//		String pquery = request.getParameter("query");
	//		
	//		int page = 1;
	//		String field = "title";
	//		String query = "";
	//		
	//		if(ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage);}
	//		if(pfield != null && !pfield.equals("")) { field = pfield ;}
	//		if(pquery != null && !pquery.equals("")) { query = pquery ;}
	//		
	//		List<NoticeVO> list = this.dao.getNotices(page, field, query);
	//		mv.addObject("list",list);			
	//		return mv;
	//	}


}
