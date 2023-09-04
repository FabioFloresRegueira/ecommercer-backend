package ebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

@Document(collection = "Produto")
public class Produto {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	
	@Id
	private Long id; 
	
	@Field
	@NonNull 
	@Indexed(unique=true)
	
	private String nome; 

	@Field 
	private double preco;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Long id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
		
	
}
