
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class induk extends ruang{
    Scanner in = new Scanner(System.in);
    public void input_identitas_ruang_kelas() {
		System.out.println("input ruang kelas");
		setNama_ruang(in.next());
		System.out.println("input lokasi ruang kelas");
		setLokasi_ruang(in.next());
                System.out.println("pilih fakultas");
		setFakultas(in.next());
                
    
}
}
