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
public class DentistaTest {
    
    public DentistaTest() {
    }
    
    @Test
    public void test1_CalcularCantidadDeCitas() {
        System.out.println("calcularCantidadDeCitas");
        Dentista dentista = new Dentista();
        dentista.setCantidadcitas(11);
        boolean expResult = false;
        boolean result = dentista.calcularCantidadDeCitas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTiempoDeTolerancia method, of class Dentista.
     */
    
    @Test
    public void test2_CalcularCantidadDeCitas() {
        System.out.println("calcularCantidadDeCitas");
        Dentista dentista = new Dentista();
        dentista.setCantidadcitas(8);
        boolean expResult = true;
        boolean result = dentista.calcularCantidadDeCitas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTiempoDeTolerancia method, of class Dentista.
     */
    
    @Test
    public void test3_CalcularTiempoDeTolerancia() {
        System.out.println("calcularTiempoDeTolerancia");
        Dentista dentista = new Dentista();
        dentista.setTiempotolerancia(25);
        boolean expResult = false;
        boolean result = dentista.calcularTiempoDeTolerancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of permitirNuevaAtencionDeCita method, of class Dentista.
     */
    
    @Test
    public void test4_CalcularTiempoDeTolerancia() {
        System.out.println("calcularTiempoDeTolerancia");
        Dentista dentista = new Dentista();
        dentista.setTiempotolerancia(10);
        boolean expResult = true;
        boolean result = dentista.calcularTiempoDeTolerancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of permitirNuevaAtencionDeCita method, of class Dentista.
     */
    
    @Test
    public void test5_PermitirNuevaAtencionDeCita() {
        System.out.println("denegarNuevaAtencionDeCita");
        int totalCantidadDeCitas = 11;
        Dentista dentista = new Dentista();
        dentista.setCantidadcitas(10);
        boolean expResult = false;
        boolean result = dentista.denegarNuevaAtencionDeCita(totalCantidadDeCitas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void test6_PermitirNuevaAtencionDeCita() {
        System.out.println("permitirNuevaAtencionDeCita");
        int totalCantidadDeCitas = 5;
        Dentista dentista = new Dentista();
        dentista.setCantidadcitas(10);
        boolean expResult = true;
        boolean result = dentista.denegarNuevaAtencionDeCita(totalCantidadDeCitas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
