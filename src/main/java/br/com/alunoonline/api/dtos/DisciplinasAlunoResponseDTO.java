package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import lombok.Data;

@Data
public class DisciplinasAlunoResponseDTO {
    private String NomeDisciplina;
    private String NomeProfessor;
    private Double nota1;
    private Double nota2;
    private Double media;
    private MatriculaAlunoStatusEnum status;


}
