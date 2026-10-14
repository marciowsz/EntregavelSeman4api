package com.escola.api.repository;

import com.escola.api.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Herda save, findById, findAll, existsById, deleteById...
}
