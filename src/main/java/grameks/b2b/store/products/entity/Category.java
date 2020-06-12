package grameks.b2b.store.products.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter @Setter @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
