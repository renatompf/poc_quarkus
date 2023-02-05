package org.renatofreire.Controllers;


import io.smallrye.common.constraint.NotNull;
import org.renatofreire.Models.Person;
import org.renatofreire.Models.PersonDTO;
import org.renatofreire.Services.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getPersons(){
        return personService.getAll();
    }
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO getPersonByEmail(@PathParam("email") String personEmail){
        return personService.getPersonByEmail(personEmail);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addPerson(@NotNull PersonDTO newPerson){
        return personService.addPerson(newPerson);
    }

    @DELETE
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deletePerson(@PathParam("email") String personEmail){
        return personService.deletePerson(personEmail);
    }

}
