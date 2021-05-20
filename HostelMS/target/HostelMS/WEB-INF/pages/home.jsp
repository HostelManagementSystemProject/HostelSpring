<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<h1>List of Hostels</h1>

	<br>
	<br>
	<br>
	<a href="search">search</a>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">HOSTEL_ID</th>
					<th scope="col">HOSTEL_NAME</th>
					<th scope="col">HOSTEL_ADDRESS</th>
					<th scope="col">PHONE_NUMBER</th>
					<th scope="col" colspan="2">ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hostel" items="${hostellist}">
					<tr>
						<td><c:out value="${hostel.hostel_id}"></c:out></td>
						<td><c:out value="${hostel.hostel_name}"></c:out></td>
						<td><c:out value="${hostel.hostel_address}"></c:out></td>
						<td><c:out value="${hostel.phone_number}"></c:out></td>
						<td><a href="delete?hostel_id=${hostel.hostel_id}">Delete</a></td>
						<td><a href="edithostel?hostel_id=${hostel.hostel_id}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>