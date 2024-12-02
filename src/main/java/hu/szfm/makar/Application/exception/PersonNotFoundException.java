package hu.szfm.makar.Application.exception;
/* Created by Arjun Gautam */

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(Integer id){
        super("Could not found the person with id "+ id);
    }
}
