package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Libro") //no es necesario
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //primary kye
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name")   //si hay un valor que no queremos que se pase a table le tenemos que poner @Trans..
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER ) //por defecto el manytoone es eager
	@JoinColumn (name="id_autor")
	private Autor autor;
	
	public Libro(String name) {
		this.name=name;
		this.autor=null;
		this.id=-1L;
	}
	
	public Libro(String name, Autor autor) {
		this.name = name;
		this.autor = autor;
		this.id=-1L;
	}

	public Libro() {
		this("desconocido");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
