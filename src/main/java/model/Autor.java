package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Autor") //no es necesario 
@NamedQueries({
	@NamedQuery(name="findByName",query="SELECT a FROM Autor a WHERE a.name=:name")
})
public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id   //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //id autoincrement
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="birthdate",columnDefinition = "date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Libro> libros;
	
	public Autor(String name, LocalDate birthDate) {
		this.id = -1L;
		this.name = name;
		this.birthDate = birthDate;
		this.libros=new HashSet<Libro>();
	}
	
	
	
	public Autor(String name, LocalDate birthDate, Set<Libro> libros) {
		this.name = name;
		this.birthDate = birthDate;
		this.libros = libros;
	}



	public Autor() {
		id=-1L;
		name="";
		birthDate= LocalDate.now();
		this.libros=new HashSet<Libro>();
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	

	public Set<Libro> getLibros() {
		return libros;
	}



	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}



	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
	
}
