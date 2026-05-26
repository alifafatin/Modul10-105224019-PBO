import java.util.LinkedList;

public class Antrean {
    public static void main(String[] args) {
        LinkedList<String> antrean = new LinkedList<>(); 

        //jika yang meminjam adalah dosen maka ia memotong antrean dan diletakkan paling depan, jika mahasiswa masuk ke paling belakang antrean
        
        //dosen masuk ke paling depan
        antrean.addFirst("105224001#001");

        //mahasiswa masuk ke paling belakang
        antrean.addLast("199999999#002");
        antrean.addLast("199999990#003");

        //nambah ni dosen wkwk
        antrean.addFirst("105224002#004");

        System.out.println("Antrean : " + antrean);
    }
}
