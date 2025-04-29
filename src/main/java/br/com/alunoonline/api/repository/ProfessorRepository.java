package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alunoonline.api.model.Professor;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
