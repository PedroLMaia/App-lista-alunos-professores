package entidades;

public class Aluno extends Entidade {

    private String matricula;

    public Aluno(String nome, Integer idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", matrícula = " + this.getMatricula() +
                ']';
    }
}
