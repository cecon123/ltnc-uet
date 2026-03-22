public abstract class Product {
    protected String maHang;
    protected String tenHang;

    public Product(String maHang, String tenHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public abstract String getDetailInfo();
}
