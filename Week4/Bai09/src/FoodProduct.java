public class FoodProduct extends Product {
    private String hanSuDung;

    public FoodProduct(String maHang, String tenHang, String hanSuDung) {
        super(maHang, tenHang);
        this.hanSuDung = hanSuDung;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    @Override
    public String getDetailInfo() {
        return "Han su dung: " + hanSuDung;
    }

    @Override
    public String toString() {
        return tenHang + " - " + hanSuDung;
    }
}
