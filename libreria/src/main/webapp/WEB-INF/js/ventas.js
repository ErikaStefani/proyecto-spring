

window.onload = iniciar;

var template;
var libros;
var items = [];

function iniciar() {

	let source = document.getElementById("detalleVenta").innerHTML;
	template = Handlebars.compile(source);
	let localData = localStorage.getItem('localData');
	if (localData) {
		const listLibros = JSON.parse(localData);
		listLibros.forEach(item => {
			items.push(item);
		});
	}

	libros = { items };
	let htmlGenerado = template(libros);
	document.getElementById('tbody-libros').innerHTML = htmlGenerado;
	calcular();

	$('#cargarDetalle').click((e) => {
		agregarLibro();
	})

	cargarLibros();
}

function cargarLibros() {
	// Fetch the preselected item, and add to the control
	var comboLibros = $('.select-libros');
	$.ajax({
		type: 'GET',
		url: '/api/students/s/' + studentId
	}).then(function(data) {
		// create the option and append to Select2
		var option = new Option("Seleccione un libro", 0, true, true);
		comboLibros.append(option).trigger('change');

		// manually trigger the `select2:select` event
		comboLibros.trigger({
			type: 'select2:select',
			params: {
				data: data
			}
		});
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


function agregarLibro() {

	//let txtIdLibro= document.getElementById('txtIdLibro');
	//let txtNombre= document.getElementById('txtNombre');
	let txtPrecio = document.getElementById('txtPrecio');
	let txtCantidad = document.getElementById('txtCantidad');

	let l = {
		idLibro: txtIdPLibro.value,
		nombre: txtNombre.value,
		precio: txtPrecio.value,
		cantidad: txtCantidad.value,
		subtotal: 0.0
	};
	l.subtotal = l.precio * l.cantidad;
	libros.items.push(p);
	document.getElementById('tbody-libros').innerHTML = template(libros);
	calcular();


	let localData = localStorage.getItem('localData');
	if (localData) {
		let data = JSON.parse(localData);
		data.push(p);
		localStorage.setItem('localData', JSON.stringify(data));
	} else {
		localStorage.setItem('localData', JSON.stringify([p]));
	}
}


function calcular() {

	var filas = document.querySelectorAll("#miTabla tbody tr");
	var total = 0;

	filas.forEach(function(e) {
		var columnas = e.querySelectorAll("td");
		var cantidad = parseFloat(columnas[3].textContent);
		var precio = parseFloat(columnas[2].textContent);

		columnas[4].textContent = (cantidad * precio).toFixed(2);

		total += cantidad * precio;
	});


	var filas = document.querySelectorAll("#miTabla tfoot tr td");
	filas[1].textContent = total.toFixed(2);
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



