/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Aplicacion;

import DentaSoft.Dominio.Dentista;
import DentaSoft.Persistencia.AccesoDatosJDBC;
import DentaSoft.Persistencia.AccesoDatosJDBCPostgreSQL;
import DentaSoft.Persistencia.DentistaPostgreSQL;

/**
 *
 * @author estdi
 */
public class RegistrarDentistaServicio {
    
    private AccesoDatosJDBC accesoDatosJDBC;
    private DentistaPostgreSQL pacientePostgreSQL;

    public RegistrarDentistaServicio() {
        accesoDatosJDBC = new AccesoDatosJDBCPostgreSQL();
        pacientePostgreSQL = new DentistaPostgreSQL(accesoDatosJDBC);        
    }
    
    public void guardarDentista(Dentista dentista) throws Exception {
        
       if(!dentista.calcularCantidadDeCitas()){
            throw new Exception("EL DENTISTA NO PUEDE ATENDER MAS CITAS");
        } 
       
       if(!dentista.calcularTiempoDeTolerancia()){
            throw new Exception("TERMINO EL TIEMPO DE TOLERANCIA");
        } 
       
       if(!dentista.denegarNuevaAtencionDeCita(0)){
            throw new Exception("DENEGAR UNA NUEVA CITA");
        } 
              
        accesoDatosJDBC.abrirConexion();
        accesoDatosJDBC.iniciarTransaccion();
        pacientePostgreSQL.guardar(dentista);
        accesoDatosJDBC.terminarTransaccion();
                
    }
    
}
