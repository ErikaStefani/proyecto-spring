<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

<h1>Listado de libros</h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borramos el libro?", function(result){ 
				if(result) {
					window.location = hrefOriginal;
				}
			});
			
		});
	});	
</script>

<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Tema</th>
			<th>Editorial</th>
			<th>Autor</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${libros}" var="l">
		<tr>
			<td>${l.id}</td>
			<td>${l.nombre}</td>
			<td>${l.tema}</td>
			<td>${l.editorial}</td>
			<td>${l.autor}</td>
			<td>${l.precio}</td>
			<td>
				
			</td>
			<td>
				<a href="/libros/${l.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/libros/${l.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/libros/${l.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>