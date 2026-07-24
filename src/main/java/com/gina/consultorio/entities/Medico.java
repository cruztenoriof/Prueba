package com.gina.consultorio.entities;

import com.gina.consultorio.enums.DisponibilidadMedico;
import com.gina.consultorio.enums.EspecialidadMedico;
import com.gina.consultorio.enums.EstadoRegistro;
import com.gina.consultorio.utils.StringCustomUtils;
import com.gina.consultorio.utils.ValoresUnicosUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "MEDICOS")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICO")
    private Long id;

    @Column(name = "NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name = "APELLIDO_PATERNO", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "EDAD", length = 3, nullable = false)
    @Email
    private Integer edad;

    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "TELEFONO", length = 10, nullable = false, unique = true)
    private String telefono;

    @Column(name = "CEDULA_PROFESIONAL", length = 12 , nullable = false, unique = true)
    private String cedulaProfecional;

    @Column(name = "ESPECIALIDAD", length = 30, nullable = false)
    private EspecialidadMedico especialidadMedico;

    @Column(name = "ESTADO_REGISTRO", length = 30, nullable = false)
    private EstadoRegistro estadoRegistro;

    @Column(name = "DISPONIBILIDAD", length = 30, nullable = false)
    private DisponibilidadMedico disponibilidadMedico;

    public void actualizar(String nombre, String apellidoPaterno, String apellidoMaterno,
                           Integer edad, String email, String telefono, String cedulaProfecional,
                           EspecialidadMedico especialidadMedico, EstadoRegistro estadoRegistro, DisponibilidadMedico disponibilidadMedico) {

        validarDatos(nombre, apellidoPaterno, apellidoMaterno, edad, email, telefono, cedulaProfecional);

        this.nombre = nombre.trim();
        this.apellidoPaterno = apellidoPaterno.trim();
        this.apellidoMaterno = apellidoMaterno.trim();
        this.edad = edad;
        this.email = email.trim();
        this.telefono = telefono.trim();
        this.cedulaProfecional = cedulaProfecional.trim();
        this.especialidadMedico = especialidadMedico;
        this.estadoRegistro = estadoRegistro;
        this.disponibilidadMedico = disponibilidadMedico;
    }

    private void validarDatos(String nombre, String apellidoPaterno, String apellidoMaterno,
                              Integer edad, String email, String telefono, String cedulaProfecional) {

        StringCustomUtils.ValidarTamanio(nombre.trim(), 4,50,
                "El nombre es requerido y debe tener entre 4 y 50 caracteres");
        StringCustomUtils.ValidarTamanio(apellidoPaterno.trim(), 4,50,
                "El nombre es requerido y debe tener entre 4 y 50 caracteres");
        StringCustomUtils.ValidarTamanio(apellidoMaterno.trim(), 4,50,
                "El nombre es requerido y debe tener entre 4 y 50 caracteres");
        StringCustomUtils.ValidarTamanio(email.trim(), 8,100,
                "El nombre es requerido y debe tener entre 8 y 100 caracteres");
        StringCustomUtils.ValidarTamanio(telefono.trim(), 10,10,
                "El nombre es requerido y debe tener 10 caracteres");
        StringCustomUtils.ValidarTamanio(cedulaProfecional.trim(), 12,12,
                "La cedula profecional es requerido y debe tener 10 caracteres");

        StringCustomUtils.validarTelefono(telefono);
        StringCustomUtils.validarEmail(telefono);
        ValoresUnicosUtils.validarEdad(edad);
    }
    public String getNombreCompleto() {
        return String.join(" ",
                nombre,
                apellidoPaterno,
                apellidoMaterno);
    }
}
