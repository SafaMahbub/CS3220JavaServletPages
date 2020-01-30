<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<div class="page-header">
			<h1>
				Inventory <small>Online Store</small>
			</h1>
		</div>

		<form class="form-inline" action=Inventory method="post">
			<div class="form-group">
				<input type="text" class="form-control"
					placeholder="Enter an item Name" name="addName"> <input
					type="text" class="form-control" placeholder="Enter an item detail"
					name="addDetail"> <input type="text" class="form-control"
					placeholder="Enter an item price" name="addPrice"> <input
					type="text" class="form-control"
					placeholder="Enter an item quantity" name="addQuantity">
			</div>
			<button type="submit" class="btn btn-default">Add</button>
			<p>${errorName}${errorPrice}${errorDetail}${errorQuantity}</p>
		</form>


		<form class="form-inline" action=Inventory method="post">
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Item</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${Inventory}" var="entry">
					<!-- <form class="form-inline" action=Inventory method="post"> -->
					<tr>
						<td>${entry.name}</td>
						<td>
							<!-- <button type="submit" class="btn btn-default"> --> <a
							class="btn primary btn-sm" href="Inventory?deleteID=${entry.id}">Delete</a>
							<!-- </button> -->
						</td>
					</tr>
					<!-- </form> -->

				</c:forEach>
			</table>
		</form>
		
		
		
		<p><a class="btn btn-success btn-sm" href="Store"> Go to Store</a></p>
	</div>



</body>
</html>