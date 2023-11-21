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
public class CitaTest {

    public CitaTest() {
    }

    @Test
    public void test1_CalcularCostoServicio() {
        System.out.println("calcularCostoServicio");
        String tipoEspecialidad = "ONDODONCIA";
        Cita cita = new Cita();
        cita.calcularCostoServicio(tipoEspecialidad);
        double expResult = 250;
        double result = cita.calcularCostoServicio(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test2_CalcularCostoServicio() {
        System.out.println("calcularCostoServicio");
        String tipoEspecialidad = "LIMPIEZA DENTAL";
        Cita cita = new Cita();
        cita.calcularCostoServicio(tipoEspecialidad);
        double expResult = 30;
        double result = cita.calcularCostoServicio(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test3_CalcularCostoServicio() {
        System.out.println("calcularCostoServicio");
        String tipoEspecialidad = "EXTRACCION DENTAL";
        Cita cita = new Cita();
        cita.calcularCostoServicio(tipoEspecialidad);
        double expResult = 50;
        double result = cita.calcularCostoServicio(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test4_CalcularCostoServicio() {
        System.out.println("calcularCostoServicio");
        String tipoEspecialidad = "RESINA FOTOCURABLE";
        Cita cita = new Cita();
        cita.calcularCostoServicio(tipoEspecialidad);
        double expResult = 60;
        double result = cita.calcularCostoServicio(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test5_CalcularCostoServicio() {
        System.out.println("calcularCostoServicio");
        String tipoEspecialidad = "PROTESIS TOTAL";
        Cita cita = new Cita();
        cita.calcularCostoServicio(tipoEspecialidad);
        double expResult = 2500;
        double result = cita.calcularCostoServicio(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularPrecioTotalCita method, of class Cita.
     */
    @Test
    public void test1_CalcularPrecioTotalCita() {
        System.out.println("calcularPrecioTotalCita");
        String tipoEspecialidad = "ONDODONCIA";
        Cita cita = new Cita();
        cita.setPreciocita(60);
        double expResult = 310;
        double result = cita.calcularPrecioTotalCita(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test2_CalcularPrecioTotalCita() {
        System.out.println("calcularPrecioTotalCita");
        String tipoEspecialidad = "LIMPIEZA DENTAL";
        Cita cita = new Cita();
        cita.setPreciocita(60);
        double expResult = 90;
        double result = cita.calcularPrecioTotalCita(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test3_CalcularPrecioTotalCita() {
        System.out.println("calcularPrecioTotalCita");
        String tipoEspecialidad = "EXTRACCION DENTAL";
        Cita cita = new Cita();
        cita.setPreciocita(60);
        double expResult = 110;
        double result = cita.calcularPrecioTotalCita(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test4_CalcularPrecioTotalCita() {
        System.out.println("calcularPrecioTotalCita");
        String tipoEspecialidad = "RESINA FOTOCURABLE";
        Cita cita = new Cita();
        cita.setPreciocita(60);
        double expResult = 120;
        double result = cita.calcularPrecioTotalCita(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test5_CalcularPrecioTotalCita() {
        System.out.println("calcularPrecioTotalCita");
        String tipoEspecialidad = "PROTESIS TOTAL";
        Cita cita = new Cita();
        cita.setPreciocita(60);
        double expResult = 2560;
        double result = cita.calcularPrecioTotalCita(tipoEspecialidad);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void test6_CalcularDescuentoPorEdad() {
        System.out.println("CalcularDescuentoPorEdad");
        Paciente paciente = new Paciente();
        paciente.setEdad(16);
        Cita cita = new Cita();
        cita.setPaciente(paciente);
        double precioBase = 100.00;
        double expResult = 5;
        double result = cita.calcularDescuentoPorEdad(precioBase);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void test7_CalcularDescuentoPorEdad() {
        System.out.println("CalcularDescuentoPorEdad");
        Paciente paciente = new Paciente();
        paciente.setEdad(17);
        Cita cita = new Cita();
        cita.setPaciente(paciente);
        double precioBase = 100.00;
        double expResult = 0;
        double result = cita.calcularDescuentoPorEdad(precioBase);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void test8_CalcularDescuentoPorFrecuenciaDeCitas() {
        System.out.println("CalcularDescuentoPorFrecuenciaDeCitas");
        Cita cita = new Cita();
        int cantidadCitasEn2Meses = 3;
        double precioBase = 100.00;
        double expResult = 10;
        double result = cita.calcularDescuentoPorFrecuenciaDeCitas(precioBase, cantidadCitasEn2Meses);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void test9_CalcularDescuentoPorFrecuenciaDeCitas() {
        System.out.println("CalcularDescuentoPorFrecuenciaDeCitas");
        Cita cita = new Cita();
        int cantidadCitasEn2Meses = 2;
        double precioBase = 100.00;
        double expResult = 0;
        double result = cita.calcularDescuentoPorFrecuenciaDeCitas(precioBase, cantidadCitasEn2Meses);
        assertEquals(expResult, result, 0.0);
    }

}
