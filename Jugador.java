
public class Jugador {
    String nombre;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Pokemon pokemon3;
    Pokemon pokemon4;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void eleccionInicial(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
    }

}