	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

<script type="text/javascript">
		$(document).ready(function() {
			$('#select-temas').select2();
			$('#form-cliente').validate();
		});
	</script>
		
		
		<script id="registro" type="text/x-handlebars-template">

		{{#each items}}
		<tr>
			<td>{{idProducto}}</td>
			<td>{{nombre}}</td>
			<td>{{precio}}</td>
			<td>{{cantidad}}</td>
			<td>{{subtotal}}</td>
			<td><a onclick="borrarProducto(this)" href="#" class="btn btn-danger" data-id-producto="{{idProducto}}">Borrar</a></td>
		
		</tr>
	  	{{/each}}
		</script>
	</script>



<head><h1>Venta Libros</h1></head>
	


	<form:form method="post" action="/productos/venta" modelAttribute="ventaForm" id="form-venta" enctype="multipart/form-data">

	
		<div class="form-group">
			<label>Fecha</label>
			<form:input path="fecha" cssClass="form-control required number" />
			<form:errors path="fecha" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<label>Cliente</label>
			<form:input path="fecha" cssClass="form-control required number" />
			<form:errors path="fecha" cssClass="error"/>
		</div>
	
		<div class="form-group">
			<label>Nombre Libro</label>
			<form:select path="nombre" items="${nombre}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-nombres" />
		</div>
		
		<div class="form-group">
			<label>Cantidad</label>
			<form:input path="cantidad" readonly="true" cssClass="form-control"/>
			<form:errors path="cantidad" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control required number" />
			<form:errors path="precio" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Subtotal</label>
			<form:input path="subtotal" cssClass="form-control required number" />
			<form:errors path="subtotal" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<label>Tema</label>
			<form:select path="categoriaId" items="${temas}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-temas" />
		</div>

		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>
	
	 <table id="miTabla" class="table">
	 	<thead class="thead-dark">
	 		<tr>
	 			<th>Id producto</th>
	 			<th>Nombre</th>
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
	 <tbody id="tbody-productos"></tbody>
	 </table>


<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>