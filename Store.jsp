<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<title>Store</title>
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

		<c:if test="${empty Inventory}">
			<div class="jumbotron">
				<h1>Sorry, we are currently fixing our inventory. Please visit
					again soon.</h1>
			</div>
		</c:if>

		<c:if test="${not empty Inventory}">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Item</th>
						<th>Description</th>
						<th>Price</th>
						<th>Stock</th>
						<th>Add!</th>
					</tr>  
				</thead>
				<tbody>
					<c:forEach items="${Inventory}" var="entry">
						<tr>
							<td>${entry.name}</td>
							<td><a class="btn btn-success btn-sm"
								href="Details?id=${entry.id}">${entry.detail}</a></td>
							<td>${entry.price}</td>
							<td>${entry.quantity}</td>
							<td><a class="btn btn-success btn-sm"
								href="Store?id=${entry.id}">Add</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<p><a class="btn btn-success btn-sm" href="ShoppingCart"> ${numberOfItemsInShoppingCart} View Cart</a></p>

		<p><a class="btn btn-success btn-sm" href="Inventory"> Go to Inventory</a></p>
		
		<p><a class="btn btn-success btn-sm" href="History"> Go to History</a></p>

	</div>



</body>



</html>