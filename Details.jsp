<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<title>Details</title>
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

		<c:if test="${empty item}">
			<div class="jumbotron">
				<h1>Sorry, we are currently fixing our inventory. Please visit
					again soon.</h1>
			</div>
		</c:if>

		<c:if test="${not empty item}">
			<h5>Name: ${item.name}</h5>
			<h5>Detail: ${item.detail}</h5>
			<h5>Quantity: ${item.quantity}</h5>
			<h5>Price: ${item.price}</h5>

			<p>
				<a class="btn btn-success btn-sm" href="Details?id=${item.id}&add=true">Add to Cart</a>
			</p>
			<p>
				<a class="btn btn-success btn-sm" href="ShoppingCart">${numberOfItemsInShoppingCart} View Cart</a>
			</p>
			<p>
				<a class="btn btn-success btn-sm" href="Store">Go to Store</a>
			</p>
		</c:if>





	</div>


</body>
</html>