import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();   //NOTE: lỗi: chưa khởi tạo map
        productMap.put(1, new Product(1, "Quạt Trần Hư", 230000, "Quạt treo trên trần", "Fuca"));
        productMap.put(2, new Product(2, "Quạt Trần Cũ", 230000, "Đồ second-hand", "Senko"));
        productMap.put(3, new Product(3, "Tivi", 230000, "Màn hình cong", "Sam Sung"));
        productMap.put(4, new Product(4, "Tủ lạnh", 230000, "280L", "Panasonic"));
        productMap.put(5, new Product(5, "Loa", 230000, "để bàn", "Fuca"));

    }

    public static void create(Product product) {
        Integer id = idAutoIncrement(productMap.size());
        product.setId(id);
        productMap.put(id, product);
        System.out.println("thanh cong");
    }
    public static Integer idAutoIncrement(int mapSize) {
        if (productMap.isEmpty()) {
            return 1;
        } else {
            return productMap.get(productMap.size()).getId() + 1;
        }
    }
    public static List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public static void main(String[] args) {
//        create(new Product(0,"Ô tô", 230000, "Ô tô địa hình ","honda" ));
//        System.out.println(findAll());
        System.out.println(findByName("Q"));
    }

    //search
    public static List<Product> findByName(String nameChar) {
        List<Product> searchByNameList = new ArrayList<>();
        for (Product value : productMap.values()) {
            if (value.getName().contains(nameChar)) {
                searchByNameList.add(value);
            }
        }
        return searchByNameList;
    }

}
