
import java.util.Scanner;

public class projekBeta2 {

    static Scanner input = new Scanner(System.in);
    static String[] username = { "admin1", "pegawai2", "manajer3" };
    static String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };
    static String[][] dataPegawai = new String[100][7]; // 100 pegawai, 7 atribut(nama, jenisKelamin,ttl, kebangsaan,
                                                        // email, alamat, noTelp, )
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

            System.out.println("====================================");
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

                break;
            case 3:
                namaCari();
                break;
            case 4:

                break;
            case 5:

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
            System.out.print("Masukkan Nama Lengkap Pegawai: ");
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
        menuManajer(); // kembali ke menu manajer

        if (!ditemukanCari) {
            System.out.println("Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
            menuManajer();
        }

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