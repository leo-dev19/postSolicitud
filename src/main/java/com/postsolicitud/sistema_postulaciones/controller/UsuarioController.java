package com.postsolicitud.sistema_postulaciones.controller;


import com.postsolicitud.sistema_postulaciones.dto.UsuarioRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.UsuarioResponseDTO;
import com.postsolicitud.sistema_postulaciones.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @PostMapping("/registrar")
    public UsuarioResponseDTO guardar(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.guardar(usuarioRequestDTO);
    }

    @GetMapping("/perfil")
    public UsuarioResponseDTO miPerfil(Authentication authentication) {
        return usuarioService.obtenerPorUsername(authentication.getName());
    }

    @PutMapping("/perfil")
    public UsuarioResponseDTO editarMiPerfil(@RequestBody UsuarioRequestDTO usuarioRequestDTO,
                                             Authentication authentication) {
        return usuarioService.editarPorUsername(authentication.getName(), usuarioRequestDTO);
    }

    @DeleteMapping("/perfil")
    public void eliminarMiCuenta(Authentication authentication) {
        usuarioService.eliminarPorUsername(authentication.getName());
    }
}
