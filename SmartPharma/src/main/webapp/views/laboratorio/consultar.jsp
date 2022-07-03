<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Laboratorio"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf=8">
<title>Laboratorios Cadastrados</title>
</head>
<body>
<h1>Laboratorios Cadastrados</h1>
</body>
</html>


    
<%
Collection<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
if(request.getAttribute("laboratorios") != null)
	laboratorios =
		(Collection<Laboratorio>) request.getAttribute("laboratorios");
%>

<nav>
	<a href="${pageContext.request.contextPath}/laboratorio/cadastrar">
		Cadastrar novo laboratorio
	</a>
</nav>

<table>
	<thead>
		<th>ID</th>
		<th>Nome</th>
		<th>CPF</th>
		<th>Data de Nascimento</th>
		<th>Endereço</th>
		<th>CEP</th>
		<th>Telefone</th>
		<th>Renda</th>
		<th>Situação</th>
		<th></th>
	</thead>
		
	</tbody>
</table>