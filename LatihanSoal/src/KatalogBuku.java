import java.util.HashMap;
import java.util.Map;

class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public void cetakBuku(){
        System.out.println("ISBN : " + isbn);
        System.out.println("Judul : " + judul);
    }
}

public class KatalogBuku{
    public static void main(String[] args) {
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("0001", new Buku("0001", "Pemrograman Berorientasi Objek"));
        katalogBuku.put("0002", new Buku("0002", "Pemrograman Berorientasi"));
        katalogBuku.put("0003", new Buku("0003", "Pemrograman"));

        String cariIsbn = "0001";

        if(katalogBuku.containsKey(cariIsbn)){
            System.out.println("Buku ditemukan!!");
            katalogBuku.get(cariIsbn).cetakBuku();
        } else {
            System.out.println("Buku dengan ISBN : " + cariIsbn + " tidak ditemukan.");
        }
    }
}

