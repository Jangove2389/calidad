/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentaSoft.Persistencia;

import DentaSoft.Dominio.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author estdi
 */
public class PacientePostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public PacientePostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public void guardar(Paciente paciente) throws Exception {
        String insertSQL = "Insert Into paciente( nombres, dni, edad, sexo, direccion, telefono, email)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, paciente.getNombres());
            sentencia.setInt(2, paciente.getDni());
            sentencia.setInt(3, paciente.getEdad());
            sentencia.setString(4, paciente.getSexo());
            sentencia.setString(5, paciente.getDireccion());
            sentencia.setString(6, paciente.getTelefono());
            sentencia.setString(7, paciente.getEmail());
            sentencia.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("ERROR AL INTENTAR GUARDAR PACIENTE", ex);
        }

    }

    public Paciente buscar(int dni) throws Exception {
        String consultaSQL = "select idpaciente,nombres,edad,sexo,direccion,telefono,email from paciente where dni = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setDni(dni);
                paciente.setIdpaciente(resultado.getInt("idpaciente"));
                paciente.setNombres(resultado.getString("nombres"));
                paciente.setEdad(resultado.getInt("edad"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setDireccion(resultado.getString("direccion"));
                paciente.setTelefono(resultado.getString("telefono"));
                paciente.setEmail(resultado.getString("email"));
                return paciente;
            } else {
                throw new Exception("No existe el Paciente.");
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR BUSCAR EL PACIENTE. ", e);
        }
    }
}
