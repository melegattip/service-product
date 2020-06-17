package grameks.b2b.store.products;

import grameks.b2b.store.products.entity.Category;
import grameks.b2b.store.products.entity.Product;
import grameks.b2b.store.products.repository.ProductRepository;
import grameks.b2b.store.products.service.ProductService;
import grameks.b2b.store.products.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product prod1 = Product.builder()
                .id(1L)
                .name("prod1")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.50"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
            .thenReturn(Optional.of(prod1));

    }
    @Test
    public void whenValidGetID_ThenReturnProduct() {
        Product found = productService.getProduct(1L);
        Assertions.assertEquals(found.getName(),"prod1");

    }
}
