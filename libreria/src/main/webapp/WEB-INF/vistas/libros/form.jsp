<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-temas').select2();
			$('#form-libros').validate();
		});
	</script>

	<h1>Formulario de Libros</h1>

	<form:form method="post" action="/libros/guardar" modelAttribute="libroForm" id="form-libro">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>


		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control required number" />
			<form:errors path="precio" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Stock actual</label>
			<form:input path="stockActual" cssClass="form-control required number" />
			<form:errors path="stockActual" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Tema</label>
			<form:select path="categoriaId" items="${temas}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-temas" />
		</div>
		<div class="form-group">
			<label>Edad</label>
			<form:select path="edad" items="${edad}" itemLabel="edad" itemValue="id" cssClass="form-control" id="select-edades" />
		</div>


		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>