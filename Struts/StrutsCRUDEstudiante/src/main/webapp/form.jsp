<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!-- IMPORTAR ETIQUETAS DE STRUTS Y STRUTS DOJO (JAVA SCRIPT) -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>FROMULARIO CRUD ESTUDIANTE</title>

<!-- CDN BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<s:head/>
<sx:head/>
<body>
	<sx:tabbedpanel id="form">
		<sx:div label="CRUD ESTUDIANTE">
			<s:form action="alta.action" method="post">
				<s:push value="estudiante">
					<s:hidden key="id"/>
					<s:textfield key="nombre" label="NOMBRE"/>
					<s:textfield key="email" label="EMAIL"/>
					<s:textfield key="edad" label="EDAD"/>
					<s:textfield key="apoyo" label="APOYO"/>
					<s:textfield key="fecha" label="FECHA"/>
					<s:submit value="Aceptar"/>
					<s:reset value="Limpiar Datos"/>
				</s:push>
			</s:form>
		</sx:div>
	</sx:tabbedpanel>
	<br>
	<table class="table table-dark table-striped">
		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>EMAIL</td>
			<td>EDAD</td>
			<td>APOYO</td>
			<td>FECHA</td>
			<td>ACCIÓN 1</td>
			<td>ACCIÓN 2</td>
		</tr>
		<s:iterator value="listEstudiante">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="nombre"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="edad"/></td>
			<td><s:property value="apoyo"/></td>
			<td><s:property value="fecha"/></td>
			<td>
				<s:url id="editURL" action="editar">
					<s:param name="id" value="%{id}"/>
				</s:url>
				<s:a href="%{editURL}">Editar</s:a>
			</td>
			<td>
				<s:url id="deleteURL" action="baja">
					<s:param name="id" value="%{id}"/>
				</s:url>
				<s:a href="%{deleteURL}">Eliminar</s:a>
			</td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>