import java.util.Scanner;
public class Magang {

    static String[][] data = new String[100][6];
    static int jumlahData = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;

        do {
            System.out.println("=== Sistem Pendaftaran Magang Mahasiswa ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar Magang");
            System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> tambahData();
                case 2 -> tampilSemua();
                case 3 -> cariProdi();
                case 4 -> hitungStatus();
                case 5 -> System.out.println("Keluar...");
                default -> System.out.println("Menu tidak valid!\n");
            }

        } while (menu != 5);
    }

    static void tambahData() {
        System.out.print("Nama Mahasiswa: ");
        data[jumlahData][0] = sc.nextLine();

        System.out.print("NIM: ");
        data[jumlahData][1] = sc.nextLine();

        System.out.print("Program Studi: ");
        data[jumlahData][2] = sc.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        data[jumlahData][3] = sc.nextLine();

        System.out.print("Semester pengambilan magang (6 atau 7): ");
        data[jumlahData][4] = sc.nextLine();

        System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
        data[jumlahData][5] = sc.nextLine();

        jumlahData++;

        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + jumlahData + "\n");
    }

    static void tampilSemua() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar.\n");
            return;
        }

        System.out.println("=== Daftar Semua Pendaftar Magang ===");
        System.out.printf("%-3s %-12s %-10s %-25s %-15s %-10s %-10s\n","No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-3d %-12s %-10s %-25s %-15s %-10s %-10s\n",i + 1, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5]);
        }
        System.out.println();
    }

    static void cariProdi() {
        System.out.print("Masukkan Program Studi: ");
        String cari = sc.nextLine();
        System.out.println();

        boolean ditemukan = false;

        System.out.printf("%-3s %-12s %-10s %-25s %-15s %-10s %-10s\n","No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");

        int nomor = 1;
        for (int i = 0; i < jumlahData; i++) {
            if (data[i][2].equalsIgnoreCase(cari)) {
                ditemukan = true;
                System.out.printf("%-3d %-12s %-10s %-25s %-15s %-10s %-10s\n",nomor, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5]);
                nomor++;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar dari program studi tersebut.");
        }

        System.out.println();
    }

    static void hitungStatus() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar.\n");
            return;
        }

        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String status = data[i][5];

            if (status.equalsIgnoreCase("Diterima")) diterima++;
            else if (status.equalsIgnoreCase("Menunggu")) menunggu++;
            else if (status.equalsIgnoreCase("Ditolak")) ditolak++;
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total pendaftar: " + jumlahData + "\n");
    }
}