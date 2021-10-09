package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findFirstByNome(String nome);
}
