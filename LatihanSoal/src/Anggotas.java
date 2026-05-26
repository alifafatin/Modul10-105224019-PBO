import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    //override nolak duplikat
    @Override
    public boolean equals(Object ojt) {
    if (this == ojt) return true;
    if (ojt == null || getClass() != ojt.getClass()) return false;
    Anggota anggota = (Anggota) ojt;
    return Objects.equals(idAnggota, anggota.idAnggota);
}

    @Override
    public int hashCode(){
        return Objects.hash(idAnggota);
    }
}

public class Anggotas {
    public static void main(String[] args) {
        Set<Anggota> anggota = new HashSet<>();

        anggota.add(new Anggota("105224001", "Silviana", "Dosen"));
        anggota.add(new Anggota("199999999", "Silvia", "Mahasiswa"));
        anggota.add(new Anggota("199999990", "Silvi", "Mahasiswa"));

        //yang bakal ditolak
        anggota.add(new Anggota("105224001", "Silviana", "Dosen"));

        System.out.println("Jumlah anggota : " + anggota.size());
    }
}
