import java.util.HashSet;
import java.util.Objects;

public class Product{
    /*************************************************
     * 필드 : key, 이름, 가격
     * 메서드 : hashCode(), equals() 오버라이딩(HashSet에서 중복 상품 판별하기 위함)
     * 중복된 상품의 기준?? key 값이 같을 때 => key는? => 이름과 가격이 동일할 때
     *************************************************/

    private int key;
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 생성자
    public Product(String name, int price) {
        this.key = name.hashCode() + price;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return key == product.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
