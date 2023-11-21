/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Persistencia;

import DentaSoft.Dominio.HorarioAtencion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estdi
 */
public class HorarioPostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public HorarioPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
//        this.MedicoPostgreSQL = new MedicoPostgreSQL(accesoDatosJDBC);
    }

    public void guardar(HorarioAtencion horario) throws Exception {
        String insertSQL = "insert into horario(idhorario,  horainicio, horafin, estado)"
                + "values(?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, horario.getIdhorario());
            sentencia.setTime(2, Time.valueOf(horario.getHoraInicio()));
            sentencia.setTime(3, Time.valueOf(horario.getHoraFin()));
            sentencia.setString(4, horario.getEstado());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR GUARDAR HORARIO", e);
        }
    }

    public HorarioAtencion buscar(String idhorario) throws Exception {
        String consultaSQL = "select horainicio,horafin,estado from horario where estado='A' and idhorario = ?";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, idhorario);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                HorarioAtencion horario = new HorarioAtencion();
                horario.setIdhorario(idhorario);
                horario.setHoraInicio(resultado.getTime("horainicio").toLocalTime());
                horario.setHoraFin(resultado.getTime("horafin").toLocalTime());
                horario.setEstado(resultado.getString("estado"));
                return horario;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR BUSCAR EL HORARIO", e);
        }
    }

//    public List<String> obtenerHoras(HorarioAtencion horario) throws Exception {
//
//        String consultaSQL = "select idhorario, horainicio, horafin, estado from horario where fecha = ? ";
//        PreparedStatement sentencia;
//        List<String> horas = new ArrayList<>();
//        try {
//
//            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
//            sentencia.setString(1, horario.getFecha());
//            ResultSet resultado = sentencia.executeQuery();
//            while (resultado.next()) {
//                horas.add(resultado.getString(1));
//                horas.add(resultado.getString(2));
//
//            }
//        } catch (Exception e) {
//            System.out.println("error metodo obetener horas");
//            throw new Exception("ERROR AL VERIFICAR SI EXISTE EL HORARIO");
//        }
//        return horas;
//    }
//
    public List<HorarioAtencion> mostrarHorarios() throws SQLException {

        String mostraSQL = "select * from horario where estado='A'";
        PreparedStatement sentencia;

        List<HorarioAtencion> lista = new ArrayList<>();

        try {
            sentencia = accesoDatosJDBC.prepararSentencia(mostraSQL);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                HorarioAtencion horarioAtencion = new HorarioAtencion(
                        resultado.getString("idhorario"),
                        resultado.getTime("horainicio").toLocalTime(),
                        resultado.getTime("horafin").toLocalTime(),
                        resultado.getString("estado"));
                String codigo = resultado.getString("idhorario");

                lista.add(horarioAtencion);
            }
            return lista;
        } catch (SQLException e) {
            throw new SQLException("ERROR AL LISTART EL HORARIO.", e);
        }
    }

}
