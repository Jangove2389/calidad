/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DentaSoft.Dominio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estdi
 */
public class PacienteTest {
    
    public PacienteTest() {
    }
    
    @Test
    public void test1_TieneEdadValida() {
        // ACA VALIDAS SI EL PACIENTE ES MENOR DE EDAD NO PUEDE GENERAR UNA CITA
        System.out.println("TieneEdadValida");
        Paciente paciente = new Paciente();
        paciente.setEdad(15);//LA EDAD ES MENOR QUE 18
        boolean expResult = true;// SI LE PONGO TRUE ME SALE ERROR
        boolean result = paciente.TieneEdadValida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void test2_TieneEdadValida() {
        System.out.println("TieneEdadValida");
        Paciente paciente = new Paciente();
        paciente.setEdad(25);
        boolean expResult = true;
        boolean result = paciente.TieneEdadValida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
