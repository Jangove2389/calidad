package DentaSoft.Dominio;

import java.time.LocalDate;

/**
 * @author estdi
 * @version 1.0
 * @created 21-may.-2022 21:58:44
 */
public class Cita {

    private int idcita;
    private String detallecita;
    private double preciocita;
    private double pagototal;
    private Dentista dentista;
    private Paciente paciente;
    private HorarioAtencion horarioatencion;
    private LocalDate fecha;
    private String tipocita;

    public Cita() {

    }

    public Cita(int idcita, String detallecita, double preciocita, double pagototal, Dentista dentista, Paciente paciente, HorarioAtencion horarioatencion, LocalDate fecha, String tipocita) {
        this.idcita = idcita;
        this.detallecita = detallecita;
        this.preciocita = preciocita;
        this.pagototal = pagototal;
        this.dentista = dentista;
        this.paciente = paciente;
        this.horarioatencion = horarioatencion;
        this.fecha = fecha;
        this.tipocita = tipocita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public String getTipocita() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    public String getDetallecita() {
        return detallecita;
    }

    public void setDetallecita(String detallecita) {
        this.detallecita = detallecita;
    }

    public double getPreciocita() {
        return preciocita;
    }

    public void setPreciocita(double preciocita) {
        this.preciocita = preciocita;
    }

    public double getPagototal() {
        return pagototal;
    }

    public void setPagototal(double pagototal) {
        this.pagototal = pagototal;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public HorarioAtencion getHorarioatencion() {
        return horarioatencion;
    }

    public void setHorarioatencion(HorarioAtencion horarioatencion) {
        this.horarioatencion = horarioatencion;
    }

// REGLAS DE NEGOCIO
    public double calcularCostoServicio(String tipoEspecialidad) {

//        String tipoEspecialidad = null;
        double CostoServicio = 0.0;
        if (tipoEspecialidad.equals("ONDODONCIA")) {
            CostoServicio = 250;
        } else if (tipoEspecialidad.equals("LIMPIEZA DENTAL")) {
            CostoServicio = 30;
        } else if (tipoEspecialidad.equals("EXTRACCION DENTAL")) {
            CostoServicio = 50;
        } else if (tipoEspecialidad.equals("RESINA FOTOCURABLE")) {
            CostoServicio = 60;
        } else if (tipoEspecialidad.equals("PROTESIS TOTAL")) {
            CostoServicio = 2500;
        }
        return CostoServicio;
    }

    public double calcularPrecioTotalCita(String tipoEspecialidad) {
//        String tipoEspecialidad = null;
//        double CostoServicio = 0.0;
        return preciocita + calcularCostoServicio(tipoEspecialidad);
    }

    public double calcularDescuentoPorEdad(Double montoTotal) {
        double descuento = 0.0;
        if (paciente.getEdad() <= 16) {
            descuento = montoTotal * 0.05;
        }
        return descuento;
    }
    
    public double calcularDescuentoPorFrecuenciaDeCitas(Double montoTotal, int cantidadCitas) {
        double descuento = 0.0;

        if (cantidadCitas >= 3) {
            descuento = montoTotal * 0.1;
        }

        return descuento;
    }

} //end Cita
