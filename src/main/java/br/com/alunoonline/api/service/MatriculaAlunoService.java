package br.com.alunoonline.api.service;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaAlunoService {
    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;
    public void criarMatricula(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }
    public void trancarMatricula(Long MatriculaAlunoId){
        // antes de tracar, verificar se a matricula existe
        MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(MatriculaAlunoId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula online não encontrada"));
        if (matriculaAluno.getStatus().equals(MatriculaAlunoStatusEnum.MATRICULADO)){
            matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
            matriculaAlunoRepository.save(matriculaAluno);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possivel trancar com o status MATRICULADO");
        }
    }
}
