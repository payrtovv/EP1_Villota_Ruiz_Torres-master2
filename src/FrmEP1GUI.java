import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEP1GUI {
    private JTextArea textArea1;
    private JTextField TxtNombre;
    private JTextField TxtTipo;
    private JTextField TxtPoder;
    private JTextField TxtHabilidad;
    private JTextField TxtEstado;
    private JButton filtrarHabilidadButton;
    private JButton encolarButton;
    private JButton calcularButton;
    private JButton evolucionButton;
    private JPanel Jp;
    private JTextField TxtHabilidadFiltrar;

    ColaPokemon colaPokemon = new ColaPokemon();

    public FrmEP1GUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Usamos getText para obtener las caracteristicas de los pokemones
                String Nombre = TxtNombre.getText();
                String Tipo = TxtTipo.getText();
                int poder = Integer.parseInt(TxtPoder.getText().trim());
                String Habilidad = TxtHabilidad.getText();
                String Estado = TxtEstado.getText();

                //Usamos la funcion de enconlar con las variables que cogimos anteriormente
                colaPokemon.encolarPokemon(Nombre, Tipo, poder, Habilidad, Estado, textArea1);

                //Quitamos los valores anteriores de los text field con setText
                TxtNombre.setText(" ");
                TxtTipo.setText(" ");
                TxtPoder.setText(" ");
                TxtHabilidad.setText(" ");
                TxtEstado.setText(" ");

            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quitamos lo que estaba anteriormente en el textArea
                textArea1.setText(" ");
                //Usamos la funcion Ajustar poder
                colaPokemon.AjustarPoder();
            }
        });
        evolucionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quitamos lo que estaba anteriormente en el textArea
                textArea1.setText(" ");
                //Usamos la funcion evolucionarPokemon poder

                colaPokemon.evolucionarPokemon(textArea1);
            }
        });
        filtrarHabilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Usamos una variable para almacenar el input
                String Input = TxtHabilidadFiltrar.getText();
                //Quitamos lo que estaba anteriormente en el textArea
                textArea1.setText(" ");
                //Usamos la funcion Filtrar poder
                colaPokemon.Filtrar_por_habilidad(Input,textArea1);
                //Quitamos los valores anteriores de el text field con setText
                TxtHabilidadFiltrar.setText(" ");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmEP1GUI");
        frame.setContentPane(new FrmEP1GUI().Jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
