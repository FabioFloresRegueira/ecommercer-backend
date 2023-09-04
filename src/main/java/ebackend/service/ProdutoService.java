package ebackend.service;

import java.util.List;

import ebackend.model.Produto;

public interface ProdutoService {

	public List<Produto> listaprodutos(); 

	public Produto buscaumProdutoId(Long id); 
	
	public Produto buscaumProdutoNome(String nome); 
	
	public Produto salvarproduto(Produto tabela); 

	public Produto editaumproduto(Produto tabela ); 

	public void apagaumProdutoId(Long id);  
	
		
}
