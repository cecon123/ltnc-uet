public class Main {
    public static void main(String[] args) {
        Warehouse<FoodProduct> khoThucPham = new Warehouse<>("Kho Thuc Pham");
        Warehouse<ElectronicsProduct> khoDienTu = new Warehouse<>("Kho Dien Tu");

        FoodProduct sua = new FoodProduct("TP01", "Sua tuoi", "31/12/2026");
        FoodProduct banh = new FoodProduct("TP02", "Banh quy", "15/06/2026");
        FoodProduct ga = new FoodProduct("TP03", "Ga dong lanh", "01/03/2027");

        khoThucPham.nhapKho(sua);
        khoThucPham.nhapKho(banh);
        khoThucPham.nhapKho(ga);
        System.out.println();

        ElectronicsProduct tivi = new ElectronicsProduct("DT01", "Tivi Samsung", "24 thang");
        ElectronicsProduct laptop = new ElectronicsProduct("DT02", "Laptop Dell", "12 thang");
        ElectronicsProduct dt = new ElectronicsProduct("DT03", "Dien thoai iPhone", "12 thang");

        khoDienTu.nhapKho(tivi);
        khoDienTu.nhapKho(laptop);
        khoDienTu.nhapKho(dt);
        System.out.println();

        khoThucPham.kiemKe();
        khoDienTu.kiemKe();

        System.out.println("--- Xuat kho ---");
        khoThucPham.xuatKho("TP02");
        khoDienTu.xuatKho("DT01");
        System.out.println();

        khoThucPham.kiemKe();
        khoDienTu.kiemKe();

        System.out.println("=== Chung minh Bounded Type (Compile-time check) ===");
        System.out.println("Kho<FoodProduct> chi nhan FoodProduct, khong nhan ElectronicsProduct.");
        System.out.println("Vi du: khoThucPham.nhapKho(tivi) se bi loi compile.");
        System.out.println("Tuong tu, khoDienTu khong the nhan sua, banh.");
    }
}
