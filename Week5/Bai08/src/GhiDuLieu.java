import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class GhiDuLieu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten tep de ghi: ");
        String tenTep = sc.nextLine();

        System.out.print("Nhap so luong so nguyen n: ");
        int n = sc.nextInt();

        try {
            DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(tenTep)
            );

            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so nguyen thu " + (i + 1) + ": ");
                int x = sc.nextInt();
                dos.writeInt(x);
            }

            dos.close();
            System.out.println("Ghi du lieu vao tep thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi tep: " + e.getMessage());
        }

        sc.close();
    }
}
