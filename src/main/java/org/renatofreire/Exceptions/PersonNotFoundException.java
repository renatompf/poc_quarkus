package org.renatofreire.Exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String s) {
        super(s);
    }
}
