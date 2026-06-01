//nomor dua membuat class sistem gudang 
//ynag pada class ini akan terdapat deklaras collections sebagai atribut kelas
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SistemGudang { //class ssistem gudang

    //Database Barang: Penyimpan data utama
    //Penyimpanan data utama, kunci (key) adalah ID barang dimana key bertipe String idBarang dengan value bertipe Barang
    //akan dipilih oleh HashMap karena pencariannya berdasarkan key
    Map<String, Barang> databaseBarang = new HashMap<>();

    //Kategori Unik : Setiap kali barang baru didaftarkan, kategorinya dimasukkan ke sini. 
    //Menggunakan HashSet karena nantinya akan otomatis menolak jika terdapat nilai duplikat tanpa perlu mengecek secara manual
    Set<String> kategoriUnik = new HashSet<>();

    //Riwayat: Mencatat setiap string aktivitas 
    //karena linkedlist menambahkan data diakhir, setiap penambahan data akan ditambahkan di akhir dengan menggunakann addLast
    LinkedList<String> riwayat = new LinkedList<>();

    //tambahBarangBaru(id, nama, kategori, stok): Memasukkan objek Barang ke Map dan kategorinya ke Set.
    //menerima id, nama, kategori, dan stok yang akan dimasukkan ke database
    public void tambahBarangBaru(String idB, String namaB, String kategoriB, int StokB){
        //buat objek dari Class Barang.java yang sebelumnya sudah dibuat dengan konstruktor
        Barang barang = new Barang(idB,namaB,kategoriB,StokB); 
        //masukkan objek barang ke HashMap dengan idB sebagai key nya
        databaseBarang.put(idB, barang);
        //masukkan kategoriB ke kategoriUnik (hash set) jika barang sudah ada maka hashset akan otomatis menolak
        kategoriUnik.add(kategoriB);
        //menambahkan atau mencatat riwayat pendaftaran barang baru ke paling akhir (addLast)
        riwayat.addLast("Barang Baru: " + idB + " - " + namaB + " [Stok Awal: " + StokB + "]");
        System.out.println(" [SIP] Barang baru sudah didaftarkan dengan Nama barang: " + namaB);
    }
    
    //tambahStok(id, jumlah): Menambah stok pada objek di dalam Map jika ID ditemukan
    //menambahkan stok pada objek di dakam map jika id ditemukan
    public void tambahkanStok(String idB, int jumlahB){
        //mengecek apakah idB ada di dalam database sebagai key pada HashMap
        if (databaseBarang.containsKey(idB)) {
            //jika ada maka lakukan penambahan stok
            //get mengambil ibjek Barang dari HashMap berdasarkan key nya lalu stok-nya akan langsung ditambahkan dengan jumlahB
            Barang barang = databaseBarang.get(idB);
            barang.stok += jumlahB;
            //biasa, mencatat aktivitas ke riwayat dan menampilkan konfirmasi ke layar
            riwayat.addLast("Barang masuk: " + idB + " - ditambahkan stok sebanyak: " + jumlahB + " unit");
            System.out.println(" [SIP] Stok barang: " + idB + " berhasil ditambahkan dengan jumlah: " + jumlahB);
            //jika idB tidak ditemukan maka gagal
        } else {
            System.out.println(" [GAGAL] Barang dengan ID " + idB + " tidak ditemukan.");
        }
    }

    //kurangiStok(id, jumlah): Mengurangi stok JIKA stok mencukupi. Tolak jika stok kurang atau ID tidak ada.
    public void kurangiStok(String idB, int jumlahB){
        //tolak jika idB tidak ada atau tidak ditemukan
        if (!databaseBarang.containsKey(idB)){
            System.out.println(" [GAGAL] Barang dengan ID " + idB + " tidak ditemukan.");
            return;
        }
        Barang barang = databaseBarang.get(idB);
        //mengurangi stok jika stok cukup
        if(barang.stok >= jumlahB){
            barang.stok -= jumlahB;
            riwayat.addLast("Barang keluar: " + idB + " - dikurangi stok sebanyak: " + jumlahB + " unit");
            System.out.println(" [SIP] Stok barang: " + idB + " berhasil dikurangi dengan jumlah: " + jumlahB);
        } else {
            //tolak karena stok tidak mencukupi atau stok kurang
            System.out.println(" [GAGAL] Stok barang: " + idB + " kurang dengan jumlah: " + jumlahB);
        }
    }
    //cetakLaporan(): Menampilkan daftar kategori (dari Set), sisa stok semua barang (dari Map), dan urutan riwayat transaksi (dari List).
    public void cetakLaporan(){
        System.out.println("=====================================");
        System.out.println("=== Laporan Gudang ===");
        System.out.println("=== Daftar Kategori Barang ===");

        for (String kategori : kategoriUnik) { //untuk setruap kategori dnegan tipe string yang ada pada kategori unik maka lakukan perulangan
            System.out.println("- " + kategori);
        }

        System.out.println("=== Sisa Stok Semua Barang ==="); //mengubah seluruh isi hashmap menjadi kumpulan yang bisa diiterasakan
        for (Map.Entry<String, Barang> entry : databaseBarang.entrySet()) { //dengan tipe data yang sesuai dengan key dan value
            Barang b = entry.getValue(); 
            System.out.println("  [" + b.idBarang + "] " + b.namaBarang + " | Kategori: " + b.kategori + " | Stok: " + b.stok);
        }

        System.out.println("=== Riwayat Transaksi ===");
        for (String transaksi : riwayat) { 
            System.out.println("- " + transaksi);
        }

        System.out.println("=====================================");
    }

    

    
    
}
