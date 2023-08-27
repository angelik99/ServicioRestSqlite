
package com.nttdata.pruebatecnica;

import com.nttdata.pruebatecnica.entity.Cliente;
import com.nttdata.pruebatecnica.service.IClienteRepository;
import com.nttdata.pruebatecnica.service.impl.ClienteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Calse de entrada para ejecutar el proyecto spring boot.
 * 
 * @author aleon <99mary.leon@gmail.com>
 */
@SpringBootApplication
public class app {

    /**
     * Inicialización para crear e insertar datos en la bd.
     */
    public void init() {
        IClienteRepository clienteRepository = new ClienteServiceImpl();
        Cliente cliente = new Cliente(23445322, "C", "ivan", " mauricio", "murcia", null, 312187898, "Calle 11", "bogota");
        if (clienteRepository.findByTypeDocumentAndNumDocument("C", 23445322) == null) {
            clienteRepository.save(cliente);
        }
    }

    /**
     * Punto de entrada.
     * 
     * @param args argumentos
     */
    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}
