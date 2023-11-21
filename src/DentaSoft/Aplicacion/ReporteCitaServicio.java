/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Aplicacion;

import DentaSoft.Dominio.Cita;
import DentaSoft.Persistencia.AccesoDatosJDBC;
import DentaSoft.Persistencia.AccesoDatosJDBCPostgreSQL;
import DentaSoft.Persistencia.CitaPostgreSQL;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author estdi
 */
public class ReporteCitaServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private CitaPostgreSQL citaPostgreSQL;

    public ReporteCitaServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        citaPostgreSQL = new CitaPostgreSQL(accesoDatosJDBC);
    }

    public List<Cita> listarCitas(LocalDate fecha) throws Exception {
        accesoDatosJDBC.abrirConexion();
        List<Cita> lista = citaPostgreSQL.listarCitas(fecha);
        accesoDatosJDBC.cerrarConexion();
        return lista;
    }

}
