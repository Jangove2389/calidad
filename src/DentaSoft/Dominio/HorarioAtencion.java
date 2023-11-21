/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DentaSoft.Dominio;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author estdi
 */
public class HorarioAtencion {

    private String idhorario;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;

    public HorarioAtencion() {
    }

    public HorarioAtencion(String idhorario, LocalTime horaInicio, LocalTime horaFin, String estado) {
        this.idhorario = idhorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }

    public HorarioAtencion(String idhorario) {
        this.idhorario = idhorario;
    }

    public String getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(String idhorario) {
        this.idhorario = idhorario;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // REGLAS DE NEGOCIO
    public boolean tieneHoraValida() {
        return idhorario == idhorario;
//                horaInicio.equalsIgnoreCase("08:00")
//                || horaFin.equalsIgnoreCase("08:45")
//                || horaInicio.equalsIgnoreCase("09:00")
//                || horaFin.equalsIgnoreCase("10:00")
//                || horaInicio.equalsIgnoreCase("11:00")
//                || horaFin.equalsIgnoreCase("12:00")
//                || horaInicio.equalsIgnoreCase("14:00")
//                || horaFin.equalsIgnoreCase("15:00")
//                || horaInicio.equalsIgnoreCase("16:00")
//                || horaFin.equalsIgnoreCase("17:00")
//                || horaInicio.equalsIgnoreCase("18:00")
//                || horaFin.equalsIgnoreCase("19:00")
//                || horaInicio.equalsIgnoreCase("20:00")
//                || horaFin.equalsIgnoreCase("20:45");
    }

//    public boolean tieneUnicaHoraValida( String horas){
//        return horas.contains(getHoraInicio()) || horas.contains(getHoraFin());
//    }
}
