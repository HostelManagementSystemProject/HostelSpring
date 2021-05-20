<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Payment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<h1>List of payments</h1>

	<br>
	<br>
	<br>
	<a href="search">search</a>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">PAYMENT_ID</th>
					<th scope="col">DUE_DATE</th>
					<th scope="col">DATE_OF_PAYMENT</th>
					<th scope="col">RECEIPT_NUMBER</th>
					<th scope="col" colspan="2">ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="payment" items="${paymentlist}">
					<tr>
						<td><c:out value="${payment.payment_id}"></c:out></td>
						<td><c:out value="${payment.due_date}"></c:out></td>
						<td><c:out value="${payment.date_of_payment}"></c:out></td>
						<td><c:out value="${payment.receipt_no}"></c:out></td>
						<td><a href="deletepayment?payment_id=${payment.payment_id}">Delete</a></td>
						<td><a href="editpayment?payment_id=${payment.payment_id}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>