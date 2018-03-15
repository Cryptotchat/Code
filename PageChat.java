import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static java.awt.Color.black;

public class PageChat extends JFrame {

    JTextField saisdetext = new JTextField("Parlez ici");
    JButton entrez = new JButton();
    JPanel conteneur = new JPanel();
    JButton creercompte = new JButton("se déconnecter");
    JButton fermerlapage = new JButton("fermer");

    IntGraph a;

    public PageChat(){
        super.setSize(IntGraph.XDIM,IntGraph.YDIM);
        super.setLayout(new GridLayout(5,5));
        super.setTitle("chat");
        super.setVisible(false);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        conteneur.add(saisdetext);
        conteneur.add(entrez);
        conteneur.add(creercompte);
        conteneur.add(fermerlapage);


        super.add(conteneur);

        fermerlapage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageChat.super.setVisible(false);
                PageChat.super.dispose();
                IntGraph a = new IntGraph();
            }
        });


        }
    }
