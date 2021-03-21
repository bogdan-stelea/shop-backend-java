package ro.bogdan.shopspring;

import ro.bogdan.shopspring.models.Client;
import ro.bogdan.shopspring.models.PaymentMethod;
import ro.bogdan.shopspring.models.Product;
import ro.bogdan.shopspring.models.TransactionRequest;
import ro.bogdan.shopspring.services.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService = new ShopService();

    @GetMapping("/products")
    public List<Product> getProductsList() {
        return shopService.getProductsList();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable(name = "id") String productCode) {
        return shopService.getProduct(productCode);
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestBody Product product) {
        return shopService.addProduct(product);
    }

    @PostMapping("/transactions/add")
    public String addTransaction(@RequestBody TransactionRequest transactionRequest) { return shopService.addTransaction(transactionRequest);}

    @DeleteMapping("/products/remove/{id}")
    public String deleteProduct(@PathVariable(name = "id") String productCode) {
        return shopService.removeProduct(productCode);
    }
}
