import java.util.Scanner;

public class Coba1 {

    public static void main(String[] args) {
        String[] username = { "admin1", "pegawai2", "manajer3" };
        String[] password = { "adminpassword1", "pegawaipassword2", "manajerpassword3" };

        String namaPegawai, jabatan, bulanGaji, jenisKelamin, ttl, kebangsaan, email, alamat, telepon;
        int jumlahJamKerja, jumlahJamLembur, totalJamKerja, usia, bonus = 0, lamaBekerja;
        int upah = 15700, pajak = 25000, totalJamLembur, totalGaji, gajiPokok = 0;
        int menuAdmin;
        boolean isAuthenticated = false;
        boolean pesan = true;
        Scanner input = new Scanner(System.in);

        for (int kesempatanLogin = 1; kesempatanLogin <= 3; kesempatanLogin++) { // Membatasi jumlah maksimal percobaan
                                                                                 // login

            int sisaKesempatan = 3 - kesempatanLogin;// menghitung sisa kesempatan login

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
                System.out.println("Selamat datang, " + usernameInput + "!");
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
                    System.out.println("===BERIKUT PILIHAN MENU ADMIN===");
                    System.out.println("1. Menu Input Data Pegawai");
                    System.out.println("2. Menu Input Jumlah Gaji Pegawai");
                    System.out.println("3. Menu Penyusunan Jadwal Pembayaran Gaji");
                    System.out.println("4. Rekap Manajemen Absensi Pegawai");
                    System.out.print("Silahkan Pilih Menu Diatas (1/2/3/4): ");
                    menuAdmin = input.nextInt();

                    if (menuAdmin == 1) {
                        System.out.print("Masukkan Jumlah Pegawai: ");
                        int jumlahPegawai = input.nextInt();

                        String namaPegawai2[] = new String[jumlahPegawai];
                        String jenisKelamin2[] = new String[jumlahPegawai];
                        String ttl2[] = new String[jumlahPegawai];
                        String kebangsaan2[] = new String[jumlahPegawai];
                        String email2[] = new String[jumlahPegawai];
                        String alamat2[] = new String[jumlahPegawai];
                        String telepon2[] = new String[jumlahPegawai];

                        for (int i = 0; i < jumlahPegawai; i++) {
                            System.out.println("=====================================");
                            System.out.println("\nMASUKKAN DATA PEGAWAI KE-" + (i + 1));
                            input.nextLine();
                            System.out.print("Masukkan Nama Lengkap Pegawai: ");
                            namaPegawai2[i] = input.nextLine();
                            System.out.print("Masukkan Jenis Kelamin Pegawai: ");
                            jenisKelamin2[i] = input.nextLine();
                            System.out.print("Masukkan Tempat dan Tanggal Lahir Pegawai: ");
                            ttl2[i] = input.nextLine();
                            System.out.print("Masukkan Kebangsaan Pegawai: ");
                            kebangsaan2[i] = input.nextLine();
                            System.out.print("Masukkan Alamat Email Pegawai: ");
                            email2[i] = input.nextLine();
                            System.out.print("Masukkan Alamat Pegawai: ");
                            alamat2[i] = input.nextLine();
                            System.out.print("Masukkan Nomor Telepon Pegawai: ");
                            telepon2[i] = input.nextLine();
                        }

                        System.out.println("\nDATA PEGAWAI YANG TELAH DI INPUT:");
                        for (int i = 0; i < jumlahPegawai; i++) {
                            System.out.println("Pegawai ke-" + (i + 1));
                            System.out.println("Nama: " + namaPegawai2[i]);
                            System.out.println("Jenis Kelamin: " + jenisKelamin2[i]);
                            System.out.println("Tempat dan Tanggal Lahir: " + ttl2[i]);
                            System.out.println("Kebangsaan: " + kebangsaan2[i]);
                            System.out.println("Email: " + email2[i]);
                            System.out.println("Alamat: " + alamat2[i]);
                            System.out.println("Telepon: " + telepon2[i]);
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
                                System.out.println("Jenis Kelamin: " + jenisKelamin2[i]);
                                System.out.println("Tempat dan Tanggal Lahir: " + ttl2[i]);
                                System.out.println("Kebangsaan: " + kebangsaan2[i]);
                                System.out.println("Email: " + email2[i]);
                                System.out.println("Alamat: " + alamat2[i]);
                                System.out.println("Telepon: " + telepon2[i]);
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
