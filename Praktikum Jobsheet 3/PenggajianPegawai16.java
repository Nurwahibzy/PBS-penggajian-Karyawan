import java.util.Scanner;
public class PenggajianPegawai16 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nama_pegawai, jabatan, bulan_gaji;
        int jumlah_jam_kerja, jumlah_jam_lembur, total_jam_kerja;
        int upah = 15700, total_jam_lembur, total_gaji, gaji_pokok = 2000000;

        System.out.print("Masukkan Nama Lengkap Anda : ");
        nama_pegawai = input.nextLine();
        System.out.print("Masukkan Jabatan Anda : ");
        jabatan = input.nextLine();
        System.out.print("Masukkan Gaji Bulan Yang Akan Diambil : ");
        bulan_gaji = input.nextLine();
        System.out.print("Masukkan Jumlah Jam Kerja Anda : ");
        jumlah_jam_kerja = input.nextInt();
        System.out.print("Masukkan Jumlah Jam Lembur Anda Jika Ada : ");
        jumlah_jam_lembur = input.nextInt();
        
        total_jam_kerja = jumlah_jam_kerja * 26;//rata - rata jumlah dengan 6 hari kerja seminggu
        total_jam_lembur = jumlah_jam_lembur * upah;
        total_gaji = gaji_pokok + total_jam_kerja + total_jam_lembur;
        System.out.println("Total Gaji Yang Anda Terima Adalah : " + "Rp." + total_gaji);

     
    }
    
}
