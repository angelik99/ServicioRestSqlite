package com.nttdata.pruebatecnica.service.impl;

import com.nttdata.pruebatecnica.entity.Cliente;
import com.nttdata.pruebatecnica.service.IClienteRepository;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Pruebas unitarias para la clase ClienteServiceImpl.
 *
 * @author aleon <99mary.leon@gmail.com>
 */
@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl archivo;

    @Mock
    private IClienteRepository clienteRepository;

    @BeforeEach
    public void init(){
        archivo.deleteByNumDocument(3333);
    }
    
    @Test
    public void saveCliente() {
        Cliente cliente = new Cliente( 3333, "C", "ivan", " mauricio", "murcia", null, 312187898, "Calle 11", "bogota");
        String resultado = archivo.save(cliente);
        Assertions.assertEquals("Se guardo el cliente.", resultado);
    }
    
    @Test
    public void saveClienteException() {
        Cliente cliente = new Cliente(1, 23445322, "C", "ivan", " mauricio", "murcia", null, 312187898, "Calle 11", "bogota");
        String resultado = archivo.save(cliente);
        Assertions.assertEquals("Error al guardad cliente.", resultado);
    }

    @Test
    public void buscarClienteTipoNumDocumento() {
        assertNotNull(archivo.findByTypeDocumentAndNumDocument("C", 23445322));
    }
    
    @Test
    public void buscarClienteTipoNumDocumentoException() {
        assertNull(archivo.findByTypeDocumentAndNumDocument("Chjhj", 23445322));
    }
    @Test
    public void eliminarCliente() {
        archivo.deleteByNumDocument(546545446);
    }

}
