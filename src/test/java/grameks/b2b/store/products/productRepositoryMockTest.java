package grameks.b2b.store.products;

import grameks.b2b.store.products.entity.Category;
import grameks.b2b.store.products.entity.Product;
import grameks.b2b.store.products.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class productRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product01 = Product.builder()
            .name("computer")
            .category(Category.builder().id(1L).build())
            .description("")
            .stock(Double.parseDouble( "10"))
            .price(Double.parseDouble("1000.50"))
            .status("Created")
            .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertEquals(founds.size(),3);
    }
}
