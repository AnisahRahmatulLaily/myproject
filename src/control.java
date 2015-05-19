
import java.util.Scanner;

public class control extends induk {

    ruang ru = new ruang();
    in_out io = new in_out();
    Scanner in = new Scanner(System.in);
    int sesuai, tidaksesuai, hasil;
    //String  hasil;
    int i, r, LCD = 0, AC = 0, lampu = 0, kipas = 0, steker = 0, CCTV = 0;
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

    int anilisis_kondisi_ruang() {
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
        if (tidaksesuai > sesuai) {
            hasil = 0;
        } else {
            hasil = 1;
        }
        return hasil;
    }

    int analisis_kelistrikan() {
        if (ru.getJumlah_steker() >= 4) {
            System.out.println("sesuai");
            sesuai++;
        } else {
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
        if (sesuai < tidaksesuai) {
            hasil = 0;
        } else {
            hasil = 1;
        }
        return hasil;
    }

    int analisis_LCD() {
        if (ru.getJumlah_kabel_LCD() > 1) {
            System.out.println("sesuai");
            sesuai++;
        } else {
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
        if (sesuai < tidaksesuai) {
            hasil = 0;
        } else {
            hasil = 1;
        }
        return hasil;
    }

    int analisis_lampu() {
        if (ru.getJumlah_lampu() >= 18) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getKondisi_lampu().equalsIgnoreCase("atapruangan")) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (sesuai < tidaksesuai) {
            hasil = 0;
        } else {

            hasil = 1;
        }
        return hasil;
    }

    int analisis_kipas_angin() {
        if (ru.getJumlah_kipas_angin() >= 2) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (ru.getPosisi_AC().equalsIgnoreCase("atapruangan") ) {
            System.out.println("sesuai");
            sesuai++;
        } else {
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }
        if (sesuai < tidaksesuai) {
            hasil = 0;
        } else {
            hasil = 1;
        }
        return hasil;
    }

    int analisis_AC() {
        if (ru.getJumlah_AC()>=1){
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
        if (sesuai<tidaksesuai){
            hasil=0;
        }else{
            hasil=1;
        }
        return hasil;
    }

    int analisis_internet() {
        if(ru.getSSID().equalsIgnoreCase("ummhotspot")){
            System.out.println("sesuai");
            sesuai++;
        }else{
            System.out.println("tidak sesuai");
            tidaksesuai++;
        }if(sesuai<tidaksesuai){
            hasil=0;
        }else{
            hasil=1;
        
        }
        return hasil;

    }

    public int analisis_CCTV() {
        if (ru.getJumlah_CCTV()==2){
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
    int analisis_kebersihan(){
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
        if (sesuai<tidaksesuai){
            hasil=0;
        }else{
            hasil =1;
        }
        return hasil;
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
//    double hitung_luas_ruang() {
//		return ru.getPanjang_ruang() * ru.getLebar_ruang();
//	}
//
//	public String hitung_bentuk_ruang() {
//		String bentuk = "persegi panjang";
//		if (ru.getPanjang_ruang() != ru.getLebar_ruang()) {
//			System.out.println(bentuk);
//			if (bentuk == "persegi panjang") {
//				hasil="sesuai";
//			}
//		} else {
//			hasil="bentuk tidak sesuai";
//		}
//            return hasil;
//	}
//
//	public double hitung_rasio_luas() {
//		double hasil;
//		hasil = hitung_luas_ruang() / ru.getJumlah_kursi();
//		if (hasil >= 0.5) {
//			System.out.println("sesuai");
//		} else {
//			System.out.println("tidak sesuai");
//			//input_kondisi_ruang_kelas();
//		}
//		return hasil;
//	}
//
//	public String analisis_pintu_dan_jendela() {
//            String hasil;
//		if (ru.getJumlah_pintu() >= 2 && ru.getJumlah_jendela() >= 1) {
//			hasil="sesuai";
//		} else {
//			hasil="tidak sesuai";
//		}
//            return hasil ;
//	}
//      public String analisis_kelistrikan() {
//            if (ru.getPosisi_steker().equalsIgnoreCase("1") && ru.getJumlah_steker() >=4 && steker ==4){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }return hasil;
//            
//	}
//
//	public String analisis_LCD() {
//	if (ru.getPosisi_kabel_LCD().equalsIgnoreCase("1") && ru.getJumlah_steker() >=1 && LCD==1){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }return hasil;
//	}
//	public String analisis_lampu() {
//        if (ru.getPosisi_lampu().equalsIgnoreCase("1") && ru.getJumlah_lampu()>=18 && lampu==18){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }return hasil;
//            
//	}
//
//	public String analisis_kipas_angin() {
//	if (ru.getPosisi_kipas_angin().equalsIgnoreCase("1") && ru.getJumlah_lampu()>=2 && kipas==2){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }return hasil;
//	}
//
//	public String analisis_AC() {
//	if (ru.getPosisi_kipas_angin().equalsIgnoreCase("1") && ru.getJumlah_lampu()>=2 && kipas==2){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }
//        return hasil;
//	}
//
//	public String analisis_internet() {
//            
//		if (ru.getSSID() == "UMM Hotspot") {
//			hasil="sesuai";
//			if (ru.getBandwidth() == "bisa") {
//				hasil="sesuai";
//			}
//		} else {
//			hasil="tidak sesuai";
//		}return hasil;
//
//	}
//
//	public String analisis_CCTV() {
//	if (ru.getPosisi_CCTV().equalsIgnoreCase("1") && ru.getJumlah_CCTV()>=2 && CCTV==2){
//                hasil="sesuai";
//            }else{
//                hasil="tidak sesuai";
//            }
//        return hasil;
//
//	}
//
//    public String analisis_kebersihan() {
//        if (ru.getKondisi_lantai() == "bersih"
//                && ru.getKondisi_dinding() == "bersih"
//                && ru.getKondisi_atap() == "bersih"
//                && ru.getKondisi_pintu() == "baik"
//                && ru.getKondisi_jendela() == "bersih") {
//            hasil = "sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_sirkulasi_udara() {
//        if ("lancar".equals(ru.getSirkulasi_udara())) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_Pencahayaan() {
//        if ((ru.getPencahayaan() >= 250) && ru.getPencahayaan() <= 350) {
//            hasil = "sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_Kelembapan() {
//        if ((ru.getKelembapan() >= 70) && ru.getKelembapan() <= 80) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_Suhu() {
//        if ((ru.getSuhu() >= 25) && ru.getSuhu() <= 35) {
//            hasil = "sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_kebisingan() {
//        if ("tidak bising".equals(ru.getKebisingan())) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_bau() {
//        if ("tidak bau".equals(ru.getBau())) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_kebocoran() {
//        if ("tidak bocor".equals(ru.getKebocoran())) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_kerusakan() {
//        if ("tidak rusak".equals(ru.getKerusakan())) {
//            hasil = "sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public String analisis_keausan() {
//        if ("tidak aus".equals(ru.getKeausan())) {
//            hasil = "Sesuai";
//        } else {
//            hasil = "tidak sesuai";
//        }
//        return hasil;
//    }
//
//    public void analisis_kekokohan() {
//        if (ru.getKekokohan() == "kokoh") {
//            System.out.println("sesuai");
//        } else {
//            System.out.println("tidak sesuai");
//        }
//    }
//
//    public void analisis_kunci_pintu_jendela() {
//        if (ru.getJumlah_kunci() != 0 && ru.getJumlah_jendela() != 0) {
//            System.out.println("sesuai");
//        } else {
//            System.out.println("tidak sesuai");
//        }
//    }
//
//    public String analisis_keamanan_ruang() {
//        if (ru.getBahaya() == "aman") {
//            hasil = "sesuai";
//        }
//        return hasil;
//    }

    public control() {
    }

}
