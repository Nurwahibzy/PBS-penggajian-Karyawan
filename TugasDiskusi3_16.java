import java.util.Scanner;

public class TugasDiskusi3_16 {

    public static void main(String[] args) {

        String[] username = { "admin1", "pegawai2", "manajer3" };
        String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };

        String namaPegawai, jabatan, bulanGaji;
        int jumlahJamKerja, jumlahJamLembur, totalJamKerja, usia, bonus = 0, lamaBekerja;
        int upah = 15700, totalJamLembur, totalGaji, gajiPokok = 0;

        Scanner input16 = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String usernameInput = input16.nextLine();

        System.out.print("Masukkan password: ");
        String passwordInput = input16.nextLine();

        boolean isAuthenticated = false;

        // Memeriksa apakah username dan password sesuai
        for (int i = 0; i < username.length; i++) {
            if (usernameInput.equals(username[i]) && passwordInput.equals(password[i])) {
                isAuthenticated = true;
                break;
            }
        }

        if (isAuthenticated) {
            System.out.println("Selamat datang, " + usernameInput + "!");
            System.out.println("=== MOHON MENGISI DATA DI BAWAH INI ====");
            System.out.print("Masukkan Nama Lengkap Anda : ");
            namaPegawai = input16.nextLine();
            System.out.print("Masukkan Jabatan Anda (Koki/Kasir/Penyaji): ");
            jabatan = input16.nextLine();
            System.out.print("Masukkan Usia Anda : ");
            usia = input16.nextInt();
            System.out.print("Masukkan Lama Anda Bekerja : ");
            lamaBekerja = input16.nextInt();
            input16.nextLine();
            System.out.print("Masukkan Gaji Bulan Yang Akan Diambil : ");
            bulanGaji = input16.nextLine();
            System.out.print("Masukkan Jumlah Jam Kerja Anda : ");
            jumlahJamKerja = input16.nextInt();
            System.out.print("Masukkan Jumlah Jam Lembur Anda Jika Ada : ");
            jumlahJamLembur = input16.nextInt();

            // Memilih jabatan
            switch (jabatan) {

                case "Koki":
                    gajiPokok = 2800000;
                    if (usia >= 50 && lamaBekerja >= 5) {
                        bonus = 1000000;
                        System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                    } else {
                        System.out.print("Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                    }
                    break;
                case "Kasir":
                    gajiPokok = 2500000;
                    if (usia >= 50 && lamaBekerja >= 5) {
                        bonus = 1000000;
                        System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                    } else {
                        System.out.print("Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                    }
                    break;
                case "Penyaji":
                    gajiPokok = 2300000;
                    if (usia >= 50 && lamaBekerja >= 5) {
                        bonus = 1000000;
                        System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                    } else {
                        System.out.print("Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                    } 
                    break;
                default:
                    System.out.print("Golongan Jabatan Tidak Ditemukan");
                    break;
            }
    
            totalJamKerja= jumlahJamKerja * 26;// rata - rata jumlah dengan 6 hari kerja seminggu
            totalJamLembur = jumlahJamLembur * upah;
            totalGaji = gajiPokok + totalJamLembur  + bonus;
            System.out.println("\nTotal Jam Kerja Anda adalah " + totalJamKerja+ " jam");
            System.out.println("Total Gaji Yang Anda Terima Adalah : " + "Rp." + totalGaji);

        } else {
            System.out.println("Username dan password salah. Silakan coba lagi.");
        }

        input16.close();
    }

}
