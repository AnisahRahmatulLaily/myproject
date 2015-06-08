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
                //ru.setNama_ruang(rs.getString("id_ruang")); 
                ru.setNama_ruang(rs.getString("nama_ruang")); 
                ru.setLokasi_ruang(rs.getString("lokasi")); 
                ru.setFakultas(rs.getString("fakultas")); 
                ru.setPanjang_ruang(rs.getInt("panjang_ruang"));
                ru.setLebar_ruang(rs.getInt("lebar_ruang"));
                ru.setJumlah_kursi(rs.getInt("jumlah_kursi"));
                ru.setJumlah_pintu(rs.getInt("jumlah_pintu"));
                ru.setJumlah_jendela(rs.getInt("jumlah_jendela"));
                ru.setJumlah_steker(rs.getInt("jumlah_steker"));
                ru.setJumlah_baik_steker(rs.getInt("kondisi_steker"));
                ru.setPosisi_steker(rs.getString("posisi_steker"));
                ru.setJumlah_kabel_LCD(rs.getInt("jumlah_lcd"));
                ru.setJumlah_baik_lcd(rs.getInt("kondisi_lcd"));
                ru.setPosisi_kabel_LCD(rs.getString("posisi_lcd"));
                ru.setJumlah_lampu(rs.getInt("jumlah_lampu"));
                ru.setJumlah_baik_lampu(rs.getInt("kondisi_lampu"));
                ru.setPosisi_lampu(rs.getString("posisi_lampu"));
                ru.setJumlah_kipas_angin(rs.getInt("jumlah_kipas"));
                ru.setJumlah_baik_kipas(rs.getInt("kondisi_kipas"));
                ru.setPosisi_kipas_angin(rs.getString("posisi_kipas"));
                ru.setJumlah_AC(rs.getInt("jumlah_ac"));
                ru.setJumlah_baik_ac(rs.getInt("kondisi_ac"));
                ru.setPosisi_AC(rs.getString("posisi_ac"));
                ru.setSSID(rs.getString("ssid"));
                ru.setBandwidth(rs.getString("login"));
                ru.setJumlah_CCTV(rs.getInt("jumlah_cctv"));
                ru.setJumlah_baik_cctv(rs.getInt("kondisi_cctv"));
                ru.setPosisi_CCTV(rs.getString("posisi_cctv"));
                ru.setKondisi_lantai(rs.getString("kondisi_lantai"));
                ru.setKondisi_dinding(rs.getString("kondisi_dinding"));
                ru.setKondisi_atap(rs.getString("kondisi_atap"));
                ru.setKondisi_pintu(rs.getString("kondisi_pintu"));
                ru.setKondisi_jendela(rs.getString("kondisi_jendela"));
                ru.setSirkulasi_udara(rs.getString("sirkulasi"));
                ru.setPencahayaan(rs.getInt("pencahayaan"));
                ru.setKelembapan(rs.getInt("kelembapan"));
                ru.setSuhu(rs.getInt("suhu"));
                ru.setKebisingan(rs.getString("kebisingan"));
                ru.setBau(rs.getString("bau"));
                ru.setKebocoran(rs.getString("kebocoran"));
                ru.setKerusakan(rs.getString("kerusakan"));
                ru.setKeausan(rs.getString("keausan"));
                ru.setKekokohan(rs.getString("kekokohan"));
                ru.setKunci_jendela(rs.getString("kunci_jendela"));
                ru.setBahaya(rs.getString("bahaya"));
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
                    + "'" +ru.getJumlah_pintu()+"','" +ru.getJumlah_jendela()+"','" +ru.getJumlah_steker()+"','" +ru.getJumlah_baik_steker()+"',"
                    + "'" +ru.getPosisi_steker()+"','" +ru.getJumlah_kabel_LCD()+"','" +ru.getJumlah_baik_lcd()+"','" +ru.getPosisi_kabel_LCD()+"',"
                    + "'" +ru.getJumlah_lampu()+"','" +ru.getJumlah_baik_lampu()+"','" +ru.getPosisi_lampu()+"','" +ru.getJumlah_kipas_angin()+"',"
                    + "'" +ru.getJumlah_baik_kipas()+"','" +ru.getPosisi_kipas_angin()+"','" +ru.getJumlah_AC()+"','" +ru.getJumlah_baik_ac()+"',"
                    + "'" +ru.getPosisi_AC()+"','" +ru.getSSID()+"','" +ru.getBandwidth()+"','" +ru.getJumlah_CCTV()+"','" +ru.getJumlah_baik_cctv()+"',"
                    + "'" +ru.getPosisi_CCTV()+"','" +ru.getKondisi_lantai()+"','" +ru.getKondisi_dinding()+"','" +ru.getKondisi_atap()+"',"
                    + "'" +ru.getKondisi_pintu()+"','" +ru.getKondisi_jendela()+"',"
                    + "'" +ru.getSirkulasi_udara()+"','" +ru.getPencahayaan()+"','" +ru.getKelembapan()+"','" +ru.getSuhu()+"',"
                    + "'" +ru.getKebisingan()+"','" +ru.getBau()+"','" +ru.getKebocoran()+"',"
                    + "'" +ru.getKerusakan()+"','" +ru.getKeausan()+"','" +ru.getKekokohan()+"','" +ru.getJumlah_kunci()+"','" +ru.getBahaya()+"')"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return result; 
    }
    public int Delete(ruang ru) { 
        int result = 0; 
        try { 
            result = st.executeUpdate("delete from datafull where nama_ruang='" + ru.getNama_ruang()+ "'"); 
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

