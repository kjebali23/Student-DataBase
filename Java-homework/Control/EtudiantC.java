package Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.ResultSetMetaData;
import Modele.Etudiant;
public class EtudiantC implements IEtudiant {

    

    @Override
public void AjouterEtudiant(Etudiant e) {
// TODO Auto-generated method stub
conn=connectionDB();
try {
ps=conn.prepareStatement("insert into etudiant1(id,Nom,Prenom) values(?,?,?)");

ps.setInt(1,e.getId());
ps.setString(2, e.getNom());
ps.setString(3, e.getPrenom());
ps.executeUpdate();
JOptionPane.showMessageDialog(null, "Update is successful");
ps.close();conn.close();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
JOptionPane.showMessageDialog(null, "id existe dans la table","attention",JOptionPane.ERROR_MESSAGE );

}
}
@Override
public void ModifierEtudiant(Etudiant e) {
// TODO Auto-generated method stub
conn=connectionDB();
try {
ps=conn.prepareStatement("UPDATE etudiant1 SET Nom = ? , Prenom = ? where id = ? ");

ps.setString(1, e.getNom());
ps.setString(2, e.getPrenom());
ps.setInt(3, e.getId());
ps.executeUpdate();



JOptionPane.showMessageDialog(null, "update is successful");
ps.close();conn.close();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}
@Override
public void DeleteEtudiant(Etudiant e) {

conn=connectionDB();
try {
ps=conn.prepareStatement("Delete from etudiant1 where id= ?" );
ps.setInt(1, e.getId());
ps.executeUpdate();
JOptionPane.showMessageDialog(null, "Delete is successful");
ps.close();conn.close();
} catch (SQLException e1) {

    e1.printStackTrace();
JOptionPane.showMessageDialog(null, "Delete is failed");
}
}
public Connection connectionDB(){
try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Chargement de driver JDBC");

conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lfig2","root",
"");

System.out.println("Connection is established" );
return conn;
} catch (Exception e) {

e.printStackTrace();
System.out.println("connection failed");
return null;
}
}
public Etudiant ChercherEtudiant(Etudiant e){
conn=connectionDB();
Etudiant ee= new Etudiant();
try {
ps=conn.prepareStatement("select * from etudiant1 where id like?");

ps.setInt(1, e.getId());
rs= ps.executeQuery();
rs.last();
int nbrerow=rs.getRow();
if(nbrerow!=0){
rs.beforeFirst();
while(rs.next()){
ee.setId(rs.getInt(1));
ee.setNom(rs.getString(2));
ee.setPrenom(rs.getString(3));
}
return ee;
}else{
JOptionPane.showMessageDialog(null, "l'etudiant n'existe pas dans la table ","Attention",JOptionPane.ERROR_MESSAGE);

}
return ee;
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
return null;
}
}
private Connection conn;
private PreparedStatement ps;
private ResultSet rs;
}

