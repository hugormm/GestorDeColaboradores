import java.util.ArrayList;

public class Colaborador{
    public String nome, cargo;
    public int idade;
    public double salario;

    public Colaborador(String nome, int idade, String cargo, double salario){
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void getficha(){
        System.out.println(this.nome+ " (" +this.idade+ " anos) - [" +this.cargo+ "] {" +this.salario+ "}");
    }

    public void setNome(String novo_nome){
        this.nome = novo_nome;
    }

    public void setIdade(int nova_idade){
        this.idade = nova_idade;
    }

    public void setCargo(String novo_cargo){
        this.cargo = novo_cargo;
    }

    public void setSalario(double novo_salario){
        this.salario = novo_salario;
    }

    public double getSalario(){
        return this.salario;
    }

}
