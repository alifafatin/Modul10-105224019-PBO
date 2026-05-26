import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Film {
    String judul;
    int hargaTiket;

    public Film(String judul, int hargaTiket) {
        this.judul = judul;
        this.hargaTiket = hargaTiket;
    }
}

class Transaksi {
    String namaPelanggan;
    String judulFilm;
    String nomorKursi;
    int harga;

    public Transaksi(String namaPelanggan, String judulFilm, String nomorKursi, int harga) {
        this.namaPelanggan = namaPelanggan;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
        this.harga = harga;
    }
}

public class BioskopIndependen {
    public static void main(String[] args) {

        //nyimpan jadwal film hri ini, bioskop ada 3 film yang tayang terus nanti kasir akan cari pakai kode film (yg F01, F02, F03)
        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("F01", new Film("Avengers: Doomsday", 70000));
        jadwal.put("F02", new Film("Jumbo", 70000));
        jadwal.put("F03", new Film("Wild Robot", 70000));

        //nolak jika kursi sudah terisi
        Set<String> pesananKursi = new HashSet<>();

        //nyimpan semua transaksi
        List<Transaksi> transaksi = new ArrayList<>();

        //tampilan
        System.out.println("=== Tiket Bioskop Ceunah ===");

        // Pesanan 1: Monica, F02, 5C
        String namaPelanggan1 = "Monica"; String kode1 = "F02"; String nomorKursi1 = "5C";
        if (!jadwal.containsKey(kode1)) {
            System.out.println("[failed] Kode film tidak ada.");
        } else if (!pesananKursi.add(nomorKursi1)) {
            System.out.println("[failed] Kursi " + nomorKursi1 + " sudah terisi. (" + namaPelanggan1 + " ditolak)");
        } else {
            Film f = jadwal.get(kode1);
            transaksi.add(new Transaksi(namaPelanggan1, f.judul, nomorKursi1, f.hargaTiket));
            System.out.println("[success] " + namaPelanggan1 + " = " + f.judul + " | Kursi: " + nomorKursi1 + " | Rp " + f.hargaTiket);
        }

        // Pesanan 2: Haruka, F01, 5D
        String namaPelanggan2 = "Haruka"; String kode2 = "F01"; String nomorKursi2 = "5D";
        if (!jadwal.containsKey(kode2)) {
            System.out.println("[failed] Kode film tidak ada.");
        } else if (!pesananKursi.add(nomorKursi2)) {
            System.out.println("[failed] Kursi " + nomorKursi2 + " sudah terisi. (" + namaPelanggan2 + " ditolak)");
        } else {
            Film f = jadwal.get(kode2);
            transaksi.add(new Transaksi(namaPelanggan2, f.judul, nomorKursi2, f.hargaTiket));
            System.out.println("[success] " + namaPelanggan2 + " = " + f.judul + " | Kursi: " + nomorKursi2 + " | Rp " + f.hargaTiket);
        }

        // Pesanan 3: Mikki, F03, 7B
        String namaPelanggan3 = "Mikki"; String kode3 = "F03"; String nomorKursi3 = "7B";
        if (!jadwal.containsKey(kode3)) {
            System.out.println("[failed] Kode film tidak ada.");
        } else if (!pesananKursi.add(nomorKursi3)) {
            System.out.println("[failed] Kursi " + nomorKursi3 + " sudah terisi. (" + namaPelanggan3 + " ditolak)");
        } else {
            Film f = jadwal.get(kode3);
            transaksi.add(new Transaksi(namaPelanggan3, f.judul, nomorKursi3, f.hargaTiket));
            System.out.println("[success] " + namaPelanggan3 + " = " + f.judul + " | Kursi: " + nomorKursi3 + " | Rp " + f.hargaTiket);
        }

        // Pesanan 4: Devi, F02, 5C (DUPLIKAT)
        String namaPelanggan4 = "Devi"; String kode4 = "F02"; String nomorKursi4 = "5C";
        if (!jadwal.containsKey(kode4)) {
            System.out.println("[failed] Kode film tidak ada.");
        } else if (!pesananKursi.add(nomorKursi4)) {
            System.out.println("[failed] Kursi " + nomorKursi4 + " sudah terisi. (" + namaPelanggan4 + " ditolak kaciann)");
        } else {
            Film f = jadwal.get(kode4);
            transaksi.add(new Transaksi(namaPelanggan4, f.judul, nomorKursi4, f.hargaTiket));
            System.out.println("[success] " + namaPelanggan4 + " = " + f.judul + " | Kursi: " + nomorKursi4 + " | Rp " + f.hargaTiket);
        }

        //sistem memeriksa riwayat sesuai denggan urutan transaksi
        System.out.println("===========================================");
        int no = 1;
        for (Transaksi t : transaksi) {
            System.out.println(no + ". " + t.namaPelanggan + " | " + t.judulFilm + " | Kursi: " + t.nomorKursi + " | Rp " + t.harga);
            no++;
        }
    }
}