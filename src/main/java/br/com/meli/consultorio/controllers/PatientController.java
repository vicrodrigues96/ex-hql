package br.com.meli.consultorio.controllers;

import br.com.meli.consultorio.entities.Patient;
import br.com.meli.consultorio.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultorio/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> listAllPatientsByDay(@RequestParam String date) {
        return this.patientService.listAllPatientsByDay(date);
    };

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return this.patientService.create(patient);
    }
}
