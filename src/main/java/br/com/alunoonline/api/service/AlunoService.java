package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
    public void atualizarAlunoPorId(Long id, Aluno aluno){
        //Primeiro passo: ver se o aluno existe no BD
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);
        //E se não existir esse aluno:
        if(alunoDoBancoDeDados.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "aluno não encontrado no banco de dados");
        }
        //Sair do if significa que existe um aluno com esse ID
        //Para armazena-lo em uma variavel e depois edita-lo
        Aluno alunoParaEditar = alunoDoBancoDeDados.get();

        //Com esse aluno a ser editado
        //Os sets necessários para atualizar os atributos dele deve ser feito
        alunoParaEditar.setNome(aluno.getNome());
        alunoParaEditar.setEmail(aluno.getEmail());
        alunoParaEditar.setCpf(aluno.getCpf());

        alunoRepository.save(alunoParaEditar);
    }
}