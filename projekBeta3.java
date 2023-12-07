
import java.util.Scanner;

public class projekBeta3 {

    static Scanner input = new Scanner(System.in);
    static String[] username = { "admin1", "pegawai2", "manajer3" };
    static String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };
    static String[][] dataPegawai = new String[100][10]; // 100 pegawai, 10 atribut(nama,jabatan, Usia, lama bekerja, jenisKelamin,ttl, kebangsaan, email, alamat, noTelp )
static {
    // Inisialisasi data awal
    dataPegawai[0][0] = "Adam";
    dataPegawai[0][1] = "Koki";
    dataPegawai[0][2] = "50";
    dataPegawai[0][3] = "5";
    dataPegawai[0][4] = "L";
    dataPegawai[0][5] = "Malang, 12 Januari 2005";
    dataPegawai[0][6] = "Indonesia";
    dataPegawai[0][7] = "adamcuy@gmail.com";
    dataPegawai[0][8] = "Malang";
    dataPegawai[0][9] = "08123456378";

}

    static double[][] jadwalGaji = new double[100][4]; // 100 pegawai, 4 atribut(gaji pokok, bonus, potongan, total
                                                       // gaji)
    static int[][] kinerjaPegawai = new int[100][3]; // 100 pegawai, 3 atribut(baik, cukup, perlu perbaikan)
    static int totalKehadiran = 0, totalTidakHadir = 0;

    static int[] jumlahHariCuti;
    static boolean[] statusPersetujuan;
    static int jumlahPermintaan = 0;
    static double totalPengeluaranGaji = 0;
    static int nomorSlip;

    // Menginisialisasi absen
    static String[][] absen = new String[100][6];
    // Mendeklarasikan nama-nama hari
    static String namaHari[] = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };

    static String usernameInput, passwordInput;

    static int jumlahPegawai = 1;

    public static void main(String[] args) {
        login();
        // menuManajer();
    }

    static void login() {
        for (int kesempatanLogin = 1; kesempatanLogin <= 3; kesempatanLogin++) { // Membatasi jumlah maksimal
                                                                                 // percobaan login

            int sisaKesempatan = 3 - kesempatanLogin;// menghitung sisa kesempatan login

            System.out.println("\n====================================");
            System.out.println("     Sistem Penggajian Restoran     ");
            System.out.println("====================================");
            System.out.print("Masukkan username: ");
            usernameInput = input.nextLine();

            System.out.print("Masukkan password: ");
            passwordInput = input.nextLine();

            if (isTerverifikasi(usernameInput, passwordInput)) {
                System.out.println();
                System.out.println("Login berhasil!");
                cekHakAkses();
            } else {
                System.out.print("Username dan password salah.");
                // memberitahu sisa kesempatan login
                if (sisaKesempatan > 0) {
                    System.out.println("Silakan coba lagi.\n");
                    System.out.printf("Peringatan! : Anda memiliki %dx kesempatan login \n", sisaKesempatan);
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Anda telah gagal login sebanyak 3 kali. Aplikasi otomatis keluar.");
                }
            }

        }
    }

    // Memeriksa apakah username dan password sesuai
    static boolean isTerverifikasi(String a, String b) {
        for (int i = 0; i < username.length; i++) {
            if (a.equalsIgnoreCase(username[i]) && b.equals(password[i])) {
                return true;
            }
        }
        return false;
    }

    // memilih hak akses
    static void cekHakAkses() {
        if (usernameInput.equalsIgnoreCase("admin1")) {
            // menu admin
            menuAdmin();
        } else if (usernameInput.equalsIgnoreCase("pegawai2")) {
            // menu pegawai
            menuPegawai();
        } else {
            // menu manajer
            menuManajer();
        }
    }

    static void menuAdmin() {
        System.out.println("\n===PILIHAN MENU ADMIN===");
        System.out.println("1. Menu Manajemen Data Pegawai");
        System.out.println("2. Menu Penyusunan Jadwal Pembayaran Gaji");
        System.out.println("3. Menu Catat dan Lacak Kehadiran Pegawai dan Jam Kerja");
        System.out.println("4. Menu Lihat Permintaan dan Persetujuan Cuti");
        System.out.println("5. Menu Laporan Pengeluaran Gaji, Kinerja Pegawai, dan Tren Kehadiran");
        System.out.println("6. Keluar (Log Out)");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4/5/6): ");
        int menuAdmin = input.nextInt();
        input.nextLine();

        switch (menuAdmin) {
            case 1:
                menuManajemen();
                break;
            case 2:
                menuPenyusunanJadwal();
                break;
            case 3:
                menuLacakKehadiran();
                break;
            case 4:
                menuCuti();
                break;
            case 5:
                menuKinerjaPegawai();
                break;
            case 6:
                login();
                break;

            default:
                System.out.println("Input salah");
                menuAdmin();
                break;
        }
    }

    static void menuPegawai() {
        System.out.println("===BERIKUT PILIHAN MENU PEGAWAI===");
        System.out.println("1. Cetak Slip Gaji");
        System.out.println("2. Input kehadiran");
        System.out.println("3. Permintaan Cuti");
        System.out.println("4. Log Out");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3): ");
        int menuPegawai = input.nextInt();
        input.nextLine();
        switch (menuPegawai) {
            case 1:
                System.out.println("daftar pegawai:");
                for (int i = 0; i < jumlahPegawai; i++) {
                    System.out.println((i + 1) + ". " + dataPegawai[i][0]);
                }
                System.out.println("Masukkan nomor pegawai : ");
                nomorSlip = input.nextInt();
                input.nextLine();
                cetakSlip(nomorSlip);
                break;
            case 2:
                inputKehadiran();
                break;
            case 3:
                prosesPermintaanCuti();
                break;
            case 4:
                login();
                break;
            default:
                System.out.println("Input salah");
                menuPegawai();
                break;
        }

    }

    static void menuManajer() {
        System.out.println("\n===PILIHAN MENU MANAJER===");
        System.out.println("1. Tampilkan Data Pegawai");
        System.out.println("2. Hasil rekap absensi karyawan");
        System.out.println("3. Pencarian data");
        System.out.println("4. Log Out");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4): ");
        int menuManajer = input.nextInt();
        input.nextLine();
        switch (menuManajer) {
            case 1:
                lihatDetailPegawai(2);
                break;
            case 2:
                cetakAbsensiKaryawan();
                break;
            case 3:
                namaCari();
                break;
            case 4:
                login();
                break;
            default:
                System.out.println("Input salah");
                menuManajer();
                break;
        }
    }

    static void menuManajemen() {
        System.out.println("\nMENU MANAJEMEN DATA PEGAWAI");
        System.out.println("1. Input Data Pegawai");
        System.out.println("2. Edit Data Pegawai");
        System.out.println("3. Hapus Data Pegawai");
        System.out.println("4. Cari Data Pegawai");
        System.out.println("5. Lihat Detail Data Pegawai");
        System.out.println("6. Kembali");
        System.out.print("Pilih Menu: ");
        int menuManajemen = input.nextInt();
        input.nextLine();

        switch (menuManajemen) {
            case 1:
                inputPegawai();
                break;
            case 2:
                editPegawai();
                break;
            case 3:
                hapusPegawai();
                break;
            case 4:
                namaCari();
                break;
            case 5:
                lihatDetailPegawai(1);
                break;
            case 6:
                menuAdmin();
                break;
            default:
                System.out.println("Input salah");
                menuManajemen();
                break;
        }

    }

    static void inputPegawai() {
        System.out.print("Masukkan Jumlah Pegawai: ");
        jumlahPegawai = input.nextInt();
        input.nextLine();
        System.out.println();

        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("=====================================");
            System.out.println("\nMASUKKAN DATA PEGAWAI KE-" + (i + 1));
            System.out.print("Masukkan Nama Pegawai: ");
            dataPegawai[i][0] = input.nextLine();

            System.out.print("Masukkan Jabatan Pegawai (Koki/Kasir/Pramusaji): ");
            dataPegawai[i][1] = input.nextLine();

            System.out.print("Masukkan Usia Pegawai: ");
            dataPegawai[i][2] = input.nextLine();

            System.out.print("Masukkan Lama Bekerja Pegawai: ");
            dataPegawai[i][3] = input.nextLine();

            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
            dataPegawai[i][4] = input.nextLine();

            System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
            dataPegawai[i][5] = input.nextLine();

            System.out.print("Masukkan Kebangsaan Pegawai: ");
            dataPegawai[i][6] = input.nextLine();

            System.out.print("Masukkan Alamat Email Pegawai: ");
            dataPegawai[i][7] = input.nextLine();

            System.out.print("Masukkan Alamat Pegawai: ");
            dataPegawai[i][8] = input.nextLine();

            System.out.print("Masukkan Nomor Telepon Pegawai: ");
            dataPegawai[i][9] = input.nextLine();
        }

        System.out.println("\nDATA PEGAWAI YANG TELAH DI INPUT:");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Pegawai ke-" + (i + 1));
            System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
            System.out.println("Jabatan Pegawai: " + dataPegawai[i][1]);
            System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
            System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
            System.out.println("Jenis Kelamin: " + dataPegawai[i][4]);
            System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][5]);
            System.out.println("Kebangsaan: " + dataPegawai[i][6]);
            System.out.println("Email: " + dataPegawai[i][7]);
            System.out.println("Alamat: " + dataPegawai[i][8]);
            System.out.println("Telepon: " + dataPegawai[i][9]);
            System.out.println("-----------------------------");
        }

        menuManajemen();
    }

    static void editPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan diubah: ");
        String namaUbah = input.nextLine();
        boolean ditemukanUbah = false;

        for (int i = 0; i < jumlahPegawai; i++) {
            if (dataPegawai[i][0].equalsIgnoreCase(namaUbah)) {
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai (Koki/Kasir/Pramusaji): " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai: " + dataPegawai[i][4]);
                System.out.println("Tempat dan Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai: " + dataPegawai[i][6]);
                System.out.println("Email Pegawai: " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai: " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai: " + dataPegawai[i][9]);

                System.out.println("\nPILIH DATA PEGAWAI YANG AKAN DIUBAH:");
                System.out.println("1. Nama Pegawai");
                System.out.println("2. Jabatan Pegawai");
                System.out.println("3. Usia Pegawai");
                System.out.println("4. Lama Pegawai Bekerja");
                System.out.println("5. Jenis Kelamin");
                System.out.println("6. Tempat dan Tanggal Lahir");
                System.out.println("7. Kebangsaan");
                System.out.println("8. Email");
                System.out.println("9. Alamat");
                System.out.println("10. Nomor Telepon");
                System.out.print("Masukkan nomor pilihan: ");
                int pilihanUbah = input.nextInt();
                input.nextLine(); // Menangani newline setelah nextInt()

                switch (pilihanUbah) {
                    case 1:
                        System.out.print("Masukkan Nama Pegawai: ");
                        dataPegawai[i][0] = input.nextLine();
                        break;
                    case 2:
                        System.out.print("Masukkan Jabatan Pegawai (Koki/Kasir/Pramusaji): ");
                        dataPegawai[i][1] = input.nextLine();
                        break;
                    case 3:
                        System.out.print("Masukkan Usia Pegawai: ");
                        dataPegawai[i][2] = input.nextLine();
                        break;
                    case 4:
                        System.out.print("Masukkan Lama Pegawai Bekerja: ");
                        dataPegawai[i][3] = input.nextLine();
                        break;
                    case 5:
                        System.out.print("Masukkan Jenis Kelamin Pegawai: ");
                        dataPegawai[i][4] = input.nextLine();
                        break;
                    case 6:
                        System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
                        dataPegawai[i][5] = input.nextLine();
                        break;
                    case 7:
                        System.out.print("Masukkan Kebangsaan Pegawai: ");
                        dataPegawai[i][6] = input.nextLine();
                        break;
                    case 8:
                        System.out.print("Masukkan Alamat Email Pegawai: ");
                        dataPegawai[i][7] = input.nextLine();
                        break;
                    case 9:
                        System.out.print("Masukkan Alamat Pegawai: ");
                        dataPegawai[i][8] = input.nextLine();
                        break;
                    case 10:
                        System.out.print("Masukkan Nomor Telepon Pegawai: ");
                        dataPegawai[i][9] = input.nextLine();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }

                System.out.println("\nDATA PEGAWAI YANG TELAH DIUBAH:");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai: " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai: " + dataPegawai[i][4]);
                System.out.println("Tempat dan Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai: " + dataPegawai[i][6]);
                System.out.println("Email Pegawai: " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai: " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai: " + dataPegawai[i][9]);
                ditemukanUbah = true;
                break;
            }
        }
        menuManajemen();

        if (!ditemukanUbah) {
            System.out.println("Data pegawai dengan nama " + namaUbah + " tidak ditemukan.");
            menuManajemen();
        }

    }

    static void hapusPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan dihapus: ");
        String namaHapus = input.nextLine();
        boolean ditemukanHapus = false;

        for (int i = 0; i < jumlahPegawai; i++) {
            if (dataPegawai[i][0].equalsIgnoreCase(namaHapus)) {
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai: " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai: " + dataPegawai[i][4]);
                System.out.println("Tempat dan Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai: " + dataPegawai[i][6]);
                System.out.println("Email Pegawai: " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai: " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai: " + dataPegawai[i][9]);

                System.out.print("Apakah Anda yakin ingin menghapus data pegawai ini? (Y/N): ");
                String konfirmasi = input.nextLine();
                if (konfirmasi.toLowerCase().equals("y")) {
                    for (int j = i; j < jumlahPegawai - 1; j++) {
                        dataPegawai[j][0] = null;
                        dataPegawai[j][1] = null;
                        dataPegawai[j][2] = null;
                        dataPegawai[j][3] = null;
                        dataPegawai[j][4] = null;
                        dataPegawai[j][5] = null;
                        dataPegawai[j][6] = null;
                        dataPegawai[j][7] = null;
                        dataPegawai[j][8] = null;
                        dataPegawai[j][9] = null;
                    }
                    jumlahPegawai--;
                    System.out.println("Data pegawai berhasil dihapus.");
                } else {
                    System.out.println("Data pegawai tidak dihapus.");
                }
                ditemukanHapus = true;
                break;
            }
        }

        menuManajemen();

        if (!ditemukanHapus) {
            System.out.println("Data pegawai dengan nama " + namaHapus + " tidak ditemukan.");
            menuManajemen();
        }

    }

    static void lihatDetailPegawai(int a) {
        System.out.println("Pilih nomor pegawai untuk melihat detail:");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println((i + 1) + ". " + dataPegawai[i][0]);
        }

        System.out.print("Masukkan nomor pegawai: ");
        int pilihan = input.nextInt();
        System.out.println();

        if (pilihan > 0 && pilihan <= jumlahPegawai) {
            int i = pilihan - 1;
            System.out.println("Detail Pegawai:");
            System.out.println("Nama Pegawai                    : " + dataPegawai[i][0]);
            System.out.println("Jabatan Pegawai                 : " + dataPegawai[i][1]);
            System.out.println("Usia Pegawai                    : " + dataPegawai[i][2]);
            System.out.println("Lama Pegawai Bekerja            : " + dataPegawai[i][3]);
            System.out.println("Jenis Kelamin Pegawai           : " + dataPegawai[i][4]);
            System.out.println("Tempat dan Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
            System.out.println("Kebangsaan Pegawai              : " + dataPegawai[i][6]);
            System.out.println("Email Pegawai                   : " + dataPegawai[i][7]);
            System.out.println("Alamat Pegawai                  : " + dataPegawai[i][8]);
            System.out.println("Telepon Pegawai                 : " + dataPegawai[i][9]);
        } else {
            System.out.println("Nomor pegawai tidak valid.");
        }
        // mengecek akan kembali ke menu mana(admin/manajer)
        if (a == 1) {
            menuManajemen();
        } else {
            menuManajer();
        }
    }

    static void namaCari() {
        System.out.print("Masukkan Nama Pegawai yang akan dicari: ");
        String namaCari = input.nextLine();
        boolean ditemukanCari = false;

        for (int i = 0; i < dataPegawai.length; i++) {
            if (namaCari.equals(dataPegawai[i][0])) {
                System.out.println("=====================================");
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai                    : " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai                 : " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai                    : " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja            : " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai           : " + dataPegawai[i][4]);
                System.out.println("Tempat dan Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai              : " + dataPegawai[i][6]);
                System.out.println("Email Pegawai                   : " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai                  : " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai                 : " + dataPegawai[i][9]);
                System.out.println("=====================================");
                ditemukanCari = true;
                break;
            }
        }
        menuManajemen(); // kembali ke menu manajemen

        if (!ditemukanCari) {
            System.out.println("Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
            menuManajemen();
        }

    }

    static void menuPenyusunanJadwal() {
        System.out.println("Selamat datang di menu Penyusunan Gaji Pegawai!");
        System.out.print("Masukkan Jumlah Jabatan: ");
        int jumlahJabatan = input.nextInt();
        input.nextLine();  // Membersihkan buffer

        dataPegawai = new String[jumlahJabatan][2];
        jadwalGaji = new double[jumlahJabatan][3];

        for (int i = 0; i < jumlahJabatan; i++) {
            System.out.println("\nMasukkan informasi untuk Jabatan ke-" + (i + 1) + ":");

            System.out.print("Jabatan (Koki/Kasir/Pramusaji): ");
            dataPegawai[i][1] = input.nextLine().toLowerCase();

            System.out.print("Gaji Pokok untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][0] = input.nextDouble();

            System.out.print("Bonus untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][1] = input.nextDouble();

            System.out.print("Potongan untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][2] = input.nextDouble();

            input.nextLine();

        }

        tampilkanInformasiGaji();
        menuAdmin();
    }

    static void tampilkanInformasiGaji() {
        System.out.println("\nInformasi Gaji untuk Setiap Jabatan:");
        for (int i = 0; i < dataPegawai.length; i++) {
            System.out.println("=====================================");
            System.out.println("Jabatan: " + dataPegawai[i][1]);
            System.out.println("Gaji Pokok: Rp" + jadwalGaji[i][0]);
            System.out.println("Bonus: Rp" + jadwalGaji[i][1]);
            System.out.println("Potongan: Rp" + jadwalGaji[i][2]);
            System.out.println("=====================================");
        
        }


    }

    static void menuLacakKehadiran() {
        System.out.print("Masukkan jumlah pegawai: ");
        int jumlahPegawai = input.nextInt();
        input.nextLine(); // Membersihkan newline

        int[] jamKerja = new int[jumlahPegawai];
        // Mengisi data kehadiran dan jam kerja setiap pegawai
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Masukkan data untuk Pegawai " + (i + 1) + ":");
            System.out.print("Nama Pegawai: ");
            dataPegawai[i][0] = input.nextLine();
            System.out.print("Jam Kerja: ");
            jamKerja[i] = input.nextInt();
            // Membersihkan newline setelah input angka
            input.nextLine();
        }

        // Menampilkan data kehadiran dan jam kerja setiap pegawai
        System.out.println("\nData Kehadiran dan Jam Kerja Pegawai:");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Pegawai " + (i + 1) + ":");
            System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
            System.out.println("Jam Kerja: " + jamKerja[i] + " jam");
            System.out.println("-----------------------------");
        }

        // Menghitung total jam kerja seluruh karyawan
        int totalJamKerja = 0;
        for (int jam : jamKerja) {
            totalJamKerja += jam;
        }

        System.out.println("\nTotal Jam Kerja Seluruh Karyawan: " + totalJamKerja + " jam");

        // Menentukan karyawan dengan jam kerja terbanyak
        int maxJamKerja = -1;
        int indexPegawaiMaxJam = -1;

        for (int i = 0; i < jumlahPegawai; i++) {
            if (jamKerja[i] > maxJamKerja) {
                maxJamKerja = jamKerja[i];
                indexPegawaiMaxJam = i;
            }
        }

        System.out.println("Pegawai dengan Jam Kerja Terbanyak: " + dataPegawai[indexPegawaiMaxJam][0]);
        menuAdmin();

    }

    static void menuCuti() {
        int pilihanMenuCuti;
        while (true) {
            System.out.println("=== MENU PERMINTAAN dan PERSETUJUAN CUTI ===");
            System.out.println("1. Lihat Permintaan Cuti");
            System.out.println("2. Persetujuan Cuti");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");

            pilihanMenuCuti = input.nextInt();

            switch (pilihanMenuCuti) {
                case 1:
                    lihatPermintaanCuti();
                    break;
                case 2:
                    persetujuanCuti();
                    break;
                case 3:
                    menuAdmin();
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    menuAdmin();
            }
        }
    }

    static void lihatPermintaanCuti() {
        System.out.println("\n=== STATUS AKHIR PERMINTAAN CUTI ===");
        for (int i = 0; i < jumlahPermintaan; i++) {
            System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
            System.out.println("Jumlah Hari Cuti: " + jumlahHariCuti[i]);
            System.out.println("Status Persetujuan: " + (statusPersetujuan[i] ? "Disetujui" : "Belum Disetujui"));
            System.out.println("-----------------------------");
        }
    }

    static void prosesPermintaanCuti() {
        System.out.print("Masukkan Jumlah Pegawai: ");
        int jumlahPegawai = input.nextInt();
        jumlahPermintaan = jumlahPegawai; // Simpan jumlah permintaan

        // Inisialisasi array sesuai dengan jumlah pegawai
        dataPegawai = new String[jumlahPegawai][1];
        jumlahHariCuti = new int[jumlahPegawai];
        statusPersetujuan = new boolean[jumlahPegawai];

        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.print("Masukkan nama pegawai ke-" + (i + 1) + ": ");
            input.nextLine(); // Membersihkan buffer
            dataPegawai[i][0] = input.nextLine();

            System.out.print("Masukkan jumlah hari cuti yang diminta oleh " + dataPegawai[i][0] + ": ");
            jumlahHariCuti[i] = input.nextInt();
        }

        input.nextLine();
    }

    static void persetujuanCuti() {
        // Menampilkan informasi permintaan cuti dari setiap pegawai
        for (int i = 0; i < jumlahPermintaan; i++) {
            System.out
                    .println("Permintaan cuti dari " + dataPegawai[i][0] + " sebanyak " + jumlahHariCuti[i] + " hari.");

            // Admin memutuskan untuk menyetujui atau menolak permintaan cuti
            System.out.print("Admin: Setujui permintaan cuti? (ya/tidak): ");
            String jawabanAdmin = input.next();

            statusPersetujuan[i] = jawabanAdmin.equalsIgnoreCase("ya");

            if (statusPersetujuan[i]) {
                System.out.println("Permintaan cuti disetujui!");
            } else {
                System.out.println("Permintaan cuti ditolak.");
            }
        }
    }

    static void menuKinerjaPegawai() {
        // Input data gaji dan kinerja pegawai
        System.out.print("Masukkan jumlah pegawai: ");
        jumlahPegawai = input.nextInt();

        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("\nData Pegawai " + (i + 1) + ":");
            input.nextLine();
            System.out.print("Nama Pegawai: ");
            dataPegawai[i][0] = input.nextLine();
            System.out.print("Jabatan Pegawai: ");
            dataPegawai[i][1] = input.nextLine();
            System.out.print("Gaji Pegawai: ");
            jadwalGaji[i][3] = input.nextDouble();
            totalPengeluaranGaji += jadwalGaji[i][3];

            System.out.print("Kinerja Pegawai (1. Baik / 2. Cukup / 3. Perlu Perbaikan): ");
            int kinerja = input.nextInt();

            switch (kinerja) {
                case 1:
                    kinerjaPegawai[i][0]++;
                    break;
                case 2:
                    kinerjaPegawai[i][1]++;
                    break;
                case 3:
                    kinerjaPegawai[i][2]++;
                    break;
                default:
                    System.out.println("Pilihan kinerja tidak valid.");
                    i--; // Ulangi input untuk karyawan ini
                    break;
            }
        }

        // Input data kehadiran
        System.out.print("\nMasukkan total kehadiran: ");
        totalKehadiran = input.nextInt();
        totalTidakHadir = jumlahPegawai * 26 - totalKehadiran;

        // Menampilkan laporan
        System.out.println("\n=== Laporan Perusahaan ===");
        System.out.println("1. Pengeluaran Gaji");
        System.out.println("   Total Pengeluaran Gaji: Rp" + totalPengeluaranGaji);
        System.out.println("\n2. Kinerja Pegawai");

        // Menampilkan data kinerja pegawai
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("   " + dataPegawai[i][0]);
            System.out.println("      - Berkinerja Baik: " + kinerjaPegawai[i][0]);
            System.out.println("      - Cukup Berkinerja: " + kinerjaPegawai[i][1]);
            System.out.println("      - Perlu Perbaikan: " + kinerjaPegawai[i][2]);
        }

        System.out.println("\n3. Tren Kehadiran");
        System.out.println("   Total Kehadiran: " + totalKehadiran + " hari");
        System.out.println("   Total Tidak Hadir: " + totalTidakHadir + " hari");

        menuAdmin();
    }

    static void cetakAbsensiKaryawan() {
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

    }

    static void inputKehadiran() {
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Karyawan " + (i + 1) + ": ");

            for (int j = 0; j < absen[i].length; j++) {
                System.out.print("Daftar Hadir pada hari " + namaHari[j] + "(Y/N): ");
                String kehadiran = input.nextLine();

                if (kehadiran.equalsIgnoreCase("y")) {
                    absen[i][j] = "Hadir";
                } else if (kehadiran.equalsIgnoreCase("n")) {
                    absen[i][j] = "Tidak Hadir";
                } else {
                    System.out.println("Input salah, masukkan kembali dengan benar!");
                    j--;
                }

            }
        }
        System.out.println("Kehadiran telah direkam\nTerimakasih!");
        menuPegawai();

    }

    static void cetakSlip(int a) {
        a--;// mencari data dengan indeks yang sesuai
        int gajiPokok, bonus, total;
        switch (dataPegawai[a][1]) {
            case "Koki":
                gajiPokok = 2800000;
                break;
            case "Kasir":
                gajiPokok = 2500000;
                break;
            case "Pramusaji":
                gajiPokok = 2000000;
                break;
            default:
                gajiPokok = 0; // Atur nilai default jika golongan tidak dikenali
                break;
        }

        // Konversi string ke tipe data numerik
        int usia = Integer.parseInt(dataPegawai[a][2]);
        int lamaBekerja = Integer.parseInt(dataPegawai[a][3]);
        int biayaBpjs = 30000;
        if (usia > 50 && lamaBekerja > 5) {
            bonus = 700000;
        } else {
            bonus = 500000;
        }

        total = gajiPokok + bonus - biayaBpjs;
        System.out.println("=======SLIP GAJI=======");
        System.out.println("Nama        : " + dataPegawai[a][0]);
        System.out.println("Gaji pokok  : " + gajiPokok);
        System.out.println("Bonus       : " + bonus);
        System.out.println("Biaya BPJS  : " + biayaBpjs);
        System.out.println("-----------------------");
        System.out.println("Total       : " + total);
        System.out.println();
        menuPegawai();
    }

}