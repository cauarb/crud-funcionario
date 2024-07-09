package gitgithub.com.cauarb.crud_funcionario.database;

import gitgithub.com.cauarb.crud_funcionario.entity.funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository <funcionario, Long> {


}
