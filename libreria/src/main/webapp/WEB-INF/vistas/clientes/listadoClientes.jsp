<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

<h1>Listado de Clientes</h1>



<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borramos el cliente?", function(result) {
				if (result) {
					window.location = hrefOriginal;
				}
			});

		});
	});
</script>

<div class="d-flex justify-content-end mt-3 mb-3">
	<a href="/clientes/agregar" class="btn btn-primary">Registrar
		cliente</a>
</div>

<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Telefono</th>
			<th>Email</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${clientes}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.nombre}</td>
			<td>${c.apellido}</td>
			<td>${c.telefono}</td>
			<td>${c.email}</td>

			<td><a href="/clientes/${c.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/clientes/${c.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/clientes/${c.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>