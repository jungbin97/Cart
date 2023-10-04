import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cart {
    // Product와 수량 저장할 hashMap (상품목록에 있는 상품만 장바구니에 담을 수 있도록 해야함.)
    private Map<Product, Integer> items;

    // 상품목록을 담을 hashSet
    private HashSet<Product> products;

    // 생성자(해쉬맵 생성, 상품목록 주입)
    public Cart(HashSet<Product> products) {
        this.items = new HashMap<>();
        this.products = products;
    }

    // 장바구니 상품 조회 메서드
    public void showItems(){
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            Product product = entry.getKey();
            int value = entry.getValue();
            System.out.println(product.getName()+ "("+ product.getPrice() + ")" + "-" + value + "개");
        }
    }

    // 장바구니 상품 추가 메서드
    public void addProduct(Product product, int value){
        if (!products.contains(product)){
            System.out.println("해당 상품은 존재하지 않습니다.");
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + value);
    }

    // 장바구니 상품 제거 메서드
    public void removeProduct(Product product, int value){
        if(!items.containsKey(product)){
            System.out.println("장바구니에 해당 상품이 없습니다.");
            return;
        }
        // 현재 제거하려는 상품의 장바구니 개수
        int currentValue = items.get(product);
        // 뺴려는 수량 보다 작으면 장바구니 목록(해쉬 맵)에서 제거
        if(currentValue <= value){
            items.remove(product);
        }else{
            items.put(product, currentValue - value);
        }
    }
}
