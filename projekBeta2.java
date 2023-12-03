
import java.util.Scanner;
import java.time.LocalDate;

public class projekBeta2 {

    static Scanner input = new Scanner(System.in);
    static String[] username = { "admin1", "pegawai2", "manajer3" };
    static String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };
    static String[][] dataPegawai = new String[100][8]; // 100 pegawai, 8 atribut(nama, jenisKelamin,ttl, kebangsaan,
                                                        // email, alamat, noTelp, jabatan )
    static double[][] jadwalGaji = new double[100][4]; // 100 pegawai, 4 atribut(gaji pokok, bonus, potongan, total gaji)
    static LocalDate[] tanggalPembayaran;
    
    // Menginisialisasi absen
    static String[][] absen = new String[100][7];
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
        System.out.println("4. Menu Permintaan dan Persetujuan Cuti");
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

                break;
            case 4:
                login();
                break;
            case 5:

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
        System.out.println("1. Input data");
        System.out.println("2. Input kehadiran");
        System.out.println("3. Log Out");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3): ");
        int menuPegawai = input.nextInt();
        input.nextLine();
        switch (menuPegawai) {
            case 1:

                break;
            case 2:
            inputKehadiran();
                break;
            case 3:
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
                // menu tampilan data pegawai
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
                lihatDetailPegawai();
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

            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
            dataPegawai[i][1] = input.nextLine();

            System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
            dataPegawai[i][2] = input.nextLine();

            System.out.print("Masukkan Kebangsaan Pegawai: ");
            dataPegawai[i][3] = input.nextLine();

            System.out.print("Masukkan Alamat Email Pegawai: ");
            dataPegawai[i][4] = input.nextLine();

            System.out.print("Masukkan Alamat Pegawai: ");
            dataPegawai[i][5] = input.nextLine();

            System.out.print("Masukkan Nomor Telepon Pegawai: ");
            dataPegawai[i][6] = input.nextLine();
        }

        System.out.println("\nDATA PEGAWAI YANG TELAH DI INPUT:");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Pegawai ke-" + (i + 1));
            System.out.println("Nama: " + dataPegawai[i][0]);
            System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
            System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
            System.out.println("Kebangsaan: " + dataPegawai[i][3]);
            System.out.println("Email: " + dataPegawai[i][4]);
            System.out.println("Alamat: " + dataPegawai[i][5]);
            System.out.println("Telepon: " + dataPegawai[i][6]);
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
        System.out.println("Nama: " + dataPegawai[i][0]);
        System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
        System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
        System.out.println("Kebangsaan: " + dataPegawai[i][3]);
        System.out.println("Email: " + dataPegawai[i][4]);
        System.out.println("Alamat: " + dataPegawai[i][5]);
        System.out.println("Telepon: " + dataPegawai[i][6]);
                                        
        System.out.println("\nPILIH DATA PEGAWAI YANG AKAN DIUBAH:");
        System.out.println("1. Nama");
        System.out.println("2. Jenis Kelamin");
        System.out.println("3. Tempat dan Tanggal Lahir");
        System.out.println("4. Kebangsaan");
        System.out.println("5. Email");
        System.out.println("6. Alamat");
        System.out.println("7. Nomor Telepon");
        System.out.print("Masukkan nomor pilihan: ");
        int pilihanUbah = input.nextInt();
        input.nextLine(); // Menangani newline setelah nextInt()
                                        
        switch (pilihanUbah) {
        case 1:
            System.out.print("Masukkan Nama Pegawai: ");
            dataPegawai[i][0] = input.nextLine();
            break;
        case 2:
            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
            dataPegawai[i][1] = input.nextLine();
            break;
        case 3:
            System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
            dataPegawai[i][2] = input.nextLine();
            break;
        case 4:
            System.out.print("Masukkan Kebangsaan Pegawai: ");
            dataPegawai[i][3] = input.nextLine();
            break;
        case 5:
            System.out.print("Masukkan Alamat Email Pegawai: ");
            dataPegawai[i][4] = input.nextLine();
            break;
        case 6:
            System.out.print("Masukkan Alamat Pegawai: ");
            dataPegawai[i][5] = input.nextLine();
            break;
        case 7:
            System.out.print("Masukkan Nomor Telepon Pegawai: ");
            dataPegawai[i][6] = input.nextLine();
            break;
        default:
            System.out.println("Pilihan tidak valid.");
        }
                                        
        System.out.println("\nDATA PEGAWAI YANG TELAH DIUBAH:");
        System.out.println("Pegawai ke-" + (i + 1));
        System.out.println("Nama: " + dataPegawai[i][0]);
        System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
        System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
        System.out.println("Kebangsaan: " + dataPegawai[i][3]);
        System.out.println("Email: " + dataPegawai[i][4]);
        System.out.println("Alamat: " + dataPegawai[i][5]);
        System.out.println("Telepon: " + dataPegawai[i][6]);
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
                System.out.println("Nama: " + dataPegawai[i][0]);
                System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
                System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
                System.out.println("Kebangsaan: " + dataPegawai[i][3]);
                System.out.println("Email: " + dataPegawai[i][4]);
                System.out.println("Alamat: " + dataPegawai[i][5]);
                System.out.println("Telepon: " + dataPegawai[i][6]);

                System.out.print("Apakah Anda yakin ingin menghapus data pegawai ini? (Y/N): ");
                String konfirmasi = input.nextLine();
                if (konfirmasi.toLowerCase().equals("y")) {
                    for (int j = i; j < jumlahPegawai - 1; j++) {
                        dataPegawai[j][0] = dataPegawai[j + 1][0];
                        dataPegawai[j][1] = dataPegawai[j + 1][1];
                        dataPegawai[j][2] = dataPegawai[j + 1][2];
                        dataPegawai[j][3] = dataPegawai[j + 1][3];
                        dataPegawai[j][4] = dataPegawai[j + 1][4];
                        dataPegawai[j][5] = dataPegawai[j + 1][5];
                        dataPegawai[j][6] = dataPegawai[j + 1][6];
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

    static void lihatDetailPegawai() {
        System.out.println("Pilih nomor pegawai untuk melihat detail:");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println((i + 1) + ". " + dataPegawai[i][0]);
        }

        System.out.print("Masukkan nomor pegawai: ");
        int pilihan = input.nextInt();

        if (pilihan > 0 && pilihan <= jumlahPegawai) {
        int i = pilihan - 1;
        System.out.println("Detail Pegawai:");
        System.out.println("Nama: " + dataPegawai[i][0]);
        System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
        System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
        System.out.println("Kebangsaan: " + dataPegawai[i][3]);
        System.out.println("Email: " + dataPegawai[i][3]);
        System.out.println("Alamat: " + dataPegawai[i][4]);
        System.out.println("Telepon: " + dataPegawai[i][5]);
        } else {
        System.out.println("Nomor pegawai tidak valid.");
        }
        
        menuManajemen();
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
                System.out.println("Nama: " + dataPegawai[i][0]);
                System.out.println("Jenis Kelamin: " + dataPegawai[i][1]);
                System.out.println("Tempat dan Tanggal Lahir: " + dataPegawai[i][2]);
                System.out.println("Kebangsaan: " + dataPegawai[i][3]);
                System.out.println("Email: " + dataPegawai[i][4]);
                System.out.println("Alamat: " + dataPegawai[i][5]);
                System.out.println("Telepon: " + dataPegawai[i][6]);
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
        tanggalPembayaran = new LocalDate[jumlahPegawai];
        System.out.print("\nMasukkan Jumlah Pegawai: ");
        jumlahPegawai = input.nextInt();
        input.nextLine();
        
        // Mengisi jadwal gaji setiap pegawai
        for (int i = 0; i < jumlahPegawai; i++) {
        System.out.println("Masukkan data untuk Pegawai " + (i + 1) + ":");
        System.out.print("Nama Pegawai: ");
        dataPegawai[i][0] = input.nextLine();
        System.out.print("Jabatan Pegawai (Koki/Kasir/Pramusaji): ");
        dataPegawai[i][7] = input.nextLine();
        System.out.print("Tanggal Pembayaran Gaji (YYYY-MM-DD): ");
        String tanggalPembayaranStr = input.nextLine();
        tanggalPembayaran[i] = LocalDate.parse(tanggalPembayaranStr);
                            
        System.out.println("Masukkan jadwal gaji untuk Pegawai " + (i + 1) + ":");
        System.out.print("Gaji Pokok: ");
        jadwalGaji[i][0] = input.nextDouble();
        System.out.print("Bonus: ");
        jadwalGaji[i][1] = input.nextDouble();
        System.out.print("Potongan: ");
        jadwalGaji[i][2] = input.nextDouble();
        jadwalGaji[i][3] = jadwalGaji[i][0] + jadwalGaji[i][1] - jadwalGaji[i][2]; // Total gaji disimpan di kolom ke-4
        }
                            
        // Menampilkan jadwal gaji setiap pegawai
        System.out.println("\nJadwal Pembayaran Gaji:");
        for (int i = 0; i < jumlahPegawai; i++) {
        System.out.println("Pegawai " + (i + 1) + ":");
        System.out.println("Nama: " + dataPegawai[i][0]);
        System.out.println("Jabatan: " + dataPegawai[i][7]);
        System.out.println("Tanggal Pembayaran: " + tanggalPembayaran[i]);
        System.out.println("Gaji Pokok: " + jadwalGaji[i][0]);
        System.out.println("Bonus: " + jadwalGaji[i][1]);
        System.out.println("Potongan: " + jadwalGaji[i][2]);
        System.out.println("Total Gaji: " + jadwalGaji[i][3]);
        System.out.println("-----------------------------");
        }
        input.nextLine();
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

static void inputKehadiran(){
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




}