/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Aplicacion;

import DentaSoft.Dominio.HorarioAtencion;
import DentaSoft.Persistencia.AccesoDatosJDBC;
import DentaSoft.Persistencia.AccesoDatosJDBCPostgreSQL;
import DentaSoft.Persistencia.HorarioPostgreSQL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estdi
 */
public class RegistrarHorarioAtencionServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private HorarioPostgreSQL horarioPostgreSQL;

    public RegistrarHorarioAtencionServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        horarioPostgreSQL = new HorarioPostgreSQL(accesoDatosJDBC);
    }

    public void guardarHorario(HorarioAtencion horario) throws Exception {

        if (!horario.tieneHoraValida()) {
            throw new Exception("EL HORARIO YA ESTA REGISTRADO");
        }
//        List< String > horas = horarioPostgreSQL.obtenerHoras(horario);

//        if (!horario.tieneHoraUnicaValida(horas)) {
//            throw new Exception("YA EXISTE UN HORARIO CON LAS HORAS INGRESADAS ");
//        }
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        horarioPostgreSQL.guardar(horario);
        accesoDatosJDBC.terminarTransaccion();

    }

    public List<HorarioAtencion> mostrarHorarios() throws Exception {
        accesoDatosJDBC.abrirConexion();
        List<HorarioAtencion> lista = horarioPostgreSQL.mostrarHorarios();
        accesoDatosJDBC.cerrarConexion();
        return lista;
    }

}
