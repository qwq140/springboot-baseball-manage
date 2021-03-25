<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/team" method="POST">
		<div class="form-group">
			<label for="name">팀 이름</label> <input type="text"
				class="form-control" placeholder="Enter Name" name="name" id="name">
		</div>
		<div class="form-group">
			<select name="fieldId" class="custom-select-sm">
				<option selected>구장 선택</option>
				<c:forEach var="field" items="${fields }">
					<option value="${field.id }">${field.name }</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
</body>
</html>

