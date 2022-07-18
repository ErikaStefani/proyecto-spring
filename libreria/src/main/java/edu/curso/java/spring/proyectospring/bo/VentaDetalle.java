package edu.curso.java.spring.proyectospring.bo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class VentaDetalle  {
	
	@Id @GeneratedValue
	private Long idDetalle;
	@Positive @NotNull(message = "Debes especificar la cantidad")
	private Long cantidad;
	@Positive @NotNull(message = "Debes especificar el precio")
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name="ID_VENTA")
	private Venta venta;
	
	@OneToOne
    private Libro libro;
    
	public Long getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}





 

}
