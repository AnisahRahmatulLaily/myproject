/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruang;
import com.sun.org.apache.xml.internal.dtm.DTM;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
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

    List<ruang> ab = new ArrayList<ruang>();
    int currentRow = 0;
    int jumlahsteker = 0, jumlahlampu = 0, jumlahlcd = 0, jumlahkipas = 0, jumlahac = 0,jumlahcctv=0;
    int stekerbaik = 0, lampubaik = 0, lcdbaik = 0, acbaik = 0, kipasbaik = 0,cctvbaik=0;
    int posisisteker = 0, posisilampu = 0, posisilcd = 0, posisiac = 0, posisikipas = 0,posisicctv=0;
    String login ="",lantai="",dinding="",atap="",pintu="",jendela="",kebisingan="",bau="",kebocoran="",kerusakan="",keausan="",kekokohan="",kuncijendela="",aman="";

    /**
     * Creates new form datafull
     */
    public datafull() {
        initComponents();
        //tampildata();
        //init();
        //ScrollDemo();
        //run();
        slider1();
        loadData();
        jumlah();
        kondisibaik();
        posisi();
        slider2();
        slider3();
        //atur(tbldata, lebar);
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
	                    p.setText ( String.valueOf(sldrkelembapan.getValue()) );	
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
	                    p.setText ( String.valueOf(sldrsuhu.getValue()) );	
                        }	
	            }
	        );
    }
    private void kondisibaik() {
        if (cbstekerbaik.isSelected()) {
            stekerbaik++;
        } else if (cblcdbaik.isSelected()) {
            lcdbaik++;
        } else if (cbacbaik.isSelected()) {
            acbaik++;
        } else if (cbkipasbaik.isSelected()) {
            kipasbaik++;
        }else if(cbcctvbaik.isSelected()){
            cctvbaik++;
        }
    }
    private void jumlah() {
        if (isCursorSet()) {
            jumlahsteker++;
            cbstekerbaik.setSelected(false);
            cbstekerbelakang.setSelected(false);
            cbstekerburuk.setSelected(false);
            cbstekerdekatdosen.setSelected(false);
            cbstekerdekatmahasiswa.setSelected(false);
            cbstekerlainnya.setSelected(false);
            cbstekerpojokruang.setSelected(false);
            cbstekersamping.setSelected(false);
        } else if (isCursorSet()) {
            jumlahlcd++;
            cblcdbaik.setSelected(false);
            cblcddekatdosen.setSelected(false);
            cblcdlainnya.setSelected(false);
            cblcdrusak.setSelected(false);
        }else if(isCursorSet()){
            jumlahlampu++;
            cblampuatap.setSelected(false);
            cblampubaik.setSelected(false);
            cblampulainny.setSelected(false);
            cblampurusak.setSelected(false);
        }else if(isCursorSet()){
            jumlahkipas++;
            cbkipasatap.setSelected(false);
            cbkipasbaik.setSelected(false);
            cbkipaslainnya.setSelected(false);
            cbkipasrusa.setSelected(false);
        }else if(isCursorSet()){
            jumlahac++;
            cbacbaik.setSelected(false);
            cbacbelakang.setSelected(false);
            cbaclainnya.setSelected(false);
            cbacrusak.setSelected(false);
            cbacsamping.setSelected(false);
        }else if(isCursorSet()){
            jumlahcctv++;
            cbcctvbaik.setSelected(false);
            cbcctvbelakang.setSelected(false);
            cbcctvdepan.setSelected(false);
            cbcctvlainnya.setSelected(false);
            cbcctvrusak.setSelected(false);
        }
       
    }

    private void posisi() {
        if (cbstekerbelakang.isSelected() 
//                || cbstekerdekatdosen.isSelected() || cbstekerdekatmahasiswa.isSelected() || cbstekerpojokruang.isSelected() || cbstekersamping.isSelected()
                ) {
            posisisteker++;
        }else if(cblcddekatdosen.isSelected()){
            posisilcd++;
        }else if(cblampuatap.isSelected()){
            posisilampu++;
            
        }else if(cbcctvbelakang.isSelected()||cbcctvdepan.isSelected()){
            posisicctv++;
        }else if(cbacbelakang.isSelected()||cbacsamping.isSelected()){
            posisiac++;
        }else if (cbkipasatap.isSelected()){
            posisikipas++;
        }}
//         private void run ()
//            {
//                JFrame frame = new JFrame("panel demo");
//                frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
//
//                JPanel panel = new JPanel();
//              data c = frame.getContentPane();
//                panel.setSize(100,100);
//                panel.setLayout(new GridLayout(1000,1));
//                for(int i = 0; i<1000;i++)
//                panel.add(new JLabel("JLabel "+i));
//
//                JScrollPane jsp = new JScrollPane(panel);
//                c.add(jsp);
//                frame.setSize(100,100);
//                frame.setVisible(true);
//            }
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
//        tabel.addColumn("sirkulasi");
//        tabel.addColumn("pencahayaan");
//        tabel.addColumn("kelembapan");
//        tabel.addColumn("suhu");
        tabel.addColumn("kebisingan");
        //tabel.addColumn("sirkulasi");
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
                    res.getString(38), res.getString(39), res.getString(40),res.getString(41)});
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
//    private void atur(JTable lihat, int lebar[]){
//        try{
//            lihat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//            int banyak=lihat.getColumnCount();
//            for(int i=0;i<banyak;i++){
//                TableColumn kolom = lihat.getColumnModel().getColumn(i);
//                kolom.setPreferredWidth(lebar[i]);
//                lihat.setRowHeight(20);
//                
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Salah"+e);
//        }
//    }
//    private void tampildata(){
//        try{
//            String [] kolom={"nama","lokasi","fakultas","panjang","lebar","jumlah kursi","jumlah pintu","jumlah jendela",
//                "jumlah steker","kondisi steker","posisi steker","jumlah lcd","kondisi lcd","posisi lcd","jumlah lampu",
//                "kondisi lampu","posisi lampu","jumlah kipas","kondisi kipas","posisi kipas","jumlah ac","kondisi ac",
//                "posisi ac","ssid","login","jumlah cctv","kondisi cctv","posisi cctv","kondisi lantai","kondisi dinding",
//                "kondisi atap","kondisi pintu","kondisi jendela","kebisingan","bau","kebocoran","kerusakan","keausan",
//                "kekokohan","kunci & jendela","bahaya"};
//            DefaultTableModel dtm = new DefaultTableModel(null,kolom){
//                @Override
//                public boolean isCellEdittable(int rowIndex, int columnIndex){
//                    return false;
//                }
//            };
//            tbldata.setModel(dtm);
//            atur(tbldata,new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
//                                   100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100});
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "saalah"+e);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        jTextField1 = new javax.swing.JTextField();
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
        cbstekerbaik = new javax.swing.JCheckBox();
        cbstekerburuk = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        cbstekerdekatdosen = new javax.swing.JCheckBox();
        cbstekerpojokruang = new javax.swing.JCheckBox();
        cbstekerbelakang = new javax.swing.JCheckBox();
        cbstekerdekatmahasiswa = new javax.swing.JCheckBox();
        cbstekersamping = new javax.swing.JCheckBox();
        cbstekerlainnya = new javax.swing.JCheckBox();
        lcd = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cblcdbaik = new javax.swing.JCheckBox();
        cblcdrusak = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        cblcddekatdosen = new javax.swing.JCheckBox();
        cblcdlainnya = new javax.swing.JCheckBox();
        lampu = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cblampuatap = new javax.swing.JCheckBox();
        cblampulainny = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cblampubaik = new javax.swing.JCheckBox();
        cblampurusak = new javax.swing.JCheckBox();
        kipas = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbkipasatap = new javax.swing.JCheckBox();
        cbkipaslainnya = new javax.swing.JCheckBox();
        cbkipasbaik = new javax.swing.JCheckBox();
        cbkipasrusa = new javax.swing.JCheckBox();
        ac = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbacbelakang = new javax.swing.JCheckBox();
        cbacsamping = new javax.swing.JCheckBox();
        cbaclainnya = new javax.swing.JCheckBox();
        cbacbaik = new javax.swing.JCheckBox();
        cbacrusak = new javax.swing.JCheckBox();
        ssid = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbssidya = new javax.swing.JCheckBox();
        cbssidtidak = new javax.swing.JCheckBox();
        cmbssid = new javax.swing.JComboBox();
        cctv = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbcctvdepan = new javax.swing.JCheckBox();
        cbcctvlainnya = new javax.swing.JCheckBox();
        cbcctvbelakang = new javax.swing.JCheckBox();
        cbcctvbaik = new javax.swing.JCheckBox();
        cbcctvrusak = new javax.swing.JCheckBox();
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
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
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
        jButton6 = new javax.swing.JButton();

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
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "nama", "lokasi", "fakultas", "panjang", "lebar", "jumlah kursi", "jumlah pintu", "jumlah jendela", "jumlah steker", "kondisi baik", "posisi steker", "jumlah LCD", "kondisi LCD", "posisi LCD", "jumlah lampu", "kondisi lampu", "posisi lampu", "jumlah kipas", "kondisi kipas", "posisi kipas", "jumlah ac", "kondisi ac", "posisi ac", "ssid", "login", "jumlah cctv", "kondisi cctv", "posisi cctv", "kondisi lantai", "kondisi lantai", "kondisi atap", "kondisi pintu", "kondisi jendela", "kebisingan", "bau", "kebocoran", "kerusakan", "keausan", "kekokohan", "kunci & jendela", "bahaya"
            }
        ));
        jScrollPane1.setViewportView(tbldata);

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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
                .addGap(95, 95, 95)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(btndelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataLayout.setVerticalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        cbstekerbaik.setText("Baik");
        cbstekerbaik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerbaikActionPerformed(evt);
            }
        });

        cbstekerburuk.setText("Buruk");

        jLabel14.setText("Posisi Steker");

        cbstekerdekatdosen.setText("Dekat Dosen");

        cbstekerpojokruang.setText("Pojok Ruang");
        cbstekerpojokruang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekerpojokruangActionPerformed(evt);
            }
        });

        cbstekerbelakang.setText("Belakang");

        cbstekerdekatmahasiswa.setText("Dekat Mahasiswa");

        cbstekersamping.setText("Samping");
        cbstekersamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstekersampingActionPerformed(evt);
            }
        });

        cbstekerlainnya.setText("Lainnya");

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
                            .addComponent(jLabel54)))
                    .addGroup(stekerLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbstekerdekatdosen)
                            .addComponent(cbstekerbelakang)
                            .addComponent(cbstekersamping))
                        .addGap(25, 25, 25)
                        .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbstekerlainnya)
                            .addComponent(cbstekerdekatmahasiswa)
                            .addComponent(cbstekerpojokruang))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stekerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbstekerbaik)
                .addGap(44, 44, 44)
                .addComponent(cbstekerburuk)
                .addGap(170, 170, 170))
        );
        stekerLayout.setVerticalGroup(
            stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stekerLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstekerbaik)
                    .addComponent(cbstekerburuk))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstekerdekatdosen)
                    .addComponent(cbstekerpojokruang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstekerbelakang)
                    .addComponent(cbstekerdekatmahasiswa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stekerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstekersamping)
                    .addComponent(cbstekerlainnya))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(steker, "card8");

        jLabel17.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Analisis LCD");

        jLabel15.setText("Kondisi LCD");

        cblcdbaik.setText("Baik");

        cblcdrusak.setText("Rusak");
        cblcdrusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblcdrusakActionPerformed(evt);
            }
        });

        jLabel16.setText("Posisi LCD");

        cblcddekatdosen.setText("Dekat Dosen");

        cblcdlainnya.setText("Lainnya");

        javax.swing.GroupLayout lcdLayout = new javax.swing.GroupLayout(lcd);
        lcd.setLayout(lcdLayout);
        lcdLayout.setHorizontalGroup(
            lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addGroup(lcdLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(35, 35, 35)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cblcdbaik)
                    .addComponent(cblcddekatdosen))
                .addGap(33, 33, 33)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cblcdlainnya)
                    .addComponent(cblcdrusak))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lcdLayout.setVerticalGroup(
            lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lcdLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cblcdbaik)
                    .addComponent(cblcdrusak)
                    .addComponent(jLabel15))
                .addGap(50, 50, 50)
                .addGroup(lcdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cblcddekatdosen)
                    .addComponent(cblcdlainnya))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.add(lcd, "card9");

        jLabel23.setText("Posisi");

        cblampuatap.setText("Atap Ruangan");

        cblampulainny.setText("Lainnya");
        cblampulainny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblampulainnyActionPerformed(evt);
            }
        });

        jLabel18.setText("jLabel18");

        jLabel19.setText("Kondisi");

        cblampubaik.setText("Baik");

        cblampurusak.setText("Rusak");

        javax.swing.GroupLayout lampuLayout = new javax.swing.GroupLayout(lampu);
        lampu.setLayout(lampuLayout);
        lampuLayout.setHorizontalGroup(
            lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lampuLayout.createSequentialGroup()
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lampuLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cblampubaik)
                            .addComponent(cblampuatap))
                        .addGap(33, 33, 33)
                        .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cblampulainny)
                            .addComponent(cblampurusak)))
                    .addGroup(lampuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        lampuLayout.setVerticalGroup(
            lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lampuLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cblampubaik)
                    .addComponent(cblampurusak))
                .addGap(37, 37, 37)
                .addGroup(lampuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cblampuatap)
                    .addComponent(cblampulainny))
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

        cbkipasbaik.setText("Baik");

        cbkipasrusa.setText("Rusak");

        javax.swing.GroupLayout kipasLayout = new javax.swing.GroupLayout(kipas);
        kipas.setLayout(kipasLayout);
        kipasLayout.setHorizontalGroup(
            kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kipasLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(52, 52, 52)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbkipasatap)
                    .addComponent(cbkipasbaik))
                .addGap(46, 46, 46)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbkipasrusa)
                    .addComponent(cbkipaslainnya))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        kipasLayout.setVerticalGroup(
            kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kipasLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(76, 76, 76)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbkipasbaik)
                    .addComponent(cbkipasrusa))
                .addGap(33, 33, 33)
                .addGroup(kipasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbkipasatap)
                    .addComponent(cbkipaslainnya))
                .addContainerGap(87, Short.MAX_VALUE))
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

        cbacbaik.setText("Baik");

        cbacrusak.setText("Rusak");

        javax.swing.GroupLayout acLayout = new javax.swing.GroupLayout(ac);
        ac.setLayout(acLayout);
        acLayout.setHorizontalGroup(
            acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28))
                .addGap(29, 29, Short.MAX_VALUE)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbacbaik)
                    .addComponent(cbacbelakang))
                .addGap(36, 36, 36)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbacsamping)
                    .addComponent(cbacrusak))
                .addContainerGap(156, Short.MAX_VALUE))
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, acLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbaclainnya)
                .addGap(210, 210, 210))
        );
        acLayout.setVerticalGroup(
            acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbacbaik)
                    .addComponent(cbacrusak))
                .addGap(36, 36, 36)
                .addGroup(acLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cbacbelakang)
                    .addComponent(cbacsamping))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbaclainnya)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.add(ac, "card12");

        jLabel30.setText("SSID");

        jLabel31.setText("Apakah Bisa Login?");

        cbssidya.setText("Ya");

        cbssidtidak.setText("Tidak");

        cmbssid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                    .addComponent(cbssidtidak)
                    .addComponent(cbssidya)
                    .addComponent(cmbssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        ssidLayout.setVerticalGroup(
            ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssidLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cmbssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ssidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(cbssidya, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbssidtidak)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel1.add(ssid, "card13");

        jLabel32.setText("Jumlah CCTV");

        jLabel33.setText("Kondisi");

        jLabel34.setText("Posisi");

        cbcctvdepan.setText("Depan");

        cbcctvlainnya.setText("Lainnya");

        cbcctvbelakang.setText("Belakang");

        cbcctvbaik.setText("Baik");

        cbcctvrusak.setText("Rusak");

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
                    .addComponent(jLabel34)
                    .addComponent(jLabel33))
                .addGap(40, 40, 40)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbcctvbaik)
                    .addComponent(cbcctvdepan))
                .addGap(76, 76, 76)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbcctvrusak)
                    .addComponent(cbcctvbelakang))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        cctvLayout.setVerticalGroup(
            cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cctvLayout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(cbcctvbaik))
                    .addComponent(cbcctvrusak))
                .addGap(46, 46, 46)
                .addGroup(cctvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cbcctvdepan)
                    .addComponent(cbcctvbelakang))
                .addGap(18, 18, 18)
                .addComponent(cbcctvlainnya)
                .addContainerGap(40, Short.MAX_VALUE))
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

        jCheckBox17.setText("Lancar");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jCheckBox18.setText("Tidak Lancar");

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
                            .addComponent(jCheckBox18)
                            .addComponent(jCheckBox17)))
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
                    .addComponent(jCheckBox17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox18)
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

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                .addGap(77, 77, 77)
                .addComponent(jButton6)
                .addGap(65, 65, 65)
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
                    .addComponent(jButton1)
                    .addComponent(jButton6))
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
            kondisi.setVisible(true);
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
        } else if (kondisi.isShowing() && !txtpanjang.getText().equalsIgnoreCase("") && (!txtlebar.getText().equalsIgnoreCase("")) && (!txtjmlkursi.getText().equalsIgnoreCase(""))
                && (!txtjmlpintu.getText().equalsIgnoreCase("")) && (!txtjmljendela.getText().equalsIgnoreCase(""))) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(true);
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
        } else if (steker.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(false);
            lcd.setVisible(true);
            kipas.setVisible(false);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (lcd.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(true);
            ac.setVisible(false);
            lcd.setVisible(false);
            kipas.setVisible(false);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (lampu.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(false);
            lcd.setVisible(false);
            kipas.setVisible(true);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (kipas.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(true);
            lcd.setVisible(false);
            kipas.setVisible(false);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (ac.isShowing()) {
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
            ssid.setVisible(true);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (ssid.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(false);
            lcd.setVisible(false);
            kipas.setVisible(false);
            cctv.setVisible(true);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(false);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
        } else if (cctv.isShowing()) {
            kondisi.setVisible(false);
            identitas.setVisible(false);
            steker.setVisible(false);
            lampu.setVisible(false);
            ac.setVisible(false);
            lcd.setVisible(false);
            kipas.setVisible(false);
            cctv.setVisible(false);
            kebersihan.setVisible(false);
            kenyamanan.setVisible(true);
            ssid.setVisible(false);
            keamanan.setVisible(false);
            lingkungan.setVisible(false);
//        } else if (lingkungan.isShowing() && (!cblantaibersih.getText().equals("") || !cblantaikotor.getText().equals("")) && (!cbatapbersih.getText().equals("") || !cbatapkotor.getText().equals(""))
//                && (!cbdindingbersih.getText().equals("") || !cbdindingkotor.getText().equals("")) && (!cbjendelabersih.getText().equals("") || !cbjendelakotor.getText().equals(""))
//                && (!cbpintubersih.getText().equals("") || !cbpintukotor.getText().equals(""))) {
//            kondisi.setVisible(false);
//            identitas.setVisible(false);
//            steker.setVisible(false);
//            lampu.setVisible(false);
//            ac.setVisible(false);
//            lcd.setVisible(false);
//            kipas.setVisible(false);
//            cctv.setVisible(false);
//            kebersihan.setVisible(true);
//            kenyamanan.setVisible(false);
//            ssid.setVisible(false);
//            keamanan.setVisible(false);
//            lingkungan.setVisible(false);
        }
                else if(kenyamanan.isShowing()){
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
                    keamanan.setVisible(true);
                    lingkungan.setVisible(false); 
                }
        else {
            JOptionPane.showMessageDialog(null, "Data Belom Terisi,, Silahkan lengkapin Data !!!");
        }


    }//GEN-LAST:event_btnnextActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        kondisibaik();
        jumlah();
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
        if(cbacbaik.isSelected())
            kerusakan+="Baik";
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

//            btnDelete.setText("Batal");
//            btnEdit.setEnabled(false);
//            btnPrev.setEnabled(false);
//            btnNext.setEnabled(false);
        } else {
            if (!txtnama.getText().equals("") && !txtlokasi.getText().equals("") && !cmbfakultas.getSelectedItem().equals("Pilih Fakultas")
                    && !txtpanjang.getText().equals("") && !txtlebar.getText().equals("") && !txtjmlkursi.getText().equals("")
                    && !txtjmlpintu.getText().equals("") && !txtjmljendela.getText().equals("")) {
                connect c = new connect(); //buka koneksi 
                ruang m = new ruang();
                posisi();
                m.setNama_ruang(txtnama.getText());
                m.setLokasi_ruang(txtlokasi.getText());
                m.setFakultas((String) cmbfakultas.getSelectedItem());
                m.setPanjang_ruang(Integer.parseInt(txtpanjang.getText()));
                m.setLebar_ruang(Integer.parseInt(txtlebar.getText()));
                m.setJumlah_kursi(Integer.parseInt(txtjmlkursi.getText()));
                m.setJumlah_pintu(Integer.parseInt(txtjmlpintu.getText()));
                m.setJumlah_jendela(Integer.parseInt(txtjmljendela.getText()));
                m.setJumlah_steker(jumlahsteker);
                m.setJumlah_baik_steker(stekerbaik);
                //m.setKondisi_steker(kondisi_steker);
                m.setPosisi_steker(posisisteker);
                m.setJumlah_kabel_LCD(jumlahlcd);
                m.setJumlah_baik_lcd(lcdbaik);
                m.setPosisi_kabel_LCD(posisilcd);
                m.setJumlah_lampu(jumlahlampu);
                m.setJumlah_baik_lcd(lampubaik);
                m.setPosisi_kabel_LCD(posisilampu);
                m.setJumlah_kipas_angin(jumlahkipas);
                m.setJumlah_baik_kipas(kipasbaik);
                m.setPosisi_kipas_angin(posisikipas);
                m.setJumlah_AC(jumlahac);
                m.setJumlah_baik_ac(acbaik);
                m.setPosisi_AC(posisiac);
                m.setSSID((String) cmbssid.getSelectedItem());
                m.setBandwidth(login);
                m.setJumlah_CCTV(jumlahcctv);
                m.setJumlah_baik_cctv(cctvbaik);
                m.setPosisi_CCTV(posisicctv);
                m.setKondisi_lantai(lantai);
                m.setKondisi_dinding(dinding);
                m.setKondisi_atap(atap);
                m.setKondisi_pintu(pintu);
                m.setKondisi_jendela(jendela);
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
                //tbldata.setVisible(true);
//                btnDelete.setText("Hapus");
//                btnEdit.setEnabled(true);
//                btnPrev.setEnabled(true);
//                btnNext.setEnabled(true);
                c.closeConnection(); //tutup koneksi 
            } else {
                JOptionPane.showMessageDialog(this, "Mohon isi data dengan benar", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        tampilkandata();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed

//       String qwe = txtpanjang.getText();
//       int ewq = qwe.length();
//       String s2 = txtnama.getText();
//       int i2 = s2.length();
//        
//        if(ewq > 0  )  {
//            kondisi.setVisible(true);
//        }else if (i2 > 0){
//            identitas.setVisible(true);
//        }                                  
//      //}     
    }//GEN-LAST:event_btnprevActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        data.setVisible(true);
        btnnext.setEnabled(false);
        btnprev.setEnabled(false);
        identitas.setVisible(false);
        kondisi.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox17ActionPerformed

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
           // ruang ru=new ruang();
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cblampulainnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblampulainnyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cblampulainnyActionPerformed

    private void cbkipasatapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkipasatapActionPerformed
        cbkipaslainnya.setVisible(false);
    }//GEN-LAST:event_cbkipasatapActionPerformed

    private void cbacbelakangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbacbelakangActionPerformed
        cbacsamping.setVisible(false);
    }//GEN-LAST:event_cbacbelakangActionPerformed

    private void cbkipaslainnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkipaslainnyaActionPerformed
        cbkipasatap.setVisible(false);
    }//GEN-LAST:event_cbkipaslainnyaActionPerformed

    private void cbbahayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbahayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbahayaActionPerformed

    private void cbdindingkotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdindingkotorActionPerformed
        cbdindingbersih.setVisible(false);
    }//GEN-LAST:event_cbdindingkotorActionPerformed

    private void cbpintubersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpintubersihActionPerformed
        cbpintukotor.setVisible(false);
    }//GEN-LAST:event_cbpintubersihActionPerformed

    private void cblantaibersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblantaibersihActionPerformed
        cblantaikotor.setVisible(false);
    }//GEN-LAST:event_cblantaibersihActionPerformed

    private void cblantaikotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblantaikotorActionPerformed
        cblantaibersih.setVisible(false);
    }//GEN-LAST:event_cblantaikotorActionPerformed

    private void cbdindingbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdindingbersihActionPerformed
        cbdindingkotor.setVisible(false);
    }//GEN-LAST:event_cbdindingbersihActionPerformed

    private void cbatapbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbatapbersihActionPerformed
        cbatapkotor.setVisible(false);
    }//GEN-LAST:event_cbatapbersihActionPerformed

    private void cbatapkotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbatapkotorActionPerformed
        cbatapbersih.setVisible(false);
    }//GEN-LAST:event_cbatapkotorActionPerformed

    private void cbjendelabersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjendelabersihActionPerformed
        cbjendelakotor.setVisible(false);
    }//GEN-LAST:event_cbjendelabersihActionPerformed

    private void cbjendelakotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjendelakotorActionPerformed
        cbjendelabersih.setVisible(false);
    }//GEN-LAST:event_cbjendelakotorActionPerformed

    private void cbpintukotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpintukotorActionPerformed
        cbpintubersih.setVisible(false);
    }//GEN-LAST:event_cbpintukotorActionPerformed

    private void cbstekerpojokruangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerpojokruangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstekerpojokruangActionPerformed

    private void cbstekersampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekersampingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstekersampingActionPerformed

    private void cblcdrusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblcdrusakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cblcdrusakActionPerformed

    private void cbacsampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbacsampingActionPerformed
        cbacbelakang.setVisible(false);
    }//GEN-LAST:event_cbacsampingActionPerformed

    private void cbstekerbaikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstekerbaikActionPerformed
        cbstekerburuk.setSelected(false);
    }//GEN-LAST:event_cbstekerbaikActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jumlah();
        kondisibaik();
    }//GEN-LAST:event_jButton6ActionPerformed

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
    private javax.swing.JCheckBox cbacbaik;
    private javax.swing.JCheckBox cbacbelakang;
    private javax.swing.JCheckBox cbaclainnya;
    private javax.swing.JCheckBox cbacrusak;
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
    private javax.swing.JCheckBox cbcctvbaik;
    private javax.swing.JCheckBox cbcctvbelakang;
    private javax.swing.JCheckBox cbcctvdepan;
    private javax.swing.JCheckBox cbcctvlainnya;
    private javax.swing.JCheckBox cbcctvrusak;
    private javax.swing.JCheckBox cbdindingbersih;
    private javax.swing.JCheckBox cbdindingkotor;
    private javax.swing.JCheckBox cbjendelabersih;
    private javax.swing.JCheckBox cbjendelakotor;
    private javax.swing.JCheckBox cbkipasatap;
    private javax.swing.JCheckBox cbkipasbaik;
    private javax.swing.JCheckBox cbkipaslainnya;
    private javax.swing.JCheckBox cbkipasrusa;
    private javax.swing.JCheckBox cbkokoh;
    private javax.swing.JCheckBox cblampuatap;
    private javax.swing.JCheckBox cblampubaik;
    private javax.swing.JCheckBox cblampulainny;
    private javax.swing.JCheckBox cblampurusak;
    private javax.swing.JCheckBox cblantaibersih;
    private javax.swing.JCheckBox cblantaikotor;
    private javax.swing.JCheckBox cblcdbaik;
    private javax.swing.JCheckBox cblcddekatdosen;
    private javax.swing.JCheckBox cblcdlainnya;
    private javax.swing.JCheckBox cblcdrusak;
    private javax.swing.JCheckBox cbpintubersih;
    private javax.swing.JCheckBox cbpintukotor;
    private javax.swing.JCheckBox cbrapuh;
    private javax.swing.JCheckBox cbrusak;
    private javax.swing.JCheckBox cbssidtidak;
    private javax.swing.JCheckBox cbssidya;
    private javax.swing.JCheckBox cbstekerbaik;
    private javax.swing.JCheckBox cbstekerbelakang;
    private javax.swing.JCheckBox cbstekerburuk;
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
    private javax.swing.JPanel cctv;
    private javax.swing.JComboBox cmbfakultas;
    private javax.swing.JComboBox cmbssid;
    private javax.swing.JPanel data;
    private javax.swing.JPanel identitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField k;
    private javax.swing.JPanel keamanan;
    private javax.swing.JPanel kebersihan;
    private javax.swing.JPanel kenyamanan;
    private javax.swing.JPanel kipas;
    private javax.swing.JPanel kondisi;
    private javax.swing.JPanel lampu;
    private javax.swing.JPanel lcd;
    private javax.swing.JPanel lingkungan;
    private javax.swing.JTextField p;
    private javax.swing.JTextField s;
    private javax.swing.JSlider sldrkelembapan;
    private javax.swing.JSlider sldrpencahayaan;
    private javax.swing.JSlider sldrsuhu;
    private javax.swing.JPanel ssid;
    private javax.swing.JPanel steker;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtjmljendela;
    private javax.swing.JTextField txtjmlkursi;
    private javax.swing.JTextField txtjmlpintu;
    private javax.swing.JTextField txtlebar;
    private javax.swing.JTextField txtloka;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpanjang;
    // End of variables declaration//GEN-END:variables

    //private static class ChangeListener implements javax.swing.event.ChangeListener {
}
