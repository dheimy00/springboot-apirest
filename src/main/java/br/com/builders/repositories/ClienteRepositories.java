package br.com.builders.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.builders.modelo.Cliente;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Long> {
	
	boolean existsByCpf(String cpf);
	
	List<Cliente> findByCpfOrNomeContaining(String cpf,String nome);
	

}
