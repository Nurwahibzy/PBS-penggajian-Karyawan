import java.util.Scanner;

public class Tugasdiskusi3_21 {

    public static void main(String[] args) {

        String[] username = { "admin1", "pegawai2", "manajer3" };
        String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };

        String namaPegawai, jabatan, bulanGaji;
        int jumlahJamKerja, jumlahJamLembur, totalJamKerja, usia, bonus = 0, lamaBekerja;
        int upah = 15700, totalJamLembur, totalGaji, gajiPokok = 0;

        Scanner input21 = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String usernameInput = input21.nextLine();

        System.out.print("Masukkan password: ");
        String passwordInput = input21.nextLine();

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
            namaPegawai = input21.nextLine();
            System.out.print("Masukkan Jabatan Anda (A/B/C): ");
            jabatan = input21.nextLine();
            System.out.print("Masukkan Usia Anda : ");
            usia = input21.nextInt();
            System.out.print("Masukkan Lama Anda Bekerja : ");
            lamaBekerja = input21.nextInt();
            input21.nextLine();
            System.out.print("Masukkan Gaji Bulan Yang Akan Diambil : ");
            bulanGaji = input21.nextLine();
            System.out.print("Masukkan Jumlah Jam Kerja Anda : ");
            jumlahJamKerja = input21.nextInt();
            System.out.print("Masukkan Jumlah Jam Lembur Anda Jika Ada : ");
            jumlahJamLembur = input21.nextInt();

            // Memilih jabatan
            switch (jabatan) {

                case "A":
                    gajiPokok = 2800000;
                    if (usia >= 50 && lamaBekerja >= 5) {
                        bonus = 1000000;
                        System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                    } else {
                        System.out.print("Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                    }
                    break;
                case "B":
                    gajiPokok = 2500000;
                    if (usia >= 50 && lamaBekerja >= 5) {
                        bonus = 1000000;
                        System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                    } else {
                        System.out.print("Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                    }
                    break;
                case "C":
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

        input21.close();
    }

}
