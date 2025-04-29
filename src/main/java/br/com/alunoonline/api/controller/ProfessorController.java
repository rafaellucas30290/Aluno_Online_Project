package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CriarProfessor(@RequestBody Professor professor) {
        professorService.criarProfessor(professor);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarProfessores(){
        return professorService.listarProfessores();

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarProfessorPorId(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessor(@PathVariable Long id,
                                   @RequestBody Professor professor) {
        professorService.atualizarProfessorPorId(id, professor);
    }
}
