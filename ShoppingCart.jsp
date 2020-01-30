<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html lang="en">
<head>
<title>Shopping Cart</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
</head>



<body>


	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>Welcome to AvadaKedavra</h2>
		</div>

		<c:if test="${empty ShoppingCart}">
			<div class="jumbotron">
				<h1>Sorry, we are currently fixing our inventory. Please visit
					again soon.</h1>
			</div>
		</c:if>

		<c:if test="${not empty ShoppingCart}">
			<table class="table table-hover table-striped table-bordered">
			
				<thead>
					<tr>
						<th>Name</th>
						<th>Detail</th>
						<th>Quantity</th>
						<th>Individual Price</th>
						<th>Overall Price</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${ShoppingCart}" var="entry">
						<tr>
							<td>${entry.item.name}</td>
							<td>${entry.item.detail}</td>
							<td>${entry.userQuantity}</td>
							<td>${entry.item.price}</td>
							<td>${entry.item.price * entry.userQuantity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<h3> Whole Price: ${wholePrice}</h3>
		</c:if>

	<p><a class="btn btn-success btn-sm" href="Checkout">Go to Checkout</a></p>

	</div>





</body>
</html>