package gitgithub.com.cauarb.crud_funcionario.entity;

import jakarta.persistence.*;
import lombok.ToString;


@Entity
@Table(name = "funcionario")
@ToString(of = {"id", "nome", "cargo", "salario"})
public class funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome",length = 30, nullable = false)
    private String nome;

    @Column(name = "cargo",length = 30, nullable = false)
    private String cargo;

    @Column(name = "salario",length = 30, nullable = false)
    private String salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario='" + salario + '\'' +
                '}';
    }

}
