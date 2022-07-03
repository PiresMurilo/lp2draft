<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Receita"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
Collection<Receita> receitas = 
	(Collection<Receita>) request.getAttribute("receitas");
%>

<nav>
	<a href="${pageContext.request.contextPath}/receita/cadastrar">
		Cadastrar nova receita
	</a>
</nav>
 
<table>
	<thead>
        <th>Id</th>
		<th>Nome</th>
		<th>Status</th>
		<th>Data</th>
		<th>Dados do Paciente</th>
		<th>Dados do Medico</th>
		<th></th>
	</thead>
	<tbody>
		<%
		for(Receita r : receitas)
		{
			out.write("<tr>");
			
			out.write("<td>" + r.getId() + "</td>");

            out.write("<td>" + r.getNomeMedicamento() + "</td>");

            out.write("<td>" + 
                (r.isStatus() == true ? "Valida" : "Invalida") +
                "</td>" );
			
            out.write("<td>" + r.getDataReceita() + "</td>");
			
			out.println("<td>" + (r.isDadosPacienteValidos() == true ? "Valido" : "Invalido") + "</td>");	
							out.println("<td>" + (r.isDadosMedicoValidos() == true ? "Valido" : "Invalido") + "</td>");	
							
			out.write("<a href=\"" + request.getContextPath() + "/pessoafisica/editar?id=" + r.getId() + "\">editar</a> ");
							
			out.write("<a href=\"" + request.getContextPath() + "/pessoafisica/excluir?id=" + r.getId() + "\">excluir</a>");
			
			out.write("</td>");
			
			out.write("</tr>");
		}
		%>
	</tbody>
</table>