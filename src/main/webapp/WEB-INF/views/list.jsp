<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div class="container mt-4">
        <h2 class="mb-4">BoardList</h2>
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Writer</th>
                    <th>Date</th>
                    <th>Hit</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.id}</td>
                        <td><a href="view/${board.id}" class="text-decoration-none">${board.title}</a></td>
                        <td>${board.writer}</td>
                        <td>${board.createdAt}</td>
                        <td>${board.views}</td>
                        <td>
                            <a href="edit/${board.id}" class="btn btn-sm btn-primary">Modify</a>
                            <a href="delete/${board.id}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="write" class="btn btn-success">NewWrite</a>
    </div>
    <%@ include file="footer.jsp" %>