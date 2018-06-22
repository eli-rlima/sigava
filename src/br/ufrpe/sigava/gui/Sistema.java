package br.ufrpe.sigava.gui;

import br.ufrpe.sigava.negocio.IServidorSigava;
import br.ufrpe.sigava.negocio.beans.pessoa.Aluno;
import br.ufrpe.sigava.negocio.beans.pessoa.Professor;
import br.ufrpe.sigava.negocio.beans.Disciplina;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {

    private static void MenuAcesso(){
        System.out.println("BEM-VINDO AO SIGAVA\n");
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println("1\t - Cadastrar");
        System.out.println("2\t - Descadastrar");
        System.out.println("3\t - Procurar");
        System.out.println("4\t - Atualizar");
        System.out.println("5\t - Cadastrar Aluno");
        System.out.println("6\t - Cadastrar Professor");
        System.out.println("7\t - Cadastrar Disciplina");
        System.out.println("8\t - Cadastrar Tarefa");
        System.out.println("9\t - Descadastrar Aluno");
        System.out.println("10\t - Descadastrar Professor");
        System.out.println("11\t - Descadastrar Disciplina");
        System.out.println("12\t - Descadastrar Tarefa");
        System.out.println("13\t - Procurar Aluno");
        System.out.println("14\t - Procurar Professor");
        System.out.println("15\t - Procurar Disciplina");
        System.out.println("16\t - Procurar Tarefa");
        System.out.println("17\t - Listar Alunos");
        System.out.println("18\t - Listar Professores");
        System.out.println("19\t - Listar Disciplinas");
        System.out.println("20\t - Listar Tarefas");
        System.out.println("21\t - SAIR");

    }


    private static Professor cadastroProfessor(Scanner in){
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
        return professor;
    }

    private static void descadastrarProfessor(Scanner in, IServidorSigava servidorSigava){
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

    public static void Sistema(IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        int controleMenu = in.nextInt();


        do {

        }while (controleMenu != 21);
    }
}
