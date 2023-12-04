package org.doit.ky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.doit.ky.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	// 1. 단순 문자열 반환
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "해윙";
	}
// APPLICATION_JSON_UTF8_VALUE : 스프링5.2 부터 APPLICATION_JSON_VALUE 변경
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {	
		return new SampleVO(112,"스타","로드");
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {	
		return new SampleVO(1122,"스타","로드");
	}
	
	// 컬렉션 타입
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO(1,"FiRST1","LAST1"));
		list.add(new SampleVO(2,"FiRST2","LAST2"));
		list.add(new SampleVO(3,"FiRST3","LAST3"));
		list.add(new SampleVO(4,"FiRST4","LAST4"));
		
		return list;
	}
	
	@GetMapping(value = "/getList2")
	public List<SampleVO> getList2() {		
		
		return IntStream.range(1, 10).mapToObj(i-> new SampleVO(1,"FIRST"+i,"LAST"+i)).collect(Collectors.toList());
	}
	
	// map
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {		
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("first", new SampleVO(1,"FiRST1","LAST1"));
		map.put("second", new SampleVO(2,"FiRST2","LAST2"));
		return map;
	}

//	ResponseEntity 
//	REST 방식은 순수 문자열,JSON,XML 데이터 송,수신
//	정상 데이터, 비정상 데이터 구분필요
//	ResponseEntity = 응답 JSON + HTTP 상태코드 
//	예)
//  height 파라미터 값 150 기준 미만일때 502 상태 코드 + 값 전달
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {		
		ResponseEntity<SampleVO> result = null;
		SampleVO vo = new SampleVO(1, height+"", weight+"");
		if(height>=150) {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}
		return result;
	}
	
//	@PathVariable
//	REST : URL 내 최대한 많은 정보를 담으려고 한다.
	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat")String cat, @PathVariable("pid")String pid) {		
		return new String[] {"category: "+ cat, "productid: "+pid};
	}
	
	@PostMapping("/samplevo")
	public SampleVO convert(@RequestBody SampleVO vo) {
		log.info(vo);
		return vo;
	}
}
