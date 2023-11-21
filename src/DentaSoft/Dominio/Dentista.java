package DentaSoft.Dominio;

/**
 * @author estdi
 * @version 1.0
 * @created 21-may.-2022 21:58:44
 */
public class Dentista {

    private int iddentista;
    private String nombres;
    private int dni;
    private int edad;
    private String email;
    private String telefono;
    private int cantidadcitas;
    private int tiempotolerancia;

    public Dentista() {

    }

    public Dentista(int iddentista, String nombres, int dni, int edad, String email, String telefono, int cantidadcitas, int tiempotolerancia) {
        this.iddentista = iddentista;
        this.nombres = nombres;
        this.dni = dni;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.cantidadcitas = cantidadcitas;
        this.tiempotolerancia = tiempotolerancia;
    }

    public int getIddentista() {
        return iddentista;
    }

    public void setIddentista(int iddentista) {
        this.iddentista = iddentista;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantidadcitas() {
        return cantidadcitas;
    }

    public void setCantidadcitas(int cantidadcitas) {
        this.cantidadcitas = cantidadcitas;
    }

    public int getTiempotolerancia() {
        return tiempotolerancia;
    }

    public void setTiempotolerancia(int tiempotolerancia) {
        this.tiempotolerancia = tiempotolerancia;
    }

// REGLAS DE NEGOCIO 
    public boolean calcularCantidadDeCitas() {
        return cantidadcitas > 5 && cantidadcitas <= 10; // EL DOCTOR SOLO ATIENDE NO REGISTR
    }

    public boolean calcularTiempoDeTolerancia() {
        return tiempotolerancia < 20;
    }

    public boolean denegarNuevaAtencionDeCita(int totalCantidadDeCitas) {
        return totalCantidadDeCitas < cantidadcitas;
    }
}//end Dentista
