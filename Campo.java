import java.util.Scanner;

public class Campo {
    Scanner teclado = new Scanner(System.in);

    Jugador jugador1 = new Jugador("Jugador 1");
    Jugador jugador2 = new Jugador("Jugador 2");
    Pokemon pokemon2 = new Pokemon("Squirtle", "Agua", 17, 6, new Habilidad("Chorro de agua", 20, 90));
    Pokemon[] pokemones = new Pokemon[8];
    
    public Campo() {
        pokemones[0] = new Pokemon("Charmander", "Fuego", 15, 5, new Habilidad("Cola de fuego", 25, 80));
        pokemones[1] = new Pokemon("Squirtle", "Agua", 17, 6, new Habilidad("Chorro de agua", 20, 90));
        pokemones[2] = new Pokemon("Bulbasaur", "Planta", 19, 7, new Habilidad("Látigo cepa", 30, 70));
        pokemones[3] = new Pokemon("Dedene", "Electrico", 16, 4, new Habilidad("Impactrueno", 100, 40));
        pokemones[4] = new Pokemon("Pikachu", "Eléctrico", 15, 5, new Habilidad("Bola Electrica", 25, 80)); 
        pokemones[5] = new Pokemon("Odish", "Planta", 10, 8, new Habilidad("Ataque rápido", 15, 90));
        pokemones[6] = new Pokemon("Piplup", "Agua", 15, 10, new Habilidad("Hidrobomba", 100, 40));
        pokemones[7] = new Pokemon("Torchic", "Fuego", 14, 9, new Habilidad("Lanzallamas", 22, 75));
    }

    public void iniciarJuego() {
        jugador1.eleccionInicial(pokemones[0], pokemones[1], pokemones[2], pokemones[3]);
        jugador2.eleccionInicial(pokemones[4], pokemones[5], pokemones[6], pokemones[7]);
    }

    public boolean ataqueEspecial(){
        String opciones = teclado.nextLine();
        return opciones.equals("si");
    }


    public Pokemon nuevaRondaJ1() {
        int opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion){
            case 1:
                return jugador1.pokemon1;
            case 2:
                return jugador1.pokemon2;
            case 3:
                return jugador1.pokemon3;
            case 4:
                return jugador1.pokemon4;
            default:
                System.out.println("Opción inválida. Elige un Pokémon válido.");
                return nuevaRondaJ1();
        }
    }

    public Pokemon nuevaRondaJ2() {
        int opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion){
            case 1:
                return jugador2.pokemon1;
            case 2:
                return jugador2.pokemon2;
            case 3:
                return jugador2.pokemon3;
            case 4:
                return jugador2.pokemon4;
            default:
                System.out.println("Opción inválida. Elige un Pokémon válido.");
                return nuevaRondaJ2();
        }
    }

    public int calcularAtaqueN(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        int efectotipo = 0;
        if ((pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Planta")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Agua"))  ) {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Electrico") || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Planta"))) {
            efectotipo = -10; 
        }
        
        int ataque = pokemonAtacante.getAtaque();
        int defensa = pokemonDefensor.getDefensa();
        int daño = ataque - defensa + efectotipo;
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }

    public int calcularAtaqueESP(Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        int efectotipo = 0;
        if ((pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Planta")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Agua"))  ) {
            efectotipo = 20;
        } else if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Electrico") || (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Fuego")) || (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Agua")) || (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Planta"))) {
            efectotipo = -10; 
        }
        
        int ataque = 0;
        if (pokemonAtacante.getHabilidad().usarHabilidad()) ataque = pokemonAtacante.getHabilidad().getAtaque();
        int defensa = pokemonDefensor.getDefensa();

        int daño = ataque - defensa + efectotipo;
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }
}