package org.xsoto.springcloud.msvc.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xsoto.springcloud.msvc.cursos.models.Usuario;

import java.util.List;

@FeignClient(name = "msvc-usuarios", url = "localhost:8001/usuarios")
public interface UsuarioClientRest {
    @GetMapping("/{id}")
    public Usuario detalle(@PathVariable Long id);
//    @PostMapping("/")
    @PostMapping
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
