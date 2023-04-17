package org.xsoto.springcloud.msvc.usuarios.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xsoto.springcloud.msvc.usuarios.clients.CursoClienteRest;
import org.xsoto.springcloud.msvc.usuarios.models.entity.Usuario;
import org.xsoto.springcloud.msvc.usuarios.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final CursoClienteRest cursoClienteRest;

    private final UsuarioRepository  usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CursoClienteRest cursoClienteRest) {
        this.usuarioRepository = usuarioRepository;
        this.cursoClienteRest = cursoClienteRest;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
        cursoClienteRest.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) usuarioRepository.findAllById(ids);
    }

    @Override
    public Optional<Usuario> porEmail(String email) {
//        return usuarioRepository.findByEmail(email);
        return usuarioRepository.porEmail(email);
    }

    @Override
    public boolean existePorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
