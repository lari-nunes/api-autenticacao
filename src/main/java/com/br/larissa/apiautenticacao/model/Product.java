package com.br.larissa.apiautenticacao.model;

import com.br.larissa.apiautenticacao.dto.ProductRequesDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price;

    public Product(ProductRequesDTO data){
        this.price = data.price();
        this.name = data.name();
    }
}
