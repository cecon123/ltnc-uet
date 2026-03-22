public class ElectronicsProduct extends Product {
    private String thoiGianBaoHanh;

    public ElectronicsProduct(String maHang, String tenHang, String thoiGianBaoHanh) {
        super(maHang, tenHang);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    @Override
    public String getDetailInfo() {
        return "Thoi gian bao hanh: " + thoiGianBaoHanh;
    }

    @Override
    public String toString() {
        return tenHang + " - " + thoiGianBaoHanh;
    }
}
