<%@page import="java.util.Map"%>
<%@page import="vn.topica.studentmanagerment.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản lý sinh viên</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	
	<div class="container">
		<h1 class="text-center">Quản Lý Sinh Viên</h1>
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#modalAdd">Thêm Sinh Viên</button>

		<form action="/student-managerment/SearchController">
			<input type="text" class="form-control"
				placeholder="Nhập tên sinh viên" name="nameKey">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
		</form>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Năm Sinh</th>
					<th>Giới Tính</th>
					<th>Ngày Nhập Học</th>
					<th>Thao Tác</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach var="entry" items="${studentMap }">
					<tr>
						<td><c:out value="${entry.value.id }"></c:out></td>
						<td><c:out value="${entry.value.name }"></c:out></td>
						<td><c:out value="${entry.value.yearOfBirth }"></c:out></td>
						<td class="genderShow"><c:out value="${entry.value.gender }"></c:out></td>
						<td><c:out value="${entry.value.dateAdmission }"></c:out></td>
						<td>
							<button class="btn-warning">
								<a href="/student-managerment/DeletionController?id=${entry.value.id }">Xóa</a>
							</button>
							<button class="btn-primary" data-toggle="modal"
								data-target="#modalUpdate"
								onclick="loadData('${entry.value.id }','${entry.value.name}', '${entry.value.yearOfBirth }', '${entry.value.gender }', '${entry.value.dateAdmission }')">Cập
								Nhật</button>
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

		<div class="modal fade" id="modalAdd" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<form action="/student-managerment/InsertionController"
							method="POST">
							<div class="form-group">
								<label>Tên:</label> <input class="form-control" name="name"
									placeholder="Họ và tên" required="required">
							</div>
							<div class="form-group">
								<label>Năm Sinh:</label> <input class="form-control"
									name="yearOfBirth" placeholder="Năm Sinh" required="required">
							</div>
							<div class="form-group">
								<label>Giới tính: </label> <select class="form-control"
									name="gender">
									<option value="Nam">Nam</option>
									<option value="Nữ">Nữ</option>
								</select>
							</div>

							<div class="form-group">
								<label>Ngày Nhập Học:</label> <input class="form-control"
									name="dateAdmission" placeholder="dd-MM-YYYY" required="required">
							</div>

							<button type="submit" class="btn btn-default">OK</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					</div>
				</div>

			</div>
		</div>


		<div class="modal fade" id="modalUpdate" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<form action="/student-managerment/UpdateController" method="POST">
							<div class="form-group">
								<label>ID:</label> <input class="form-control" id="id"
									placeholder="" name="id" readonly="readonly">
							</div>
							<div class="form-group">
								<label>Tên:</label> <input class="form-control" id="name"
									placeholder="Họ và tên" name="name" required="required">
							</div>
							<div class="form-group">
								<label>Năm Sinh:</label> <input class="form-control"
									id="yearOfBirth" placeholder="Năm Sinh" name="yearOfBirth" required="required">
							</div>
							<div class="form-group">
								<label>Giới tính: </label> 
								<select class="form-control" name="gender">
									<option value="Nam">Nam</option>
									<option value="Nữ">Nữ</option>
								</select>
							</div>

							<div class="form-group">
								<label>Ngày Nhập Học:</label> <input class="form-control"
									id="date" placeholder="Ngày nhập học" name="dateAdmission" required="required">
							</div>

							<button type="submit" class="btn btn-default">OK</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		function loadData(id, name, yearOfBirth, gender, dateAdmission) {
			$("#modalUpdate #id").val(id);
			$("#modalUpdate #name").val(name);
			$("#modalUpdate #yearOfBirth").val(yearOfBirth);
			$("#modalUpdate #gender").val(gender);
			$("#modalUpdate #date").val(dateAdmission);

		};
	</script>

</body>
</html>