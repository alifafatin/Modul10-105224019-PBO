//nomor satu membuat class barang dengan atribut
public class Barang {
    String idBarang;
    String namaBarang;
    String kategori;
    int stok;

    //Konstruktor untuk atribut
    public Barang(String idBarang, String namaBarang, String kategori, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }
}