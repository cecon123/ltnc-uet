import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends Product> {
    private String tenKho;
    private List<T> danhSachHang;

    public Warehouse(String tenKho) {
        this.tenKho = tenKho;
        this.danhSachHang = new ArrayList<>();
    }

    public void nhapKho(T hangHoa) {
        danhSachHang.add(hangHoa);
        System.out.println("Da nhap: " + hangHoa.getMaHang() + " - " + hangHoa.getTenHang() + " vao " + tenKho);
    }

    public T xuatKho(String maHang) {
        for (int i = 0; i < danhSachHang.size(); i++) {
            if (danhSachHang.get(i).getMaHang().equals(maHang)) {
                T hang = danhSachHang.remove(i);
                System.out.println("Da xuat: " + hang.getMaHang() + " - " + hang.getTenHang() + " khoi " + tenKho);
                return hang;
            }
        }
        System.out.println("Khong tim thay hang voi ma: " + maHang + " trong " + tenKho);
        return null;
    }

    public void kiemKe() {
        System.out.println("=== Kiem ke " + tenKho + " ===");
        if (danhSachHang.isEmpty()) {
            System.out.println("Kho trong.");
        } else {
            for (T hang : danhSachHang) {
                System.out.println(hang);
            }
        }
        System.out.println("Tong so luong: " + danhSachHang.size());
        System.out.println();
    }

    public int getSoLuong() {
        return danhSachHang.size();
    }

    public String getTenKho() {
        return tenKho;
    }
}
