$(function() {
	$('#cargarDetalle').click((e) => {
		agregarDetalle();
		cargarLibros();
	});

	$("#registrarVenta").click(() => {
		const clienteId = +$("#select-clientes").val()
		const fecha = $("#fecha").val();

		const ventaForm = {
			clienteId: clienteId,
			fecha: fecha,
			detalles: []
		};

		var filas = $("#miTabla tbody tr");
		filas.each(function() {
			const columnas = $(this).find("td");
			const cantidad = +$(columnas[3]).find(".cantidad").val();
			const precio = +$(columnas[2]).find(".precio").val();
			const libroId = +$(columnas[0]).find(".select-libros").val();
			
			ventaForm.detalles.push({
				cantidad: cantidad,
				precio: precio,
				libroId: libroId
			});
		});

		$.ajax({
			url: "/ventas/guardar",
			type: 'POST',
			data: JSON.stringify(ventaForm),
			contentType: "application/json",
			success: function(res) {
				window.location.reload();
			}
		});
	});

	$("#tbody-ventas").on('change', 'select', (e) => {
		const parent = $(e.target).parent().parent();
		const selectedId = e.target.value;

		$(parent).find(".precio").keyup((e) => {
			const parent = $(e.target).parent().parent();
			const cantidad = $(parent).find(".cantidad").val();
			const subtotal = e.target.value * cantidad;
			$(parent).find(".subtotal").html(subtotal);
			calcularTotal();
		});

		$(parent).find(".cantidad").keyup((e) => {
			const parent = $(e.target).parent().parent();
			const precio = $(parent).find(".precio").val();
			const subtotal = precio * e.target.value;
			$(parent).find(".subtotal").html(subtotal);
			calcularTotal();
		});

		$.ajax({
			url: "http://localhost:8081/api/libros/" + selectedId,
			type: 'GET',
			dataType: 'json', // added data type
			success: function(res) {
				$(parent).find(".precio").val(res.precio);
				$(parent).find(".libroId").html(res.id);
				const cantidad = $(parent).find(".cantidad").val();
				const subtotal = res.precio * cantidad;
				$(parent).find(".subtotal").html(subtotal);
				calcularTotal();
			}
		});
	});
});

function cargarLibros() {
	// Set up the Select2 control
	$('.select-libros').select2({
		ajax: {
			url: '/api/libros',
			processResults: function(data) {
				// Transforms the top-level key of the response object from 'items' to 'results'
				return {
					results: $.map(data, function(item) {
						return {
							text: item.nombre,
							id: item.id
						}
					})
				};
			}
		}
	});
}

function validarFormulario() {

	let idLibro = document.getElementById('txtId').value;
	let nombre = document.getElementById('txtNombre').value;
	let precio = document.getElementById('txtPrecio').value;
	let cantidad = document.getElementById('txtCantidad').value;

	if (idLibro === "" || nombre === "" || precio === "" || cantidad === "") {
		bootbox.alert("Debe completar todos los campos");
		return;
	}
	else if (idLibro <= 0 || precio <= 0 || cantidad <= 0) {
		bootbox.alert("Debe ingresar un valor correcto");
		return;
		//	}else if(/^([0-9])*$/.test(nombre)){
		//		bootbox.alert("El nombre del producto ingresado no es válido");   
		//		return;
	}
	//	else if(!isNaN(nombre)){
	//		bootbox.alert("El nombre del producto ingresado no es válido");
	//		return;
	//	}
	else {
		agregarProducto();
		clear();
	}
}


function agregarDetalle() {

	const detalleVenta = {
		libroId: "-",
		precio: 0,
		cantidad: 1,
		subtotal: 0.0
	};

	const row = `<tr>
		<td class="w20">
			<select class="form-control select-libros">
			<select>
		</td>
		<td class="libroId">${detalleVenta.libroId}</td>
		<td><input class="form-control required number precio" value="${detalleVenta.precio}"/></td>
		<td><input class="form-control required number cantidad" value="${detalleVenta.cantidad}"/></td>
		<td class="subtotal">${detalleVenta.subtotal}</td>
		<td><a onclick="borrarVenta(this)" href="#" class="btn btn-danger">Borrar</a></td>
	</tr>`;
	$('#tbody-ventas').append(row);
}


function calcularTotal() {
	var filas = $("#miTabla tbody tr");
	var total = 0;

	filas.each(function() {
		const columnas = $(this).find("td");
		const cantidad = $(columnas[3]).find(".cantidad").val();
		const precio = $(columnas[2]).find(".precio").val();
		const subtotal = (cantidad * precio).toFixed(2);
		$(columnas[4]).html(subtotal);
		total += cantidad * precio;
	});


	var filas = $("#miTabla tfoot tr td");
	$(filas[1]).html(total.toFixed(2));
}


function borrarLibro(boton) {

	bootbox.confirm("Borramos el libro?", function(result) {
		if (result == true) {
			let idLibro = boton.dataset.idLibro;
			let libroRecuperado = libros.items.find(p => p.idLibro == idLibro);
			let indexLibroParaBorrar = libros.items.indexOf(libroRecuperado);
			libros.items.splice(indexLibroParaBorrar, 1);

			document.getElementById('tbody-productos').innerHTML = template(libros);
			calcular();
		}
	});

}

function clear() {
	let form = document.getElementById('formulario');
	formulario.addEventListener('submit', function() {
		formulario.reset();
	});
}


