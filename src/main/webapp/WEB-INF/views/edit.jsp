<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mt-4">
  <h2 class="mb-4">게시글 수정</h2>
  <form action="/edit" method="post">
    <input type="hidden" name="id" value="${board.id}">
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" class="form-control" id="title" name="title" value="${board.title}" required>
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용</label>
      <textarea class="form-control" id="content" name="content" rows="5" required>${board.content}</textarea>
    </div>
    <button type="submit" class="btn btn-primary">저장</button>
    <a href="/list" class="btn btn-secondary">취소</a>
  </form>
</div>
<%@ include file="footer.jsp" %>