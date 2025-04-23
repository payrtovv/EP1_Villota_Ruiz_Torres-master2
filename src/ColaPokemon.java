import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColaPokemon {

    public   Queue<Pokemon> Cola = new LinkedList<>();
    final int NIVEL_EVOLUCION = 140;


    public void encolarPokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado, JTextArea cont){
        Cola.add(new Pokemon(nombre, tipo, nivelPoder, habilidad,estado));
        Cola.add(new Pokemon("Pikachu", "Electrico", 34, "Levitacion", "Activo"));
        Cola.add(new Pokemon("Charizard", "Fuego", 45, "Intimidacion", "Desmayado"));
        Cola.add(new Pokemon("Gyarados", "Agua", 50, "Pistola Agua", "Curado"));
        Cola.add(new Pokemon("Geodude", "Roca", 24, "Robustez", "Debilitado"));

        for (Pokemon pok : Cola){
            cont.append(pok.toString() + "\n");
        }

    }


    public void AjustarPoder(){


        // Se recorre toda la cola para ajustar el poder de los pokemons.
        for (Pokemon poke: Cola ) {
            float PerfectPoder = poke.getNivelPoder();
            String tipo = poke.getTipo();
            switch (tipo) {
                case "Fuego":
                    // Si el tipo del pokemon coincide ajusta su poder
                    PerfectPoder *= 1.3F;
                    break;
                case "Agua":
                    PerfectPoder *= 1.5F;
                    break;
                case "Planta":
                    PerfectPoder *= 1.2F;
                    break;
                default:
                    // Los demás tipos elementales no reciben un cambio en su nivel de poder
                    break;
            }

            // Se crea una cadena con la información de cada pokemon.
            String data =   "Nombre Pokemon: " + poke.getNombre() + "\n" +
                    "Tipo Elemental: " + poke.getTipo() + "\n" +
                    "Habilidad: " + poke.getHabilidad() + "\n" +
                    "Poder Ajustado: " + PerfectPoder;

            // Panel para mostrar los cambios
            JOptionPane.showMessageDialog(null,"Información del Pokemon " + "\n" + data);
        }
    }


    public void Filtrar_por_habilidad(String habilidad, JTextArea cont) {

        Queue<Pokemon> NuevaCola = new LinkedList<>();

        if (!Cola.isEmpty()) {
            for (Pokemon poke : Cola){
                if (habilidad.equals(poke.getHabilidad())){
                    NuevaCola.add(poke);
                }
            }


        }
        for (Pokemon pok : NuevaCola) {
            cont.append(pok.toString() + "\n");
        }
    }

    public void evolucionarPokemon(JTextArea cont){


        Queue<Pokemon> pokemonesEvolucionados = new LinkedList<>();

        try{
            boolean evolucion = false;

            for (Pokemon pok : Cola){
                int poderPokemon = pok.getNivelPoder();
                if (poderPokemon >= NIVEL_EVOLUCION){
                    poderPokemon = (int) (poderPokemon +(poderPokemon*0.20));
                    pok.setNivelPoder(poderPokemon);
                    pok.setEstado("Evolucionando");
                    pokemonesEvolucionados.add(pok);
                    evolucion = true;
                }
            }

            if (!evolucion) {
                throw new Exception ("No hay pokemones para evolcuionar");
            }
            cont.append("Lista de pokemones evolucionados");

            for(Pokemon pok : pokemonesEvolucionados){
                cont.append(pok.toString() + "\n");
            }
        }catch(Exception e){
            //poner el error en Jpanel
        }



    }



}
