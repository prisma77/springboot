<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Controller Demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<div class="container mt-5">
  <h1 class="text-center">Controller Demo</h1>

  <!-- 버튼 그룹 -->
  <div class="d-flex flex-wrap justify-content-center gap-3">
    <button id="btnHelloWorld" class="btn btn-primary">Hello World</button>
    <button id="btnJsonData" class="btn btn-secondary">JSON Data</button>
    <button id="btnPathVariable" class="btn btn-success">PathVariable</button>
    <button id="btnRequestParam" class="btn btn-danger">RequestParam</button>
    <button id="btnPostRequest" class="btn btn-warning">POST Request</button>
    <button id="btnPutRequest" class="btn btn-info">PUT Request</button>
    <button id="btnDeleteRequest" class="btn btn-dark">DELETE Request</button>
    <button id="btnListData" class="btn btn-primary">List Data</button>
    <button id="btnResponseEntity" class="btn btn-secondary">ResponseEntity</button>
    <button id="btnErrorHandling" class="btn btn-danger">Error Handling</button>
  </div>

  <!-- 결과 영역 -->
  <div class="mt-5">
    <h3>Response</h3>
    <pre id="responseArea" class="p-3 border bg-light"></pre>
  </div>
</div>

<script>
  $(document).ready(function () {
    // Hello World
    $("#btnHelloWorld").click(function () {
      $.get("/api/hello", function (data) {
        $("#responseArea").text(data);
      });
    });

    // JSON Data
    $("#btnJsonData").click(function () {
      $.get("/api/user", function (data) {
        $("#responseArea").text(JSON.stringify(data, null, 4));
      });
    });

    // PathVariable
    $("#btnPathVariable").click(function () {
      $.get("/api/greet/John", function (data) {
        $("#responseArea").text(data);
      });
    });

    // RequestParam
    $("#btnRequestParam").click(function () {
      $.get("/api/sum?a=10&b=20", function (data) {
        $("#responseArea").text("Sum: " + data);
      });
    });

    // POST Request
    $("#btnPostRequest").click(function () {
      $.ajax({
        url: "/api/create",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({ name: "John Doe" }),
        success: function (data) {
          $("#responseArea").text(data);
        }
      });
    });

    // PUT Request
    $("#btnPutRequest").click(function () {
      $.ajax({
        url: "/api/update/1",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify({ name: "Jane Doe" }),
        success: function (data) {
          $("#responseArea").text(data);
        }
      });
    });

    // DELETE Request
    $("#btnDeleteRequest").click(function () {
      $.ajax({
        url: "/api/delete/1",
        method: "DELETE",
        success: function (data) {
          $("#responseArea").text(data);
        }
      });
    });

    // List Data
    $("#btnListData").click(function () {
      $.get("/api/users", function (data) {
        $("#responseArea").text(JSON.stringify(data, null, 4));
      });
    });

    // ResponseEntity
    $("#btnResponseEntity").click(function () {
      $.get("/api/status", function (data) {
        $("#responseArea").text(data);
      });
    });

    // Error Handling
    $("#btnErrorHandling").click(function () {
      $.get("/api/error", function (data) {
        $("#responseArea").text(data);
      }).fail(function (xhr) {
        $("#responseArea").text("Error: " + xhr.responseText);
      });
    });
  });

</script>
</body>

</html>