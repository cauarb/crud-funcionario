package gitgithub.com.cauarb.crud_funcionario.rest;

import gitgithub.com.cauarb.crud_funcionario.database.FuncionarioRepository;
import gitgithub.com.cauarb.crud_funcionario.entity.funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class RestApi {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<funcionario> criaFuncionario(@RequestBody funcionario novoFuncionario) {
        funcionario funcionarioSalvo = funcionarioRepository.save(novoFuncionario);
        return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<funcionario> listaFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody funcionario funcionarioAtualizado) {
        funcionario funcionarioExistente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com id FDP: " + id));

        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
        funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());

        funcionarioRepository.save(funcionarioExistente);
    }
}
