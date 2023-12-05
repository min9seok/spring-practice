<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content">
	<h2>공지사항</h2>
	<h3 class="hidden">방문페이지위치</h3>
	<ul id="breadscrumb" class="block_hlist">
		<li>HOME</li>
		<li>고객센터</li>
		<li>공지사항수정</li>
	</ul>
<%-- 	<form method="post" enctype="multipart/form-data" action="/customer/noticeEdit.htm?${_csrf.parameterName}=${_csrf.token}"> --%>
	<form action="" method="post" enctype="multipart/form-data">
		<div id="notice-article-detail" class="article-detail margin-large">
			<dl class="article-detail-row">
				<dt class="article-detail-title">제목</dt>
				<dd class="article-detail-data">
					&nbsp;<input name="title" value="${vo.title }" />
				</dd>
			</dl>
			<dl class="article-detail-row half-row">
				<dt class="article-detail-title">작성자</dt>
				<dd class="article-detail-data half-data">${vo.writer }</dd>
			</dl>
			<dl class="article-detail-row half-row">
				<dt class="article-detail-title">조회수</dt>
				<dd class="article-detail-data half-data">${vo.hit }</dd>
			</dl>
			<dl class="article-detail-row">
				<dt class="article-detail-title">첨부파일</dt>
				<dd class="article-detail-data">
					&nbsp;<input type="file" id="txtFile" name="file" /> <input
						readonly type="text" name="o_file" value="${vo.filesrc }" />
				</dd>
			</dl>

			<div class="article-content">
				<textarea id="txtContent" class="txtContent" name="content">${vo.content }</textarea>
			</div>
		</div>
		<p class="article-comment margin-small">
			<button class="btn-save button" type="submit">수정</button>
			<!-- 						<a class="btn-save button" href="noticeEditProc.htm">수정</a>						 -->
			<a class="btn-cancel button" href="noticeDetail.htm?seq=${vo.seq }">취소</a>
		</p>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
<%-- 		<input type="hidden" name="seq" value="${ param.seq }" /> --%>
	</form>
</div>

