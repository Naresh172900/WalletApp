<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Wallet</title>
<link rel="stylesheet" href="styles1.css"/>
</head>
<body>

<h2>Digital Wallet</h2>
<h3>Hello, ${client1.username}</h3>
<h3>Current Balance : ${client1.balance}</h3>
<form action="/addBalance">
<table>
<tr>
<td>
 <input type="submit" value="addMoney">
 </td>
 </tr>
 </form>
 <form action="/withDraw">
 <tr>
 <td>
 <input type="submit" value="withDrawMoney">
 </td>
 </tr>
</form>
</table>
</body>
</html>