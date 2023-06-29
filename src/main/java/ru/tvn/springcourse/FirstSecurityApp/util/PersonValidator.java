package ru.tvn.springcourse.FirstSecurityApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tvn.springcourse.FirstSecurityApp.models.Person;
import ru.tvn.springcourse.FirstSecurityApp.services.PeopleService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
         Person person = (Person) target;
         Optional<Person> personFromDb = peopleService.findByUsername(person.getUsername());
        if (personFromDb.isPresent()){
           errors.rejectValue("username","","Чуловек с таким именем пользователя существует");
        }
    }
}
