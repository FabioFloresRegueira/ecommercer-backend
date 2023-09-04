package ebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebackend.exception.ResourceNotFoundException;
import ebackend.model.Produto;
import ebackend.repository.ProdutoRepository;

@Service 
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired 
	private ProdutoRepository RPO; 
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	//--------------------------------------------------------------------//
	// LISTA TODOS OS PRODUTOS
	//--------------------------------------------------------------------//
	@Override
	public List<Produto> listaprodutos() {
		List<Produto> lstProdutos = RPO.findAll(); 
		return lstProdutos; 
	}

	
	//--------------------------------------------------------------------//
	// BUSCA UM PRODUTO POR ID
	//--------------------------------------------------------------------//
	@Override
	public Produto buscaumProdutoId(Long id) {
	
		Optional<Produto> opt = RPO.findById(id); 
		
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Falha!, na localização do Poduto com o id :: " + id + " ::.  Registro Inexistente."); 
		}
		
		return opt.get();
	}
	
	
	//--------------------------------------------------------------------//
	// BUSCA UM PRODUTO POR NOME
	//--------------------------------------------------------------------//
	@Override 
	public Produto buscaumProdutoNome(String nome) {
		
		Optional<Produto>  opt = RPO.findByNome(nome); 
		
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Falha!, na localização de um registro com o nome : " + nome + " Inexistente."); 
		}

		return opt.get();	
	}
	
	
	//--------------------------------------------------------------------//
	// GRAVA O REGISTRO DE PRODUTO
	//--------------------------------------------------------------------//
	@Override
	public Produto salvarproduto(Produto tabela) {
		
		tabela.setId(sequenceGeneratorService.generateSequence(Produto.SEQUENCE_NAME));
				
		return RPO.save(tabela); 
	}

	
	//--------------------------------------------------------------------//
	// SALVA A EDIÇÃO DO PRODUTO
	//--------------------------------------------------------------------//
	public Produto editaumproduto(Produto tabela ) {
		return RPO.save(tabela);
		
	}
	
	//--------------------------------------------------------------------//
	// APAGA UM PRODUTO POR ID
	//--------------------------------------------------------------------//
	@Override
	public void apagaumProdutoId(Long id) {
		Produto tabela = buscaumProdutoId(id); 
		RPO.delete(tabela);
			 
	}

}
