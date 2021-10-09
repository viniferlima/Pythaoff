package pythaoff.backend.etl.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Access;

public interface AccessRepository extends JpaRepository<Access, Long> {
    public List<Access> findAllByOrderByDate();

    public Access findByPersonNome(String nome);
}
