import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Vector;

public class PageChat extends JFrame {
	
	  private ChatServerInt serverInt;
	  private PublicAndPrivateKey papk;
	  private BigInteger nclepr;    // mon n
	  private BigInteger cclepr;    // mon c
	  private BigInteger uclepr;    // mon u
	  
	  private BigInteger ncourant;  // le n de mon amis
	  private BigInteger ccourant;  // le c de mon amis
	  Vector<String> listecontact = new Vector<String>();
	  private  boolean bol =true;


    JFrame m;

    JPanel pChat = new JPanel();
    JPanel pSend = new JPanel();
    JPanel pList = new JPanel();

    JTextField txtMsg = new JTextField("Parlez ici");
    JButton btnSend = new JButton("Envoyer");

    JButton btnFermer = new JButton("Actualiser");

    JTextArea chatBox = new JTextArea();

    JLabel txt = new JLabel("Connexion avec ");
    JComboBox boxList = new JComboBox();

    ChatUI a;

    public PageChat() {

        this.setSize(ChatUI.XDIM, ChatUI.YDIM);
        this.setTitle("Chat");
        this.setVisible(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pSend.setBackground(Color.gray);
        pList.setBackground(Color.gray);
        txtMsg.setForeground(Color.gray);

        chatBox.setEditable(false);
        chatBox.setLineWrap(true);

        pChat.setLayout(new BorderLayout());

        txtMsg.setPreferredSize(new Dimension(200, 40));
        btnSend.setPreferredSize(new Dimension(80, 40));

        btnFermer.setPreferredSize(new Dimension(100, 20));
        boxList.setPreferredSize(new Dimension(120, 20));


        pSend.add(txtMsg);
        pSend.add(btnSend);

        pList.add(txt);
        pList.add(boxList);
        pList.add(btnFermer);

        pChat.add(pList, BorderLayout.NORTH);
        pChat.add(chatBox, BorderLayout.CENTER);
        pChat.add(pSend, BorderLayout.SOUTH);
        
        this.setContentPane(pChat);
        this.setVisible(true);

        // -------------------------------Hints----------------------------------

        txtMsg.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField texteField = ((JTextField) e.getSource());
                texteField.setText("");
                texteField.getFont().deriveFont(Font.PLAIN);
                texteField.setForeground(Color.black);
                texteField.removeMouseListener(this);
            }
        });

        // -------------------------------Buttons----------------------------------

        btnFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listecontact = serverInt.recupere();
                    this.actualisation();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
             /*   PageChat.this.setVisible(false);
                PageChat.this.dispose();
                ChatUI a = new ChatUI();*/
            }

            private void actualisation() {
                int a = 0;
                for (int i = 0; i < listecontact.size(); i++){
                    if(listecontact.get(i).equals(boxList.getItemAt(a)) == false)
                    boxList.addItem(listecontact.get(i));
                }

            }


        });
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    this.sendText();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }

            }

            public void sendText() throws RemoteException {
                String st=txtMsg.getText();
                String a = boxList.getSelectedItem().toString();
              /*  if (m.equals(boxList.getItemAt(0))){
                    chatBox.append(("vous vous envoyez "+st+ "\n"));

                }   */
                this.recuperationdesclefspublic();
                    System.out.println("récupération des données en cours");
                    System.out.println("c ="+ccourant);
                    System.out.println("c ="+ncourant);
                System.out.println(st);

                String b = Code.chiffrer(st,ncourant, ccourant );
                    String c = b;
                System.out.println("le message chiffré N°1 est:" +c);
                txtMsg.setText("");
                System.out.println("1ere etape : message du client vers le serveur"+boxList.getItemAt(0).toString());

                try{
                    serverInt.envoie(c,a, boxList.getItemAt(0).toString()); //st est ici le msg chiffré
                    System.out.println("1ere etape : message du client vers le serveur"+boxList.getItemAt(0).toString());
                }catch(Exception e){e.printStackTrace();}
            }

            private void recuperationdesclefspublic() throws RemoteException {
                String a = boxList.getSelectedItem().toString();
                listecontact = serverInt.getListeNom();
                System.out.println(a);
                for (int i = 0; i < listecontact.size(); i++) {
                    System.out.println(listecontact.get(i).equals(a));
                if (listecontact.get(i).equals(a)) {
                    System.out.println("changement de variable acceptée");
                    ncourant = serverInt.getListeclefpublicn().get(i);
                    System.out.println("envoie du texte avec n publique : "+ncourant);
                    ccourant = serverInt.getListeclefpublicc().get(i);
                    System.out.println("envoie du texte avec c publique : "+ccourant);

                    //  System.out.println("it's working");
                    }
                }
            }
            });
   /*         public void recuperationdesclefsprivée() throws RemoteException {
                listecontact = serverInt.getListeNom();
                for (int i = 0; i < listecontact.size(); i++) {
                    if (listecontact.get(i) == "lalala") {
                        nclepr = serverInt.getListeclefpublicn().get(i);
                        cclepr = serverInt.getListeclefpublicc().get(i);
                        uclepr = serverInt.getListeclefpriveeu().get(i);
                        System.out.println("it's working");
                    }
                }
            }*/

        };




    
    public void ajoutecontact(String S) {
    		listecontact.add(S);
	for (int i = 0; i < listecontact.size(); i++) {
			if (S.equals(listecontact.get(i)) ){
            System.out.println("contact déja existant");
        }
}
		boxList.addItem(S);
}

    public void redige(String st, BigInteger n, BigInteger u, String a, String m){
     //   System.out.println(st);
        System.out.println(" a a dit "+a+" a "+m);

        System.out.println("u : "+u);
        if (a.equals(boxList.getItemAt(0)) && m.equals(boxList.getSelectedItem()) == false) {
            st = Code.dechiffrer(st, n, u);
            //  System.out.println(st);
            chatBox.append(m+" vous a dis : "+st + "\n");
        }
        else if (m.equals(boxList.getSelectedItem()) && a.equals(boxList.getItemAt(0))){
            chatBox.append(" vous ne pouvez pas parler à vous même \n");

        }


  	  }

    public static void main(String[] args){
        PageChat a = new PageChat();
    }

	public void setServ(ChatServerInt serverInt2) {
		this.serverInt = serverInt2;
	}





}
