public class Habilidad {
    private String nombre;
    private String efecto;
    private String probabilidad;

    public Habilidad(String nombre, String efecto, String probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    public String getDatos() {
        datos = "Nombre: " + this.nombre + ", Efecto: " + efecto + ", Probabilidad: " + probabilidad;
        return datos;
    }
}