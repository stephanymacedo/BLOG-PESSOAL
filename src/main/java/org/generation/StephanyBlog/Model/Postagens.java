package org.generation.StephanyBlog.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="Postagens")
public class Postagens {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long Id;
	@NotNull
	@Size (min=5,max=100)
	
	private String titulo;
	@NotNull
	@Size (min=10, max=500)
	
	private String texto;
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date Data=new java.sql.Date(System.currentTimeMillis());
	public long getId() {
	return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	
	
}
