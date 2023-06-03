package HackerRankPraktikum.Searching;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Input Format :
//Baris pertama berisi angka n sebagai banyaknya rumah.
// Baris selanjutnya berisi angka r sebagai angka rumah yang akan ditempati.
// Baris terakhir berisi n angka b yang menunjukkan nomor rumah pada Griya Katak Permai.

//Output Format:
//Baris pertama berisi m angka yang menunjukkan batu mana saja yang telah ditelusuri.
// Baris kedua berisi string "ditemukan" atau "tidak ditemukan" sesuai hasil pencarian.
public class GriyaKatakPermai {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Membaca input banyaknya rumah
        int banyakRumah = userInput.nextInt();

        // Membaca nomor rumah yang akan ditempati
        int rumahDiCari = userInput.nextInt();

        // Membaca nomor rumah pada Griya Katak Permai
        int[] nomorSemuaRumah = new int[banyakRumah];
        for (int i = 0; i < banyakRumah; i++) {
            nomorSemuaRumah[i] = userInput.nextInt();
        }

        // Panggil fungsi binarySearch untuk mencari rumah
        List<Integer> rumahSudahDikunjungi = binarySearch(nomorSemuaRumah, rumahDiCari);

        // Menampilkan hasil pencarian
        for (int i = 0; i < rumahSudahDikunjungi.size(); i++) {
            System.out.print(rumahSudahDikunjungi.get(i) + " ");
        }

        System.out.println();

        int lastIndex = rumahSudahDikunjungi.size() - 1;
        if (rumahSudahDikunjungi.get(lastIndex) == rumahDiCari) {
            System.out.println("ditemukan");
        } else {
            System.out.println("tidak ditemukan");
        }

    }
    // Implementasi algoritma binary search
    public static List<Integer> binarySearch(int[] nomorSemuaRumah, int rumahDiCari) {
        List<Integer> rumahSudahDikunjungi = new ArrayList<>();
        int akhir = nomorSemuaRumah.length;
        int mulai = 0;
        while (mulai <= akhir) {
            int tengah = (mulai + akhir) / 2;
            rumahSudahDikunjungi.add(nomorSemuaRumah[tengah]);
            if (nomorSemuaRumah[tengah] == rumahDiCari) {
                return rumahSudahDikunjungi;
            }
            else if (nomorSemuaRumah[tengah] < rumahDiCari) {
                mulai = tengah + 1;
            }
            else {
                akhir = tengah - 1;
            }
        }
        return rumahSudahDikunjungi;
    }

}