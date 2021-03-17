package ro.bogdan.shopspring;

import ro.bogdan.shopspring.models.Product;
import ro.bogdan.shopspring.services.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/shop")
public class ShopController {
    private ShopService shopService = new ShopService();
    public List<Product> productList = new ArrayList<>(Arrays.asList(
            new Product("5B3raA", 5, "Cui", "AREWQWEqeq", 10),
            new Product("1234AB", 24, "Cuw", "asdfQWET", 25)
    ));

    @GetMapping("/products")
    public List<Product> getProductList() {
        return shopService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name = "id") String productCode) {
        return shopService.getProduct(productCode);
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestBody Product product) {
        return shopService.addProduct(product);
    }

    @DeleteMapping("/products/remove/{id}")
    public String deleteProduct(@PathVariable(name = "id") String productCode) {
        return shopService.removeProduct(productCode);
    }
}

