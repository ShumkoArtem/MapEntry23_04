public class Product {

    private String type;
    private int count;

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public Product(String type, int count) {
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
