
package com.nttdata.pruebatecnica.entity;


/**
 * Entidad de la tabla de cliente.
 * 
 * @author aleon <99mary.leon@gmail.com>
 */
public class Cliente {
    
    public Integer id;
    public Integer numeroDocumento;
    public String tipoDocumento;
    public String primerNombre;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public Integer telefono;
    public String direccion;
    public String ciudadRecidencia;

    public Cliente() {
    }

    public Cliente(Integer id, Integer numeroDocumento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer telefono, String direccion, String ciudadRecidencia) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadRecidencia = ciudadRecidencia;
    }

    
    public Cliente(Integer numeroDocumento, String tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer telefono, String direccion, String ciudadRecidencia) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadRecidencia = ciudadRecidencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadRecidencia() {
        return ciudadRecidencia;
    }

    public void setCiudadRecidencia(String ciudadRecidencia) {
        this.ciudadRecidencia = ciudadRecidencia;
    }
    
    
}
