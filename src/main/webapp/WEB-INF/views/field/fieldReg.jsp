<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/field" method="POST">
		<div class="form-group">
			<label for="name">구장 이름</label> 
			<input type="text" class="form-control" placeholder="Enter Name" name="name" id="name">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
</body>
</html>

