/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DentaSoft.Persistencia;

import DentaSoft.Dominio.Cita;
import DentaSoft.Dominio.HorarioAtencion;
import DentaSoft.Dominio.Dentista;
import DentaSoft.Dominio.Paciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estdi
 */
public class CitaPostgreSQL {

    private AccesoDatosJDBC accesoDatosJDBC;

    public CitaPostgreSQL(AccesoDatosJDBC accesoDatosJDBC) {
        this.accesoDatosJDBC = accesoDatosJDBC;
    }

    public void guardar(Cita cita) throws Exception {
        String insertSQL = "insert into cita(detallecita, preciocita, iddentista, idpaciente, idhorario,fecha,pagototal,tipocita)"
                + "values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia;
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(insertSQL);
            sentencia.setString(1, cita.getDetallecita());
            sentencia.setDouble(2, cita.getPreciocita());
            sentencia.setInt(3, cita.getDentista().getIddentista());
            sentencia.setInt(4, cita.getPaciente().getIdpaciente());
            sentencia.setString(5, cita.getHorarioatencion().getIdhorario());
            sentencia.setDate(6, Date.valueOf(cita.getFecha()));
            sentencia.setDouble(7, cita.getPagototal());
            sentencia.setString(8, cita.getTipocita());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR GUARDAR LA CITA.", e);
        }
    }

    public int consultarTotalDeCitas(Paciente paciente) throws Exception {

        String consultaSQL = "select count(idcita) as total from cita where idpaciente = ? and fecha between ? and ?";
        PreparedStatement sentencia;
        int totalDeCitas = 0;
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaHace2Meses = LocalDate.now().minusMonths(2);
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, paciente.getIdpaciente());
            sentencia.setDate(2, Date.valueOf(fechaHace2Meses));
            sentencia.setDate(3, Date.valueOf(fechaActual));
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                totalDeCitas = resultado.getInt("total");
            }
            return totalDeCitas;
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR CONSULTAR LA CITA.", e);
        }
    }

//    public void desactivarEstado(HorarioAtencion horario) {
//
//        String updateSQL = "update horario set estado = 'NO DISPONIBLE' where idhorario = ? ";
//        PreparedStatement sentencia;
//        try {
//            sentencia = accesoDatosJDBC.prepararSentencia(updateSQL);
//            sentencia.setString(1, horario.getIdhorario());
//
//        } catch (Exception ex) {
//            System.out.println("ERROR AL CAMBIAR ESTADO " + ex.getMessage());
//        }
//    }
    public boolean verificarHorarioDisponible(HorarioAtencion horario, LocalDate fecha) throws Exception {

        String consultaSQL = "select idcita from cita where idhorario = ? and fecha=?";
        PreparedStatement sentencia;
        String estado = "";
        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, horario.getIdhorario());
            sentencia.setDate(2, Date.valueOf(fecha));
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL INTENTAR CONSULTAR HORARIO", e);
        }
        return true;
    }

    public List<Cita> listarCitas(LocalDate fecha) throws Exception {
        String consultaSQL = "select c.idcita,c.detallecita,c.fecha,c.preciocita,c.pagototal,c.tipocita,"
                + " p.idpaciente, p.nombres as nombrespaciente,"
                + " d.iddentista, d.nombres as nombresdentista, "
                + " h.idhorario, h.horainicio, h.horafin "
                + " from cita c"
                + " join paciente p on p.idpaciente=c.idpaciente "
                + " join dentista d on d.iddentista=c.iddentista "
                + " join horario h on h.idhorario=c.idhorario "
                + "where fecha = ?";
        PreparedStatement sentencia;

        try {
            sentencia = accesoDatosJDBC.prepararSentencia(consultaSQL);
            sentencia.setDate(1, Date.valueOf(fecha));
            ResultSet resultado = sentencia.executeQuery();
            List<Cita> citas = new ArrayList<>();

            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdpaciente(resultado.getInt("idpaciente"));
                paciente.setNombres(resultado.getString("nombrespaciente"));

                Dentista dentista = new Dentista();
                dentista.setIddentista(resultado.getInt("iddentista"));
                dentista.setNombres(resultado.getString("nombresdentista"));

                HorarioAtencion horarioAtencion = new HorarioAtencion();
                horarioAtencion.setIdhorario(resultado.getString("idhorario"));
                horarioAtencion.setHoraInicio(resultado.getTime("horainicio").toLocalTime());
                horarioAtencion.setHoraFin(resultado.getTime("horafin").toLocalTime());

                Cita cita = new Cita(
                        resultado.getInt("idcita"),
                        resultado.getString("detallecita"),
                        resultado.getDouble("preciocita"),
                        resultado.getDouble("pagototal"),
                        dentista,
                        paciente,
                        horarioAtencion,
                        fecha,
                        resultado.getString("tipocita"));
                citas.add(cita);
            }
            return citas;
        } catch (Exception e) {
            throw new Exception("ERROR AL INTENTAR CONSULTAR LA CITA.", e);
        }
    }
}
