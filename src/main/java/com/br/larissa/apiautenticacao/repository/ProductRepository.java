package com.br.larissa.apiautenticacao.repository;

import com.br.larissa.apiautenticacao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
