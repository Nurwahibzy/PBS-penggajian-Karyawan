import java.util.Scanner;

public class projekBeta1 {

    public static void main(String[] args) {
        String[] username = { "admin1", "pegawai2", "manajer3" };
        String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };

        String namaPegawai, jabatan, bulanGaji, kehadiran;
        int jumlahJamKerja, jumlahJamLembur, totalJamKerja, usia, bonus = 0, lamaBekerja;
        int upah = 15700, pajak = 25000, totalJamLembur, totalGaji, gajiPokok = 0;
        int menuAdmin, jumlahPegawai = 3, menuManajer, menuPegawai, menuManajemen, jumlahPermintaan = 0;
        boolean isAuthenticated = false;
        boolean pesan = true;
        boolean ifManajer = true, ifPegawai = true;
        double totalPengeluaranGaji = 0;
        int pegawaiBerkinerjaBaik = 0, pegawaiCukupBerkinerja = 0, pegawaiPerluPerbaikan = 0, totalKehadiran = 0,
                totalTidakHadir = 0;
        Scanner input = new Scanner(System.in);

        // mendeklarasikan array
        // String[] namaPegawai2, jenisKelaminPegawai, ttlPegawai, kebangsaanPegawai,
        // emailPegawai, alamatPegawai,teleponPegawai;
        String[] namaPegawai2 = new String[100];
        String[] jenisKelaminPegawai = new String[100];
        String[] ttlPegawai = new String[100];
        String[] kebangsaanPegawai = new String[100];
        String[] emailPegawai = new String[100];
        String[] alamatPegawai = new String[100];
        String[] teleponPegawai = new String[100];
        int[] jumlahHariCuti = new int[100];
        boolean[] statusPersetujuan = new boolean[100];

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
                        while (ifPegawai) {
                            System.out.println("===BERIKUT PILIHAN MENU PEGAWAI===");
                            System.out.println("1. Input data");
                            System.out.println("2. Input kehadiran");
                            System.out.println("3. Log Out");
                            System.out.print("Silahkan Pilih Menu Diatas (1/2/3): ");
                            menuPegawai = input.nextInt();
                            input.nextLine();
                            switch (menuPegawai) {
                                case 1:
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

                                    totalJamKerja = jumlahJamKerja * 26;// rata - rata jumlah jam dengan 6 hari kerja
                                                                        // seminggu
                                    totalJamLembur = jumlahJamLembur * upah;
                                    totalGaji = gajiPokok + totalJamLembur + bonus - pajak;
                                    System.out.println("\nTotal Jam Kerja Anda adalah " + totalJamKerja + " jam");
                                    System.out.println("Total Gaji Yang Anda Terima Adalah : " + "Rp." + totalGaji);
                                    break;
                                case 2:
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
                                                System.out.println("Input salah, masukkan kembali dengan benar!");
                                                j--;
                                            }

                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Anda telah logout");
                                    ifPegawai = false;
                                    break;
                                default:
                                    System.out.println("Tidak Ada Pilihan");
                                    break;
                            }

                        }

                    } else if (usernameInput.equalsIgnoreCase("admin1")) {
                        while (true) {
                            System.out.println("===BERIKUT PILIHAN MENU ADMIN===");
                            System.out.println("1. Menu Manajemen Data Pegawai");
                            System.out.println("2. Menu Penyusunan Jadwal Pembayaran Gaji");
                            System.out.println("3. Menu Catat dan Lacak Kehadiran Pegawai dan Jam Kerja");
                            System.out.println("4. Menu Permintaan dan Persetujuan Cuti");
                            System.out.println("5. Menu Laporan Pengeluaran Gaji, Kinerja Pegawai, dan Tren Kehadiran");
                            System.out.println("6. Keluar (Log Out)");
                            System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4/5/6): ");

                            menuAdmin = input.nextInt();
                            input.nextLine();

                            if (menuAdmin == 1) {
                                do {
                                    System.out.println("\nMENU MANAJEMEN DATA PEGAWAI");
                                    System.out.println("1. Input Data Pegawai");
                                    System.out.println("2. Edit Data Pegawai");
                                    System.out.println("3. Hapus Data Pegawai");
                                    System.out.println("4. Cari Data Pegawai");
                                    System.out.println("5. Lihat Detail Data Pegawai");
                                    System.out.println("6. Keluar");
                                    System.out.print("Pilih Menu: ");
                                    menuManajemen = input.nextInt();
                                    input.nextLine();

                                    switch (menuManajemen) {
                                        case 1:
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
                                            break;

                                            case 2:
                                            System.out.print("Masukkan Nama Pegawai yang akan diubah: ");
                                            String namaUbah = input.nextLine();
                                            boolean ditemukanUbah = false;
                                        
                                            for (int i = 0; i < jumlahPegawai; i++) {
                                                if (namaPegawai2[i].equalsIgnoreCase(namaUbah)) {
                                                    System.out.println("Data ditemukan!");
                                                    System.out.println("Pegawai ke-" + (i + 1));
                                                    System.out.println("Nama: " + namaPegawai2[i]);
                                                    System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                                    System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                                    System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                                    System.out.println("Email: " + emailPegawai[i]);
                                                    System.out.println("Alamat: " + alamatPegawai[i]);
                                                    System.out.println("Telepon: " + teleponPegawai[i]);
                                        
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
                                                            System.out.print("Masukkan Nama Lengkap Pegawai: ");
                                                            namaPegawai2[i] = input.nextLine();
                                                            break;
                                                        case 2:
                                                            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
                                                            jenisKelaminPegawai[i] = input.nextLine();
                                                            break;
                                                        case 3:
                                                            System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
                                                            ttlPegawai[i] = input.nextLine();
                                                            break;
                                                        case 4:
                                                            System.out.print("Masukkan Kebangsaan Pegawai: ");
                                                            kebangsaanPegawai[i] = input.nextLine();
                                                            break;
                                                        case 5:
                                                            System.out.print("Masukkan Alamat Email Pegawai: ");
                                                            emailPegawai[i] = input.nextLine();
                                                            break;
                                                        case 6:
                                                            System.out.print("Masukkan Alamat Pegawai: ");
                                                            alamatPegawai[i] = input.nextLine();
                                                            break;
                                                        case 7:
                                                            System.out.print("Masukkan Nomor Telepon Pegawai: ");
                                                            teleponPegawai[i] = input.nextLine();
                                                            break;
                                                        default:
                                                            System.out.println("Pilihan tidak valid.");
                                                    }
                                        
                                                    System.out.println("\nDATA PEGAWAI YANG TELAH DIUBAH:");
                                                    System.out.println("Pegawai ke-" + (i + 1));
                                                    System.out.println("Nama: " + namaPegawai2[i]);
                                                    System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                                    System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                                    System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                                    System.out.println("Email: " + emailPegawai[i]);
                                                    System.out.println("Alamat: " + alamatPegawai[i]);
                                                    System.out.println("Telepon: " + teleponPegawai[i]);
                                                    ditemukanUbah = true;
                                                    break;
                                                }
                                            }
                                        
                                            if (!ditemukanUbah) {
                                                System.out.println("Data pegawai dengan nama " + namaUbah + " tidak ditemukan.");
                                            }
                                            break;                                        

                                        case 3:
                                            System.out.print("Masukkan Nama Pegawai yang akan dihapus: ");
                                            String namaHapus = input.nextLine();
                                            boolean ditemukanHapus = false;

                                            for (int i = 0; i < jumlahPegawai; i++) {
                                                if (namaPegawai2[i].equalsIgnoreCase(namaHapus)) {
                                                    System.out.println("Data ditemukan!");
                                                    System.out.println("Pegawai ke-" + (i + 1));
                                                    System.out.println("Nama: " + namaPegawai2[i]);
                                                    System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                                                    System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                                                    System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                                                    System.out.println("Email: " + emailPegawai[i]);
                                                    System.out.println("Alamat: " + alamatPegawai[i]);
                                                    System.out.println("Telepon: " + teleponPegawai[i]);

                                                    System.out.print(
                                                            "Apakah Anda yakin ingin menghapus data pegawai ini? (Y/N): ");
                                                    String konfirmasi = input.nextLine();
                                                    if (konfirmasi.equalsIgnoreCase("Y")) {
                                                        for (int j = i; j < jumlahPegawai - 1; j++) {
                                                            namaPegawai2[j] = namaPegawai2[j + 1];
                                                            jenisKelaminPegawai[j] = jenisKelaminPegawai[j + 1];
                                                            ttlPegawai[j] = ttlPegawai[j + 1];
                                                            kebangsaanPegawai[j] = kebangsaanPegawai[j + 1];
                                                            emailPegawai[j] = emailPegawai[j + 1];
                                                            alamatPegawai[j] = alamatPegawai[j + 1];
                                                            teleponPegawai[j] = teleponPegawai[j + 1];
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

                                            if (!ditemukanHapus) {
                                                System.out.println(
                                                        "Data pegawai dengan nama " + namaHapus + " tidak ditemukan.");
                                            }
                                            break;

                                        case 4:
                                            System.out.print("Masukkan Nama Pegawai yang akan dicari: ");
                                            String namaCari = input.nextLine();
                                            boolean ditemukanCari = false;

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
                                                    ditemukanCari = true;
                                                    break;
                                                }
                                            }

                                            if (!ditemukanCari) {
                                                System.out.println(
                                                        "Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
                                            }
                                            break;

                                        case 5:
                                            System.out.println("Pilih nomor pegawai untuk melihat detail:");
                                            for (int i = 0; i < jumlahPegawai; i++) {
                                                System.out.println((i + 1) + ". " + namaPegawai2[i]);
                                            }

                                            System.out.print("Masukkan nomor pegawai: ");
                                            int pilihan = input.nextInt();

                                            if (pilihan > 0 && pilihan <= jumlahPegawai) {
                                                int index = pilihan - 1;
                                                System.out.println("Detail Pegawai:");
                                                System.out.println("Nama: " + namaPegawai2[index]);
                                                System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[index]);
                                                System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[index]);
                                                System.out.println("Kebangsaan: " + kebangsaanPegawai[index]);
                                                System.out.println("Email: " + emailPegawai[index]);
                                                System.out.println("Alamat: " + alamatPegawai[index]);
                                                System.out.println("Telepon: " + teleponPegawai[index]);
                                            } else {
                                                System.out.println("Nomor pegawai tidak valid.");
                                            }
                                            break;

                                        case 6:
                                            System.out.println("Terima kasih telah menggunakan program ini.");
                                            //System.exit(0);
                                            break;

                                        default:
                                            System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
                                            break;
                                    }

                                } while (menuManajemen != 6);

                            } else if (menuAdmin == 2) {
                                System.out.print("Masukkan Jumlah Pegawai: ");
                                jumlahPegawai = input.nextInt();
                                input.nextLine();

                                // Membuat array 2 dimensi untuk menyimpan data gaji pegawai
                                double[][] jadwalGaji = new double[jumlahPegawai][6]; // Array 2 dimensi untuk menyimpan
                                                                                      // jadwal gaji

                                // Mengisi jadwal gaji setiap pegawai
                                for (int i = 0; i < jumlahPegawai; i++) {
                                    System.out.println("Masukkan jadwal gaji untuk Pegawai " + (i + 1) + ":");
                                    System.out.print("Gaji Pokok: ");
                                    jadwalGaji[i][0] = input.nextDouble();
                                    System.out.print("Bonus: ");
                                    jadwalGaji[i][1] = input.nextDouble();
                                    System.out.print("Potongan: ");
                                    jadwalGaji[i][2] = input.nextDouble();
                                    jadwalGaji[i][3] = jadwalGaji[i][0] + jadwalGaji[i][1] - jadwalGaji[i][2]; // Total
                                                                                                               // gaji
                                                                                                               // disimpan
                                                                                                               // di
                                                                                                               // kolom
                                                                                                               // ke-4
                                }

                                // Menampilkan jadwal gaji setiap pegawai
                                System.out.println("\nJadwal Pembayaran Gaji:");
                                for (int i = 0; i < jumlahPegawai; i++) {
                                    System.out.println("Pegawai " + (i + 1) + ":");
                                    System.out.println("Gaji Pokok: " + jadwalGaji[i][0]);
                                    System.out.println("Bonus: " + jadwalGaji[i][1]);
                                    System.out.println("Potongan: " + jadwalGaji[i][2]);
                                    System.out.println("Total Gaji: " + jadwalGaji[i][3]);
                                    System.out.println("-----------------------------");
                                }
                                input.nextLine();
                                break;

                            } else if (menuAdmin == 3) {
                                System.out.print("Masukkan jumlah pegawai: ");
                                int jumlahPegawai3 = input.nextInt();
                                input.nextLine(); // Membersihkan newline

                                String[] namaPegawai3 = new String[jumlahPegawai3];
                                int[] jamKerja = new int[jumlahPegawai3];

                                // Mengisi data kehadiran dan jam kerja setiap karyawan
                                for (int i = 0; i < jumlahPegawai3; i++) {
                                    System.out.println("Masukkan data untuk Karyawan " + (i + 1) + ":");
                                    System.out.print("Nama Karyawan: ");
                                    namaPegawai3[i] = input.nextLine();
                                    System.out.print("Jam Kerja: ");
                                    jamKerja[i] = input.nextInt();

                                    // Membersihkan newline setelah input angka
                                    input.nextLine();
                                }

                                // Menampilkan data kehadiran dan jam kerja setiap karyawan
                                System.out.println("\nData Kehadiran dan Jam Kerja Karyawan:");
                                for (int i = 0; i < jumlahPegawai3; i++) {
                                    System.out.println("Karyawan " + (i + 1) + ":");
                                    System.out.println("Nama: " + namaPegawai3[i]);
                                    System.out.println("Jam Kerja: " + jamKerja[i] + " jam");
                                    System.out.println("-----------------------------");
                                }

                                // Menghitung total jam kerja seluruh karyawan
                                int totalJamKerja2 = 0;
                                for (int jam : jamKerja) {
                                    totalJamKerja2 += jam;
                                }

                                System.out.println("\nTotal Jam Kerja Seluruh Karyawan: " + totalJamKerja2 + " jam");

                                // Menentukan karyawan dengan jam kerja terbanyak
                                int maxJamKerja = -1;
                                int indexKaryawanMaxJam = -1;

                                for (int i = 0; i < jumlahPegawai3; i++) {
                                    if (jamKerja[i] > maxJamKerja) {
                                        maxJamKerja = jamKerja[i];
                                        indexKaryawanMaxJam = i;
                                    }
                                }

                                System.out.println(
                                        "Karyawan dengan Jam Kerja Terbanyak: " + namaPegawai3[indexKaryawanMaxJam]);
                                break;

                            } else if (menuAdmin == 4) {

                                while (true) {
                                    System.out.println("=== MENU PERMINTAAN dan PERSETUAJUAN CUTI ===");
                                    System.out.println("1. Lihat Permintaan Cuti");
                                    System.out.println("2. Proses Permintaan Cuti");
                                    System.out.println("3. Persetujuan Cuti");
                                    System.out.println("4. Keluar");
                                    System.out.print("Pilih menu (1/2/3): ");

                                    int pilihanMenuCuti = input.nextInt();

                                    switch (pilihanMenuCuti) {
                                        case 1:
                                            System.out.println("\n=== DAFTAR PERMINTAAN CUTI ===");
                                            for (int i = 0; i < jumlahPermintaan; i++) {
                                                System.out.println("Nama Pegawai: " + namaPegawai2[i]);
                                                System.out.println("Jumlah Hari Cuti: " + jumlahHariCuti[i]);
                                                System.out.println("Status Persetujuan: "
                                                        + (statusPersetujuan[i] ? "Disetujui" : "Belum Disetujui"));
                                                System.out.println("-----------------------------");
                                            }
                                            break;

                                        case 2:
                                            System.out.print("Masukkan nama pegawai: ");
                                            input.nextLine(); // Membersihkan newline
                                            String nama = input.nextLine();

                                            System.out.print("Masukkan jumlah hari cuti: ");
                                            int hariCuti = input.nextInt();

                                            // Memasukkan data permintaan cuti ke dalam array
                                            namaPegawai2[jumlahPermintaan] = nama;
                                            jumlahHariCuti[jumlahPermintaan] = hariCuti;
                                            statusPersetujuan[jumlahPermintaan] = false; // Default: Belum disetujui
                                            jumlahPermintaan++;

                                            System.out.println("Permintaan cuti berhasil diajukan.");
                                            break;

                                        case 3:
                                            System.out.print("Masukkan nomor permintaan cuti yang akan disetujui: ");
                                            int nomorPermintaan = input.nextInt();

                                            if (nomorPermintaan >= 0 && nomorPermintaan < jumlahPermintaan) {
                                                statusPersetujuan[nomorPermintaan] = true;
                                                System.out.println("Permintaan cuti disetujui untuk karyawan "
                                                        + namaPegawai2[nomorPermintaan]);
                                            } else {
                                                System.out.println("Nomor permintaan cuti tidak valid.");
                                            }
                                            break;

                                        case 4:
                                            System.out.println("Terima kasih telah menggunakan program ini.");
                                            input.close();
                                            System.exit(0);
                                            break;

                                        default:
                                            System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
                                            break;
                                    }
                                }

                            } else if (menuAdmin == 5) {

                                // Input data gaji dan kinerja karyawan
                                System.out.print("Masukkan jumlah pegawai: ");
                                int jumlahPegawai5 = input.nextInt();

                                for (int i = 0; i < jumlahPegawai5; i++) {
                                    System.out.println("\nData Karyawan " + (i + 1) + ":");
                                    System.out.print("Gaji Karyawan: ");
                                    double gajiPegawai = input.nextDouble();
                                    totalPengeluaranGaji += gajiPegawai;

                                    System.out.print("Kinerja Karyawan (Baik/Cukup/Perlu Perbaikan): ");
                                    String kinerja = input.next();
                                    switch (kinerja.toLowerCase()) {
                                        case "Baik":
                                            pegawaiBerkinerjaBaik++;
                                            break;
                                        case "Cukup":
                                            pegawaiCukupBerkinerja++;
                                            break;
                                        case "Perlu Perbaikan":
                                            pegawaiPerluPerbaikan++;
                                            break;
                                        default:
                                            System.out.println("Pilihan kinerja tidak valid.");
                                            i--; // Ulangi input untuk karyawan ini
                                    }
                                }

                                // Input data kehadiran
                                System.out.print("\nMasukkan total kehadiran: ");
                                totalKehadiran = input.nextInt();
                                totalTidakHadir = jumlahPegawai5 * 30 - totalKehadiran;

                                // Menampilkan laporan
                                System.out.println("\n=== Laporan Perusahaan ===");
                                System.out.println("1. Pengeluaran Gaji");
                                System.out.println("   Total Pengeluaran Gaji: Rp" + totalPengeluaranGaji);
                                System.out.println("\n2. Kinerja Karyawan");
                                System.out.println("   Karyawan Berkinerja Baik: " + pegawaiBerkinerjaBaik);
                                System.out.println("   Karyawan Cukup Berkinerja: " + pegawaiCukupBerkinerja);
                                System.out.println("   Karyawan Perlu Perbaikan: " + pegawaiPerluPerbaikan);
                                System.out.println("\n3. Tren Kehadiran");
                                System.out.println("   Total Kehadiran: " + totalKehadiran + " hari");
                                System.out.println("   Total Tidak Hadir: " + totalTidakHadir + " hari");

                                input.nextLine();
                                break;

                            } else if (menuAdmin == 6) {
                                System.out.println("Terima kasih telah menggunakan program ini.");
                                break;
                            }

                            else {
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
                            System.out.println("4. Log Out");
                            System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4): ");
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
                    System.out.println();
                    // memberitahu sisa kesempatan login
                    System.out.printf("Peringatan! : Anda memiliki %dx kesempatan login \n", sisaKesempatan);
                    System.out.println();
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
