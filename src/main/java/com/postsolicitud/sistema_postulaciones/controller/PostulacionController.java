package com.postsolicitud.sistema_postulaciones.controller;


import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;
import com.postsolicitud.sistema_postulaciones.service.IPostulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulaciones")
@RequiredArgsConstructor
public class PostulacionController {

    private final IPostulacionService postulacionService;

    @GetMapping
    public List<PostulacionResponseDTO> listar(Authentication authentication) {
        return postulacionService.listarPorUsername(authentication.getName());
    }

    @GetMapping("/{id}")
    public PostulacionResponseDTO obtenerPorId(@PathVariable Integer id, Authentication authentication) {
        return postulacionService.obtenerPorId(id, authentication.getName());
    }

    @PostMapping
    public PostulacionResponseDTO guardar(@RequestBody PostulacionRequestDTO requestDTO,
                                          Authentication authentication) {
        return postulacionService.guardar(requestDTO, authentication.getName());
    }

    @PutMapping("/{id}")
    public PostulacionResponseDTO editar(@PathVariable Integer id,
                                         @RequestBody PostulacionRequestDTO requestDTO,
                                         Authentication authentication) {
        return postulacionService.editar(id, requestDTO, authentication.getName());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id, Authentication authentication) {
        postulacionService.eliminar(id, authentication.getName());
    }
}