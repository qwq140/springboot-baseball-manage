<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>No</th>
				<th>구장</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="field" items="${fields }">
				<tr id="field-${field.id }">
					<td>${field.id }</td>
					<td>${field.name }</td>
					<td>${field.team.name }</td>
					<td><button type="button" class="btn btn-danger" onClick="deleteField(${field.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>
<script>
	function deleteField(id){
		$.ajax({
			type:"DELETE",
			url:"/field/"+id,
			dataType:"json"
	  }).done((res)=>{
			console.log(res);
		    if(res.statusCode===1){
				$("#field-"+id).remove();
			} else {
				alert("수정에 실패하였습니다.");
			}
	  });
	}
</script>
</body>
</html>