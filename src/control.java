
import java.util.Scanner;

public class control extends induk {

    ruang ru = new ruang();
    in_out io = new in_out();
    Scanner in = new Scanner(System.in);
    int sesuai =0, tidaksesuai=0, hasil;
    //String  hasil;
    //int i, r, LCD = 0, AC = 0, lampu = 0, kipas = 0, steker = 0, CCTV = 0;
    private int luas;
    private double rasio;

    public void setLuas(int luas) {
        this.luas = luas;
    }

    public void setRasio(double rasio) {
        this.rasio = rasio;
    }

    public int getLuas() {
        return luas;
    }

    public double getRasio() {
        return rasio;
    }

    public  void analisis_hitung_ruang (){
    }
    double hitung_luas_ruang() {
        luas = ru.getPanjang_ruang() * ru.getLebar_ruang();
        return luas;
    }

    double hitung_rasio_luas() {
        rasio = luas / ru.getJumlah_kursi();

        return rasio;
    }

    int kondisi_ruang() {
        //ru= io.getruang();
        if (ru.getPanjang_ruang() == ru.getLebar_ruang()) {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        } else {
            System.out.println("sesuai");
            sesuai++;
        }
        System.out.println("Rasio Ruangan = " + rasio);
        if (ru.getJumlah_pintu() >= 2) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_jendela() >= 1) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai ");
            tidaksesuai++;
        }
//        if (tidaksesuai > sesuai) {
//            hasil = 0;
//        } else {
//            hasil = 1;
//        }
        io.output(ru.getPanjang_ruang(), ru.getLebar_ruang(), ru.getJumlah_kursi(), ru.getJumlah_pintu(), ru.getJumlah_jendela());
        return sesuai;
    }
    @Override
    void persentasekondisiruang(){
       int persen = sesuai*25;
        System.out.println("persentase keseuaian kondisi ruangan "+persen+"%");
    }

    int kondisi_sarana() {
        if (ru.getJumlah_steker() >= 4) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_steker().equalsIgnoreCase("baik")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_steker().equalsIgnoreCase("dekatdosen") || (ru.getPosisi_steker().equalsIgnoreCase("pojokruang"))) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_kabel_LCD() > 1) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_kabel_LCD().equalsIgnoreCase("berfunfsi")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_kabel_LCD().equalsIgnoreCase("dekatdosen")) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_lampu() >= 18) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_lampu().equalsIgnoreCase("baik")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_lampu().equalsIgnoreCase("atapruangan")) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_kipas_angin() >= 2) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getKondisi_kipas_angin().equalsIgnoreCase("baik")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_kipas_angin().equalsIgnoreCase("atapruangan") ) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_AC()>=1){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_AC().equalsIgnoreCase("baik")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_AC().equalsIgnoreCase("belakang")||(ru.getPosisi_AC().equalsIgnoreCase("samping"))){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getSSID().equalsIgnoreCase("ummhotspot")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_CCTV()==2){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_CCTV().equalsIgnoreCase("baik")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getPosisi_CCTV().equalsIgnoreCase("depan") && (ru.getPosisi_CCTV().equalsIgnoreCase("belakang"))){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        return sesuai;
    }
    @Override
    void persentasekondisisarana(){
    int persen = sesuai*5;
        System.out.println("persentase keseuaian kondisi sarana "+persen+"%");
    }
    int kondisi_kebersihan(){
        if (ru.getKondisi_lantai().equalsIgnoreCase("bersih")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getKondisi_dinding().equalsIgnoreCase("bersih")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getKondisi_atap().equalsIgnoreCase("bersih")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_pintu().equalsIgnoreCase("bersih")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKondisi_jendela().equalsIgnoreCase("bersih")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
//        if (sesuai<tidaksesuai){
//            hasil=0;
//        }else{
//            hasil =1;
//        }
        return sesuai;
    }
    @Override
    void persentasekondisikebersihan(){
       int persen = sesuai*20;
        System.out.println("persentase keseuaian kondisi lingkungan "+persen+"%");
    }
    int analisis_lingkungan(){
        if (ru.getSirkulasi_udara().equalsIgnoreCase("lancar")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getPencahayaan()<=350 && ru.getPencahayaan()>=250){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getKelembapan()<=80 && ru.getKelembapan() >=70){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getSuhu()>=25 && ru.getSuhu()<=35){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (sesuai<tidaksesuai){
            hasil=0;
        }else{
            hasil=1;
        }
        return hasil;
    }
    @Override
    void persentasekondisilingkungan(){
       int persen = sesuai*25;
        System.out.println("persentase keseuaian kondisi lingkungan "+persen+"%");
    }
    int analisis_kenyamanan(){
       if (ru.getKebisingan().equalsIgnoreCase("bising")){
           System.out.println("tidak sesuai");
           tidaksesuai++;
       }else{
           System.out.println("sesuai");
           sesuai++;
       }
       if (ru.getBau().equalsIgnoreCase("bau")){
           System.out.println("tidak sesuai");
           tidaksesuai++;
       }else{
           System.out.println("sesuai");
           sesuai++;
       }
       if(ru.getKebocoran().equalsIgnoreCase("bocor")){
           System.out.println("tidak sesuai");
           tidaksesuai++;
       }else{
           System.out.println("sesuai");
           sesuai++;
       }
       if(ru.getKerusakan().equalsIgnoreCase("rusak")){
           System.out.println("tidak sesuai");
           tidaksesuai++;
       }else{
           System.out.println("sesuai");
           sesuai++;
       }
       if (ru.getKeausan().equalsIgnoreCase("aus")){
           System.out.println("tidak sesuai");
           tidaksesuai++;
       }else{
           System.out.println("sesuai");
           sesuai++;
       }
       if(sesuai<tidaksesuai){
           hasil=0;
       }else{
           hasil=1;
       }
      return hasil;
    }
    @Override
    void persentasekenyamanan(){
       int persen = sesuai*20;
        System.out.println("persentase keseuaian kondisi ruangan "+persen+"%");
    }
    int analisis_keamanan(){
        if (ru.getKekokohan().equalsIgnoreCase("kokoh")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if(ru.getJumlah_kunci()>=1){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getJumlah_jendela()>=1){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }if (ru.getBahaya().equalsIgnoreCase("aman")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai ");
            tidaksesuai++;
        }
        if (sesuai<tidaksesuai){
            hasil=0;
        }else{
            hasil=1;
        }
        return hasil;
    }
    @Override
    void persentasekeamanan(){
       int persen = (int) (sesuai*33.333333);
        System.out.println("persentase keseuaian kondisi ruangan "+persen+"%");
    }

}
