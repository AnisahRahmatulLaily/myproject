package ruang;

 
import java.awt.Checkbox;
import java.awt.Panel;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ruang.datafull;
import javax.swing.*;
import ruang.datafull;


public class in_out extends induk implements interfa  {

    Scanner in = new Scanner(System.in);
    ruang d = new ruang();
    ruang f;
    
    public in_out(JTextField txtnama,JTextField txtlokasi, JCheckBox cmbfakultas,JTextField txtpanjang,JTextField txtlebar,JTextField txtkursi,JTextField txtpintu,JTextField txtjendela) {
        d.setNama_ruang(txtnama.getText());
        d.setLokasi_ruang(txtlokasi.getText());
        d.setFakultas(cmbfakultas.getText());
        f = new ruang(d.getNama_ruang(), d.getLokasi_ruang(), d.getFakultas(),d.getPanjang_ruang(), d.getLebar_ruang(), d.getJumlah_kursi(), d.getJumlah_pintu(), d.getJumlah_jendela());
    }
    public in_out(JTextField txtjumlahsteker,JTextField txtkondisisteker,JTextField txtposisisteker,JTextField txtjumlahlcd,
            JTextField txtkondisilcd,JTextField txtposisilcd,JTextField txtjumlahlampu,JTextField txtkondisilampu,
            JTextField txtposisilampu,JTextField txtjumlahac,JTextField kondisiac,JTextField posisiac,JComboBox cmblogin,JTextField txtlogin,
            JTextField txtjumlahcctv,JTextField txtkondisicctv,JTextField txtposisicctv){
        //d.setJumlah_steker(txtjumlahsteker.getText());
    }
    @Override
    public void input_identitas_ruang_kelas() {
        datafull.identitas.setVisible(true);
    }
    @Override
    public void input_kondisi_ruang_kelas() {
     datafull.kondisi.setVisible(true);
    }
    

    @Override
    public void kondisi_dan_posisi_sarana() {
        datafull.steker.setVisible(true);
        datafull.identitas.setVisible(true);
        
////        System.out.println("masukan jumlah steker atau stop kontak");
////        d.setJumlah_steker(in.nextInt());
//////                for(i=0;i<d.getJumlah_steker();i++){
//////                    r=i+1;
////        System.out.println("Kondisi steker baik/buruk ke  : ");
////        d.setKondisi_steker(in.next());
//////                    if (d.getKondisi_steker().equalsIgnoreCase("baik")){
//////                        steker++;
//////                    }
//////                }
////        System.out.println("posisi steker \n1. Di pojok Ruang dan di dekat dosen n\2. Di pojok ruang n\3. dekat dosen  ");
////        d.setPosisi_steker(in.nextInt());
////
////        System.out.println("input jumlah kabel LCD");
////        d.setJumlah_kabel_LCD(in.nextInt());
//////        for (i = 0; i > d.getJumlah_kabel_LCD(); i++) {
//////            r = i + 1;
////            System.out.println("kondisi kabel LCD baik/ buruk");
////            d.setKondisi_kabel_LCD(in.next());
//////            if (d.getKondisi_steker().equalsIgnoreCase("baik")) {
//////                LCD++;
//////            }
//////        }
////        System.out.println("posisi kabel LCD n\1. dekat dosen n\2. tidak dekat dosen");
////        System.out.println("jumlah lampu");
////        d.setPosisi_kabel_LCD(in.nextInt());
//////        for (i = 0; i > d.getJumlah_lampu(); i++) {
//////            r = i + 1;
////            System.out.println("kondisi lampu baik/buruk");
////            d.setKondisi_lampu(in.next());
//////            if (d.getKondisi_lampu().equalsIgnoreCase("baik")) {
//////                lampu++;
//////            }
//////        }
////        System.out.println("posisi :n\1. atap ruang n\2. bukan di atap ruang");
////        d.setPosisi_lampu(in.nextInt());
////        System.out.println("jumlah kipas angin");
////        d.setJumlah_kipas_angin(in.nextInt());
//////        for (i = 0; i > d.getJumlah_kipas_angin(); i++) {
//////            r = i + 1;
////            System.out.println("kondisi kipas angin ");
////            d.setKondisi_kipas_angin(in.next());
//////            if (d.getKondisi_kipas_angin().equalsIgnoreCase("baik")) {
//////                kipas++;
//////            }
//////        }
////        System.out.println("posisi kipas n\1. atap ruang n\2. bukan atap ruang ");
////        d.setPosisi_kipas_angin(in.nextInt());
////        System.out.println("jumlah AC");
////        d.setJumlah_AC(in.nextInt());
//////        for (i = 0; i > d.getJumlah_AC(); i++) {
//////            r = i + 1;
////            System.out.println("kondisi AC");
////            d.setKondisi_AC(in.next());
//////            if (d.getKondisi_AC().equalsIgnoreCase("baik")) {
//////                AC++;
//////            }
//////        }
////        System.out.println("posisi AC n\1. dibelakang atau di samping n/2. bukan dibelakang ataupun bukan disamping");
////        d.setPosisi_AC(in.nextInt());
////        System.out.println("pilih SSID");
////        d.setSSID(in.next());
////        System.out.println("bandwidth");
////        d.setBandwidth(in.next());
////        System.out.println("jumlah cctv");
////        d.setJumlah_CCTV(in.nextInt());
//////        for (i = 0; i > d.getJumlah_CCTV(); i++) {
//////            r = i + 1;
////            System.out.println("kondisi baik cctv");
////            d.setKondisi_CCTV(in.next());
//////            if (d.getKondisi_CCTV().equalsIgnoreCase("baik")) {
//////                CCTV++;
//////            }
//////        }
////        System.out.println("posisi cctv n\1. depan dan belakang n\2.belakang n\3. depan n\4. bukan depan dan belakang");
////        d.setKondisi_CCTV(in.next());
//        f = new ruang (d.getJumlah_steker(),d.getKondisi_steker(),d.getPosisi_steker(),
//                d.getJumlah_kabel_LCD(),d.getKondisi(),d.getPosisi_kabel_LCD(),
//                d.getJumlah_lampu(),d.getKondisi_lampu(),d.getPosisi_lampu(), d.getJumlah_kipas_angin(),
//        d.getKondisi_kipas_angin(),d.getPosisi_kipas_angin(),d.getJumlah_AC(),d.getKondisi_AC(), d.getPosisi_AC(),
//        d.getSSID(),d.getBandwidth(),d.getJumlah_CCTV(),d.getKondisi_CCTV(),d.getPosisi_CCTV());
//		//analisis_CCTV();
//
//    }
//    void setdata(int jumlah_steker, String kondisi_steker, String posisi_steker, int jumlah_kabel_LCD, 
//            String kondisi_kabel_LCD, String posisi_kabel_LCD, int jumlah_lampu,String kondisi_lampu ,
//            String posisi_lampu, int jumlah_kipas_angin, String kondisi_kipas_angin, String posisi_kipas_angin,
//            int jumlah_AC, String kondisi_AC,String posisi_AC,String SSID, String bandwidth, int jumlah_CCTV, String kondisi_CCTV, String posisi_CCTV){
//        setdata(jumlah_steker, kondisi_steker, posisi_steker, jumlah_kabel_LCD, kondisi_kabel_LCD, posisi_kabel_LCD, jumlah_lampu, kondisi_lampu, posisi_lampu, jumlah_kipas_angin, kondisi_kipas_angin, posisi_kipas_angin, jumlah_AC, kondisi_AC, posisi_AC, SSID, bandwidth, jumlah_CCTV, kondisi_CCTV, posisi_CCTV);
//    }
    }
    public in_out(JCheckBox cblantaibersih,JCheckBox cblantaikotor, JCheckBox cbdindingbersih,JCheckBox cbdindingkotor, JCheckBox cbatapbersih, JCheckBox cbatapkotor,JCheckBox cbpintubersih,JCheckBox cbpintukotor, JCheckBox cbjendelabersih,JCheckBox cbjendelakotor) {
        if(cblantaibersih.isSelected()){
            d.setKondisi_lantai("Bersih");
        }else if(cblantaikotor.isSelected()){
            d.setKondisi_lantai("Kotor");
        }if(cbdindingbersih.isSelected()){
            d.setKondisi_dinding("Bersih");
        }else if(cbdindingkotor.isSelected()){
            d.setKondisi_dinding("Kotor");
        }if(cbatapbersih.isSelected()){
            d.setKondisi_atap("Bersih");
        }else if(cbatapkotor.isSelected()){
            d.setKondisi_atap("Kotor");
        }
        f=new ruang(d.getKondisi_lantai(),d.getKondisi_dinding(),d.getKondisi_atap(),d.getKondisi_pintu(),d.getKondisi_jendela());
    }
    @Override
    public void input_lingkungan_ruang_kelas(){
        datafull.lingkungan.setVisible(true);
        
    }
//    @Override
//   void setdata(String kondisi_lantai, String kondisi_dinding, String kondisi_atap, String kondisi_pintu, String kondisi_jendela){
//        setdata(kondisi_lantai, kondisi_dinding, kondisi_atap, kondisi_pintu, kondisi_jendela);
//    }

    @Override
    public void kebersihan_ruang_kelas() {
        System.out.println("masukan sirkulasi udara");
        d.setSirkulasi_udara(in.next());
        System.out.println("masukan nilai pencahaan");
        d.setPencahayaan(in.nextInt());
        System.out.println("masukan kelembapan");
        d.setKelembapan(in.nextInt());
        System.out.println("Masukan suhu Celcius");
        d.setSuhu(in.nextInt());
        f=new ruang(d.getSirkulasi_udara(),d.getPencahayaan(),d.getKelembapan(),d.getSuhu());
    }
//    @Override
//    void setdata (String sirkulasi_udara, int pencahayaan, int kelembapan, int suhu){
//        setdata(sirkulasi_udara, pencahayaan, kelembapan, suhu);  
//    }

    @Override
    public void kenyamanan_ruang_kelas() {
        System.out.println("masukan kebisingan");
        d.setKebisingan(in.next());
        System.out.println("masukan bau");
        d.setBau(in.next());
        System.out.println("masukan kebocoran");
        d.setKebocoran(in.next());
        System.out.println("masukan kerusakan");
        d.setKerusakan(in.next());
        System.out.println("masukan keausan");
        d.setKeausan(in.next());
        f=new ruang(d.getKebisingan(),d.getBau(),d.getKebocoran(),d.getKerusakan(),d.getKeausan());
    }
//    @Override
//    void setdata (int kebisingan, String bau, String kebocoran, String kerusakan, String keausan){
//        setdata(kebisingan, bau, kebocoran, kerusakan, keausan);
//    }

    @Override
    public void keamanan_ruang() {
        System.out.println("input kekokohan");
        d.setKekokohan(in.next());
        System.out.println("jumlah kunci pintu");
        d.setJumlah_kunci(in.nextInt());
        System.out.println("jumlah jendela");
        d.setJumlah_jendela(in.nextInt());
        System.out.println("bahaya atau aman ?");
        d.setBahaya(in.next());
        f=new ruang(d.getKekokohan(),d.getJumlah_kunci(),d.getJumlah_jendela(),d.getBahaya());
    }
//    void setdata(String kekokohan, int jumlah_kunci, int jumlah_jendela, String bahaya){
//        setdata(kekokohan, jumlah_kunci, jumlah_jendela, bahaya);
//    }

//    public void tampil() {
//        System.out.println("ruang : " + d.getNama_ruang());
//        System.out.println("lokasi : " + d.getLokasi_ruang());
//        System.out.println("fakultas : " + d.getFakultas());
//            //System.out.println("panjang ruang :"+getPanjang_ruang());
//        //System.out.println("lebar ruang :"+d.getLebar_ruang());
//        //System.out.println("luas ruang : "+d.hitung_luas_ruang());
//        //System.out.println("bentuk ruang :" +d.hitung_bentuk_ruang());
//        System.out.println("jumlah kursi di dalam ruang : " + d.getJumlah_kursi());
//        // System.out.println("rasio luas ruang :" +d.hitung_rasio_luas());
//        System.out.println("jumlah pintu : " + d.getJumlah_pintu());
//        System.out.println("jumlah jendela :" + d.getJumlah_jendela());
//        //System.out.println("analisis pintu dan jendela : "+this.analisis_pintu_dan_jendela());
////            System.out.println("jumlah steker : "+super.getJumlah_steker());
////            System.out.println("kondisi steker "+super.getKondisi_steker());
////            System.out.println("posisi steker :"+super.getPosisi_steker());
////            System.out.println("analisis kelistrikan "+ this.analisis_kelistrikan());
////            System.out.println("jumlah kabel LCD : "+super.getJumlah_kabel_LCD());
////            System.out.println("kondisi kabel LCD : "+super.getKondisi_kabel_LCD());
////            System.out.println("posisi kabel LCD : "+super.getPosisi_kabel_LCD());
////            System.out.println("analisis kabel LCD : "+this.analisis_LCD());
////            System.out.println("jumlah lampu dalam ruang : "+ super.getJumlah_lampu());
////            System.out.println("kondisi lampu dalam ruang : "+super.getKondisi_lampu());
////            System.out.println("posisi lampu dalam ruang: "+super.getKondisi_lampu());
////            System.out.println("analisis lampu : "+this.analisis_lampu());
////            System.out.println("jumlah kipas angin : "+super.getJumlah_kipas_angin());
////            System.out.println("kondisi kipas angin :"+ super.getKondisi_kipas_angin());
////            System.out.println("posisi kipas angin dalam ruang : " +super.getKondisi_kipas_angin());
////            System.out.println("analisis kipas angin :"+this.analisis_kipas_angin());
////            System.out.println("jumlah AC dalam ruangan : "+super.getJumlah_AC());
////            System.out.println("kondisi AC dalam ruangan:  "+super.getKondisi_AC());
////            System.out.println("posisi AC dalam ruangan : "+super.getPosisi_AC());
////            System.out.println("analisis AC dalam ruang : "+ this.analisis_AC());
////            System.out.println("inputan SSID : "+super.getSSID());
////            System.out.println("inputan bandwidth :"+super.getBandwidth());
////            System.out.println("analisis internet : "+this.analisis_internet());
//    }

    public ruang getruang() {
        return d;
    }

    
//    @Override
//    public void output(int panjang_ruang, int lebar_ruang, int jumlah_kursi, int jumlah_pintu, int jumlah_jendela) {
//        System.out.println("=== KONDISI RUANG KELAS ===");
//        System.out.println("Panjang Ruang : "+panjang_ruang);
//        System.out.println("Lebar Ruang : "+lebar_ruang);
//        System.out.println("Jumlah Kursi : "+jumlah_kursi);
//        System.out.println("Jumlah Pintu : "+jumlah_pintu);
//        System.out.println("Jumlah Jendela : "+jumlah_jendela);
//    }
//
//    @Override
//    public void output(int jumlah_steker, String kondisi_steker, String posisi_steker, int jumlah_kabel_LCD,
//            String kondisi_kabel_LCD, String posisi_kabel_LCD, int jumlah_lampu, String kondisi_lampu, 
//            String posisi_lampu, int jumlah_kipas_angin, String kondisi_kipas_angin, String posisi_kipas_angin, 
//            int jumlah_AC, String kondisi_AC, String posisi_AC, String SSID, String bandwidth, int jumlah_CCTV, 
//            String kondisi_CCTV, String posisi_CCTV) {
//        System.out.println("=== KONDISI SARANA ===");
//        System.out.println("Jumlah Steker : "+jumlah_steker);
//        System.out.println("Kondisi Steker : "+kondisi_steker);
//        System.out.println("Posisi Steker : "+posisi_steker);
//        System.out.println("Jumlah Kabel LCD : "+jumlah_kabel_LCD);
//        System.out.println("Kondisi Kabel LCD :"+kondisi_kabel_LCD);
//        System.out.println("Posisi Kabel LCD :"+posisi_kabel_LCD);
//        System.out.println("Jumlah Lampu :"+jumlah_lampu);
//        System.out.println("Kondisi Lampu :"+kondisi_lampu);
//        System.out.println("Posisi Lampu :"+posisi_lampu);
//        System.out.println("Jumlah Kipas Angin :"+jumlah_kipas_angin);
//        System.out.println("Kondisi Kipas Angin :"+kondisi_kipas_angin);
//        System.out.println("Posisi Kipas Angin :"+posisi_kipas_angin);
//        System.out.println("Jumlah AC :"+jumlah_AC);
//        System.out.println("Kondisi AC :"+kondisi_AC);
//        System.out.println("Posisi AC :"+posisi_AC);
//        System.out.println("SSID : "+SSID);
//        System.out.println("Bandwidth :"+bandwidth);
//        System.out.println("jumlah CCTV :"+jumlah_CCTV);
//        System.out.println("Kondisi CCTV : "+kondisi_CCTV);
//        System.out.println("Posisi CCTV : "+posisi_CCTV);
//        
//    }
//
//    @Override
//    public void output(String kondisi_lantai, String kondisi_dinding, String kondisi_atap, String kondisi_pintu, String kondisi_jendela) {
//        System.out.println("===KONDISI===");
//        System.out.println("Kondisi Lantai : "+kondisi_lantai);
//        System.out.println("Kondisi Dinding :"+kondisi_dinding);
//        System.out.println("Kondisi Atap :"+kondisi_atap);
//        System.out.println("Kondisi Pintu :"+kondisi_pintu);
//        System.out.println("Kondisi Jendela :"+kondisi_jendela);
//    }
//
//    @Override
//    public void output(String sirkulasi_udara, int pencahayaan, int kelembapan, int suhu) {
//        System.out.println("===KONDISI===");
//        System.out.println("Sirkulasi Udara :"+sirkulasi_udara);
//        System.out.println("Pencahayaan :"+pencahayaan);
//        System.out.println("Pencahayaan :"+kelembapan);
//        System.out.println("Suhu :"+suhu);
//    }
//
//    @Override
//    public void output(int kebisingan, String bau, String kebocoran, String kerusakan, String keausan) {
//        System.out.println("===KONDISI===");
//        System.out.println("Kebisingan :"+kebisingan);
//        System.out.println("Bau :"+bau);
//        System.out.println("kebocoran :"+kebocoran);
//        System.out.println("Kerusakan :"+kerusakan);
//        System.out.println("Keausan :"+keausan);
//    }
//
//    @Override
//    public void output(String kekokohan, int jumlah_kunci, int jumlah_jendela, String bahaya) {
//        System.out.println("===KONDISI===");
//        System.out.println("Kekokohan :"+kekokohan);
//        System.out.println("Jumlah Kunci :"+jumlah_kunci);
//        System.out.println("Bahaya :"+bahaya);
//    }
//
//    @Override
//    void persentasekondisiruang() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    void persentasekondisisarana() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    void persentasekondisilingkungan() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    void persentasekondisikebersihan() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    void persentasekenyamanan() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    void persentasekeamanan() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
public in_out(){
}

    
}