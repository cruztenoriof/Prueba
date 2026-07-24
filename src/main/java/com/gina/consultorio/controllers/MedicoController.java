package com.gina.consultorio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/maestros")
    public class MedicoController extends CommonController<MaestroRequest, MaestroResponse, MaestroService>{

        public MedicoController(MaestroService service) {
            super(service);
        }
    }
