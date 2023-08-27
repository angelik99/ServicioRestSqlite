package com.nttdata.pruebatecnica.service.impl;

import com.nttdata.pruebatecnica.entity.Cliente;
import com.nttdata.pruebatecnica.service.IClienteRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa las funciones para la clase de clientes.
 *
 * @author aleon <99mary.leon@gmail.com>
 */
@Service
public class ClienteServiceImpl implements IClienteRepository {

    final Logger LOG = Logger.getLogger("com.nttdata.pruebatecnica");
    private String cadenaConexion;

    public ClienteServiceImpl() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:pruebaCliente.db";
            createTable();
        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Error en conexion base de datos");
        }
    }

    /**
     * Método para crear la tabla de cliente en la base de datos sqlite.
     *
     */
    private void createTable() {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = "CREATE TABLE IF NOT EXISTS cliente( "
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " numeroDocumento INTEGER NOT NULL UNIQUE,"
                    + " tipoDocumento TEXT NOT NULL,"
                    + " primerNombre TEXT NOT NULL,"
                    + " segundoNombre TEXT,"
                    + " primerApellido TEXT NOT NULL,"
                    + " segundoApellido TEXT,"
                    + " telefono INTEGER,"
                    + " direccion TEXT,"
                    + " ciudadResidencia TEXT"
                    + " );";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            LOG.log(Level.INFO, "Se creo la talbla cliente.");

        } catch (Exception e) {
            LOG.log(Level.WARNING, "{1} Error encreacion de tabla base de datos", e.getMessage());
        }
    }

    /**
     * Método que permite guardar en la base de datos un cliente.
     *
     * @param cliente datos del cliente
     */
    @Override
    public String save(Cliente cliente) {
        String mensaje = "";
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = "INSERT INTO cliente("
                    + " numeroDocumento, tipoDocumento, primerNombre,"
                    + " segundoNombre, primerApellido, segundoApellido,"
                    + " telefono, direccion, ciudadResidencia) "
                    + " VALUES(" + cliente.getNumeroDocumento() + ", '" + cliente.getTipoDocumento() + "', '"
                    + cliente.getPrimerNombre() + "', '" + cliente.getSegundoNombre() + "', '" + cliente.getPrimerApellido()
                    + "', '" + cliente.getSegundoApellido() + "', " + cliente.getTelefono() + ", '" + cliente.getDireccion()
                    + "', '" + cliente.getCiudadRecidencia() + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            mensaje = "Se guardo el cliente.";
            LOG.log(Level.INFO, mensaje);
        } catch (Exception e) {
            mensaje = "Error al guardad cliente.";
            LOG.log(Level.WARNING, "{1}" + mensaje, e.getMessage());
        }
        return mensaje;
    }

    /**
     * Método que permite consultar un cliente por el tipo y número de documento
     *
     * @param tipoDocumento tipo de Documento
     * @param numDocument numero de Documento
     * @return
     */
    @Override
    public Cliente findByTypeDocumentAndNumDocument(String tipoDocumento, int numDocument) {
        Cliente cliente = null;
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = " SELECT * FROM cliente "
                    + " where  tipoDocumento  = ? "
                    + " AND numeroDocumento = ? ";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, tipoDocumento);
            sentencia.setInt(2, numDocument);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                int id = resultadoConsulta.getInt("id");
                int documento = resultadoConsulta.getInt("numeroDocumento");
                String tipoDoc = resultadoConsulta.getString("tipoDocumento");
                String nombre1 = resultadoConsulta.getString("primerNombre");
                String nombre2 = resultadoConsulta.getString("segundoNombre");
                String apellido1 = resultadoConsulta.getString("primerApellido");
                String apellido2 = resultadoConsulta.getString("segundoApellido");
                int telefono = resultadoConsulta.getInt("telefono");
                String direccion = resultadoConsulta.getString("direccion");
                String ciudad = resultadoConsulta.getString("ciudadResidencia");

                cliente = new Cliente(id, documento, tipoDoc, nombre1, nombre2, apellido1, apellido2, telefono, direccion, ciudad);
                LOG.log(Level.INFO, "Se encontro cliente en la búsqueda.");
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "{1} Error buscando en la base de datos", e.getMessage());
        }
        return cliente;
    }

    /**
     * Método que permite eliminar un cliente por el número de documento.
     *
     * @param numDocumento
     *
     */
    @Override
    public String deleteByNumDocument(int numDocumento) {
        String mensaje = "";
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = " DELETE FROM cliente "
                    + " where  numeroDocumento =  " + numDocumento + ";";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            mensaje = "Se elimino usuario.";
            LOG.log(Level.INFO, mensaje);

        } catch (Exception e) {
            mensaje = "Error al eliminar cliente";
            LOG.log(Level.WARNING, "{1}" + mensaje, e.getMessage());
        }
        return mensaje;
    }
}
