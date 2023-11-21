/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentaSoft.Persistencia;

import DentaSoft.Dominio.Dentista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author estdi
 */
public class DentistaPostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public DentistaPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public void guardar(Dentista dentista) throws Exception {
        String insertSQL = "insert into dentista(nombres,dni,edad,email,telefono,cantidadcitas,tiempotolerancia) "
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, dentista.getNombres());
            sentencia.setInt(2, dentista.getDni());
            sentencia.setInt(3, dentista.getEdad());
            sentencia.setString(4, dentista.getEmail());
            sentencia.setString(5, dentista.getTelefono());
            sentencia.setInt(6, dentista.getCantidadcitas());
            sentencia.setInt(7, dentista.getTiempotolerancia());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR GUARDAR DENTISTA.", e);
        }
    }

    public Dentista buscar(int dni) throws Exception {
        String consultaSQL = " select iddentista,nombres,edad,email,telefono,cantidadcitas,tiempotolerancia from dentista where dni = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Dentista dentista = new Dentista();
                dentista.setDni(dni);
                dentista.setIddentista(resultado.getInt("iddentista"));
                dentista.setNombres(resultado.getString("nombres"));
                dentista.setEdad(resultado.getInt("edad"));
                dentista.setEmail(resultado.getString("email"));
                dentista.setTelefono(resultado.getString("telefono"));
                dentista.setCantidadcitas(resultado.getInt("cantidadcitas"));
                dentista.setTiempotolerancia(resultado.getInt("tiempotolerancia"));
                return dentista;
            } else {
                throw new Exception("NO EXISTE EL DENTISTA.");
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR BUSCAR EL DENTISTA.", e);
        }
    }

}
