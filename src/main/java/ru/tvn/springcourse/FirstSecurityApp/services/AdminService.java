package ru.tvn.springcourse.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SOME_ROLE')")
    public void doAdminStaff(){
        System.out.println("Admin here");
    }
}
