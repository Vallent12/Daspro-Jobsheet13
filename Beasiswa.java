import java.util.Scanner;

public class Beasiswa {

    static String[][] data = new String[100][5]; 
    static int jumlahData = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;

        do {
            System.out.println("=== Sistem Pendaftaran Beasiswa ===");
            System.out.println("1. Tambah Data Pendaftar Beasiswa");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar berdasarkan Jenis Beasiswa");
            System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> tambahData();
                case 2 -> tampilData();
                case 3 -> cariJenis();
                case 4 -> rataIPK();
                case 5 -> System.out.println("Keluar...");
                default -> System.out.println("Menu tidak valid!");
            }

        } while (menu != 5);
    }

    static void tambahData() {

        System.out.print("Nama Mahasiswa: ");
        data[jumlahData][0] = sc.nextLine();

        System.out.print("NIM: ");
        data[jumlahData][1] = sc.nextLine();

        System.out.print("IPK terakhir: ");
        data[jumlahData][2] = sc.nextLine();

        System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
        data[jumlahData][3] = sc.nextLine();

        System.out.print("Penghasilan orang tua (maksimal 2000000): ");
        data[jumlahData][4] = sc.nextLine();

        int penghasilan = Integer.parseInt(data[jumlahData][4]);
        if (penghasilan > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.\n");
            return;
        }

        jumlahData++;
        System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlahData + "\n");
    }

    static void tampilData() {

        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar.\n");
            return;
        }

        System.out.println("Daftar pendaftar beasiswa:");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println((i + 1) + ". " 
                + data[i][0] + " (" + data[i][1] + "), IPK: " 
                + data[i][2] + ", Jenis: " 
                + data[i][3] + ", Penghasilan: " 
                + data[i][4]);
        }
        System.out.println();
    }

    static void cariJenis() {

        System.out.print("Masukkan jenis beasiswa: ");
        String cari = sc.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (data[i][3].equalsIgnoreCase(cari)) {

                if (!ditemukan) {
                    System.out.println("Pendaftar dengan jenis " + cari + ":");
                }

                System.out.println("- " + data[i][0] + " (" + data[i][1] + "), IPK: " + data[i][2]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar dengan jenis tersebut.");
        }
        System.out.println();
    }

    static void rataIPK() {

        String[] jenisList = {"Reguler", "Unggulan", "Riset"};

        for (String j : jenisList) {

            double total = 0;
            int hitung = 0;

            for (int i = 0; i < jumlahData; i++) {
                if (data[i][3].equalsIgnoreCase(j)) {
                    total += Double.parseDouble(data[i][2]);
                    hitung++;
                }
            }

            if (hitung > 0) {
                System.out.printf("%s : rata-rata IPK = %.2f\n", j, total / hitung);
            } else {
                System.out.println(j + " : tidak ada pendaftar.");
            }
        }

        System.out.println();
    }
}