<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>포지션</th>
				<th>기아</th>
				<th>NC</th>
				<th>롯데</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="dto" items="${dtos }">
				<tr>
					<td>${dto.position }</td>
					<td>${dto.kia }</td>
					<td>${dto.nc }</td>
					<td>${dto.lotte }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>
</body>
</html>