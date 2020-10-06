package View;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Control.EtudiantC;
import Modele.Etudiant;

public class Gestion  extends JFrame implements ActionListener {
    public Gestion(){
        this.setTitle("Gestion des etudiants");
        this.setSize(600,100);
        this.setLocationRelativeTo(null);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        id = new JLabel("Identifiant ");
        id.setBounds(10, 10, 10, 10);
        c.add(id);
        tid= new JTextField(10);
        c.add(tid);
        //tid.setEditable(false);
        nom = new JLabel("Nom ");
        c.add(nom);
        tnom= new JTextField(10);
        c.add(tnom);
        
        
        prenom = new JLabel("Prénom ");
        c.add(prenom);
        tprenom= new JTextField(10);
        c.add(tprenom);
        
        ajouter = new JButton("Ajouter");
        chercher=new JButton("Chercher");
        modifier = new JButton("Modifier");
        supprimer = new JButton("Supprimer");
        c.add(ajouter);
        c.add(chercher);
        c.add(modifier);
        c.add(supprimer);
        modifier.addActionListener(this);
        ajouter.addActionListener(this);
        chercher.addActionListener(this);
        supprimer.addActionListener(this);
        }
        private JLabel id,nom,prenom;
        private JTextField tid,tnom,tprenom;
        private JButton ajouter , modifier,supprimer,chercher;
        @Override
        public void actionPerformed(ActionEvent a) {
        // TODO Auto-generated method stub
        Object source= a.getSource();
        if(source== ajouter){
        // recuperer le contenu des champs de text tid, tnom et tprenom
        String txtid=tid.getText();
        String txtnom=tnom.getText();
        String txtprenom=tprenom.getText();
        try{
        int id= Integer.parseInt(txtid);
        Etudiant e= new Etudiant(id,txtnom, txtprenom);
        EtudiantC ec= new EtudiantC();
        ec.AjouterEtudiant(e);
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Verifier le champs identifiant doit etre nombre","attention",JOptionPane.ERROR_MESSAGE );
        
        }
        }
        if(source == modifier){
        String txtid=tid.getText();
        try{
        int id= Integer.parseInt(txtid);
        Etudiant e=new Etudiant(id, tnom.getText(),
        
        tprenom.getText());
        
        EtudiantC ecm= new EtudiantC();
        ecm.ModifierEtudiant(e);
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Verifier le champs identifiant doit etre nombre","attention",JOptionPane.ERROR_MESSAGE );
        
        }
        }
        if(source==chercher ){
        String txtid=tid.getText();
        try{
        int id= Integer.parseInt(txtid);
        Etudiant e=new Etudiant(id);
        EtudiantC ecm= new EtudiantC();
        Etudiant echer=ecm.ChercherEtudiant(e);
        if(echer!=null){
        tnom.setText(echer.getNom());
        tprenom.setText(echer.getPrenom());
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Verifier le champs identifiant doit etre un nombre","attention",JOptionPane.ERROR_MESSAGE );
        
        }
        }
        if(source==supprimer){
        String txtid=tid.getText();
        try{
        int id= Integer.parseInt(txtid);
        Etudiant e=new Etudiant(id);
        EtudiantC ecm= new EtudiantC();
        ecm.DeleteEtudiant(e);
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Verifier le champs identifiant doit etre nombre","attention",JOptionPane.ERROR_MESSAGE );
        
        }
        }
        }
        }

