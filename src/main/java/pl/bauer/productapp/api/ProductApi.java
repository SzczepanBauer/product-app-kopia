package pl.bauer.productapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bauer.productapp.dao.entity.Product;
import pl.bauer.productapp.manager.ProductManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    private ProductManager products;

    @Autowired
    public ProductApi(ProductManager products) {
        this.products = products;
    }

    @GetMapping("/all")
    public Iterable<Product> getAll(){
        return products.findAll();
    }

    @GetMapping
    public Optional<Product> getById(@RequestParam Long index ){
        return products.findById(index);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product ){
        return products.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product ){
        return products.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam Long index ){
        products.deleteById(index);
    }








}








