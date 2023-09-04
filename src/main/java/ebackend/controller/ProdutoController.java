package ebackend.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebackend.model.Produto;
import ebackend.service.ProdutoService;



@RestController 
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/rest/")
public class ProdutoController {

	@Autowired
	private ProdutoService servico; 
	
	
	
	//--------------------------------------------------------------------//
	// METODO HTTP: (GET) - http://localhost:8084/rest/listaprodutos
	//--------------------------------------------------------------------//
	@GetMapping("listaprodutos")
	public ResponseEntity<?> listatodosos_produtos(){
		List<Produto> list = servico.listaprodutos(); 
		return ResponseEntity.ok(list);
	 } 
	
	//--------------------------------------------------------------------//
	// METODO HTTP: (GET) - http://localhost:8084/rest/listaumproduto:id
	//--------------------------------------------------------------------//
	@GetMapping("listaumproduto/{id}")
	public Produto listaum_produto(@PathVariable Long id){  
		return servico.buscaumProdutoId(id);  
	}
		
	//--------------------------------------------------------------------//
	// METODO HTTP: (GET) - http://localhost:8084/rest/listapornome:nome
	//--------------------------------------------------------------------//
	@GetMapping("listapornome/{nome}")
	public Produto listapornome_produto(@PathVariable String nome){  
		return servico.buscaumProdutoNome(nome);  
	}
		
	//--------------------------------------------------------------------//
	// METODO HTTP: (POST) - http://localhost:8084/rest/adicionaproduto
	//--------------------------------------------------------------------//
	@PostMapping("adicionaproduto")
	public Produto criar_produto(@Validated @RequestBody Produto tabela) {

		return servico.salvarproduto(tabela); 
	}

	
	//--------------------------------------------------------------------//
	// METODO HTTP: (PUT) - http://localhost:8080/rest/alteraproduto/0
	//--------------------------------------------------------------------//
	@PutMapping("alteraproduto/{id}")
	public ResponseEntity<Produto> altera_produto(@PathVariable Long id, @RequestBody Produto tabela ) {
		
		Produto dados = servico.buscaumProdutoId(id); 
		
		dados.setNome(tabela.getNome());
		dados.setPreco(tabela.getPreco()); 
				
		Produto dadosalterado = servico.editaumproduto(dados); 
		
		return ResponseEntity.ok(dadosalterado);
	}
	

	//--------------------------------------------------------------------//
	// METODO HTTP: (DELETE) - http://localhost:8080/rest/apagaproduto/0
	//--------------------------------------------------------------------//
	@DeleteMapping("/apagaproduto/{id}")
	public ResponseEntity<Map<String, Boolean>> deletaUm_produto(@PathVariable Long id){
		
		servico.apagaumProdutoId(id); 
		
		Map<String, Boolean> response = new HashMap<>(); 
		response.put("deleted", Boolean.TRUE); 
		return ResponseEntity.ok(response); 
	}
	
	
}
