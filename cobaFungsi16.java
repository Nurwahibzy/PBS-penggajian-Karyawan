import java.util.Scanner;

public class cobaFungsi16 {

    static Scanner input = new Scanner(System.in);

    static String[] namaPegawai2 = new String[100];
    static String[] jenisKelaminPegawai = new String[100];
    static String[] ttlPegawai = new String[100];
    static String[] kebangsaanPegawai = new String[100];
    static String[] emailPegawai = new String[100];
    static String[] alamatPegawai = new String[100];
    static String[] teleponPegawai = new String[100];
    static int jumlahPegawai = 0;

    public static void main(String[] args) {
        int menuAdmin;
        
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

            switch (menuAdmin) {
                case 1:
                    menuManajemenDataPegawai();
                    break;
                // other cases
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
                    break;
            }
        }
    }

    static void menuManajemenDataPegawai() {
        int menuManajemen;

        while (true) {
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
                    inputDataPegawai();
                    break;
                case 2:
                    editDataPegawai();
                    break;
                case 3:
                    hapusDataPegawai();
                    break;
                case 4:
                    cariDataPegawai();
                    break;
                case 5:
                    lihatDetailDataPegawai();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
                    break;
            }
        }
    }

    static void inputDataPegawai() {
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
    }

    static void editDataPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan diubah: ");
        String namaUbah = input.nextLine();
        int foundIndex = -1;

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

                System.out.println("\nMASUKKAN DATA PEGAWAI BARU");
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

                System.out.println("\nDATA PEGAWAI YANG TELAH DIUBAH:");
                System.out.println("Pegawai ke-" + (i + 1));
                System.out.println("Nama: " + namaPegawai2[i]);
                System.out.println("Jenis Kelamin: " + jenisKelaminPegawai[i]);
                System.out.println("Tempat dan Tanggal Lahir: " + ttlPegawai[i]);
                System.out.println("Kebangsaan: " + kebangsaanPegawai[i]);
                System.out.println("Email: " + emailPegawai[i]);
                System.out.println("Alamat: " + alamatPegawai[i]);
                System.out.println("Telepon: " + teleponPegawai[i]);
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Data pegawai dengan nama " + namaUbah + " tidak ditemukan.");
        }
    }

    static void hapusDataPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan dihapus: ");
        String namaHapus = input.nextLine();
        int foundIndex = -1;

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

                System.out.print("Apakah Anda yakin ingin menghapus data pegawai ini? (Y/N): ");
                String konfirmasi = input.nextLine();
                if (konfirmasi.toLowerCase().equals("y")) {
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
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Data pegawai dengan nama " + namaHapus + " tidak ditemukan.");
        }
    }

    static void cariDataPegawai() {
        System.out.print("Masukkan Nama Pegawai yang akan dicari: ");
        String namaCari = input.nextLine();
        int foundIndex = -1;

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
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Data pegawai dengan nama " + namaCari + " tidak ditemukan.");
        }
    }

    static void lihatDetailDataPegawai() {
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
    }
}
