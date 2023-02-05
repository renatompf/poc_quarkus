package org.renatofreire.Services;

import org.renatofreire.Exceptions.EmailAlreadyOccupied;
import org.renatofreire.Exceptions.EmptyFields;
import org.renatofreire.Exceptions.PersonNotFoundException;
import org.renatofreire.Models.Person;
import org.renatofreire.Models.PersonDTO;
import org.renatofreire.Repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<PersonDTO> getAll(){
        return personRepository.listAll()
                .stream()
                .map(person -> new PersonDTO(
                        person.getName(),
                        person.getDateOfBirth(),
                        person.getEmail()
                )).collect(Collectors.toList());
    }

    public PersonDTO getPersonByEmail(String email){
        return personRepository.findPersonByEmail(email)
                .map(person -> new PersonDTO(
                        person.getName(),
                        person.getDateOfBirth(),
                        person.getEmail())
                ).orElseThrow( () -> new PersonNotFoundException("Person with " + email + " not found"));
    }

    public boolean addPerson(PersonDTO newPerson){
        if(newPerson.email().isEmpty() || newPerson.name().isEmpty() || newPerson.dateOfBirth().toString().isEmpty())
            throw new EmptyFields("You must fill all the fields");
        else if(personRepository.findPersonByEmail(newPerson.email()).isPresent())
            throw new EmailAlreadyOccupied("Email " + newPerson.email() + " it's already taken");
        else{
            Person p = new Person(newPerson.name(), newPerson.dateOfBirth(), newPerson.email());
            personRepository.persist(p);
            return true;
        }
    }

    public boolean deletePerson(String email){
        Optional<Person> personByEmail = personRepository.findPersonByEmail(email);
        if(personByEmail.isPresent()) {
            personRepository.delete(personByEmail.get());
            return true;
        }else
            return false;
    }

}
