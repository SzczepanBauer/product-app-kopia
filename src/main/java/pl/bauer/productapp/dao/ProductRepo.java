package pl.bauer.productapp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bauer.productapp.dao.entity.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
