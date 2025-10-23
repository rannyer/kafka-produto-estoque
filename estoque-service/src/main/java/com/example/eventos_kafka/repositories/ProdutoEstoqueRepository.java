package com.example.eventos_kafka.repositories;

import com.example.eventos_kafka.models.ProdutoEstoque;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, Long> {
}
