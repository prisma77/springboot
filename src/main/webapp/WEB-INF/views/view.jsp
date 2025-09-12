<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mt-4">
  <h2 class="mb-4">게시글 상세보기</h2>
  <div class="card">
    <div class="card-header bg-dark text-white">
      제목: ${board.title}
    </div>
    <div class="card-body">
      <h5 class="card-title">작성자: ${board.writer}</h5>
      <p class="card-text">${board.content}</p>
      <p class="text-muted">작성일: ${board.createdAt} | 조회수: ${board.views}</p>
      <a href="/list" class="btn btn-secondary">목록으로</a>
      <a href="/edit/${board.id}" class="btn btn-primary">수정</a>
      <a href="/delete/${board.id}" class="btn btn-danger">삭제</a>
    </div>
  </div>
</div>
<%@ include file="footer.jsp" %>

