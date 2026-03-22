
public class Main {

    public static void main(String[] args) {
        // Tao khu vuc quan ly Sach
        LibrarySection<Book> bookSection = new LibrarySection<>("Khu vuc Sach");

        // Tao khu vuc quan ly DVD
        LibrarySection<DVD> dvdSection = new LibrarySection<>("Khu vuc DVD");

        System.out.println("===== THEM TAI LIEU =====");

        // Them sach vao khu vuc sach
        bookSection.addItem(new Book("B001", "Lap trinh Huong doi tuong", "Nguyen Van A", 350));
        bookSection.addItem(new Book("B002", "Cau truc du lieu va Giai thuat", "Tran Thi B", 420));
        bookSection.addItem(new Book("B003", "Co so du lieu", "Le Van C", 280));

        // Them DVD vao khu vuc DVD
        dvdSection.addItem(new DVD("D001", "Khoa hoc vien tuong", "Steven Spielberg", 148));
        dvdSection.addItem(new DVD("D002", "Hanh dong", "Christopher Nolan", 152));
        dvdSection.addItem(new DVD("D003", "Phieu luu", "James Cameron", 194));

        System.out.println();
        System.out.println("===== HIEN THI TAT CA TAI LIEU =====");

        // Hien thi danh sach tai lieu
        bookSection.displayItems();
        dvdSection.displayItems();

        System.out.println();
        System.out.println("===== XOA TAI LIEU =====");

        // Xoa tai lieu
        bookSection.removeItem("B002");
        dvdSection.removeItem("D001");

        System.out.println();
        System.out.println("===== SAU KHI XOA =====");

        // Hien thi lai danh sach
        bookSection.displayItems();
        dvdSection.displayItems();

        System.out.println();
        System.out.println("===== THONG KE =====");
        System.out.println("So sach: " + bookSection.getItemCount());
        System.out.println("So DVD: " + dvdSection.getItemCount());

        // Thu xoa tai lieu khong ton tai
        System.out.println();
        System.out.println("===== THU XOA MA KHONG TON TAI =====");
        bookSection.removeItem("B999");
    }
}
