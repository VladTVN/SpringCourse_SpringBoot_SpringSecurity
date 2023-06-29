package ru.tvn.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tvn.springcourse.FirstSecurityApp.models.Person;
import ru.tvn.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
@Transactional(readOnly = true)
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }


}
