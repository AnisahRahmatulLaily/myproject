
package ruang;
import com.sun.org.apache.xml.internal.dtm.DTM;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import ruang.connect;
import ruang.ruang;

/**
 *
 * @author TOSHIBA
 */
public class datafull extends javax.swing.JFrame {
    private DefaultTableModel tabel;

    List<ruang> ab = new ArrayList<ruang>();
    int currentRow = 0;
    String sirkulasi="",login ="",lantai="",dinding="",atap="",pintu="",jendela="",kebisingan="",bau="",kebocoran="",kerusakan="",keausan="",kekokohan="",kuncijendela="",aman="";

   
    public datafull() {
        initComponents();
        slider1();
        loadData();
        tampilmodel();
        slider2();
        slider3();
        String lookAndFeel
                = javax.swing.UIManager.getSystemLookAndFeelClassName();
        try {

            javax.swing.UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
        }

        loadData();
        bindData();
        //this.setTitle("Data Mahasiswa");
        txtnama.setEditable(false);
        txtlokasi.setEditable(false);
        cmbfakultas.setEditable(false);
        txtpanjang.setEditable(false);
        txtlebar.setEditable(false);
        txtjmlkursi.setEditable(false);
        txtjmlpintu.setEditable(false);
        txtjmljendela.setEditable(false);
        this.setLocationRelativeTo(this);
        tampilkandata();
    }

    public Connection conn;
    public Statement cn;

    public void koneksi()            throws SQLException
    {
        try {
            conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "");
            cn=conn.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ruang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(ruang.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(ruang.class.getName()).log(Level.SEVERE, null, es);

        }
        
    }
    public void panel(){
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(false);
            lcd.setVisible(false);
            kipas.setVisible(false);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
    }
public void slider1(){
                p.setEditable(false);	
	        p.setText(null);	
	       sldrpencahayaan.setMinorTickSpacing(5);	
	        sldrpencahayaan.setMajorTickSpacing(20);	
	        sldrpencahayaan.setPaintTicks(true);	
	        sldrpencahayaan.setLabelTable(sldrpencahayaan.getLabelTable());	
	        sldrpencahayaan.setPaintLabels(true);
                sldrpencahayaan.addChangeListener (	
	            new ChangeListener() {
	                public void stateChanged (ChangeEvent e) {	
	                    p.setText ( String.valueOf(sldrpencahayaan.getValue()) );	
                        }	
	            }
	        );
    }
public void slider2(){
                k.setEditable(false);	
	        k.setText(null);	
	       sldrkelembapan.setMinorTickSpacing(5);	
	        sldrkelembapan.setMajorTickSpacing(20);	
	        sldrkelembapan.setPaintTicks(true);	
	        sldrkelembapan.setLabelTable(sldrkelembapan.getLabelTable());	
	        sldrkelembapan.setPaintLabels(true);
                sldrkelembapan.addChangeListener (	
	            new ChangeListener() {
	                public void stateChanged (ChangeEvent e) {	
	                    k.setText ( String.valueOf(sldrkelembapan.getValue()) );	
                        }	
	            }
	        );
    }
public void slider3(){
                s.setEditable(false);	
	        s.setText(null);	
	       sldrsuhu.setMinorTickSpacing(5);	
	        sldrsuhu.setMajorTickSpacing(20);	
	        sldrsuhu.setPaintTicks(true);	
	        sldrsuhu.setLabelTable(sldrsuhu.getLabelTable());	
	        sldrsuhu.setPaintLabels(true);
                sldrsuhu.addChangeListener (	
	            new ChangeListener() {
	                public void stateChanged (ChangeEvent e) {	
	                    s.setText ( String.valueOf(sldrsuhu.getValue()) );	
                        }	
	            }
	        );
    }
public void input(){
    ruang m = new ruang();
                
}
    private void tampilkandata() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("nama");
        tabel.addColumn("lokasi");
        tabel.addColumn("fakultas");
        tabel.addColumn("panjang");
        tabel.addColumn("lebar");
        tabel.addColumn("jumlah kursi");
        tabel.addColumn("jumlah pintu");
        tabel.addColumn("jumlah jendela");
        tabel.addColumn("jumlah steker");
        tabel.addColumn("kondisi steker");
        tabel.addColumn("posisi steker");
        tabel.addColumn("jumlah lcd");
        tabel.addColumn("kondisi lcd");
        tabel.addColumn("posisi lcd");
        tabel.addColumn("jumlah lampu");
        tabel.addColumn("kondisi lampu");
        tabel.addColumn("posisi lampu");
        tabel.addColumn("jumlah kipas");
        tabel.addColumn("kondisi kipas");
        tabel.addColumn("posisi kipas");
        tabel.addColumn("jumlah ac");
        tabel.addColumn("kondisi ac");
        tabel.addColumn("posisi ac");
        tabel.addColumn("ssid");
        tabel.addColumn("login");
        tabel.addColumn("jumlah cctv");
        tabel.addColumn("kondisi cctv");
        tabel.addColumn("posisi cctv");
        tabel.addColumn("kondisi lantai");
        tabel.addColumn("kondisi dinding");
        tabel.addColumn("kondisi atap");
        tabel.addColumn("kondisi pintu");
        tabel.addColumn("kondisi jendela");
        tabel.addColumn("sirkulasi");
        tabel.addColumn("pencahayaan");
        tabel.addColumn("kelembapan");
        tabel.addColumn("suhu");
        tabel.addColumn("kebisingan");
        tabel.addColumn("bau");
        tabel.addColumn("kebocoran");
        tabel.addColumn("kerusakan");
        tabel.addColumn("keausan");
        tabel.addColumn("kekokohan");
        tabel.addColumn("kunci & jendela");
        tabel.addColumn("bahaya");
        
        try {
            koneksi();
            String sql = "select * from datafull";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10), res.getString(11),res.getString(12), res.getString(13), res.getString(14),
                    res.getString(15), res.getString(16), res.getString(17), res.getString(18),
                    res.getString(19), res.getString(20), res.getString(21), res.getString(22),res.getString(23),
                    res.getString(24), res.getString(25), res.getString(26), res.getString(27),
                    res.getString(28), res.getString(29), res.getString(30),res.getString(31), res.getString(32), res.getString(33),
                    res.getString(34), res.getString(35), res.getString(36), res.getString(37),
                    res.getString(38), res.getString(39), res.getString(40),res.getString(41),res.getString(42), res.getString(43), res.getString(44),res.getString(45)});
            }
            tbldata.setModel(tabel);
        } catch (Exception e) {
        }
    }

    private void loadData() {
        connect st = new connect();
        ab = st.getruang();
        st.closeConnection();
    }
    private void bindData() {
        if (ab.size() > 0) {
            ruang s = ab.get(currentRow);
            txtnama.setText(s.getNama_ruang());
            txtlokasi.setText(s.getLokasi_ruang());
            cmbfakultas.setActionCommand(s.getFakultas());
            txtpanjang.setSelectionEnd((int) s.getPanjang_ruang());
            txtlebar.setSelectionEnd((int) s.getLebar_ruang());
            txtjmlkursi.setSelectionEnd(s.getJumlah_kursi());
            txtjmlpintu.setSelectionEnd(s.getJumlah_pintu());
            txtjmljendela.setSelectionEnd(s.getJumlah_jendela());
            //s.getJumlah_steker(jumlahsteker);
        } else {
            currentRow = 0;
            txtnama.setText("");
            txtlokasi.setText("");
            cmbfakultas.setActionCommand("");
            txtpanjang.setText("");
            txtlebar.setText("");
            txtjmlkursi.setText("");
            txtjmlpintu.setText("");
            txtjmljendela.setText("");
        }                                                                                                                                                                                               
    }
     private void atur(JTable lihat, int lebar[]) {
        try {
            lihat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int banyak = lihat.getColumnCount();
            for (int i = 0; i < banyak; i++) {
                TableColumn kolom = lihat.getColumnModel().getColumn(i);
                kolom.setPreferredWidth(lebar[i]);
                lihat.setRowHeight(20);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah" + e);
        }
    }

    //untuk membuat void colom yang sesuai kita inginkan
    private void tampilmodel() {
        try {
            String[] kolom = {"nama","lokasi","fakultas","panjang","lebar","jumlah kursi","jumlah pintu","jumlah jendela",
                "jumlah steker","kondisi steker","posisi steker","jumlah lcd","kondisi lcd","posisi lcd","jumlah lampu",
                "kondisi lampu","posisi lampu","jumlah kipas","kondisi kipas","posisi kipas","jumlah ac","kondisi ac",
                "posisi ac","ssid","login","jumlah cctv","kondisi cctv","posisi cctv","kondisi lantai","kondisi dinding",
                "kondisi atap","kondisi pintu","kondisi jendela","kebisingan","bau","kebocoran","kerusakan","keausan",
                "kekokohan","kunci & jendela","bahaya"};
            DefaultTableModel dtm = new DefaultTableModel(null, kolom) {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            
            tbldata.setModel(dtm);
            atur(tbldata, new int []{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100});
            }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah" + e);
        }
    }
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        identitas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        cmbfakultas = new javax.swing.JComboBox();
        kondisi = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpanjang = new javax.swing.JTextField();
        txtlebar = new javax.swing.JTextField();
        txtjmlkursi = new javax.swing.JTextField();
        txtjmlpintu = new javax.swing.JTextField();
        txtjmljendela = new javax.swing.JTextField();
        data = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        cari = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtloka = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        steker = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbstekerdekatdosen = new javax.swing.JCheckBox();
        cbstekerpojokruang = new javax.swing.JCheckBox();
        cbstekerbelakang = new javax.swing.JCheckBox();
        cbstekerdekatmahasiswa = new javax.swing.JCheckBox();
        cbstekersamping = new javax.swing.JCheckBox();
        cbstekerlainnya = new javax.swing.JCheckBox();
        txtkondisisteker = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtjumlahsteker = new javax.swing.JTextField();
        txtposisisteker = new javax.swing.JTextField();
        lcd = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cblcddekatdosen = new javax.swing.JCheckBox();
        cblcdlainnya = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        txtjumlahlcd = new javax.swing.JTextField();
        txtlcdkondisi = new javax.swing.JTextField();
        txtposisilcd = new javax.swing.JTextField();
        lampu = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cblampuatap = new javax.swing.JCheckBox();
        cblampulainny = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtkondisilampu = new javax.swing.JTextField();
        txtjumlahlampu = new javax.swing.JTextField();
        txtposisilampu = new javax.swing.JTextField();
        kipas = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbkipasatap = new javax.swing.JCheckBox();
        cbkipaslainnya = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        txtjumlahkipas = new javax.swing.JTextField();
        txtkondisikipas = new javax.swing.JTextField();
        txtposisikipas = new javax.swing.JTextField();
        ac = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbacbelakang = new javax.swing.JCheckBox();
        cbacsamping = new javax.swing.JCheckBox();
        cbaclainnya = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        txtjumlahac = new javax.swing.JTextField();
        txtkondisiAC = new javax.swing.JTextField();
        txtposisiac = new javax.swing.JTextField();
        ssid = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbssidya = new javax.swing.JCheckBox();
        cbssidtidak = new javax.swing.JCheckBox();
        cmbssid = new javax.swing.JComboBox();
        txtlogin = new javax.swing.JTextField();
        cctv = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbcctvdepan = new javax.swing.JCheckBox();
        cbcctvlainnya = new javax.swing.JCheckBox();
        cbcctvbelakang = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        txtjumlahcctv = new javax.swing.JTextField();
        txtkondisicctv = new javax.swing.JTextField();
        txtposisicctv = new javax.swing.JTextField();
        keamanan = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        cbkokoh = new javax.swing.JCheckBox();
        cbrapuh = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        cbada = new javax.swing.JCheckBox();
        cbtidakada = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        cbbahaya = new javax.swing.JCheckBox();
        cbaman = new javax.swing.JCheckBox();
        kebersihan = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cblancar = new javax.swing.JCheckBox();
        cbtidaklancar = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        sldrpencahayaan = new javax.swing.JSlider();
        jLabel41 = new javax.swing.JLabel();
        sldrkelembapan = new javax.swing.JSlider();
        jLabel42 = new javax.swing.JLabel();
        sldrsuhu = new javax.swing.JSlider();
        p = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        s = new javax.swing.JTextField();
        kenyamanan = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        cbbising = new javax.swing.JCheckBox();
        cbtidakbising = new javax.swing.JCheckBox();
        jLabel45 = new javax.swing.JLabel();
        cbbau = new javax.swing.JCheckBox();
        cbtidakbau = new javax.swing.JCheckBox();
        cbbocor = new javax.swing.JCheckBox();
        cbtidakbocor = new javax.swing.JCheckBox();
        jLabel47 = new javax.swing.JLabel();
        cbrusak = new javax.swing.JCheckBox();
        cbbaik = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        cbaus = new javax.swing.JCheckBox();
        cbtidakaus = new javax.swing.JCheckBox();
        lingkungan = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        cblantaibersih = new javax.swing.JCheckBox();
        cblantaikotor = new javax.swing.JCheckBox();
        cbatapbersih = new javax.swing.JCheckBox();
        cbatapkotor = new javax.swing.JCheckBox();
        jLabel50 = new javax.swing.JLabel();
        cbdindingbersih = new javax.swing.JCheckBox();
        cbdindingkotor = new javax.swing.JCheckBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        cbjendelabersih = new javax.swing.JCheckBox();
        cbjendelakotor = new javax.swing.JCheckBox();
        jLabel53 = new javax.swing.JLabel();
        cbpintubersih = new javax.swing.JCheckBox();
        cbpintukotor = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btnnew = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnprev = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        jLabel46.setText("Kebocoran");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IDENTITAS RUANG");

        jLabel2.setText("Ruang Kelas");

        jLabel3.setText("Lokasi");

        jLabel4.setText("Fakultas");

        cmbfakultas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Fakultas", "aa", "Item 3", "Item 4" }));

        javax.swing.GroupLayout identitasLayout = new javax.swing.GroupLayout(identitas);
        identitas.setLayout(identitasLayout);
        identitasLayout.setHorizontalGroup(
            identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identitasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addGroup(identitasLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbfakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        identitasLayout.setVerticalGroup(
            identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identitasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(identitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbfakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel1.add(identitas, "card2");

        jLabel5.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KONDISI RUANG");

        jLabel6.setText("Panjang Ruang");

        jLabel7.setText("Lebar Ruang");

        jLabel8.setText("Jumlah Kursi");

        jLabel9.setText("Jumlah Pintu");

        jLabel10.setText("Jumlah Jendela");

        txtpanjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpanjangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kondisiLayout = new javax.swing.GroupLayout(kondisi);
        kondisi.setLayout(kondisiLayout);
        kondisiLayout.setHorizontalGroup(
            kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kondisiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(82, 82, 82)
                        .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpanjang, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(txtlebar)
                            .addComponent(txtjmlkursi)
                            .addComponent(txtjmlpintu)
                            .addComponent(txtjmljendela))
                        .addGap(0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kondisiLayout.setVerticalGroup(
            kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kondisiLayout.createSequentialGroup()
                .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addComponent(txtjmlkursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kondisiLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)))
                .addGroup(kondisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kondisiLayout.createSequentialGroup()
                        .addComponent(txtjmlpintu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtjmljendela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(76, Short.MAX_VALUE))))
        );

        jPanel1.add(kondisi, "card3");

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "nama", "lokasi", "fakultas", "panjang", "lebar", "jumlah kursi", "jumlah pintu", "jumlah jendela", "jumlah steker", "kondisi baik", "posisi steker", "jumlah LCD", "kondisi LCD", "posisi LCD", "jumlah lampu", "kondisi lampu", "posisi lampu", "jumlah kipas", "kondisi kipas", "posisi kipas", "jumlah ac", "kondisi ac", "posisi ac", "ssid", "login", "jumlah cctv", "kondisi cctv", "posisi cctv", "kondisi lantai", "kondisi lantai", "kondisi atap", "kondisi pintu", "kondisi jendela", "sirkulasi", "pencahayaan", "kelembapan", "suhu", "kebisingan", "bau", "kebocoran", "kerusakan", "keausan", "kekokohan", "kunci & jendela", "bahaya"
            }
        ));
        jScrollPane1.setViewportView(tbldata);

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataLayout = new javax.swing.GroupLayout(data);
        data.setLayout(dataLayout);
        dataLayout.setHorizontalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(dataLayout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(btndelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataLayout.setVerticalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btndelete)
                .addContainerGap())
        );

        jPanel1.add(data, "card4");

        jLabel12.setText("Nama");

        jLabel13.setText("Lokasi");

        btncari.setText("Cari");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "nama", "lokasi", "fakultas", "panjang"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout cariLayout = new javax.swing.GroupLayout(cari);
        cari.setLayout(cariLayout);
        cariLayout.setHorizontalGroup(
            cariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(36, 36, 36)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtloka, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btncari)
                .addContainerGap(89, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        cariLayout.setVerticalGroup(
            cariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cariLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(cariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtloka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(cari, "card7");

        jLabel11.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Kondisi Sarana");

        jLabel54.setText("Kondisi Steker");

        jLabel14.setText("Posisi Steker");

        cbstekerdekatdosen.setText("Dekat Dosen");
        cbstekerdekatdosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerdekatdosenActionPerformed(evt);
            }
        });

        cbstekerpojokruang.setText("Pojok Ruang");
        cbstekerpojokruang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerpojokruangActionPerformed(evt);
            }
        });

        cbstekerbelakang.setText("Belakang");
        cbstekerbelakang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerbelakangActionPerformed(evt);
            }
        });

        cbstekerdekatmahasiswa.setText("Dekat Mahasiswa");
        cbstekerdekatmahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerdekatmahasiswaActionPerformed(evt);
            }
        });

        cbstekersamping.setText("Samping");
        cbstekersamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekersampingActionPerformed(evt);
            }
        });

        cbstekerlainnya.setText("Lainnya");
        cbstekerlainnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerlainnyaActionPerformed(evt);
            }
        });

        jLabel20.setText("Jumlah Steker");

        javax.swing.GroupLayout stekerLayout = new javax.swing.GroupLayout(steker);
        steker.setLayout(stekerLayout);
        stekerLayout.setHorizontalGroup(
            stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addGroup(stekerLayout.createSequentialGroup()
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stekerLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(stekerLayout.createSequentialGroup()
                                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel20))
                                .addGap(63, 63, 63)
                                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtkondisisteker)
                                    .addComponent(txtjumlahsteker, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))))
                    .addGroup(stekerLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbstekerdekatdosen)
                            .addComponent(cbstekerbelakang)
                            .addComponent(cbstekersamping))
                        .addGap(25, 25, 25)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbstekerlainnya)
                            .addGroup(stekerLayout.createSequentialGroup()
                                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbstekerdekatmahasiswa)
                                    .addComponent(cbstekerpojokruang))
                                .addGap(18, 18, 18)
                                .addComponent(txtposisisteker)))))
                .addGap(31, 31, 31))
        );
        stekerLayout.setVerticalGroup(
            stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stekerLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtjumlahsteker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtkondisisteker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stekerLayout.createSequentialGroup()
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbstekerdekatdosen)
                            .addComponent(cbstekerpojokruang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbstekerbelakang)
                            .addComponent(cbstekerdekatmahasiswa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stekerLayout.createSequentialGroup()
                        .addComponent(txtposisisteker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstekersamping)
                    .addComponent(cbstekerlainnya))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(steker, "card8");

        jLabel17.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Analisis LCD");

        jLabel15.setText("Kondisi Baik LCD");

        jLabel16.setText("Posisi LCD");

        cblcddekatdosen.setText("Dekat Dosen");
        cblcddekatdosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblcddekatdosenActionPerformed(evt);
            }
        });

        cblcdlainnya.setText("Lainnya");

        jLabel21.setText("Jumlah LCD");

        javax.swing.GroupLayout lcdLayout = new javax.swing.GroupLayout(lcd);
        lcd.setLayout(lcdLayout);
        lcdLayout.setHorizontalGroup(
            lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addGroup(lcdLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lcdLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(73, 73, 73)
                        .addComponent(txtjumlahlcd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lcdLayout.createSequentialGroup()
                        .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lcdLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(cblcddekatdosen)
                                .addGap(33, 33, 33)
                                .addComponent(cblcdlainnya))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lcdLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlcdkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)))
                        .addComponent(txtposisilcd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        lcdLayout.setVerticalGroup(
            lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lcdLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtjumlahlcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtlcdkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cblcddekatdosen)
                    .addComponent(cblcdlainnya)
                    .addComponent(txtposisilcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.add(lcd, "card9");

        jLabel23.setText("Posisi");

        cblampuatap.setText("Atap Ruangan");
        cblampuatap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblampuatapActionPerformed(evt);
            }
        });

        cblampulainny.setText("Lainnya");
        cblampulainny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblampulainnyActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Kondisi Lampu");

        jLabel19.setText("Kondisi");

        jLabel22.setText("Jumlah Lampu");

        javax.swing.GroupLayout lampuLayout = new javax.swing.GroupLayout(lampu);
        lampu.setLayout(lampuLayout);
        lampuLayout.setHorizontalGroup(
            lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lampuLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(36, 36, 36)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lampuLayout.createSequentialGroup()
                        .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtkondisilampu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(txtjumlahlampu, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(252, Short.MAX_VALUE))
                    .addGroup(lampuLayout.createSequentialGroup()
                        .addComponent(cblampuatap)
                        .addGap(33, 33, 33)
                        .addComponent(cblampulainny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtposisilampu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        lampuLayout.setVerticalGroup(
            lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lampuLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtjumlahlampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(txtkondisilampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cblampuatap)
                    .addComponent(cblampulainny)
                    .addComponent(txtposisilampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel1.add(lampu, "card10");

        jLabel24.setText("Jumlah Kipas Angin");

        jLabel25.setText("Kondisi");

        jLabel26.setText("Posisi ");

        cbkipasatap.setText("Atap Ruangan");
        cbkipasatap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkipasatapActionPerformed(evt);
            }
        });

        cbkipaslainnya.setText("Lainnya");
        cbkipaslainnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkipaslainnyaActionPerformed(evt);
            }
        });

        jLabel55.setText("Jumlah Kipas");

        javax.swing.GroupLayout kipasLayout = new javax.swing.GroupLayout(kipas);
        kipas.setLayout(kipasLayout);
        kipasLayout.setHorizontalGroup(
            kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kipasLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel55))
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kipasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cbkipasatap)
                        .addGap(18, 18, 18)
                        .addComponent(cbkipaslainnya)
                        .addGap(28, 28, 28)
                        .addComponent(txtposisikipas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kipasLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtjumlahkipas, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(txtkondisikipas))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        kipasLayout.setVerticalGroup(
            kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kipasLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(68, 68, 68)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtjumlahkipas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtkondisikipas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbkipasatap)
                    .addComponent(cbkipaslainnya)
                    .addComponent(txtposisikipas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel1.add(kipas, "card11");

        jLabel27.setText("Jumlah AC");

        jLabel28.setText("Kondisi");

        jLabel29.setText("Posisi");

        cbacbelakang.setText("Belakang");
        cbacbelakang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbacbelakangActionPerformed(evt);
            }
        });

        cbacsamping.setText("Samping");
        cbacsamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbacsampingActionPerformed(evt);
            }
        });

        cbaclainnya.setText("Lainnya");
        cbaclainnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbaclainnyaActionPerformed(evt);
            }
        });

        jLabel56.setText("Jumlah AC");

        javax.swing.GroupLayout acLayout = new javax.swing.GroupLayout(ac);
        ac.setLayout(acLayout);
        acLayout.setHorizontalGroup(
            acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, acLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbaclainnya)
                .addGap(210, 210, 210))
            .addGroup(acLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(35, 35, 35)
                        .addComponent(txtjumlahac, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(acLayout.createSequentialGroup()
                        .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(acLayout.createSequentialGroup()
                                .addGap(41, 56, Short.MAX_VALUE)
                                .addComponent(cbacbelakang)
                                .addGap(36, 36, 36)
                                .addComponent(cbacsamping)
                                .addGap(18, 18, 18)
                                .addComponent(txtposisiac, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
                            .addGroup(acLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtkondisiAC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        acLayout.setVerticalGroup(
            acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtjumlahac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtkondisiAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cbacbelakang)
                    .addComponent(cbacsamping)
                    .addComponent(txtposisiac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbaclainnya)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel1.add(ac, "card12");

        jLabel30.setText("SSID");

        jLabel31.setText("Apakah Bisa Login?");

        cbssidya.setText("Ya");
        cbssidya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbssidyaActionPerformed(evt);
            }
        });

        cbssidtidak.setText("Tidak");
        cbssidtidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbssidtidakActionPerformed(evt);
            }
        });

        cmbssid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ssidLayout = new javax.swing.GroupLayout(ssid);
        ssid.setLayout(ssidLayout);
        ssidLayout.setHorizontalGroup(
            ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssidLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(45, 45, 45)
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ssidLayout.createSequentialGroup()
                        .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbssidtidak)
                            .addComponent(cbssidya))
                        .addGap(28, 28, 28)
                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        ssidLayout.setVerticalGroup(
            ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssidLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cmbssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ssidLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(cbssidya, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbssidtidak))
                    .addGroup(ssidLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel1.add(ssid, "card13");

        jLabel32.setText("Jumlah CCTV");

        jLabel33.setText("Kondisi");

        jLabel34.setText("Posisi");

        cbcctvdepan.setText("Depan");
        cbcctvdepan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcctvdepanActionPerformed(evt);
            }
        });

        cbcctvlainnya.setText("Lainnya");

        cbcctvbelakang.setText("Belakang");

        jLabel57.setText("Jumlah CCTV");

        javax.swing.GroupLayout cctvLayout = new javax.swing.GroupLayout(cctv);
        cctv.setLayout(cctvLayout);
        cctvLayout.setHorizontalGroup(
            cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cctvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbcctvlainnya)
                .addGap(174, 174, 174))
            .addGroup(cctvLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cctvLayout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(34, 34, 34)
                        .addComponent(txtjumlahcctv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cctvLayout.createSequentialGroup()
                        .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33))
                        .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cctvLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(cbcctvdepan)
                                .addGap(37, 37, 37)
                                .addComponent(cbcctvbelakang))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cctvLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtkondisicctv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)))
                        .addComponent(txtposisicctv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        cctvLayout.setVerticalGroup(
            cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cctvLayout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtjumlahcctv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtkondisicctv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cbcctvdepan)
                    .addComponent(cbcctvbelakang)
                    .addComponent(txtposisicctv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbcctvlainnya)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(cctv, "card14");

        jLabel35.setText("Kekokohan");

        cbkokoh.setText("Kokoh");

        cbrapuh.setText("Rapuh");

        jLabel36.setText("Kunci Pintu & Jendela");

        cbada.setText("Ada");

        cbtidakada.setText("Tidak Ada");

        jLabel37.setText("Bahaya");

        cbbahaya.setText("Bahaya");
        cbbahaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbahayaActionPerformed(evt);
            }
        });

        cbaman.setText("Aman");

        javax.swing.GroupLayout keamananLayout = new javax.swing.GroupLayout(keamanan);
        keamanan.setLayout(keamananLayout);
        keamananLayout.setHorizontalGroup(
            keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keamananLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(58, 58, 58)
                .addGroup(keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbaman)
                    .addComponent(cbbahaya)
                    .addComponent(cbtidakada)
                    .addComponent(cbada)
                    .addComponent(cbrapuh)
                    .addComponent(cbkokoh))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        keamananLayout.setVerticalGroup(
            keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keamananLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cbkokoh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbrapuh)
                .addGap(21, 21, 21)
                .addGroup(keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cbada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbtidakada)
                .addGap(18, 18, 18)
                .addGroup(keamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(cbbahaya, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbaman)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(keamanan, "card15");

        jLabel38.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Kebersihan Ruang Kelas");

        jLabel39.setText("Sirkulasi Udara");

        cblancar.setText("Lancar");
        cblancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblancarActionPerformed(evt);
            }
        });

        cbtidaklancar.setText("Tidak Lancar");

        jLabel40.setText("Pencahayaan");

        jLabel41.setText("Kelembapan");

        jLabel42.setText("Suhu");

        javax.swing.GroupLayout kebersihanLayout = new javax.swing.GroupLayout(kebersihan);
        kebersihan.setLayout(kebersihanLayout);
        kebersihanLayout.setHorizontalGroup(
            kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kebersihanLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kebersihanLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(115, 115, 115)
                        .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbtidaklancar)
                            .addComponent(cblancar)))
                    .addGroup(kebersihanLayout.createSequentialGroup()
                        .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42))
                        .addGap(63, 63, 63)
                        .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kebersihanLayout.createSequentialGroup()
                                .addComponent(sldrpencahayaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kebersihanLayout.createSequentialGroup()
                                .addComponent(sldrsuhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(kebersihanLayout.createSequentialGroup()
                                .addComponent(sldrkelembapan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        kebersihanLayout.setVerticalGroup(
            kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kebersihanLayout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(cblancar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbtidaklancar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldrpencahayaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldrkelembapan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kebersihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sldrsuhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1.add(kebersihan, "card7");

        jLabel43.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Kenyamanan Ruang Kelas");

        jLabel44.setText("Kebisingan");

        cbbising.setText("Bising");

        cbtidakbising.setText("Tidak Bising");

        jLabel45.setText("Bau");

        cbbau.setText("Iya");
        cbbau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbauActionPerformed(evt);
            }
        });

        cbtidakbau.setText("Tidak");

        cbbocor.setText("Bocor");
        cbbocor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbocorActionPerformed(evt);
            }
        });

        cbtidakbocor.setText("Tidak Bocor");

        jLabel47.setText("Kerusakan");

        cbrusak.setText("Rusak");

        cbbaik.setText("Baik");

        jLabel48.setText("Keausan");

        cbaus.setText("Aus");
        cbaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbausActionPerformed(evt);
            }
        });

        cbtidakaus.setText("Tidak Aus");

        javax.swing.GroupLayout kenyamananLayout = new javax.swing.GroupLayout(kenyamanan);
        kenyamanan.setLayout(kenyamananLayout);
        kenyamananLayout.setHorizontalGroup(
            kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kenyamananLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addGap(68, 68, 68)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbising)
                    .addComponent(cbbau)
                    .addComponent(cbbocor)
                    .addComponent(cbrusak)
                    .addComponent(cbaus))
                .addGap(31, 31, 31)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbtidakaus)
                    .addComponent(cbbaik)
                    .addComponent(cbtidakbocor)
                    .addComponent(cbtidakbau)
                    .addComponent(cbtidakbising))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        kenyamananLayout.setVerticalGroup(
            kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kenyamananLayout.createSequentialGroup()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(cbbising)
                    .addComponent(cbtidakbising))
                .addGap(8, 8, 8)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(cbbau)
                    .addComponent(cbtidakbau))
                .addGap(8, 8, 8)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbocor)
                    .addComponent(cbtidakbocor))
                .addGap(9, 9, 9)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbrusak)
                    .addComponent(jLabel47)
                    .addComponent(cbbaik))
                .addGap(8, 8, 8)
                .addGroup(kenyamananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(cbaus)
                    .addComponent(cbtidakaus))
                .addGap(0, 58, Short.MAX_VALUE))
        );

        jPanel1.add(kenyamanan, "card8");

        jLabel49.setText("Lantai");

        cblantaibersih.setText("Bersih");
        cblantaibersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblantaibersihActionPerformed(evt);
            }
        });

        cblantaikotor.setText("Kotor");
        cblantaikotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblantaikotorActionPerformed(evt);
            }
        });

        cbatapbersih.setText("Bersih");
        cbatapbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbatapbersihActionPerformed(evt);
            }
        });

        cbatapkotor.setText("Kotor");
        cbatapkotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbatapkotorActionPerformed(evt);
            }
        });

        jLabel50.setText("Dinding");

        cbdindingbersih.setText("Bersih");
        cbdindingbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdindingbersihActionPerformed(evt);
            }
        });

        cbdindingkotor.setText("Kotor");
        cbdindingkotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdindingkotorActionPerformed(evt);
            }
        });

        jLabel51.setText("Atap");

        jLabel52.setText("Jendela");

        cbjendelabersih.setText("Bersih");
        cbjendelabersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjendelabersihActionPerformed(evt);
            }
        });

        cbjendelakotor.setText("Kotor");
        cbjendelakotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjendelakotorActionPerformed(evt);
            }
        });

        jLabel53.setText("Pintu");

        cbpintubersih.setText("Bersih");
        cbpintubersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpintubersihActionPerformed(evt);
            }
        });

        cbpintukotor.setText("Kotor");
        cbpintukotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpintukotorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lingkunganLayout = new javax.swing.GroupLayout(lingkungan);
        lingkungan.setLayout(lingkunganLayout);
        lingkunganLayout.setHorizontalGroup(
            lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lingkunganLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lingkunganLayout.createSequentialGroup()
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lingkunganLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(lingkunganLayout.createSequentialGroup()
                                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cblantaibersih)
                                    .addComponent(cblantaikotor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lingkunganLayout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addGap(107, 107, 107))
                                    .addGroup(lingkunganLayout.createSequentialGroup()
                                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbdindingbersih)
                                            .addComponent(cbdindingkotor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbatapbersih)
                            .addComponent(cbatapkotor)
                            .addComponent(jLabel51))
                        .addGap(90, 90, 90))
                    .addGroup(lingkunganLayout.createSequentialGroup()
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbjendelakotor)
                            .addComponent(cbjendelabersih))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbpintubersih)
                            .addComponent(cbpintukotor))
                        .addGap(84, 84, 84))
                    .addGroup(lingkunganLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53)
                        .addGap(115, 115, 115))))
        );
        lingkunganLayout.setVerticalGroup(
            lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lingkunganLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel51))
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lingkunganLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cblantaibersih)
                            .addComponent(cbatapbersih))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cblantaikotor)
                            .addComponent(cbatapkotor)))
                    .addGroup(lingkunganLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbdindingbersih)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbdindingkotor)
                .addGap(12, 12, 12)
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbjendelabersih)
                    .addComponent(cbpintubersih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lingkunganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbjendelakotor)
                    .addComponent(cbpintukotor))
                .addContainerGap())
        );

        jPanel1.add(lingkungan, "card16");

        btnnew.setText("Baru");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnprev.setText("Back");
        btnprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevActionPerformed(evt);
            }
        });

        jButton1.setText("view");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnprev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnnext)
                .addGap(145, 145, 145)
                .addComponent(btnnew)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnew)
                    .addComponent(btnnext)
                    .addComponent(btnprev)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed

        if (identitas.isShowing() && !txtnama.getText().equalsIgnoreCase("") && (!txtlokasi.getText().equalsIgnoreCase("") && (!cmbfakultas.getSelectedItem().equals("Pilih Fakultas")))) {
            panel();
            kondisi.setVisible(true);
        } else if (kondisi.isShowing()) {
            panel();
            steker.setVisible(true);
        } else if (steker.isShowing()) {
            panel();
            lcd.setVisible(true);
        } else if (lcd.isShowing()) {
            panel();
            lampu.setVisible(true);
        } else if (lampu.isShowing()) {
            panel();
            kipas.setVisible(true);
        } else if (kipas.isShowing()) {
            panel();
            ac.setVisible(true);
        } else if (ac.isShowing()) {
            panel();
            ssid.setVisible(true);
        } else if (ssid.isShowing()) {
            panel();
            cctv.setVisible(true);
        } else if (cctv.isShowing()) {
            panel();
            lingkungan.setVisible(true);
        }else if(lingkungan.isShowing()){
            panel();
                    kebersihan.setVisible(true);
                }
        else if(kebersihan.isShowing()){
            panel();
                    kenyamanan.setVisible(true);
                }
                else if(kenyamanan.isShowing()){
                 panel();
                    keamanan.setVisible(true); 
                }
        else {
            JOptionPane.showMessageDialog(null, "Data Belom Terisi,, Silahkan lengkapin Data !!!");
        }


    }//GEN-LAST:event_btnnextActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        if(cblancar.isSelected())
            sirkulasi+="Lancar";
        if(cbtidaklancar.isSelected())
            sirkulasi+="Tidak Lancar";
        if(cbssidya.isSelected())
            login+="Bisa Login";
        if(cbssidtidak.isSelected())
            login+="Tidak Bisa Login";
        if(cblantaibersih.isSelected())
            lantai+="Bersih";
        if(cblantaikotor.isSelected())
            lantai+="Kotor";
        if(cbdindingbersih.isSelected())
            dinding+="Bersih";
        if(cbatapbersih.isSelected())
            atap+="Bersih";
        if(cbatapkotor.isSelected())
            atap+="Kotor";
        if(cbpintubersih.isSelected())
            pintu+="Bersih";
        if(cbpintukotor.isSelected())
            pintu+="Kotor";
        if(cbjendelabersih.isSelected())
            jendela+="Bersih";
        if(cbjendelakotor.isSelected())
            jendela+="Kotor";
        if(cbbising.isSelected())
            kebisingan+="Bising";
        if(cbtidakbising.isSelected())
            kebisingan+="Tidak Bising";
        if(cbbau.isSelected())
            bau+="Bau";
        if(cbtidakbau.isSelected())
            bau+="Tidak Bau";
        if(cbbocor.isSelected())
            kebocoran+="Bocor";
        if(cbtidakbocor.isSelected())
            kebocoran+="Tidak Bocor";
        if(cbrusak.isSelected())
            kerusakan+="Rusak";
//        if(cbacbaik.isSelected())
//            kerusakan+="Baik";
        if(cbaus.isSelected())
            keausan+="Aus";
        if(cbtidakaus.isSelected())
            keausan+="Tidak Aus";
        if(cbkokoh.isSelected())
            kekokohan+="Kokoh";
        if(cbrapuh.isSelected())
            kekokohan+="Rapuh";
        if(cbada.isSelected())
            kuncijendela+="Ada";
        if(cbtidakada.isSelected())
            kuncijendela+="Tidak Ada";
        if(cbbahaya.isSelected())
            aman+="Bahaya";
        if(cbaman.isSelected())
            aman+="Aman";
        // String posisi_steker="";
        identitas.setVisible(true);
        btnnext.setEnabled(true);
        btnprev.setEnabled(true);
        identitas.setVisible(false);
        steker.setVisible(false);
        lampu.setVisible(false);
        ac.setVisible(false);
        lcd.setVisible(false);
        kipas.setVisible(false);
        cctv.setVisible(false);
        kebersihan.setVisible(false);
        kenyamanan.setVisible(false);
        ssid.setVisible(false);
        keamanan.setVisible(false);
        lingkungan.setVisible(false);
        data.setVisible(false);
        if (btnnew.getText().equals("Baru")) {
            txtnama.setText("");
            txtlokasi.setText("");
            cmbfakultas.setSelectedItem("");
            txtpanjang.setText("");
            txtlebar.setText("");
            txtjmlkursi.setText("");
            txtjmlpintu.setText("");
            txtjmljendela.setText("");
            txtnama.setEditable(true);
            txtlokasi.setEditable(true);
            cmbfakultas.setEditable(true);
            txtpanjang.setEditable(true);
            txtlebar.setEditable(true);
            txtjmlkursi.setEditable(true);
            txtjmlpintu.setEditable(true);
            txtjmljendela.setEditable(true);
            txtnama.requestFocus();
            btnnew.setText("Simpan");
        } else {
            if (!txtnama.getText().equals("") && !txtlokasi.getText().equals("") && !cmbfakultas.getSelectedItem().equals("Pilih Fakultas")
                    && !txtpanjang.getText().equals("") && !txtlebar.getText().equals("") && !txtjmlkursi.getText().equals("")
                    && !txtjmlpintu.getText().equals("") && !txtjmljendela.getText().equals("")) {
                connect c = new connect(); //buka koneksi 
                ruang m= new ruang();
                m.setNama_ruang(txtnama.getText());
                m.setLokasi_ruang(txtlokasi.getText());
                m.setFakultas((String) cmbfakultas.getSelectedItem());
                m.setPanjang_ruang(Integer.parseInt(txtpanjang.getText()));
                m.setLebar_ruang(Integer.parseInt(txtlebar.getText()));
                m.setJumlah_kursi(Integer.parseInt(txtjmlkursi.getText()));
                m.setJumlah_pintu(Integer.parseInt(txtjmlpintu.getText()));
                m.setJumlah_jendela(Integer.parseInt(txtjmljendela.getText()));
                m.setJumlah_steker(Integer.parseInt(txtjumlahsteker.getText()));
                m.setJumlah_baik_steker(Integer.parseInt(txtkondisisteker.getText()));
                m.setPosisi_steker(txtposisisteker.getText());
                m.setJumlah_kabel_LCD(Integer.parseInt(txtjumlahlcd.getText()));
                m.setJumlah_baik_lcd(Integer.parseInt(txtlcdkondisi.getText()));
                m.setPosisi_kabel_LCD(txtposisilcd.getText());
                m.setJumlah_lampu(Integer.parseInt(txtjumlahlampu.getText()));
                m.setJumlah_baik_lampu(Integer.parseInt(txtkondisilampu.getText()));
                m.setPosisi_lampu(txtposisilampu.getText());
                m.setJumlah_kipas_angin(Integer.parseInt(txtjumlahkipas.getText()));
                m.setJumlah_baik_kipas(Integer.parseInt(txtkondisikipas.getText()));
                m.setPosisi_kipas_angin(txtposisikipas.getText());
                m.setJumlah_AC(Integer.parseInt(txtjumlahac.getText()));
                m.setJumlah_baik_ac(Integer.parseInt(txtkondisiAC.getText()));
                m.setPosisi_AC(txtposisiac.getText());
                m.setSSID((String) cmbssid.getSelectedItem());
                m.setBandwidth(login);
                m.setJumlah_CCTV(Integer.parseInt(txtjumlahcctv.getText()));
                m.setJumlah_baik_cctv(Integer.parseInt(txtkondisicctv.getText()));
                m.setPosisi_CCTV(txtposisicctv.getText());
                m.setKondisi_lantai(lantai);
                m.setKondisi_dinding(dinding);
                m.setKondisi_atap(atap);
                m.setKondisi_pintu(pintu);
                m.setKondisi_jendela(jendela);
                m.setSirkulasi_udara(sirkulasi);
                m.setPencahayaan(Integer.parseInt(p.getText()));
                m.setKelembapan(Integer.parseInt(k.getText()));
                m.setSuhu(Integer.parseInt(s.getText()));
                m.setKebisingan(kebisingan);
                m.setBau(bau);
                m.setKebocoran(kebocoran);
                m.setKerusakan(kerusakan);
                m.setKeausan(keausan);
                m.setKekokohan(kekokohan);
                m.setKunci_jendela(kuncijendela);
                m.setBahaya(aman);
                if (c.Insert(m) > 0) {
                    loadData();
                    currentRow = ab.size() - 1;
                    bindData();
                    kondisi.setVisible(false);
                    identitas.setVisible(false);
                    steker.setVisible(false);
                    lampu.setVisible(false);
                    ac.setVisible(false);
                    lcd.setVisible(false);
                    kipas.setVisible(false);
                    cctv.setVisible(false);
                    kebersihan.setVisible(false);
                    kenyamanan.setVisible(false);
                    ssid.setVisible(false);
                    keamanan.setVisible(false);
                    lingkungan.setVisible(false);
                    data.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
                txtnama.setEditable(false);
                txtlokasi.setEditable(false);
                cmbfakultas.setEditable(false);
                txtpanjang.setEditable(false);
                txtlebar.setEditable(false);
                txtjmlkursi.setEditable(false);
                txtjmlpintu.setEditable(false);
                txtjmljendela.setEditable(false);
                btnnew.setText("Baru");
                c.closeConnection(); //tutup koneksi 
            } else {
                JOptionPane.showMessageDialog(this, "Mohon isi data dengan benar", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        tampilkandata();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed
if(kondisi.isShowing()){
    panel();
    identitas.setVisible(true);
}
else if(lcd.isShowing()){
    panel();
    kondisi.setVisible(true);
}else if(lampu.isShowing()){
    panel();
    lcd.setVisible(true);
}else if(kipas.isShowing()){
    panel();
    lampu.setVisible(true);
}else if(ac.isShowing()){
    panel();
    kipas.setVisible(true);
}else if(ssid.isShowing()){
    panel();
    ac.setVisible(true);
}else if(cctv.isShowing()){
    panel();
    ssid.setVisible(true);
}else if(lingkungan.isShowing()){
    panel();
    cctv.setVisible(true);
}else if(kebersihan.isShowing()){
    panel();
    lingkungan.setVisible(true);
}else if(kenyamanan.isShowing()){
    panel();
    kebersihan.setVisible(true);
}else if(keamanan.isShowing()){
    panel();
    kenyamanan.setVisible(true);
}
    }//GEN-LAST:event_btnprevActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data.setVisible(true);
        btnnext.setEnabled(false);
        btnprev.setEnabled(false);
        identitas.setVisible(false);
        kondisi.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cblancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblancarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cblancarActionPerformed

    private void cbbauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbauActionPerformed

    private void cbbocorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbocorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbocorActionPerformed

    private void cbausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbausActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbausActionPerformed

    private void txtpanjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpanjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpanjangActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        try {
            koneksi();
            ruang ru=new ruang();
            String sql= "delete from datafull where nama_ruang='" + txtnama.getText()+ "'";
            cn.executeUpdate(sql);
            conn.close();
            tampilkandata();
            bindData();
            JOptionPane.showMessageDialog(null, "berhasil hapus data");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal");
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void cblampulainnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblampulainnyActionPerformed
        // TODO add your handling code here:
        txtposisilampu.setText("Lainnya");
        cblampuatap.setSelected(false);
    }//GEN-LAST:event_cblampulainnyActionPerformed

    private void cbkipasatapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkipasatapActionPerformed
        cbkipaslainnya.setSelected(false);
        txtposisikipas.setText("Atap Ruangan");
    }//GEN-LAST:event_cbkipasatapActionPerformed

    private void cbacbelakangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbacbelakangActionPerformed
        txtposisiac.setText("Belakang");
        cbacsamping.setSelected(false);
        cbaclainnya.setSelected(false);
        
    }//GEN-LAST:event_cbacbelakangActionPerformed

    private void cbkipaslainnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkipaslainnyaActionPerformed
        cbkipasatap.setSelected(false);
        txtposisikipas.setText("Lainnya");
    }//GEN-LAST:event_cbkipaslainnyaActionPerformed

    private void cbbahayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbahayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbahayaActionPerformed

    private void cbdindingkotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdindingkotorActionPerformed
        cbdindingbersih.setSelected(false);
    }//GEN-LAST:event_cbdindingkotorActionPerformed

    private void cbpintubersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpintubersihActionPerformed
        cbpintukotor.setSelected(false);
    }//GEN-LAST:event_cbpintubersihActionPerformed

    private void cblantaibersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblantaibersihActionPerformed
        cblantaikotor.setSelected(false);
    }//GEN-LAST:event_cblantaibersihActionPerformed

    private void cblantaikotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblantaikotorActionPerformed
        cblantaibersih.setSelected(false);
    }//GEN-LAST:event_cblantaikotorActionPerformed

    private void cbdindingbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdindingbersihActionPerformed
        cbdindingkotor.setSelected(false);
    }//GEN-LAST:event_cbdindingbersihActionPerformed

    private void cbatapbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbatapbersihActionPerformed
        cbatapkotor.setSelected(false);
    }//GEN-LAST:event_cbatapbersihActionPerformed

    private void cbatapkotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbatapkotorActionPerformed
        cbatapbersih.setSelected(false);
    }//GEN-LAST:event_cbatapkotorActionPerformed

    private void cbjendelabersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjendelabersihActionPerformed
        cbjendelakotor.setSelected(false);
    }//GEN-LAST:event_cbjendelabersihActionPerformed

    private void cbjendelakotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjendelakotorActionPerformed
        cbjendelabersih.setSelected(false);
    }//GEN-LAST:event_cbjendelakotorActionPerformed

    private void cbpintukotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpintukotorActionPerformed
        cbpintubersih.setSelected(false);
    }//GEN-LAST:event_cbpintukotorActionPerformed

    private void cbstekerpojokruangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerpojokruangActionPerformed
        txtposisisteker.setText("Pojok Ruang");
        cbstekerbelakang.setSelected(false);
        cbstekersamping.setSelected(false);
        cbstekerdekatmahasiswa.setSelected(false);
        cbstekerlainnya.setSelected(false);
        cbstekerdekatdosen.setSelected(false);
    }//GEN-LAST:event_cbstekerpojokruangActionPerformed

    private void cbstekersampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekersampingActionPerformed
        txtposisisteker.setText("Samping");
        cbstekerpojokruang.setSelected(false);
        cbstekerdekatmahasiswa.setSelected(false);
        cbstekerbelakang.setSelected(false);
        cbstekerlainnya.setSelected(false);
        cbstekerdekatdosen.setSelected(false);
    }//GEN-LAST:event_cbstekersampingActionPerformed

    private void cbacsampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbacsampingActionPerformed
        cbacbelakang.setSelected(false);
        cbaclainnya.setSelected(false);
        txtposisiac.setText("Samping");
    }//GEN-LAST:event_cbacsampingActionPerformed

    private void cbstekerdekatdosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerdekatdosenActionPerformed
        // TODO add your handling code here:
        txtposisisteker.setText("Dekat Dosen");
        cbstekerbelakang.setSelected(false);
        cbstekersamping.setSelected(false);
        cbstekerdekatmahasiswa.setSelected(false);
        cbstekerlainnya.setSelected(false);
        cbstekerpojokruang.setSelected(false);
    }//GEN-LAST:event_cbstekerdekatdosenActionPerformed

    private void cbstekerbelakangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerbelakangActionPerformed
        txtposisisteker.setText("Belakang");
        cbstekerpojokruang.setSelected(false);
        cbstekersamping.setSelected(false);
        cbstekerdekatmahasiswa.setSelected(false);
        cbstekerlainnya.setSelected(false);
        cbstekerdekatdosen.setSelected(false);
    }//GEN-LAST:event_cbstekerbelakangActionPerformed

    private void cbstekerdekatmahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerdekatmahasiswaActionPerformed
        txtposisisteker.setText("Dekat Mahasiswa");
        cbstekerpojokruang.setSelected(false);
        cbstekersamping.setSelected(false);
        cbstekerbelakang.setSelected(false);
        cbstekerlainnya.setSelected(false);
        cbstekerdekatdosen.setSelected(false);
    }//GEN-LAST:event_cbstekerdekatmahasiswaActionPerformed

    private void cbstekerlainnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerlainnyaActionPerformed
        cbstekerpojokruang.setSelected(false);
        cbstekerdekatmahasiswa.setSelected(false);
        cbstekerbelakang.setSelected(false);
        cbstekersamping.setSelected(false);
        cbstekerdekatdosen.setSelected(false);
    }//GEN-LAST:event_cbstekerlainnyaActionPerformed

    private void cblcddekatdosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblcddekatdosenActionPerformed
        // TODO add your handling code here:
        txtposisilcd.setText("Dekat Dosen");
        cblcdlainnya.setSelected(false);
    }//GEN-LAST:event_cblcddekatdosenActionPerformed

    private void cblampuatapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblampuatapActionPerformed
        txtposisilampu.setText("Atap");
        cblampulainny.setSelected(false);
    }//GEN-LAST:event_cblampuatapActionPerformed

    private void cbaclainnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbaclainnyaActionPerformed
        // TODO add your handling code here:
        txtposisiac.setText("Lainnya");
        cbacbelakang.setSelected(false);
        cbacsamping.setSelected(false);
    }//GEN-LAST:event_cbaclainnyaActionPerformed

    private void cbcctvdepanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcctvdepanActionPerformed
        // TODO add your handling code here:
        txtposisicctv.setText("Depan");
        
    }//GEN-LAST:event_cbcctvdepanActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void cbssidyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbssidyaActionPerformed
        txtlogin.setText("Bisa Login");
        cbssidtidak.setSelected(false);
    }//GEN-LAST:event_cbssidyaActionPerformed

    private void cbssidtidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbssidtidakActionPerformed
        txtlogin.setText("Tidak Bisa Login");
        cbssidya.setSelected(false);
    }//GEN-LAST:event_cbssidtidakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(datafull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datafull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datafull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datafull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datafull().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ac;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprev;
    private javax.swing.JPanel cari;
    private javax.swing.JCheckBox cbacbelakang;
    private javax.swing.JCheckBox cbaclainnya;
    private javax.swing.JCheckBox cbacsamping;
    private javax.swing.JCheckBox cbada;
    private javax.swing.JCheckBox cbaman;
    private javax.swing.JCheckBox cbatapbersih;
    private javax.swing.JCheckBox cbatapkotor;
    private javax.swing.JCheckBox cbaus;
    private javax.swing.JCheckBox cbbahaya;
    private javax.swing.JCheckBox cbbaik;
    private javax.swing.JCheckBox cbbau;
    private javax.swing.JCheckBox cbbising;
    private javax.swing.JCheckBox cbbocor;
    private javax.swing.JCheckBox cbcctvbelakang;
    private javax.swing.JCheckBox cbcctvdepan;
    private javax.swing.JCheckBox cbcctvlainnya;
    private javax.swing.JCheckBox cbdindingbersih;
    private javax.swing.JCheckBox cbdindingkotor;
    private javax.swing.JCheckBox cbjendelabersih;
    private javax.swing.JCheckBox cbjendelakotor;
    private javax.swing.JCheckBox cbkipasatap;
    private javax.swing.JCheckBox cbkipaslainnya;
    private javax.swing.JCheckBox cbkokoh;
    private javax.swing.JCheckBox cblampuatap;
    private javax.swing.JCheckBox cblampulainny;
    private javax.swing.JCheckBox cblancar;
    private javax.swing.JCheckBox cblantaibersih;
    private javax.swing.JCheckBox cblantaikotor;
    private javax.swing.JCheckBox cblcddekatdosen;
    private javax.swing.JCheckBox cblcdlainnya;
    private javax.swing.JCheckBox cbpintubersih;
    private javax.swing.JCheckBox cbpintukotor;
    private javax.swing.JCheckBox cbrapuh;
    private javax.swing.JCheckBox cbrusak;
    private javax.swing.JCheckBox cbssidtidak;
    private javax.swing.JCheckBox cbssidya;
    private javax.swing.JCheckBox cbstekerbelakang;
    private javax.swing.JCheckBox cbstekerdekatdosen;
    private javax.swing.JCheckBox cbstekerdekatmahasiswa;
    private javax.swing.JCheckBox cbstekerlainnya;
    private javax.swing.JCheckBox cbstekerpojokruang;
    private javax.swing.JCheckBox cbstekersamping;
    private javax.swing.JCheckBox cbtidakada;
    private javax.swing.JCheckBox cbtidakaus;
    private javax.swing.JCheckBox cbtidakbau;
    private javax.swing.JCheckBox cbtidakbising;
    private javax.swing.JCheckBox cbtidakbocor;
    private javax.swing.JCheckBox cbtidaklancar;
    private javax.swing.JPanel cctv;
    private javax.swing.JComboBox cmbfakultas;
    private javax.swing.JComboBox cmbssid;
    private javax.swing.JPanel data;
    static javax.swing.JPanel identitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField k;
    private javax.swing.JPanel keamanan;
    private javax.swing.JPanel kebersihan;
    private javax.swing.JPanel kenyamanan;
    private javax.swing.JPanel kipas;
    static javax.swing.JPanel kondisi;
    private javax.swing.JPanel lampu;
    private javax.swing.JPanel lcd;
    static javax.swing.JPanel lingkungan;
    private javax.swing.JTextField p;
    private javax.swing.JTextField s;
    private javax.swing.JSlider sldrkelembapan;
    private javax.swing.JSlider sldrpencahayaan;
    private javax.swing.JSlider sldrsuhu;
    private javax.swing.JPanel ssid;
    static javax.swing.JPanel steker;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtjmljendela;
    private javax.swing.JTextField txtjmlkursi;
    private javax.swing.JTextField txtjmlpintu;
    private javax.swing.JTextField txtjumlahac;
    private javax.swing.JTextField txtjumlahcctv;
    private javax.swing.JTextField txtjumlahkipas;
    private javax.swing.JTextField txtjumlahlampu;
    private javax.swing.JTextField txtjumlahlcd;
    private javax.swing.JTextField txtjumlahsteker;
    private javax.swing.JTextField txtkondisiAC;
    private javax.swing.JTextField txtkondisicctv;
    private javax.swing.JTextField txtkondisikipas;
    private javax.swing.JTextField txtkondisilampu;
    private javax.swing.JTextField txtkondisisteker;
    private javax.swing.JTextField txtlcdkondisi;
    private javax.swing.JTextField txtlebar;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtloka;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpanjang;
    private javax.swing.JTextField txtposisiac;
    private javax.swing.JTextField txtposisicctv;
    private javax.swing.JTextField txtposisikipas;
    private javax.swing.JTextField txtposisilampu;
    private javax.swing.JTextField txtposisilcd;
    private javax.swing.JTextField txtposisisteker;
    // End of variables declaration//GEN-END:variables

    //private static class ChangeListener implements javax.swing.event.ChangeListener {

    
}
