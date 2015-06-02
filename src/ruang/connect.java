package ruang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
 
public class connect { 
 
    Connection conn = null; 
    Statement st = null; 
    String url = "jdbc:mysql://localhost:3306/myproject"; 
    String user = "root"; 
    String pass = ""; 
 
    public connect() { 
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(url, user, pass); 
            st = conn.createStatement(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
 
    public List getruang() { 
        ResultSet rs = null; 
        List ruang = new ArrayList(); 
        try { 
            rs = st.executeQuery("select * from datafull"); 
            while (rs.next()) { 
                ruang ru = new ruang(); 
                ru.setNama_ruang(rs.getString("nama_ruang")); 
                ru.setLokasi_ruang(rs.getString("lokasi")); 
                ru.setFakultas(rs.getString("fakultas")); 
                ru.setPanjang_ruang(rs.getInt("panjang_ruang"));
                ru.setLebar_ruang(rs.getInt("lebar_ruang"));
                ru.setJumlah_kursi(rs.getInt("jumlah_kursi"));
                ru.setJumlah_pintu(rs.getInt("jumlah_pintu"));
                ru.setJumlah_jendela(rs.getInt("jumlah_jendela"));
                //s.setEmail(rs.getString("email")); 
                ruang.add(ru); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return ruang; 
    } 
 
    public int Insert(ruang ru) { 
        int result = 0; 
        try { 
            result = st.executeUpdate("insert into datafull values('" + ru.getNama_ruang()+ "','" + ru.getLokasi_ruang()+ "',"
                    + "'" + ru.getFakultas()+ "','" +ru.getPanjang_ruang()+"','" +ru.getLebar_ruang()+"','" +ru.getJumlah_kursi()+"',"
                    + "'" +ru.getJumlah_pintu()+"','" +ru.getJumlah_jendela()+"')"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return result; 
    }
    public int Delete(ruang ru) { 
        int result = 0; 
        try { 
            result = st.executeUpdate("delete from student where ruang='" + ru.getNama_ruang()); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return result; 
    } 
 
    public int Update(ruang ru) { 
        int result = 0; 
        try { 
            result = st.executeUpdate("update ruang set nama_ruang='"
                    + ru.getNama_ruang()+ "',lokasi='" + ru.getLokasi_ruang()
                    + "',fakultas='" +ru.getFakultas()+ "' where nama_ruang='" + ru.getNama_ruang()+ "'"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return result; 
    } 
 
    public void closeConnection() { 
        try { 
            conn.close(); 
            st.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
} 



//public class connect {
//   private String user,pass,url;
//    public Connection con=null;
//    
//    
//    public connect(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            url="jdbc:mysql://localhost/myproject";
//            user="root";
//            pass="";
//            try {
//                con=DriverManager.getConnection(url,user,pass);
//                JOptionPane.showMessageDialog(null, "conneksi berhasil");
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "server belomstart");
//                System.exit(1);
//            }
//        } catch (Exception e) {
//            System.out.println("salah");
//        }
//    }
    

//    private String user,pass,url;
//    public Connection con=null;
//    
//    public connect(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            url="jdbc:mysql://localhost/myproject";
//            user="root";
//            pass="";
//            try {
//                con=DriverManager.getConnection(url,user,pass);
//                JOptionPane.showMessageDialog(null, "conneksi berhasil");
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "server belomstart");
//                System.exit(1);
//            }
//        } catch (Exception e) {
//            System.out.println("salah");
//        }
//    }
    


