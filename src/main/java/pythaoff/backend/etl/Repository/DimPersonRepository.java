package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimPerson;

public interface DimPersonRepository extends JpaRepository<DimPerson, Long> {
    public DimPerson findFirstByName(String nome);

    public DimPerson findByName(String name);
}
