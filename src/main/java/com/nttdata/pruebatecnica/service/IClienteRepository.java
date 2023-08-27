package com.nttdata.pruebatecnica.service;

import com.nttdata.pruebatecnica.entity.Cliente;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define las funciones para la clase cliente.
 * 
 * @author aleon <99mary.leon@gmail.com>
 */
@Repository
public interface IClienteRepository {

    /**
     * Método que permite guardar en la base de datos un cliente.
     *
     * @param cliente datos del cliente
     * @return mensaje de confirmacion
     */
    public String save(Cliente cliente);

    /**
     * Método que permite consultar un cliente por el tipo y número de documento
     * 
     * @param tipoDocumento tipo de Documento
     * @param numDocumento numero de Documento
     * @return 
     */
    Cliente findByTypeDocumentAndNumDocument(String tipoDocumento, int numDocumento);

    /**
     * Método que permite eliminar un cliente por el número de documento.
     * 
     * @param numDocumento
     * @return mensaje de confirmacion
     * 
     */
    public String deleteByNumDocument(int numDocumento);

}
