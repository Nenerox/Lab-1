public class Habilidad {
    private String nombre;
    private int ataque;
    private int probabilidad;

    public Habilidad(String nombre, int ataque, int probabilidad) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.probabilidad = probabilidad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getProbabilidad() {
        return probabilidad;
    }
    public String getDatos() {
        String datos ="Nombre: " + nombre + ", Efecto: " + ataque + ", Probabilidad: " + probabilidad +"%";
        return datos;
    }
    public boolean usarHabilidad() {
        double probabilidadAleatoria = Math.random() * 101;
        return probabilidadAleatoria <= probabilidad;
    }
}