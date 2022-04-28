<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page!</title>
</head>
<body>
	<h1>LIST PRODUCT</h1>
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Producer</th>
			<th>Year Making</th>
			<th>Expire Date</th>
			<th>Price(VND)</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.proId}</td>
				<td>${p.proName}</td>
				<td>${p.cate.cateName}</td>
				<td>${p.producer}</td>
				<td>${p.yearMaking}</td>
				<td><fmt:formatDate value="${p.expireDate}" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatNumber value="${p.price}" currencySymbol=""/></td>
			</tr>
		</c:forEach>
	</table>
	<a href="initInsertProduct">Add New Product</a>
</body>
</html>