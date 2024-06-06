package com.escuela.controller;

import com.escuela.client.SoapClient;
import com.escuela.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/escuela")
public class AlumnoController {
    @Autowired
    private SoapClient soapClient;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarAlumno(@RequestBody Alumno alumno){
        PostAgregarAlumnoResponse response = soapClient.agregarAlumno(alumno);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAlumnos(){
        GetMostrarAlumnosResponse response = soapClient.mostrarAlumnos();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarAlumno(@RequestParam String nombre){
        GetBuscarAlumnoResponse response = soapClient.buscarAlumno(nombre);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarAlumno(@RequestParam int id){
        DeleteAlumnoResponse response = soapClient.eliminarAlumno(id);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarAlumno(@RequestBody Alumno alumno){
        UpdateAlumnoResponse response = soapClient.editarAlumno(alumno);

        return ResponseEntity.ok().body(response);
    }
}
