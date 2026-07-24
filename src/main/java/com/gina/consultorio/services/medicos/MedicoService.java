package com.gina.consultorio.services.medicos;

import com.gina.consultorio.dto.medico.MedicoRequest;
import com.gina.consultorio.dto.medico.MedicoResponse;
import com.gina.consultorio.repositories.Medico;
import com.gina.consultorio.services.CrudService;

public interface MedicoService extends CrudService<MedicoRequest, MedicoResponse> {
}
