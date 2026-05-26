import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // SOAL 1 - Katalog Buku
        Map<String, Buku> katalogBuku = new HashMap<>();
        katalogBuku.put("001", new Buku("001", "Pemrograman Berorientasi Objek"));
        katalogBuku.put("002", new Buku("002", "Pemrograman Berorientasi"));
        katalogBuku.put("003", new Buku("003", "Pemrograman"));
        katalogBuku.put("004", new Buku("004", "Pemrograman Dasar"));

        // SOAL 2 - Daftar Anggota
        Set<Anggota> anggota = new HashSet<>();
        anggota.add(new Anggota("105224001", "Silviana", "Dosen"));
        anggota.add(new Anggota("199999999", "Silvia", "Mahasiswa"));
        anggota.add(new Anggota("199999990", "Silvi", "Mahasiswa"));
        anggota.add(new Anggota("105224002", "Silvianak", "Dosen"));

        // SOAL 3 - Antrean
        LinkedList<String> antrean = new LinkedList<>();
        antrean.addFirst("105224001#001"); // Dosen
        antrean.addFirst("105224002#004"); // Dosen
        antrean.addLast("199999999#002");  // Mahasiswa
        antrean.addLast("199999990#003");  // Mahasiswa

        System.out.println("Antrean awal: " + antrean);
        System.out.println("========================================");

        // Kumpulkan idAnggota ke Set untuk pengecekan
        Set<String> idDaftar = new HashSet<>();
        for (Anggota a : anggota) {
            idDaftar.add(a.idAnggota);
        }

        Map<String, String> sedangDipinjam = new HashMap<>();

        // SOAL 4 - Proses Antrean
        while (!antrean.isEmpty()) {
            String antrian = antrean.removeFirst();
            String[] data = antrian.split("#");
            String idAnggota = data[0];
            String isbn = data[1];

            System.out.println("Memproses Antrian: " + antrian);

            //anggota ada ga si kedaftar?
            boolean anggotaAda = false;
            for (Anggota a : anggota) {
                if (a.idAnggota.equals(idAnggota)) {
                    anggotaAda = true;
                    break;
                }
            }
            if (!anggotaAda) {
                System.out.println("gagal: Anggota " + idAnggota + " tidak terdaftar.");
                continue;
            }

            //buku ada nggak di katalog
            boolean bukuAda = false;
            for (Buku b : katalogBuku.values()) {
                if (b.isbn.equals(isbn)) {
                    bukuAda = true;
                    break;
                }
            }
            if (!bukuAda) {
                System.out.println("gagal: Buku ISBN " + isbn + " tidak ada di katalog.");
                continue;
            }

            // apakah buku sudah dipinjam atau belum?
            boolean sudahDipinjam = false;
            for (String isbnDipinjam : sedangDipinjam.values()) {
                if (isbnDipinjam.equals(isbn)) {
                    sudahDipinjam = true;
                    break;
                }
            }
            if (sudahDipinjam) {
                System.out.println("gagal: Buku ISBN " + isbn + " sedang dipinjam orang lain.");
                continue;
            }

            // Semua OK
            sedangDipinjam.put(idAnggota, isbn);
            System.out.println("berhasil: " + idAnggota + " pinjam buku dengan ISBN " + isbn);
        }

        System.out.println("======================================");
        System.out.println("Buku Sedang dipinjam: " + sedangDipinjam);
    }
}