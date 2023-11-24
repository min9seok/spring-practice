<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<div>
 <xmp class="code">
  N-tier 방식
  3-tier 방식           
웹 프로젝트 3-tier 방식
1) 화면 계층 - Presentation Tier
2) 비지니스(로직) 계층  Business Tier
3) 데이터 계층 == 영속 계층 Persistence Tier
-- 스프링 MVC 패턴 개발 --
-- 패키지 --
config : 설정 관련
domain : VO, DTO 클래스
persistence : DAO, MyBatis 인터페이스, 클래스 (mapper)
controller
service
exception
aop
util
security
--------------------------------------
       CREATE TABLE tbl_board
    (
      bno number(10)
      , title varchar2(200) not null
      , content varchar2(2000) not null
      , writer varchar2(50) not null
      , regdate date default sysdate
      , updatedate date default sysdate
    );
    
    alter table tbl_board add constraint pk_tblboard_bno primary key(bno);
    
     CREATE SEQUENCE seq_board;
--------------------------------------  
1. DB 환경 확인 + MyBatis
 pom.xml  의존모듈 확인
 root-content.xml DB 연동 모든 스프링 빈 객체 생성 + 등록 + 연결
  - 스프링, MyBatis 에서 DB연동할 때 DataSource 객체 사용 
2. web.xml
3. org.doit.ky.domain 패키지 추가 > BoardVO 추가
4. 게시글 목록 
 org.doit.ky.mapper 패키지 > BoardMapper 인터페이스 추가
 resources > org.doit.ky.mapper 폴더 > BoardMapper.xml 추가
5. Homecontroller 복사 > BoardController 생성
6. home.jsp 복사 > home_original.jsp 생성 
7. org.doit.ky.service 패키지 > BoardService 인터페이스 추가 > BoardServiceImpl 클래스 추가
8. servlet-context.xml : <context:component-scan base-package="org.doit.ky" />
base-packge 패키지 및 하위 패키지를 찾아 component을 자동 스캔해서 스프링빈 객체로 등록 + 연결
@Component
@Controller
@Service
@Repository
9. servlet-context.xml : ViewResolver 등록
10. webapp > board > list 파일 생성 ( 요청 URL 사용)
11. 글쓰기 페이지 응답 > register.jsp 추가 , Controller 추가 코딩   
12. 글쓰기 작업 > BoardMapper 추가 코딩  

 
 </xmp>  
</div>
</body>
</html>
