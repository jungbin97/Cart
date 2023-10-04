import java.lang.reflect.Member;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 상품 목록 생성
        HashSet<Product> set = new HashSet<>();

        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
        Product milk = new Product("우유", 1000);
        Product tissue = new Product("휴지", 3000);

        set.add(milk);
        set.add(tissue);

        // 상품 목록 확인
        String str = "고유한 상품목록";
        System.out.println("-".repeat(20) + str + "-".repeat(20));
        for(Product product : set){
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println("-".repeat(51));

        // Unit Test
        // name, price 같음 => key 같아야함 => 상품목록에 추가되면 안됨.
        set.add(new Product("우유", 1000));

        // 장바구니 생성
        Cart cart = new Cart(set);

        // TODO: 상품을 장바구니에 추가
        cart.addProduct(milk, 2);
        cart.addProduct(tissue, 3);
        cart.showItems();

        // TODO: 상품을 장바구니에서 제거
        cart.removeProduct(milk, 2);
        cart.showItems();


        Product cigarette = new Product("담배", 4500);
        // 상품목록에 없는 상품 추가 시 예외처리
        cart.addProduct(cigarette, 2);

        // 장바구니에 없는 상품 삭제 시 예외처리
        cart.removeProduct(cigarette, 2);
    }
}