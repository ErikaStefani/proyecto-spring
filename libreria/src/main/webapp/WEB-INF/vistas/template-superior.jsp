<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Libreria</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/handlebars-v4.7.7.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/ventas.js"/>"></script>
	
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
</head>
<body>

	<header>
	  <!-- Fixed navbar -->
	  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	    <a class="navbar-brand" href="<c:url value="/libros"/>">Libreria</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarCollapse">
	      <ul class="navbar-nav mr-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/libros"/>">Libros</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/ventas"/>">Venta</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/clientes"/>">Clientes</a>
	        </li>
	      </ul>
	    </div>
	  </nav>
	</header>


	<div class="container">
	<!-- INICIO CONTENIDO -->