package org.renatofreire.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.renatofreire.Models.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public Optional<Person> findPersonByEmail(String email){
        return find("email", email).firstResultOptional();
    }
}
