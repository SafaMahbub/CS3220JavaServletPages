<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>History</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

<div class="container">

		<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>Welcome to AvadaKedavra's History</h2>
		</div>

		<c:if test="${empty History}">
			<div class="jumbotron">
				<h1>We have no order's yet. Be our FIRST!!!.</h1>
			</div>
		</c:if>

		<c:if test="${not empty History}">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>OrderID</th>
						<th>Order</th>
						<th>Total Amount</th>
					</tr>  
				</thead>
				<tbody>
					<c:forEach items="${History}" var="entry">
						<tr>
							<td>${entry.orderID}</td>
							<td>${entry.order}</td>
							<td>${entry.total}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<p><a class="btn btn-success btn-sm" href="Store"> Go to Store</a></p>
		
		<p><a class="btn btn-success btn-sm" href="ShoppingCart"> ${numberOfItemsInShoppingCart} View Cart</a></p>

		<p><a class="btn btn-success btn-sm" href="Inventory"> Go to Inventory</a></p>
		

</body>
</html>