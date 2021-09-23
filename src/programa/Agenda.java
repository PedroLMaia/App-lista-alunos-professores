package programa;

import entidades.Aluno;
import entidades.Entidade;
import entidades.Professor;

import java.util.*;

public class Agenda {

    private final EntidadeIterator list = new EntidadeIterator(new ArrayList<>());

    public void add(Entidade entidade) {
        list.get().add(entidade);
    }

    public Iterator<Entidade> getList() {
        return this.list;
    }

    public static void main(String[] args) {

        Agenda app = new Agenda();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Digita uma das opções:");
            System.out.println("=======================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Remover");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha um opção: ");

            int opcao = sc.nextInt();


            if (opcao == 5) {
                break;
            }

            if (opcao == 1) {
                System.out.println("");
                System.out.println("Escolha uma das entidades:");
                System.out.println("=======================");
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Cadastrar professor");
                System.out.print("Escolha um opção: ");
                opcao = sc.nextInt();

                Entidade entidade = null;

                System.out.print("Nome: ");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("Idade: ");
                Integer idade = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();
                        // Polimorfismo
                        entidade = new Aluno(nome, idade, matricula);
                        break;
                    case 2:
                        System.out.print("Disciplina: ");
                        String disciplina = sc.nextLine();
                        // Polimorfismo
                        entidade = new Professor(nome, idade, disciplina);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

                // Iserindo a entidade
                app.add(entidade);
                continue;
            }

            if (opcao == 2) {
                System.out.println("=======|LISTA|=======");
                Iterator<Entidade> lista = app.getList();

                while (lista.hasNext()) {
                    int idx = ((EntidadeIterator) lista).getIndex();
                    Entidade e = lista.next();
                    System.out.println(idx + " - " + e);
                }
                System.out.println("=======|FIM|=======");

                continue;
            }

            if (opcao == 3) {
                System.out.print("Digite o index da entidade: ");
                int idx = sc.nextInt();

                try {
                    Entidade e = app.list.get(idx);

                    System.out.printf("Nome (%s) ou enter para ignorar... ", e.getNome());
                    sc.nextLine();
                    String nome = sc.nextLine();

                    if (nome.trim().length() != 0) {
                        e.setNome(nome);
                    }

                    System.out.printf("Idade (%d) ou enter para ignorar... ", e.getIdade());
                    String idade = sc.nextLine();

                    if (idade.trim().length() != 0) {
                        e.setIdade(Integer.parseInt(idade));
                    }

                    if (e instanceof Aluno) {
                        System.out.printf("Matricula (%s) ou enter para ignorar... ", ((Aluno) e).getMatricula());
                        String matricula = sc.nextLine();

                        if (matricula.trim().length() != 0) {
                            ((Aluno) e).setMatricula(matricula);
                        }

                    } else {
                        System.out.printf("Disciplina (%s) ou enter para ignorar... ", ((Professor) e).getDisciplina());
                        String disciplina = sc.nextLine();

                        if (disciplina.trim().length() != 0) {
                            ((Professor) e).setDisciplina(disciplina);
                        }
                    }

                } catch (RuntimeException e) {
                    System.out.println("Nenhuma entidade encontrada.");
                }

                continue;
            }

            if (opcao == 4) {
                System.out.print("Digite o index a ser removido: ");
                int idx = sc.nextInt();
                app.list.get().remove(idx);




                continue;
            }

            System.out.println("Opção inválida!");

        }

        sc.close();
    }
}
