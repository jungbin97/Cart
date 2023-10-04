import java.lang.reflect.Member;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        HashSet<Product> set = new HashSet<>();

        // 상품 목록 구성
        Product milk = new Product("우유", 1000);
        Product tissue = new Product("휴지", 3000);

        set.add(milk);
        set.add(tissue);

        // name, price 같음 => key 같아야함 => 상품목록에 추가되면 안됨.
        set.add(new Product("우유", 1000));


        Cart cart = new Cart(set);
        cart.addProduct(milk, 2);
        cart.addProduct(tissue, 3);
        cart.showItems();

        cart.removeProduct(milk, 2);
        cart.showItems();


        Product cigarette = new Product("담배", 4500);
        // 상품목록에 없는 상품 추가 시 예외처리
        cart.addProduct(cigarette, 2);

        cart.showItems();

        // 장바구니에 없는 상품 삭제 시 예외처리
        cart.removeProduct(cigarette, 2);
    }
}