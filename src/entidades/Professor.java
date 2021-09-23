package entidades;

public class Professor extends Entidade {

    private String disciplina;

    public Professor(String nome, Integer idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", disciplina = " + this.getDisciplina() +
                ']';
    }
}
