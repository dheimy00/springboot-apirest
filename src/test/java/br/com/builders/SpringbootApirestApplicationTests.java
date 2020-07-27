package br.com.builders;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.builders.modelo.Cliente;
import br.com.builders.repositories.ClienteRepositories;

@SpringBootTest
class SpringbootApirestApplicationTests {
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	
    private Cliente clientePaulo;
    private Cliente clienteMaria;
    
    @Before(value = "teste")
    public void init() {
    	clientePaulo = new Cliente();
    	clientePaulo.setCpf("014.004.000-00");
    	clientePaulo.setNome("Paulo");
    	clientePaulo.setDataNascimento(new Date(1991-04-14));
    	clienteRepositories.save(clientePaulo);
 
    	clienteMaria = new Cliente();
    	clienteMaria.setCpf("014.004.000-00");
    	clienteMaria.setNome("Doe");
    	clienteMaria.setDataNascimento(new Date(1991-12-15));
    	clienteRepositories.save(clienteMaria);
    }
    
	
	@Test 
	public void salvar() {
		Cliente cliente = new Cliente();
		cliente.setId(10L);
		cliente.setCpf("042.150.541-92");
		cliente.setNome("Dheimy");
		cliente.setDataNascimento(new Date(1991-04-14));
		clienteRepositories.save(cliente);
	}
	
	
	@Test 
	public void excluir() {
		clienteRepositories.deleteById(1L);
	}

}
