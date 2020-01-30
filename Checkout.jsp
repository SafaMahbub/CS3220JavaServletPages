<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checkout</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<div class="page-header">
			<h1>
				Checkout <small>online store</small>
			</h1>
		</div>

		<form class="form-inline" action=Checkout method="post">
			Name: <input type="text" class="form-control"
				placeholder="Enter a Name" name="name" value="${name}"> 
			emailAddress: <input type="text" class="form-control" 
				placeholder="Enter a Email" name="email" value="${email}">
		<!-- </form> -->
	</div>
	<h5>${errornamecheckout}  ${erroremailcheckout}</h5>
	<br/><br/>


	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>Items</th>
			<th>Quantity</th>
		</tr>

		<c:forEach items="${ShoppingCart}" var="entry">
			<tr>
				<td>${entry.item.name}</td>
				<td>${entry.userQuantity}</td>
			</tr>
		</c:forEach>
		
	</table>
	Total: ${wholePrice}<br/>
	<!-- <form class="form-inline" action=Checkout method="post"> -->
	<button type="submit" class="btn btn-default">Complete Order</button>
	</form>




</body>
</html>