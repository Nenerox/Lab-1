
public class Jugador {
    String nombre;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Pokemon pokemon3;
    Pokemon pokemon4;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void eleccionInicial(){
        System.out.println("Elige tu Pokémon inicial:");
        System.out.println("1. " + pokemon1.getNombre() + " -Tipo" + pokemon1.getTipo() + " -ATK: " + pokemon1.getAtaque() + " -DEF " + pokemon1.getDefensa()    + " -Habilidad " + pokemon1.getHabilidad().getNombre());
    }

}