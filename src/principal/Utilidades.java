package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivi
 */
public class Utilidades {
    
    public static Connection conexionBD(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.177/banda?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ivan", "Abcd1234!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "forname error!!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "connection error!!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return conexion;
    }
    
    
    public static void cerrarConexion(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error cerrando la conexion!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public static void resultadoEnTabla(Connection conexion,DefaultTableModel modelo){
        try {
            Statement sentencia=conexion.createStatement();
            ResultSet rs=sentencia.executeQuery("SELECT * FROM musico");
            ResultSetMetaData metaDatos=rs.getMetaData();
            
            int numColumnas=metaDatos.getColumnCount();
            
            Object[] etiquetas=new Object[numColumnas];
            for(int i=0;i<numColumnas;i++){
                etiquetas[i]=metaDatos.getColumnLabel(i+1);
            }
            modelo.setColumnIdentifiers(etiquetas);

            while(rs.next()){
                Object[] datosFila=new Object[modelo.getColumnCount()];
                
                for(int i=0;i<modelo.getColumnCount();i++){
                    datosFila[i]=rs.getObject(i+1);
                }
                modelo.addRow(datosFila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error Statemente!!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } 
    }

    
    public static void aniadir(Connection conexion, int id, String nombre, String apellidos, String direccion){
        try{
            Statement misentencia=conexion.createStatement();

            String consulta="INSERT INTO musico(idmusico,nombre,apellidos,direccion) VALUES('"+id+"','"+nombre+"','"+apellidos+"','"+direccion+"')";

            int filas=misentencia.executeUpdate(consulta);
            if(filas==0){
                JOptionPane.showMessageDialog(null, "Error añadiendo músico!!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Músico añadido correctamente!!!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de consulta!!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void eliminarMusico(Connection conexion, int id){
        try {
            Statement misentencia=conexion.createStatement();
            String consulta="DELETE FROM musico WHERE idmusico='"+id+"'";
            misentencia.executeUpdate(consulta);
          
        } catch (SQLException ex) {
            System.out.println("ERROR Statement");
        }
    }
    
    public static boolean comprobarID(Connection conexion, int id){
        boolean b=false;
        try {
            Statement misentencia=conexion.createStatement();
            String consulta="SELECT * FROM musico WHERE idmusico='"+id+"'";
            
            ResultSet rs=misentencia.executeQuery(consulta);
            if(rs.next()==false){
                b= true;
            }          
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return b;
    }
}
