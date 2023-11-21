/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Aplicacion;

import DentaSoft.Dominio.Paciente;
import DentaSoft.Persistencia.AccesoDatosJDBC;
import DentaSoft.Persistencia.AccesoDatosJDBCPostgreSQL;
import DentaSoft.Persistencia.PacientePostgreSQL;
/**
 *
 * @author estdi
 */
public class RegistrarPacienteServicio {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private PacientePostgreSQL pacientePostgreSQL;

    public RegistrarPacienteServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        pacientePostgreSQL = new PacientePostgreSQL(accesoDatosJDBC);        
    }
    
    public void guardarPaciente(Paciente paciente) throws Exception {
        
       if(!paciente.TieneEdadValida()){
            throw new Exception("EL PACIENTE NO TIENE EDAD PERMITIDA PARA SOLICITAR UNA CITA");
        } 
        
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pacientePostgreSQL.guardar(paciente);
        accesoDatosJDBC.terminarTransaccion();
                
    }
    
}
