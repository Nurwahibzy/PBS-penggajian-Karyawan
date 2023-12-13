
import java.util.Scanner;

public class projekBeta3 {

    static Scanner input = new Scanner(System.in);
    // data login
    static String pegawai[][] = { { "pegawai1", "pegawai2", "pegawai3" },
            { "pegawaipassword1", "pegawaipassword2", "pegawaipassword3" } };
    static String admin[][] = { { "admin1", "admin2", "admin3" },
            { "adminpassword1", "adminpassword2", "adminpassword3" } };
    static String manajer[][] = { { "manajer1", "manajer2", "manajer3" },
            { "manajerpassword1", "manajerpassword2", "manajerpassword3" } };
    static String[][] dataPegawai = new String[100][10];
    // 100 pegawai, 10 atribut(nama,jabatan, Usia, lama bekerja,
    // jenisKelamin,ttl, kebangsaan, email, alamat, noTelp )

    static {
        dataPegawai[0] = new String[] { "Adam", "password", "Koki", "50", "5", "L", "Malang, 12 Januari 2005",
                "Indonesia",
                "adamcuy@gmail.com", "Malang", "08123456378" };
        dataPegawai[1] = new String[] { "Abdul", "password", "Koki", "50", "5", "L", "Malang, 12 Januari 2005",
                "Indonesia",
                "adamcuy@gmail.com", "Malang", "08123456378" };
        dataPegawai[2] = new String[] { "Rayhan", "password", "Koki", "50", "5", "L", "Malang, 12 Januari 2005",
                "Indonesia",
                "adamcuy@gmail.com", "Malang", "08123456378" };
        dataPegawai[3] = new String[] { "Rino", "password", "Koki", "50", "5", "L", "Malang, 12 Januari 2005",
                "Indonesia",
                "adamcuy@gmail.com", "Malang", "08123456378" };
    }
    static int nextIndexDataPegawai = 4;

    static double[][] jadwalGaji = new double[100][4]; // 100 pegawai, 4 atribut(gaji pokok, bonus, potongan, total
                                                       // gaji)
    static int[][] kinerjaPegawai = new int[100][3]; // 100 pegawai, 3 atribut(baik, cukup, perlu perbaikan)
    static int totalKehadiran = 0, totalTidakHadir = 0;

    static String[][] permintaanCuti = new String[100][3];
    static {
        permintaanCuti[0] = new String[] { "Adam", "4", "Belum disetujui" };
    }
    static int nextIndexCuti = 1;

    static boolean[] statusPersetujuan;
    static int jumlahPermintaan = 0;
    static double totalPengeluaranGaji = 0;
    static int nomorSlip;

    // Menginisialisasi absen
    static int[][] absen = new int[100][6];
    // Mendeklarasikan nama-nama hari
    static String namaHari[] = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };
    static {
        absen[0] = new int[] { 1, 1, 1, 1, 1, 1 };
        absen[1] = new int[] { 1, 1, 1, 1, 1, 1 };
        absen[2] = new int[] { 1, 1, 1, 1, 1, 1 };
        absen[3] = new int[] { 1, 1, 1, 1, 1, 1 };
    }
    static String usernameInput, passwordInput;


    public static void main(String[] args) {
        login();
    }

    static void login() {
        for (int kesempatanLogin = 1; kesempatanLogin <= 3; kesempatanLogin++) { // Membatasi jumlah maksimal
                                                                                 // percobaan login

            int sisaKesempatan = 3 - kesempatanLogin;// menghitung sisa kesempatan login

            System.out.println("\n======================================");
            System.out.println("|     Sistem Penggajian Restoran     |");
            System.out.println("======================================");
            System.out.print("Masukkan username: ");
            usernameInput = input.nextLine();
            System.out.print("Masukkan password: ");
            passwordInput = input.nextLine();
            int indexAkun = cekVerifikasi(usernameInput, passwordInput);
            if (indexAkun != -1) {
                System.out.println();
                System.out.println("Login berhasil!");
                System.out.println("\nSelamat datang, " + usernameInput + "!");

                cekHakAkses(indexAkun);
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
                    break;
                }
            }

        }
    }

    static int cekVerifikasi(String username, String pass) {
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (username.equalsIgnoreCase(dataPegawai[i][0]) && pass.equals(dataPegawai[i][1])) {
                return i;
            }
        }
        for (int i = 0; i < admin[0].length; i++) {
            if (username.equalsIgnoreCase(admin[0][i]) && pass.equals(admin[1][i])) {
                return i;
            }
        }
        for (int i = 0; i < manajer[0].length; i++) {
            if (username.equalsIgnoreCase(manajer[0][i]) && pass.equals(manajer[1][i])) {
                return i;
            }
        }
        return -1;
    }

    // periksa peran admin
    static void cekHakAkses(int indexAkun) {
        for (int i = 0; i < admin[0].length; i++) {
            if (usernameInput.equalsIgnoreCase(admin[0][i])) {
                // menu admin
                menuAdmin();
                return; // keluar dari method setelah nama pengguna yang benar ditemukan
            }
        }

        // periksa peran pegawai
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (usernameInput.equalsIgnoreCase(dataPegawai[i][0])) {
                // menu pegawai
                menuPegawai(indexAkun);
                return;
            }
        }

        // Periksa peran manajer
        for (int i = 0; i < manajer[0].length; i++) {
            if (usernameInput.equalsIgnoreCase(manajer[0][i])) {
                // menu manajer
                menuManajer();
                return;
            }
        }

        System.out.println("Invalid username.");
    }

    static void menuAdmin() {
        System.out.println("\n============================================================================");
        System.out.println("|                              PILIHAN MENU ADMIN                          |");
        System.out.println("============================================================================");
        System.out.println("|1. Menu Manajemen Data Pegawai                                            |");
        System.out.println("|2. Menu Informasi Gaji Pegawai                                            |");
        System.out.println("|3. Menu Catat dan Lacak Kehadiran Pegawai dan Jam Kerja                   |");
        System.out.println("|4. Menu Lihat Permintaan dan Persetujuan Cuti                             |");
        System.out.println("|5. Menu Laporan Pengeluaran Gaji, Kinerja Pegawai, dan Tren Kehadiran     |");
        System.out.println("|6. Keluar (Log Out)                                                       |");
        System.out.println("============================================================================");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4/5/6): ");
        int menuAdmin = input.nextInt();
        input.nextLine();

        switch (menuAdmin) {
            case 1:
                menuManajemen();
                break;
            case 2:
                menuInformasiGaji();
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

    static void menuPegawai(int indexAkun) {
        System.out.println("\n======================================");
        System.out.println("|         PILIHAN MENU PEGAWAI       |");
        System.out.println("======================================");
        System.out.println("|1. Cetak Slip Gaji                  |");
        System.out.println("|2. Input kehadiran                  |");
        System.out.println("|3. Permintaan Cuti                  |");
        System.out.println("|4. Informasi Gaji                   |");
        System.out.println("|5. Log Out                          |");
        System.out.println("======================================");
        System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4/5): ");
        int menuPegawai = input.nextInt();
        input.nextLine();
        System.out.println();
        switch (menuPegawai) {
            case 1:
                cetakSlip(indexAkun);
                break;
            case 2:
                inputKehadiran(indexAkun);
                break;
            case 3:
                prosesPermintaanCuti(indexAkun);
                break;
            case 4:
                tampilkanInformasiGaji(indexAkun);
            case 5:
                login();
                break;
            default:
                System.out.println("Input salah");
                menuPegawai(indexAkun);
                break;
        }

    }

    static void menuManajer() {
        System.out.println("\n======================================");
        System.out.println("|         PILIHAN MENU MANAJER       |");
        System.out.println("======================================");
        System.out.println("|1. Tampilkan Data Pegawai           |");
        System.out.println("|2. Hasil rekap absensi karyawan     |");
        System.out.println("|3. Pencarian data                   |");
        System.out.println("|4. Log Out                          |");
        System.out.println("======================================");
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
                namaCari(2);
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
        System.out.println("\n======================================");
        System.out.println("|     MENU MANAJEMEN DATA PEGAWAI    |");
        System.out.println("======================================");
        System.out.println("|1. Input Data Pegawai               |");
        System.out.println("|2. Edit Data Pegawai                |");
        System.out.println("|3. Hapus Data Pegawai               |");
        System.out.println("|4. Cari Data Pegawai                |");
        System.out.println("|5. Lihat Detail Data Pegawai        |");
        System.out.println("|6. Kembali                          |");
        System.out.println("======================================");
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
                namaCari(1);
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

       do {
            System.out.println("=====================================");
            System.out.println("\nMASUKKAN DATA PEGAWAI KE-" + (nextIndexDataPegawai + 1));
            System.out.print("Masukkan Nama Pegawai: ");
            dataPegawai[nextIndexDataPegawai][0] = input.nextLine();
    
            System.out.print("Masukkan Jabatan Pegawai (Koki/Kasir/Pramusaji): ");
            dataPegawai[nextIndexDataPegawai][1] = input.nextLine();
    
            System.out.print("Masukkan Usia Pegawai: ");
            dataPegawai[nextIndexDataPegawai][2] = input.nextLine();
    
            System.out.print("Masukkan Lama Bekerja Pegawai: ");
            dataPegawai[nextIndexDataPegawai][3] = input.nextLine();
    
            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
            dataPegawai[nextIndexDataPegawai][4] = input.nextLine();
    
            System.out.print("Masukkan Tempat, Tanggal Lahir Pegawai: ");
            dataPegawai[nextIndexDataPegawai][5] = input.nextLine();
    
            System.out.print("Masukkan Kebangsaan Pegawai: ");
            dataPegawai[nextIndexDataPegawai][6] = input.nextLine();
    
            System.out.print("Masukkan Alamat Email Pegawai: ");
            dataPegawai[nextIndexDataPegawai][7] = input.nextLine();
    
            System.out.print("Masukkan Alamat Pegawai: ");
            dataPegawai[nextIndexDataPegawai][8] = input.nextLine();
    
            System.out.print("Masukkan Nomor Telepon Pegawai: ");
            dataPegawai[nextIndexDataPegawai][9] = input.nextLine();
    

            // Ask the user if they want to input data again

            System.out.print("\nIngin input kembali? (ya/tidak): ");
            String jawaban = input.nextLine();

            if (!jawaban.equalsIgnoreCase("ya")) {
                break; // Exit the loop if the answer is not "ya"
            }

            // Increment the index for the next employee
            nextIndexDataPegawai++;

        } while (true);

        // Display the entered data or perform other actions
        System.out.println("\nDATA PEGAWAI YANG TELAH DI INPUT:");
        System.out.println("Pegawai ke-" + (nextIndexDataPegawai + 1));
        System.out.println("Nama Pegawai: " + dataPegawai[nextIndexDataPegawai][0]);
        System.out.println("Jabatan Pegawai: " + dataPegawai[nextIndexDataPegawai][1]);
        System.out.println("Usia Pegawai: " + dataPegawai[nextIndexDataPegawai][2]);
        System.out.println("Lama Pegawai Bekerja: " + dataPegawai[nextIndexDataPegawai][3]);
        System.out.println("Jenis Kelamin: " + dataPegawai[nextIndexDataPegawai][4]);
        System.out.println("Tempat, Tanggal Lahir: " + dataPegawai[nextIndexDataPegawai][5]);
        System.out.println("Kebangsaan: " + dataPegawai[nextIndexDataPegawai][6]);
        System.out.println("Email: " + dataPegawai[nextIndexDataPegawai][7]);
        System.out.println("Alamat: " + dataPegawai[nextIndexDataPegawai][8]);
        System.out.println("Telepon: " + dataPegawai[nextIndexDataPegawai][9]);
        System.out.println("-----------------------------");

        menuManajemen();
        
    }

    static void editPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan diubah: ");
        String namaUbah = input.nextLine();
        boolean ditemukanUbah = false;

        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (dataPegawai[i][0].equalsIgnoreCase(namaUbah)) {
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai (Koki/Kasir/Pramusaji): " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai: " + dataPegawai[i][4]);
                System.out.println("Tempat, Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
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
                System.out.println("6. Tempat, Tanggal Lahir");
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
                        System.out.print("Masukkan Tempat, Tanggal Lahir Pegawai: ");
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
                System.out.println("Tempat, Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
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

        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (dataPegawai[i][0].equalsIgnoreCase(namaHapus)) {
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai: " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai: " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai: " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja: " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai: " + dataPegawai[i][4]);
                System.out.println("Tempat, Tanggal Lahir Pegawai: " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai: " + dataPegawai[i][6]);
                System.out.println("Email Pegawai: " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai: " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai: " + dataPegawai[i][9]);

                System.out.print("Apakah Anda yakin ingin menghapus data pegawai ini? (Y/N): ");
                String konfirmasi = input.nextLine();
                if (konfirmasi.toLowerCase().equals("y")) {
                    for (int j = i; j < nextIndexDataPegawai - 1; j++) {
                        dataPegawai[j][0] = dataPegawai[j+1][0];
                        dataPegawai[j][1] = dataPegawai[j+1][1];
                        dataPegawai[j][2] = dataPegawai[j+1][2];
                        dataPegawai[j][3] = dataPegawai[j+1][3];
                        dataPegawai[j][4] = dataPegawai[j+1][4];
                        dataPegawai[j][5] = dataPegawai[j+1][5];
                        dataPegawai[j][6] = dataPegawai[j+1][6];
                        dataPegawai[j][7] = dataPegawai[j+1][7];
                        dataPegawai[j][8] = dataPegawai[j+1][8];
                        dataPegawai[j][9] = dataPegawai[j+1][9];
                    }
                    nextIndexDataPegawai--;
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
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            System.out.println((i + 1) + ". " + dataPegawai[i][0]);
        }

        System.out.print("Masukkan nomor pegawai: ");
        int pilihan = input.nextInt();
        System.out.println();

        if (pilihan > 0 && pilihan <= nextIndexDataPegawai) {
            int i = pilihan - 1;
            System.out.println("Detail Pegawai:");
            System.out.println("Nama Pegawai                    : " + dataPegawai[i][0]);
            System.out.println("Jabatan Pegawai                 : " + dataPegawai[i][1]);
            System.out.println("Usia Pegawai                    : " + dataPegawai[i][2]);
            System.out.println("Lama Pegawai Bekerja            : " + dataPegawai[i][3]);
            System.out.println("Jenis Kelamin Pegawai           : " + dataPegawai[i][4]);
            System.out.println("Tempat, Tanggal Lahir Pegawai   : " + dataPegawai[i][5]);
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

    static void namaCari(int a) {
        System.out.print("Masukkan Nama Pegawai yang akan dicari: ");
        String namaCari = input.nextLine();
        boolean ditemukanCari = false;

        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (namaCari.equals(dataPegawai[i][0])) {
                System.out.println("=====================================");
                System.out.println("Data ditemukan!");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama Pegawai                    : " + dataPegawai[i][0]);
                System.out.println("Jabatan Pegawai                 : " + dataPegawai[i][1]);
                System.out.println("Usia Pegawai                    : " + dataPegawai[i][2]);
                System.out.println("Lama Pegawai Bekerja            : " + dataPegawai[i][3]);
                System.out.println("Jenis Kelamin Pegawai           : " + dataPegawai[i][4]);
                System.out.println("Tempat, Tanggal Lahir Pegawai   : " + dataPegawai[i][5]);
                System.out.println("Kebangsaan Pegawai              : " + dataPegawai[i][6]);
                System.out.println("Email Pegawai                   : " + dataPegawai[i][7]);
                System.out.println("Alamat Pegawai                  : " + dataPegawai[i][8]);
                System.out.println("Telepon Pegawai                 : " + dataPegawai[i][9]);
                System.out.println("=====================================");
                ditemukanCari = true;
                break;
            }
        }
        if (!ditemukanCari) {
            System.out.println("\nData pegawai dengan nama " + namaCari + " tidak ditemukan.");
        }
        if (a == 1) {
            menuManajemen();
        } else {
            menuManajer();
        }

    }

    static void menuInformasiGaji() {
        System.out.println("Selamat datang di menu Penyusunan Gaji Pegawai!");
        System.out.print("Masukkan Jumlah Jabatan: ");
        int jumlahJabatan = input.nextInt();
        input.nextLine(); // Membersihkan buffer

        dataPegawai = new String[jumlahJabatan][2];
        jadwalGaji = new double[jumlahJabatan][3];

        for (int i = 0; i < jumlahJabatan; i++) {
            System.out.println("\nMasukkan informasi untuk Jabatan ke-" + (i + 1) + ":");

            System.out.print("Jabatan (Koki/Kasir/Pramusaji): ");
            dataPegawai[i][2] = input.nextLine().toLowerCase();

            System.out.print("Gaji Pokok untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][0] = input.nextDouble();

            System.out.print("Bonus untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][1] = input.nextDouble();

            System.out.print("Potongan untuk " + dataPegawai[i][1] + ": Rp");
            jadwalGaji[i][2] = input.nextDouble();

            input.nextLine();

        }

       
        menuAdmin();
    }

    static void tampilkanInformasiGaji(int indexAkun) {
        System.out.println("\nInformasi Gaji untuk Setiap Jabatan:");
        for (int i = 0; i < dataPegawai.length; i++) {
            System.out.println("=====================================");
            System.out.println("Jabatan: " + dataPegawai[i][2]);
            System.out.println("Gaji Pokok: Rp" + jadwalGaji[i][0]);
            System.out.println("Bonus: Rp" + jadwalGaji[i][1]);
            System.out.println("Potongan: Rp" + jadwalGaji[i][2]);
            System.out.println("=====================================");

        }

        menuPegawai(indexAkun);

    }

    static void menuLacakKehadiran() {
        System.out.println("Daftar Nama Pegawai:");
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            System.out.println((i + 1) + ". " + dataPegawai[i][0]);
        }
    
        int[] jamKerjaPegawai = new int[nextIndexDataPegawai]; // Array untuk menyimpan jam kerja setiap karyawan
    
        do {
            System.out.print("Masukkan nama pegawai yang akan diinput jam kerjanya: ");
            String namaPegawai = input.nextLine();
    
            int indexPegawai = -1;
            for (int i = 0; i < nextIndexDataPegawai; i++) {
                if (dataPegawai[i][0].equalsIgnoreCase(namaPegawai)) {
                    indexPegawai = i;
                    break;
                }
            }
    
            if (indexPegawai != -1) {
                System.out.print("Masukkan jam kerja untuk " + dataPegawai[indexPegawai][0] + ": ");
                int jamKerja = input.nextInt();
                input.nextLine(); // Membersihkan newline
    
                // Menampilkan data kehadiran dan jam kerja pegawai yang diinputkan
                System.out.println("\nData Kehadiran dan Jam Kerja Pegawai:");
                System.out.println("Nama Pegawai: " + dataPegawai[indexPegawai][0]);
                System.out.println("Jam Kerja: " + jamKerja + " jam");
    
                // Menyimpan jam kerja pegawai ke array jamKerjaPegawai
                jamKerjaPegawai[indexPegawai] += jamKerja;
    
                // Menanyakan apakah ingin menginputkan jam kerja pegawai lainnya
                System.out.print("Ingin menginputkan jam kerja pegawai lainnya? (Ya/Tidak): ");
                String pilihan = input.nextLine();
    
                if (!pilihan.equalsIgnoreCase("Ya")) {
                    break; // Keluar dari loop jika tidak ingin menginputkan lagi
                }
            } else {
                System.out.println("Pegawai dengan nama " + namaPegawai + " tidak ditemukan.");
            }
    
        } while (true); // Melakukan loop selama user ingin menginputkan jam kerja pegawai
    
        // Menampilkan total jam kerja seluruh pegawai
        int totalJamKerja = 0;
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            totalJamKerja += jamKerjaPegawai[i]; // Mengambil jam kerja dari array jamKerjaPegawai
        }
    
        System.out.println("\nTotal Jam Kerja Seluruh Pegawai: " + totalJamKerja + " jam");
    
        // Menentukan karyawan dengan jam kerja terbanyak
        int maxJamKerja = -1;
        String pegawaiMaxJam = "";
    
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (jamKerjaPegawai[i] > maxJamKerja) {
                maxJamKerja = jamKerjaPegawai[i];
                pegawaiMaxJam = dataPegawai[i][0];
            }
        }
    
        System.out.println("Pegawai dengan Jam Kerja Terbanyak: " + pegawaiMaxJam);
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
        for (int i = 0; i < nextIndexCuti; i++) {
            System.out.println("Nama Pegawai: " + permintaanCuti[i][0]);
            System.out.println("Jumlah Hari Cuti: " + permintaanCuti[i][1]);
            System.out.println("Status Persetujuan: " + permintaanCuti[i][2]);
            System.out.println("-----------------------------");
        }
    }

    static void prosesPermintaanCuti(int indexAkun) {
        System.out.print("Masukkan jumlah hari cuti yang diminta oleh " + dataPegawai[indexAkun][0] + ": ");
        String jumlahCuti = input.next();
        permintaanCuti[nextIndexCuti] = new String[] { dataPegawai[indexAkun][0], jumlahCuti, "belum disetujui" };
        nextIndexCuti++;
        input.nextLine();
        System.out.println("Permintaan cuti sedang diproses");
        menuPegawai(indexAkun);
    }

    static void persetujuanCuti() {
        // Menampilkan informasi permintaan cuti dari setiap pegawai
        for (int i = 0; i < nextIndexCuti; i++) {
            if (permintaanCuti[i][2].equals("Belum disetujui")) {
                System.out.println("Permintaan cuti dari " + permintaanCuti[i][0] + " sebanyak " + permintaanCuti[i][1]
                        + " hari.");

                // Admin memutuskan untuk menyetujui atau menolak permintaan cuti
                System.out.print("Admin: Setujui permintaan cuti? (ya/tidak): ");
                String jawabanAdmin = input.next();

                if (jawabanAdmin.equalsIgnoreCase("ya")) {
                    System.out.println("Permintaan cuti disetujui!");
                    permintaanCuti[i][2] = "Disetujui";
                } else if (jawabanAdmin.equalsIgnoreCase("tidak")) {
                    System.out.println("Permintaan cuti ditolak.");
                }
            }
        }
    }

    static void menuKinerjaPegawai() {
        // Display list of employee names
        System.out.println("Daftar Nama Pegawai:");
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            System.out.println((i + 1) + ". " + dataPegawai[i][0]);
        }
    
        // Input data gaji dan kinerja pegawai
        System.out.print("\nMasukkan nama pegawai: ");
        String namaPegawai = input.nextLine();
    
        // Temukan nomor pegawai berdasarkan nama
        int nomorPegawai = -1;
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            if (dataPegawai[i][0].equalsIgnoreCase(namaPegawai)) {
                nomorPegawai = i;
                break;
            }
        }
    
        if (nomorPegawai == -1) {
            System.out.println("Pegawai dengan nama '" + namaPegawai + "' tidak ditemukan.");
            menuAdmin(); // Kembali ke menu admin
            return;
        }
    
        System.out.println("Data Pegawai " + (nomorPegawai + 1) + ":");
        System.out.print("Jabatan Pegawai: ");
        dataPegawai[nomorPegawai][1] = input.nextLine();
        System.out.print("Gaji Pegawai: ");
        jadwalGaji[nomorPegawai][0] = input.nextDouble();
        totalPengeluaranGaji += jadwalGaji[nomorPegawai][0];
    
        // Input status kinerja pegawai
        System.out.print("Kinerja Pegawai (1. Baik / 2. Cukup / 3. Perlu Perbaikan): ");
        int kinerja = input.nextInt();
    
        switch (kinerja) {
            case 1:
                kinerjaPegawai[nomorPegawai][0]++;
                break;
            case 2:
                kinerjaPegawai[nomorPegawai][1]++;
                break;
            case 3:
                kinerjaPegawai[nomorPegawai][2]++;
                break;
            default:
                System.out.println("Pilihan kinerja tidak valid.");
                break;
        }
    
        // Input data kehadiran
        System.out.print("Masukkan jumlah kehadiran untuk " + dataPegawai[nomorPegawai][0] + ": ");
        int kehadiran = input.nextInt();
        int tidakHadir = 26 - kehadiran;
        jadwalGaji[nomorPegawai][1] = kehadiran;
        jadwalGaji[nomorPegawai][2] = tidakHadir;
    
        // Tanya apakah ingin menginputkan kinerja pegawai lagi
        System.out.print("\nIngin menginputkan kinerja pegawai lagi? (Ya/Tidak): ");
        input.nextLine(); // Membersihkan newline di buffer
        String inputKinerja = input.nextLine();
        
        if (inputKinerja.equalsIgnoreCase("Ya")) {
            menuKinerjaPegawai(); // Rekursif untuk mengulangi input kinerja pegawai
        } else {
            // Menampilkan laporan setelah selesai menginputkan
            System.out.println("\n=== Laporan Perusahaan ===");
            System.out.println("1. Pengeluaran Gaji");
            System.out.println("   Total Pengeluaran Gaji: Rp" + totalPengeluaranGaji);
    
            // Menampilkan total status kinerja
            int totalBaik = 0, totalCukup = 0, totalPerbaikan = 0;
            for (int i = 0; i < nextIndexDataPegawai; i++) {
                totalBaik += kinerjaPegawai[i][0];
                totalCukup += kinerjaPegawai[i][1];
                totalPerbaikan += kinerjaPegawai[i][2];
        }

        System.out.println("\n=== Laporan Kinerja Pegawai ===");
        System.out.println("2. Kinerja Pegawai");
        System.out.println("      - Berkinerja Baik: " + totalBaik);
        System.out.println("      - Cukup Berkinerja: " + totalCukup);
        System.out.println("      - Perlu Perbaikan: " + totalPerbaikan);

        // Menampilkan total tren kehadiran
        int totalKehadiran = 0, totalTidakHadir = 0;
        for (int i = 0; i < nextIndexDataPegawai; i++) {
        totalKehadiran += jadwalGaji[i][1];
        totalTidakHadir += jadwalGaji[i][2];
    }
        System.out.println("\n=== Laporan Tren Kehadiran ===");
        System.out.println("\n3. Tren Kehadiran");
        System.out.println("   Total Kehadiran: " + totalKehadiran + " hari");
        System.out.println("   Total Tidak Hadir: " + totalTidakHadir + " hari");
    
        menuAdmin(); // Kembali ke menu admin

        }
    }
    
    static void cetakAbsensiKaryawan() {
        System.out.println("\n Daftar Absensi Pegawai: \n");
        String keterangan;
        for (int i = 0; i < nextIndexDataPegawai; i++) {
            System.out.println("Pegawai " + (i + 1) + ": ");
            for (int j = 0; j < absen[i].length; j++) {
                switch (absen[i][j]) {
                    case 0:
                        keterangan = "Tidak hadir";
                        break;
                    case 1:
                        keterangan = "Hadir";
                        break;
                    default:
                        keterangan = "-";
                        break;
                }
                System.out.println(" hari " + namaHari[j] + ": " + keterangan);

            }
            System.out.println("-----------------------------");
        }
        menuManajer();

    }

    static void inputKehadiran(int indexAkun) {
        for (int j = 0; j < absen[indexAkun].length; j++) {
            System.out.print("Daftar Hadir pada hari " + namaHari[j] + "(Y/N): ");
            String kehadiran = input.next();

            if (kehadiran.equalsIgnoreCase("y")) {
                absen[indexAkun][j] = 1;
            } else if (kehadiran.equalsIgnoreCase("n")) {
                absen[indexAkun][j] = 0;
            } else {
                System.out.println("Input salah, masukkan kembali dengan benar!");
                j--;
            }

        }

        System.out.println("Kehadiran telah direkam\nTerimakasih!");
        menuPegawai(indexAkun);

    }

    static void cetakSlip(int a) {
        int gajiPokok, bonus, total;
        switch (dataPegawai[a][2]) {
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
        int usia = Integer.parseInt(dataPegawai[a][3]);
        int lamaBekerja = Integer.parseInt(dataPegawai[a][4]);
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
        System.out.println("-----------------------");
        menuPegawai(a);
    }

}