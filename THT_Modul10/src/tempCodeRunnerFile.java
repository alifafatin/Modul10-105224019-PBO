public class Main {
    public static void main(String[] args) {
        //buat objek dari sistemgudang
        SistemGudang gudangs = new SistemGudang();

        //Daftarkan minimal 3 barang baru.
        gudangs.tambahBarangBaru("BAR01", "Beras 10kg", "Sembako", 100);
        gudangs.tambahBarangBaru("BAR02", "Minyak Goreng 1L", "Sembako", 100);
        gudangs.tambahBarangBaru("BAR03", "Air Puti Mineral 500ml", "Minuman", 50);

        //Lakukan 1x tambah stok yang berhasil.
        gudangs.tambahkanStok("BAR01", 5);

        //Lakukan 1x kurangi stok yang berhasil
        gudangs.kurangiStok("BAR02", 10);

        //Lakukan 1x kurangi stok yang GAGAL (karena stok ditarik lebih besar dari sisa).
        gudangs.kurangiStok("BAR03", 100);

        //Panggil metode cetak laporan akhir.
        gudangs.cetakLaporan();
    }

}
