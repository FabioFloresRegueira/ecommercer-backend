package ebackend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ebackend.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, Long> {

	Optional<Produto> findByNome(String nome);
	
}
