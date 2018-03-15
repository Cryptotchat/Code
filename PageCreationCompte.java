import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageCreationCompte extends JFrame {



    JTextField ndc = new JTextField("Veuillez Saisir un nom de compte");
    JTextField mdp = new JTextField("Veuillez Saisir un mdp");
    JButton bouton = new JButton("Créer mon compte !");
    JPanel jpan = new JPanel();

    public PageCreationCompte(){
            super.setTitle("Page 2");
            super.setSize(IntGraph.XDIM,IntGraph.YDIM);
            super.setVisible(false);
            super.setResizable(false);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        jpan.add(ndc);
            jpan.add(mdp);
            jpan.add(bouton);

            super.add(jpan);

        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                IntGraph a = new IntGraph();
            }
        });

        }


    }

