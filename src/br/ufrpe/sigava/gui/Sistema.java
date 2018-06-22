package br.ufrpe.sigava.gui;

import br.ufrpe.sigava.negocio.IServidorSigava;
import br.ufrpe.sigava.negocio.beans.pessoa.Aluno;
import br.ufrpe.sigava.negocio.beans.pessoa.Professor;
import br.ufrpe.sigava.negocio.beans.Disciplina;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {

    private static void MenuAcesso(){
        System.out.println("BEM-VINDO AO SIGAVA\n");
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println("1\t - Cadastrar Aluno");
        System.out.println("2\t - Cadastrar Professor");
        System.out.println("3\t - Cadastrar Disciplina");
        System.out.println("4\t - Cadastrar Tarefa");
        System.out.println("5\t - Descadastrar Aluno");
        System.out.println("6\t - Descadastrar Professor");
        System.out.println("7\t - Descadastrar Disciplina");
        System.out.println("8\t - Descadastrar Tarefa");
        System.out.println("9\t - Procurar Aluno");  //TODO
        System.out.println("10\t - Procurar Professor"); //TODO
        System.out.println("11\t - Procurar Disciplina"); //TODO
        System.out.println("12\t - Procurar Tarefa"); //TODO
        System.out.println("13\t - Listar Alunos"); //TODO
        System.out.println("14\t - Listar Professores"); //TODO
        System.out.println("15\t - Listar Disciplinas"); //TODO
        System.out.println("16\t - Listar Tarefas"); //TODO
        System.out.println("17\t - SAIR");
    }

    private static void cadastroProfessor(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        Professor professor;
        String nome, email, senha, cpf, data;
        String dataR[];
        char sexo;
        LocalDate dataNascimento;

        System.out.println("Nome: ");
        nome = in.nextLine();
        in.nextLine();

        System.out.println("Sexo (m ou f): ");
        sexo = in.next().charAt(0);

        System.out.println("Data de Nascimento (dd/MM/aaaa): ");
        data = in.nextLine();
        dataR = data.split("/");
        dataNascimento = LocalDate.parse(dataR[0] + "-" + dataR[1] + "-" + dataR[2]);

        System.out.println("CPF: ");
        cpf = in.nextLine();
        in.nextLine();

        System.out.println("E-mail: ");
        email = in.nextLine();
        in.nextLine();

        System.out.println("Senha: ");
        senha = in.nextLine();
        in.nextLine();

        professor = new Professor(nome, email, sexo, dataNascimento, senha, cpf);
        servidorSigava.cadastrarProfessor(professor);
    }

    private static void descadastrarProfessor(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        Professor professor;
        String cpf;
        boolean ver;
        System.out.println("CPF do professor: ");
        cpf = in.nextLine();
        professor = servidorSigava.buscarProfessor(cpf);

        if (professor == null){
            System.out.println("Professor não cadastrado!");
        }
        else {
            ver = servidorSigava.descadastrarProfessor(professor);
            if (ver){
                System.out.println("Descadastrado com sucesso!");
            }else System.out.println("Não foi possível descadastrar!");
        }
    }

    private static void cadastrarDisciplina(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        Disciplina disciplina = null;
        String nome, data;
        String dataR[];
        LocalDate dataInicio;
        DayOfWeek diaAula;
        int duracaoAula, cargaHoraria;

        System.out.println("Nome: ");
        nome = in.nextLine();
        in.nextLine();

        System.out.println("Data de Início (dd/MM/aaaa): ");
        data = in.nextLine();
        dataR = data.split("/");
        dataInicio = LocalDate.parse(dataR[0] + "-" + dataR[1] + "-" + dataR[2]);
        diaAula = dataInicio.getDayOfWeek();

        System.out.println("Duração da aula: ");
        duracaoAula = in.nextInt();

        System.out.println("Carga Horária da disciplina: ");
        cargaHoraria = in.nextInt();

        disciplina = new Disciplina(nome, dataInicio, diaAula, duracaoAula, cargaHoraria);
        servidorSigava.cadastrarDisciplina(disciplina);
    }

    public static void descadastrarDisciplina(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        Disciplina disciplina;
        String nome;
        boolean ver;

        System.out.println("Nome da disciplina: ");
        nome = in.nextLine();
        disciplina = servidorSigava.buscarDisciplina(nome);

        if (disciplina == null){
            System.out.println("Disciplina não cadastrada!");
        }
        else {
            ver = servidorSigava.descadastrarDisciplina(disciplina);
            if (ver){
                System.out.println("Descadastrada com sucesso!");
            }else System.out.println("Não foi possível descadastrar!");
        }
    }

    public static void Sistema(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        int controleMenu = in.nextInt();


        do {

        }while (controleMenu != 17);
    }
}
