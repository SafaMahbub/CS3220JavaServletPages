<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Final Checkout Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>

<div class="page-header">
			<h1>
				Order Confirmation <small>online store</small>
			</h1>
		</div>
		
		<div class="page-header">
			<h1>
				ORDER IF COMPLETE <small>${orderNumber}</small>
			</h1>
		</div>
		
		<p><a class="btn btn-success btn-sm" href="Inventory"> Go to Inventory</a></p>
		
		<p><a class="btn btn-success btn-sm" href="Store"> Go to Store</a></p>

</body>
</html>