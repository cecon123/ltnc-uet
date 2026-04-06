import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        String fileName = "students.dat";

        // 1. Import the list of students
        System.out.println("Nhap danh sach sinh vien (nhap ID = END de dung):");
        while (true) {
            System.out.print("Nhap id: ");
            String id = sc.nextLine();

            if (id.equalsIgnoreCase("END")) {
                break;
            }

            System.out.print("Nhap ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap gpa: ");
            double gpa = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, gpa));
        }

        // 2. Write the list to a file
        try (
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName)
            )
        ) {
            for (Student s : list) {
                oos.writeObject(s);
            }
            System.out.println("Da ghi danh sach sinh vien vao tep.");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi IO khi ghi tep: " + e.getMessage());
        }

        // 3. Read back from the file and print the list
        System.out.println("\nDanh sach sinh vien doc tu tep:");
        try (
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName)
            )
        ) {
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }
        } catch (EOFException e) {
            System.out.println("Da doc het file.");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay lop Student: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi IO khi doc tep: " + e.getMessage());
        }

        sc.close();
    }
}
