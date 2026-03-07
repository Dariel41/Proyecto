/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.service.impl;

import com.cafeteria.domain.Usuario;
import com.cafeteria.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        // 🔴 ESTA ES LA LÍNEA IMPORTANTE
        roles.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.isActivo(),
                true,
                true,
                true,
                roles
        );
    }
}
