import java.util.Scanner;

public class TugasDiskusi4_21 {
    

    public static void main(String[] args) {
        String[] username = { "admin1", "pegawai2", "manajer3" };
        String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };

        String namaPegawai, jabatan, bulanGaji, kehadiran;
        int jumlahJamKerja, jumlahJamLembur, totalJamKerja, usia, bonus = 0, lamaBekerja, jumlahPegawai = 3;
        int upah = 15700, pajak = 25000, totalJamLembur, totalGaji, gajiPokok = 0;
        int menuAdmin, menuManajer;
        boolean isAuthenticated = false;
        boolean pesan = true;
        boolean ifManajer = true;
        Scanner input = new Scanner(System.in);

        // mendeklarasikan array
        String[] namaPegawai2, jenisKelaminPegawai, ttlPegawai, kebangsaanPegawai, emailPegawai, alamatPegawai,
                teleponPegawai;
        namaPegawai2 = new String[jumlahPegawai];
        jenisKelaminPegawai = new String[jumlahPegawai];
        ttlPegawai = new String[jumlahPegawai];
        kebangsaanPegawai = new String[jumlahPegawai];
        emailPegawai = new String[jumlahPegawai];
        alamatPegawai = new String[jumlahPegawai];
        teleponPegawai = new String[jumlahPegawai];

        // Mendeklarasikan nama-nama hari
        String namaHari[] = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" };
        // Menginisialisasi absen
        String absen[][] = new String[jumlahPegawai][namaHari.length];

        while (true) {
            for (int kesempatanLogin = 1; kesempatanLogin <= 3; kesempatanLogin++) { // Membatasi jumlah maksimal
                                                                                     // percobaan login

                int sisaKesempatan = 3 - kesempatanLogin;// menghitung sisa kesempatan login

                System.out.println("====================================");
                System.out.println("     Sistem Penggajian Restoran     ");
                System.out.println("====================================");
                System.out.print("Masukkan username: ");
                String usernameInput = input.nextLine();

                System.out.print("Masukkan password: ");
                String passwordInput = input.nextLine();

                // Memeriksa apakah username dan password sesuai
                for (int i = 0; i < username.length; i++) {
                    if (usernameInput.equalsIgnoreCase(username[i]) && passwordInput.equals(password[i])) {
                        isAuthenticated = true;
                        break;
                    } else {
                        isAuthenticated = false;
                    }
                }

                if (isAuthenticated) {
                    System.out.println("\nSelamat datang, " + usernameInput + "!");
                    if (usernameInput.equalsIgnoreCase("pegawai2")) {
                        System.out.println("=== MOHON MENGISI DATA DI BAWAH INI ====");
                        System.out.print("Masukkan Nama Lengkap Anda : ");
                        namaPegawai = input.nextLine();
                        System.out.print("Masukkan Jabatan Anda (Koki/Kasir/Pramusaji): ");
                        jabatan = input.nextLine();
                        System.out.print("Masukkan Usia Anda : ");
                        usia = input.nextInt();
                        System.out.print("Masukkan Lama Anda Bekerja : ");
                        lamaBekerja = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan Gaji Bulan Yang Akan Diambil : ");
                        bulanGaji = input.nextLine();
                        System.out.print("Masukkan Jumlah Jam Kerja Anda : ");
                        jumlahJamKerja = input.nextInt();
                        System.out.print("Masukkan Jumlah Jam Lembur Anda Jika Ada : ");
                        jumlahJamLembur = input.nextInt();

                      // Memilih jabatan
                        switch (jabatan) {

                            case "Koki":
                                gajiPokok = 2800000;
                                if (usia >= 50 && lamaBekerja >= 5) {
                                    bonus = 1000000;
                                    System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                                } else {
                                    System.out.print(
                                            "Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                                }
                                break;
                            case "Kasir":
                                gajiPokok = 2500000;
                                if (usia >= 50 && lamaBekerja >= 5) {
                                    bonus = 1000000;
                                    System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                                } else {
                                    System.out.print(
                                            "Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                                }
                                break;
                            case "Pramusaji":
                                gajiPokok = 2300000;
                                if (usia >= 50 && lamaBekerja >= 5) {
                                    bonus = 1000000;
                                    System.out.println("Jabatan anda " + jabatan + ", Bonus anda " + bonus);
                                } else {
                                    System.out.print(
                                            "Maaf, usia dan masa kerja anda belum memenuhi syarat untuk mendapatkan bonus");
                                }
                                break;
                            default:
                                System.out.print("Golongan Jabatan Tidak Ditemukan");
                                break;
                        }

                        totalJamKerja = jumlahJamKerja * 26;// rata - rata jumlah jam dengan 6 hari kerja seminggu
                        totalJamLembur = jumlahJamLembur * upah;
                        totalGaji = gajiPokok + totalJamLembur + bonus - pajak;
                        System.out.println("\nTotal Jam Kerja Anda adalah " + totalJamKerja + " jam");
                        System.out.println("Total Gaji Yang Anda Terima Adalah : " + "Rp." + totalGaji);
                        break;

                    } else if (usernameInput.equalsIgnoreCase("admin1")) {
                        while (true) {
                            System.out.println("===BERIKUT PILIHAN MENU ADMIN===");
                            System.out.println("1. Menu Input Data Pegawai");
                            System.out.println("2. Menu Input Jumlah Gaji Pegawai");
                            System.out.println("3. Menu Penyusunan Jadwal Pembayaran Gaji");
                            System.out.println("4. Rekap Manajemen Absensi Pegawai");
                            System.out.println("5. logout");
                            System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4): ");

                            menuAdmin = input.nextInt();
                            input.nextLine();

                            if (menuAdmin == 1) {
                                System.out.print("Masukkan Jumlah Pegawai: ");
                                jumlahPegawai = input.nextInt();
                                input.nextLine();

                                for (int i = 0; i < jumlahPegawai; i++) {
                                    System.out.println("=====================================");
                                    System.out.println("\nMASUKKAN DATA PEGAWAI KE-" + (i + 1));
                                    System.out.print("Masukkan Nama Lengkap Pegawai: ");
                                    namaPegawai2[i] = input.nextLine();
                                    System.out.print("Masukkan Jenis Kelamin Pegawai: ");
                                    jenisKelaminPegawai[i] = input.nextLine();
                                    System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
                                    ttlPegawai[i] = input.nextLine();
                                    System.out.print("Masukkan Kebangsaan Pegawai: ");
                                    kebangsaanPegawai[i] = input.nextLine();
                                    System.out.print("Masukkan Alamat Email Pegawai: ");
                                    emailPegawai[i] = input.nextLine();
                                    System.out.print("Masukkan Alamat Pegawai: ");
                                    alamatPegawai[i] = input.nextLine();
                                    System.out.print("Masukkan Nomor Telepon Pegawai: ");
                                    teleponPegawai[i] = input.nextLine();
                                }

                                System.out.println("\nDATA PEGAWAI YANG TELAH DI INPUT:");
                                for (int i = 0; i < jumlahPegawai; i++) {
                                    System.out.println("Pegawai ke-" + (i + 1));
                                    System.out.println("Nama: " + namaPegawai2[i]);
                                    System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                    System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                    System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                    System.out.println("Email: " + emailPegawai[i]);
                                    System.out.println("Alamat: " + alamatPegawai[i]);
                                    System.out.println("Telepon: " + teleponPegawai[i]);
                                    System.out.println("-----------------------------");
                                }

                                // Pencarian berdasarkan nama
                                System.out.print("Masukkan nama pegawai yang akan dicari: ");
                                String namaCari = input.nextLine();
                                boolean ditemukan = false;

                                for (int i = 0; i < jumlahPegawai; i++) {
                                    if (namaPegawai2[i].equalsIgnoreCase(namaCari)) {
                                        System.out.println("Data ditemukan!");
                                        System.out.println("Pegawai ke-" + (i + 1));
                                        System.out.println("Nama: " + namaPegawai2[i]);
                                        System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                        System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                        System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                        System.out.println("Email: " + emailPegawai[i]);
                                        System.out.println("Alamat: " + alamatPegawai[i]);
                                        System.out.println("Telepon: " + teleponPegawai[i]);
                                        ditemukan = true;
                                        break;
                                    }
                                }

                                if (!ditemukan) {
                                    System.out.println("Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
                                }

                            } else {
                                System.out.println("Tidak Ada Pilihan");
                            }
                            break;

                        }
                    } else if (usernameInput.equalsIgnoreCase("manajer3")) {
                        while (ifManajer) {
                            System.out.println("===BERIKUT PILIHAN MENU MANAJER===");
                            System.out.println("1. Tampilkan Data Pegawai");
                            System.out.println("2. Hasil rekap absensi karyawan");
                            System.out.println("3. Pencarian data");
                            System.out.println("4. Input kehadiran karyawan(fitur punya e pegawai)");
                            System.out.println("5. Log Out");
                            System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4/5): ");
                            menuManajer = input.nextInt();
                            input.nextLine();

                            switch (menuManajer) {
                                case 1:
                                    for (int i = 0; i < jumlahPegawai; i++) {

                                        System.out.println("=====Daftar nama Pegawai ke-" + (i + 1) + "=====");
                                        System.out.println("Nama: " + namaPegawai2[i]);
                                        System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                        System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                        System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                        System.out.println("Email: " + emailPegawai[i]);
                                        System.out.println("Alamat: " + alamatPegawai[i]);
                                        System.out.println("Telepon: " + teleponPegawai[i]);
                                        System.out.println("-----------------------------");
                                    }
                                    break;

                                case 2:
                                    System.out.println("\n Daftar Absensi karyawan: \n");

                                    for (int i = 0; i < jumlahPegawai; i++) {
                                        System.out.println("Karyawan " + (i + 1) + ": ");
                                        for (int j = 0; j < absen[i].length; j++) {
                                            if (absen[i][j] == null) {
                                                absen[i][j] = "Kosong";
                                            }
                                            System.out.println(" hari " + namaHari[j] + ": " + absen[i][j]);

                                        }
                                        System.out.println("-----------------------------");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Masukkan nama pegawai yang akan dicari: ");
                                    String namaCari = input.nextLine();
                                    boolean ditemukan = false;

                                    for (int i = 0; i < jumlahPegawai; i++) {
                                        if (namaPegawai2[i].equalsIgnoreCase(namaCari)) {
                                            System.out.println("Data ditemukan!");
                                            System.out.println("Pegawai ke-" + (i + 1));
                                            System.out.println("Nama: " + namaPegawai2[i]);
                                            System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                            System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                            System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                            System.out.println("Email: " + emailPegawai[i]);
                                            System.out.println("Alamat: " + alamatPegawai[i]);
                                            System.out.println("Telepon: " + teleponPegawai[i]);
                                            ditemukan = true;
                                            break;
                                        }
                                    }

                                    if (!ditemukan) {
                                        System.out
                                                .println("Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
                                        break;
                                    }
                                case 4:
                                    for (int i = 0; i < jumlahPegawai; i++) {
                                        System.out.println("Karyawan " + (i + 1) + ": ");

                                        for (int j = 0; j < absen[i].length; j++) {
                                            System.out.print(" Daftar Hadir pada hari " + namaHari[j] + "(Y/N): ");
                                            kehadiran = input.nextLine();

                                            if (kehadiran.equalsIgnoreCase("y")) {
                                                absen[i][j] = "Hadir";
                                            } else if (kehadiran.equalsIgnoreCase("n")) {
                                                absen[i][j] = "Tidak Hadir";
                                            } else {
                                                System.out.println("Input salah");
                                                j--;
                                            }

                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.println("Anda telah logout");
                                    ifManajer = false;
                                    break;

                                default:
                                    System.out.println("Tidak Ada Pilihan");
                                    break;
                            }
                        }

                    }

                } else {
                    System.out.println("Username dan password salah. Silakan coba lagi.");
                    System.out.printf("Peringatan! : Anda memiliki %dx kesempatan login \n", sisaKesempatan);
                    // memberitahu sisa kesempatan login
                    pesan = false;
                }

            }
            if (pesan) {
                System.out.println("Terimakasih!");
            } else {
                System.out.println("Anda telah gagal login sebanyak 3 kali. Aplikasi otomatis keluar.");
                input.close();
            }

        }

    }
}
