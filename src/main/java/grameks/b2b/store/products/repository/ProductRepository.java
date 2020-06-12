package grameks.b2b.store.products.repository;

import grameks.b2b.store.products.entity.Category;
import grameks.b2b.store.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category cat);

}
