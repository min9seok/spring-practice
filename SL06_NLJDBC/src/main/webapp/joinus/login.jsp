<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="login.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="header">
			<div class="top-wrapper">
				<h1 id="logo"><a href="/"><img src="../images/logo.png" alt="뉴렉처" /></a></h1>
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">학습가이드</a>
					</li>
					<li>
						<a href="" >과정선택</a>
					</li>
					<li>
						<a href="" >인기과정</a>
					</li>
				</ul>
				<form id="searchform" action="" method="get">
					<fieldset>
						<legend class="hidden">
							과정검색폼
						</legend>
						<label for="query">과정검색</label>
						<input type="text" name="query" />
						<input type="submit" class="button" value="검색" />
					</fieldset>
				</form>
				<h3 class="hidden">로그인메뉴</h3>
				<ul id="loginmenu" class="block_hlist">
					<li>
						<a href="../index.jsp">HOME</a>
					</li>
					<li>
						<a href="../joinus/login.jsp">로그인</a>
					</li>
					<li>
						<a href="../joinus/join.jsp">회원가입</a>
					</li>
				</ul>
				<h3 class="hidden">회원메뉴</h3>
				<ul id="membermenu" class="clear">
					<li>
						<a href=""><img src="../images/menuMyPage.png" alt="마이페이지" /></a>
					</li>
					<li>
						<a href="../customer/notice.jsp"><img src="../images/menuCustomer.png" alt="고객센터" /></a>
					</li>
				</ul>
			</div>
		</div>
		<div id="visual" class="joinus">
			<div class="top-wrapper">

			</div>
		</div>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>로그인</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>
							HOME
						</li>
						<li>
							회원가입
						</li>
						<li>
							로그인
						</li>
					</ul>
					<h3 class="hidden">회원가입 폼</h3>
					<div id="join-form" class="join-form margin-large" >						
						<form action="" method="post">                            <fieldset>
                                <legend class="hidden">로그인 폼</legend>
                                <h3><img src="images/txtTitle.png" /></h3>
                                <ul id="loginBox">
                                    <li><label for="uid">아이디</label><input name="UserName" class="text" /></li>
                                    <li><label for="pwd">비밀번호</label><input type="password" name="Password" class="text" /></li>
                                </ul>
                                <p><input type="submit" id="btnLogin" value="" /></p>
                                <ul id="loginOption">
                                    <li><span>아이디 또는 비밀번호를 분실하셨나요?</span><a href="/Member/FindID"><img alt="ID/PWD 찾기" src="images/btnFind.png" /></a></li>
                                    <li><span>아이디가 없으신 분은 회원가입을 해주세요.</span><a href="/Member/Agree"><img alt="회원가입" src="images/btnJoin.png" /></a></li>
                                </ul>
                            </fieldset>
						</form>
					</div>
					
				</div>
				<div id="navi">
					<h2>회원가입</h2>
					<h3 class="hidden">회원메뉴</h3>
					<ul id="navi-menu">
						<li>
							<a href="">로그인</a>
						</li>
						<li>
							<a href="" class="current">회원가입</a>
						</li>
						<li>
							<a href="">아이디찾기</a>
						</li>
						<li>
							<a href="">비밀번호 재발급</a>
						</li>						
					</ul>
                       
					<h3 id="fav-title">추천사이트</h3>
					<ul class="margin-small">
						<li>
							<a href="http://www.answeris.net"><img src="../images/answeris.png" alt="앤서이즈" /></a>
						</li>
						<li>
							<a href="http://www.microsoft.com"><img src="../images/microsoft.png" alt="마이크로소프트" /></a>
						</li>
						<li>
							<a href="http://www.w3c.org"><img src="../images/w3c.png" alt="W3C" /></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="top-wrapper">
				<h2><img src="../images/footerLogo.png" alt="뉴렉처"/></h2>
				<p>				
					<address id="ad">
						사업자등록번호 : 000-00-00000000 통신판매업신고 : 서울 0000-000 관리자 : 홍길동
						<br/>
						주소 : 서울시 000구 001동 000-0 00빌딩 0층 전화 : 02-000-0000 팩스 : 02-000-0000
					</address>
				</p>				
				<p>
					Copyright ⓒ newlecture.com 2012-2012 All Right Reserved. Contact master@newlecture.com for more information
				</p>
			</div>
		</div>
	</body>
</html>
