<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
<style>
#wrapper {
  width: 235px;
}

table {
  border: 1px solid black;
  width: 15%;
}

th,
td {
  width: 100px;
  border: 1px solid black;
}

thead>tr {
  position: relative;
  display: block;
}

tbody {
  display: block;
  height: 170px;
  overflow: auto;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
		</div>
		<table>
		<thead>
		<tr>
			<th>Titulo</th>
			<th>N&uacute;mero</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listaComics}" var="current">
        <tr>
          <td><c:out value="${current.titulo}" /></td>
          <td><c:out value="${current.numero}" /></td>
        </tr>
      </c:forEach>
      </tbody>
		</table>
	</div>
	<div>
	<select>
		<c:forEach items="${listaEditoriales}" var="editorial">
		 <option value="${editorial.idEditorial}">${editorial.nombre}</option>
		</c:forEach>
	</select>
	</div>
	<div>
	<select>
		<c:forEach items="${listaPerio}" var="periodicidad">
		<option value="${periodicidad.idPeriodicidad}">${periodicidad.descripcion}</option>
		</c:forEach>
	</select>
	</div>
	<a href="<c:url value="/logout" />">Logout</a>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>