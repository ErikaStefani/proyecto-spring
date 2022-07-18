package edu.curso.java.spring.proyectospring.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImagenLibro {
	@Id
	@GeneratedValue
	private Long id;
	private String fileName;
	private String fileContent;
	
	@ManyToOne
	private Libro libro;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String file) {
		this.fileContent = file;
	}
}
