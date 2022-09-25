<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>wallet</title>
<link rel="stylesheet" href="styles1.css"/>
</head>
<body>
<h2>Digital Wallet</h2>
<h3>Current Balance : ${client.balance}</h3>
<table>
<form action="/newBalance">
<tr>
<td>
<input type="text" name="amount" size="22" autofocus required placeholder="Enter the amount" >
</td>
</tr>
<tr>
<td>
<input type="submit" value="add">
</td>
</tr>
</form>
<form action="/">
<tr>
<td>
<input type="submit" value="Home">
</td>
</tr>
</form>
</table>
</body>
</html>