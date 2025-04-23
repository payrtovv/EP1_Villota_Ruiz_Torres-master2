import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColaPokemon {

    public   Queue<Pokemon> Cola = new LinkedList<>();
    final int NIVEL_EVOLUCION = 140;


    public void encolarPokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado, JTextArea cont){
        //Se añade un pokemon por medio de el constructor por defecto
        Cola.add(new Pokemon(nombre, tipo, nivelPoder, habilidad,estado));
        //Se crean 4 pokemones predefinidos con el constructor
        Cola.add(new Pokemon("Pikachu", "Electrico", 34, "Levitacion", "Activo"));
        Cola.add(new Pokemon("Charizard", "Fuego", 45, "Intimidacion", "Desmayado"));
        Cola.add(new Pokemon("Gyarados", "Agua", 50, "Pistola Agua", "Curado"));
        Cola.add(new Pokemon("Geodude", "Roca", 24, "Robustez", "Debilitado"));

        //Se recorre la lista con un for each para mostrar todos los pokemones ingresados
        for (Pokemon pok : Cola){
            cont.append(pok.toString() + "\n");
        }

    }

    public boolean Comprobar() {
        return Cola.peek() == null;
    }


    public void AjustarPoder(){
        //Se comprueba que la cola no este vacia
        if (Comprobar()) {
            JOptionPane.showMessageDialog(null,"La cola está vacía ");
        } else {
            // Se recorre toda la cola para ajustar el poder de los pokemons.

            for (Pokemon poke: Cola ) {
                //Creamos variables para guardar las caracteristicas de los pokemones
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
    }


    public void Filtrar_por_habilidad(String habilidad, JTextArea cont) {

        //Creamos una cola temporal para almacenar los pokemones que coinciden con la habilidad
        Queue<Pokemon> NuevaCola = new LinkedList<>();

        //Se verifica que la cola tenga elementos
        if (!Cola.isEmpty()) {
            //Creamos un for each para recorrer todos los pokemones de la lista
            for (Pokemon poke : Cola) {
                //Creamos un if para ver si la habilidad que se ingreso es igual a la habilidad de el pokemon
                if (habilidad.equals(poke.getHabilidad())) {
                    //Si coinciden se agrega a la cola temporal
                    NuevaCola.add(poke);
                }
            }
            //Se muestran los poquemones que coincidieron con un foreach en la nueva cola
            for (Pokemon pok : NuevaCola) {
                cont.append(pok.toString() + "\n");
            }
        } else {
            //Si no hay se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "No existen poquemones en la lista");
        }


    }

    public void evolucionarPokemon(JTextArea cont){

        //Creamos una cola para ingresar los pokemones que pueden evolucionar
        Queue<Pokemon> pokemonesEvolucionados = new LinkedList<>();


        try{
            boolean evolucion = false;
            //Recorremos la cola de pokemones con un for each
            for (Pokemon pok : Cola){
                //Generamos una variable que adquiera el valor de el poder del pokemos
                int poderPokemon = pok.getNivelPoder();
                //Verificamos que el pokemon pueda evolucionar
                if (poderPokemon >= NIVEL_EVOLUCION){
                    //Hacemos el update
                    poderPokemon = (int) (poderPokemon +(poderPokemon*0.20));
                    pok.setNivelPoder(poderPokemon);
                    pok.setEstado("Evolucionando");
                    //Agregamos el pokemon a la nueva cola
                    pokemonesEvolucionados.add(pok);
                    evolucion = true;
                }
            }

            if (!evolucion) {
                throw new Exception ("No hay pokemones para evolcuionar");
            }
            cont.append("Lista de pokemones evolucionados");
            //Mostramos los pokemones que ingresamos a la nueva cola mediante un for each
            for(Pokemon pok : pokemonesEvolucionados){
                cont.append(pok.toString() + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay pokemons que cumplan con las condiciones para evolucionar.");

        }



    }



}
