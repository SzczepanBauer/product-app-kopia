package pl.bauer.productapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.bauer.productapp.Status;
import pl.bauer.productapp.dao.ProductRepo;
import pl.bauer.productapp.dao.entity.Product;

import java.util.Optional;

@Service
public class ProductManager {

    private ProductRepo productRepo;

    @Autowired
    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<Product> findById(Long id){
        return productRepo.findById(id);
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public Product save(Product product){
        return productRepo.save(product);
    }

    public void deleteById(Long id){
        productRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Product(1L,"Product1",
                "Description1",1,1, Status.IN_STOCK));
        save(new Product(2L,"Product2",
                "Description2",2,2,Status.ORDERED));
        save(new Product(3L,"Product3",
                "Description3",3,3,Status.UNAVAILABLE));
        save(new Product(4L,"Product4",
                "Description4",4,4,Status.IN_STOCK));
    }
}
