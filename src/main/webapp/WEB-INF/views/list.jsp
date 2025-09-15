<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2 class="mb-3">BoardList</h2>

    <form method="get" action="<c:url value='/list'/>" class="row g-2 mb-3">
        <div class="col-auto">
            <select name="type" class="form-select form-select-sm">
                <option value="titleOrContent" <c:if test="${type=='titleOrContent'}">selected</c:if>>제목+내용</option>
                <option value="title"          <c:if test="${type=='title'}">selected</c:if>>제목</option>
                <option value="content"        <c:if test="${type=='content'}">selected</c:if>>내용</option>
                <option value="writer"         <c:if test="${type=='writer'}">selected</c:if>>작성자</option>
            </select>
        </div>
        <div class="col-auto">
            <input type="text" name="q" value="${fn:escapeXml(q)}"
                   class="form-control form-control-sm" placeholder="검색어">
        </div>
        <div class="col-auto">
            <select name="size" class="form-select form-select-sm">
                <option value="10" <c:if test="${pagination.size == 10}">selected</c:if>>10개</option>
                <option value="20" <c:if test="${pagination.size == 20}">selected</c:if>>20개</option>
                <option value="30" <c:if test="${pagination.size == 30}">selected</c:if>>30개</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-sm btn-primary">검색</button>
        </div>
    </form>

    <table class="table table-striped align-middle">
        <thead class="table-dark">
        <tr>
            <th>#</th><th>Title</th><th>Writer</th><th>Date</th><th>Hit</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.id}</td>
                <td>
                    <a href="<c:url value='/view/${board.id}'/>" class="text-decoration-none">
                            ${fn:escapeXml(board.title)}
                    </a>
                </td>
                <td>${fn:escapeXml(board.writer)}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty board.createdAt}">
                            <c:out value="${board.createdAt}"/>
                        </c:when>
                        <c:otherwise>-</c:otherwise>
                    </c:choose>
                </td>
                <td>${board.views}</td>
                <td>
                    <a href="<c:url value='/edit/${board.id}'/>" class="btn btn-sm btn-primary">Modify</a>
                    <a href="<c:url value='/delete/${board.id}'/>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty boardList}">
            <tr><td colspan="6" class="text-center py-5">데이터가 없습니다.</td></tr>
        </c:if>
        </tbody>
    </table>

    <%-- 페이징 --%>
    <div class="d-flex justify-content-between">
        <a href="<c:url value='/write'/>" class="btn btn-success">NewWrite</a>

        <nav aria-label="pagination">
            <ul class="pagination pagination-sm mb-0">
                <li class="page-item ${pagination.hasPrev ? '' : 'disabled'}">
                    <a class="page-link"
                       href="<c:url value='/list'>
                             <c:param name='page' value='${pagination.prevPage}'/>
                             <c:param name='size' value='${pagination.size}'/>
                             <c:param name='type' value='${type}'/>
                             <c:param name='q'    value='${q}'/>
                           </c:url>">«</a>
                </li>

                <c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
                    <li class="page-item ${p == pagination.page ? 'active' : ''}">
                        <a class="page-link"
                           href="<c:url value='/list'>
                                 <c:param name='page' value='${p}'/>
                                 <c:param name='size' value='${pagination.size}'/>
                                 <c:param name='type' value='${type}'/>
                                 <c:param name='q'    value='${q}'/>
                               </c:url>">${p}</a>
                    </li>
                </c:forEach>

                <li class="page-item ${pagination.hasNext ? '' : 'disabled'}">
                    <a class="page-link"
                       href="<c:url value='/list'>
                             <c:param name='page' value='${pagination.nextPage}'/>
                             <c:param name='size' value='${pagination.size}'/>
                             <c:param name='type' value='${type}'/>
                             <c:param name='q'    value='${q}'/>
                           </c:url>">»</a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<%@ include file="footer.jsp" %>
