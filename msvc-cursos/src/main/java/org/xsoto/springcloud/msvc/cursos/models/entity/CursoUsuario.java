package org.xsoto.springcloud.msvc.cursos.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", unique = true)
    private Long usuarioId;

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof CursoUsuario)){
            return false;
        }
        CursoUsuario cursoUsuario = (CursoUsuario) obj;
        return cursoUsuario.usuarioId != null && this.usuarioId.equals(cursoUsuario.usuarioId);
        }
}
