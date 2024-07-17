package com.aluracursos.Foro_hub.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepositorio extends JpaRepository <cadaUser, Long> {

    UserDetails findByLogin(String Login);
}
