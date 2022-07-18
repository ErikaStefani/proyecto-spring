<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		// $('#select-libros').select2();

		$('#select-clientes').select2();
		$('#form-ventas').validate();
	});
</script>

<h1>Ventas</h1>

<form:form method="post" action="/ventas/guardar"
	modelAttribute="ventaForm" id="form-venta">

	<div class="row">
		<div class="col-4">
			<label>Fecha</label>
			<form:input id="fecha" type="date" path="fecha"
				cssClass="form-control" />
		</div>
		<div class="col-4">
			<label>Cliente</label>
			<form:select path="clienteId" items="${clientes}" itemLabel="nombre"
				itemValue="id" cssClass="form-control" id="select-clientes" />
		</div>
		<div class="col-2 mt-3">
			<button id="cargarDetalle" type="button" class="btn btn-primary">Cargar
				detalle</button>
		</div>
	</div>
	<div class="row mt-3">
		<table id="miTabla" class="table">
			<thead class="thead-dark">
				<tr>
					<th>Libro</th>
					<th>Codigo Libro</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Subtotal</th>
					<th>Accion</th>
				</tr>
			</thead>
			<tfoot id="tfoot-total">
				<tr>
					<td colspan=4>Total</td>
					<td></td>
				</tr>
			</tfoot>
			<tbody id="tbody-ventas"></tbody>
		</table>
	</div>

	<div class="d-flex justify-content-end mt-3">
		<button id="registrarVenta" type="button" class="btn btn-primary">Registrar
			Venta</button>
	</div>

</form:form>

<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>