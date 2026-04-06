import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DocDuLieu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten tep can doc: ");
        String tenTep = sc.nextLine();

        try {
            DataInputStream dis = new DataInputStream(
                new FileInputStream(tenTep)
            );

            System.out.println("Cac so nguyen doc duoc tu tep:");

            while (true) {
                try {
                    int x = dis.readInt();
                    System.out.println(x);
                } catch (EOFException e) {
                    System.out.println("Da doc het du lieu trong tep.");
                    break;
                }
            }

            dis.close();
        } catch (IOException e) {
            System.out.println("Loi khi doc tep: " + e.getMessage());
        }

        sc.close();
    }
}
