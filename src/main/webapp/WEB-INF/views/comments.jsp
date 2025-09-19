<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Comments</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
    .edit-input {
      background-color: pink;
      width: 200%;
      /* 현재 너비보다 2배 크게 설정 */
    }
  </style>
</head>

<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Comments</h1>

  <!-- Add Comment Form -->
  <div class="card p-4 shadow-sm">
    <form id="add-comment-form">
      <div class="mb-3">
        <input type="text" id="comment-content" class="form-control" placeholder="Enter your comment"
               required>
      </div>
      <button type="submit" class="btn btn-primary w-100">Add Comment</button>
    </form>
  </div>

  <!-- Comment List -->
  <h2 class="mt-5">Comment List</h2>
  <ul class="list-group" id="comment-list">
    <c:forEach var="comment" items="\${comments}">
      <li class="list-group-item d-flex justify-content-between align-items-center"
          data-id="\${comment.id}">
        <div class="comment-content">
          <strong>\${comment.content}</strong>
          <br>
          <small class="text-muted">\${comment.createdAt}</small>
        </div>
        <div>
          <button class="btn btn-warning btn-sm edit-button">Edit</button>
          <button class="btn btn-danger btn-sm delete-button">Delete</button>
        </div>
      </li>
    </c:forEach>
  </ul>
</div>

<script>
  const API_URL = '/api/comments';
  // 댓글 추가
  $('#add-comment-form').on('submit', function (e) {
    e.preventDefault();
    const content = $('#comment-content').val();

    if (!content.trim()) {
      alert('Comment content cannot be empty.');
      return;
    }

    $.ajax({
      url: API_URL,
      type: 'POST',
      data: { content: content },
      success: function () {
        $('#comment-content').val('');
        loadComments();
      },
      error: function () {
        alert('Failed to add comment.');
      }
    });
  });

  // 댓글 삭제
  $('#comment-list').on('click', '.delete-button', function () {
    const commentId = $(this).closest('li').data('id');

    $.ajax({
      url: `\${API_URL}/\${commentId}`,
      type: 'DELETE',
      success: function () {
        loadComments();
      },
      error: function () {
        alert('Failed to delete comment.');
      }
    });
  });

  // 댓글 수정
  $('#comment-list').on('click', '.edit-button', function () {
    const listItem = $(this).closest('li');
    const commentId = listItem.data('id');
    const commentContentDiv = listItem.find('.comment-content');
    const currentContent = commentContentDiv.find('strong').text();

    // 수정 모드로 변경
    commentContentDiv.html(`
                <input type="text" class="form-control edit-input" value="\${currentContent}">
                <button class="btn btn-success btn-sm save-button mt-2">Save</button>
                <button class="btn btn-secondary btn-sm cancel-button mt-2">Cancel</button>
            `);
  });

  // 수정 저장
  $('#comment-list').on('click', '.save-button', function () {
    const listItem = $(this).closest('li');
    const commentId = listItem.data('id');
    const newContent = listItem.find('.edit-input').val();

    if (!newContent.trim()) {
      alert('Comment content cannot be empty.');
      return;
    }

    $.ajax({
      url: `\${API_URL}/\${commentId}`,
      type: 'PUT',
      data: { content: newContent },
      success: function () {
        loadComments();
      },
      error: function () {
        alert('Failed to update comment.');
      }
    });
  });

  // 수정 취소
  $('#comment-list').on('click', '.cancel-button', function () {
    loadComments(); // 수정 취소 시 목록을 다시 로드
  });

  // 댓글 목록 로드
  function loadComments() {
    $.ajax({
      url: API_URL,
      type: 'GET',
      success: function (data) {
        const commentList = $('#comment-list');
        commentList.empty();
        data.forEach(comment => {
          commentList.append(`
                            <li class="list-group-item d-flex justify-content-between align-items-center" data-id="\${comment.id}">
                                <div class="comment-content">
                                    <strong>\${comment.content}</strong>
                                    <br>
                                    <small class="text-muted">\${comment.createdAt}</small>
                                </div>
                                <div>
                                    <button class="btn btn-warning btn-sm edit-button">Edit</button>
                                    <button class="btn btn-danger btn-sm delete-button">Delete</button>
                                </div>
                            </li>
                        `);
        });
      },
      error: function () {
        alert('Failed to load comments.');
      }
    });
  }

  $(document).ready(function () {
    loadComments();
  });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>