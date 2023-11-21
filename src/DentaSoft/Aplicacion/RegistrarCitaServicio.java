/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Aplicacion;

import DentaSoft.Dominio.Cita;
import DentaSoft.Dominio.Dentista;
import DentaSoft.Dominio.HorarioAtencion;
import DentaSoft.Dominio.Paciente;
import DentaSoft.Persistencia.AccesoDatosJDBC;
import DentaSoft.Persistencia.AccesoDatosJDBCPostgreSQL;
import DentaSoft.Persistencia.CitaPostgreSQL;
import DentaSoft.Persistencia.DentistaPostgreSQL;
import DentaSoft.Persistencia.PacientePostgreSQL;
import DentaSoft.Persistencia.HorarioPostgreSQL;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estdi
 */
public class RegistrarCitaServicio {

    private AccesoDatosJDBC accesoDatosJDBC;
    private CitaPostgreSQL citaPostgreSQL;
    private DentistaPostgreSQL dentistaPostgreSQL;
    private PacientePostgreSQL pacientePostgreSQL;
    private HorarioPostgreSQL horarioPostgreSQL;

    public RegistrarCitaServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        citaPostgreSQL = new CitaPostgreSQL(accesoDatosJDBC);
        dentistaPostgreSQL = new DentistaPostgreSQL(accesoDatosJDBC);
        pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);
        horarioPostgreSQL = new HorarioPostgreSQL(accesoDatosJDBC);
    }

    public Dentista buscarDentista(int dni) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Dentista dentista = dentistaPostgreSQL.buscar(dni);
        accesoDatosJDBC.cerrarConexion();
        return dentista;
    }

    public Paciente buscarPaciente(int dni) throws Exception {
        accesoDatosJDBC.abrirConexion();
        Paciente paciente = pacientePostgreSQL.buscar(dni);
        accesoDatosJDBC.cerrarConexion();
        return paciente;
    }

    public HorarioAtencion buscarHorario(String idhorario, LocalDate fecha) throws Exception {
        accesoDatosJDBC.abrirConexion();
        HorarioAtencion horario = horarioPostgreSQL.buscar(idhorario);

        if (horario != null) {
            horario.setEstado("LIBRE");

            if (fecha != null) {
                boolean libre = citaPostgreSQL.verificarHorarioDisponible(horario, fecha);
                if (!libre) {
                    horario.setEstado("OCUPADO");
                }
            }
        }
        accesoDatosJDBC.cerrarConexion();
        return horario;
    }

    public void MostrarHorario(DefaultTableModel modelo) throws Exception {

        accesoDatosJDBC.abrirConexion();
//        horarioPostgreSQL.Mostrar(modelo);
        accesoDatosJDBC.cerrarConexion();
    }

    public void guardarCita(Cita cita) throws Exception {
        accesoDatosJDBC.abrirConexion();
        if (!citaPostgreSQL.verificarHorarioDisponible(cita.getHorarioatencion(), cita.getFecha())) {
            throw new Exception("EL HORARIO ESCOGIDO NO ESTA DISPONIBLE");
        }
        accesoDatosJDBC.iniciarTransaccion();
        citaPostgreSQL.guardar(cita);
        accesoDatosJDBC.terminarTransaccion();
    }

    public int consultarTotalDeCitas(Paciente paciente) throws Exception {
        accesoDatosJDBC.abrirConexion();
        int cantidadCitas = citaPostgreSQL.consultarTotalDeCitas(paciente);
        accesoDatosJDBC.cerrarConexion();
        return cantidadCitas;
    }

}
