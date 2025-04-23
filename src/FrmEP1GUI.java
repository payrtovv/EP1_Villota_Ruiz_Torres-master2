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
                String Nombre = TxtNombre.getText();
                String Tipo = TxtTipo.getText();
                int poder = Integer.parseInt(TxtPoder.getText().trim());
                String Habilidad = TxtHabilidad.getText();
                String Estado = TxtEstado.getText();


                colaPokemon.encolarPokemon(Nombre, Tipo, poder, Habilidad, Estado, textArea1);

            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea1.setText(" ");
                colaPokemon.AjustarPoder();
            }
        });
        evolucionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(" ");
                colaPokemon.evolucionarPokemon(textArea1);
            }
        });
        filtrarHabilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Input = TxtHabilidadFiltrar.getText();
                textArea1.setText(" ");
                colaPokemon.Filtrar_por_habilidad(Input,textArea1);
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
