
package com.nttdata.pruebatecnica.controller;

import com.nttdata.pruebatecnica.entity.Cliente;
import com.nttdata.pruebatecnica.service.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase para el manejo de las respuesta del api rest.
 * 
 * @author aleon <99mary.leon@gmail.com>
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    IClienteRepository clienteRepo;

    /**
     * Metodo para realizar la consulta de un cliente
     *
     * @param tipoDocumento tipo del documento (C o P)
     * @param numeroDoc numero del documento
     * @return si se encuentra o no el cliente
     */
    @GetMapping("/consultar/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity consultarCliente(@PathVariable("tipoDocumento") String tipoDocumento,
            @PathVariable("numeroDocumento") Integer numeroDoc) {
        Cliente cliente = null;
        try {
            if (!tipoDocumento.toUpperCase().equals("C") && !tipoDocumento.toUpperCase().equals("P")) {
                return new ResponseEntity("Para el tipo de documento solo se permite ({C}cedula o {P} pasaporte)", HttpStatusCode.valueOf(200));
            } else {
                cliente = clienteRepo.findByTypeDocumentAndNumDocument(tipoDocumento.toUpperCase(), numeroDoc);
                if (cliente == null) {
                    return new ResponseEntity("Sin resultados en la búsqueda", HttpStatusCode.valueOf(200));
                }
            }
        } catch (Exception e) {
            return new ResponseEntity("Internal Server Error - Error en backend", HttpStatusCode.valueOf(500));
        }

        return new ResponseEntity(cliente, HttpStatusCode.valueOf(200));
    }
}
