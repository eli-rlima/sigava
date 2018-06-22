package br.ufrpe.sigava.gui;

import br.ufrpe.sigava.negocio.IServidorSigava;
import br.ufrpe.sigava.pessoa.Professor;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {

    private static void MenuAcesso(){
        System.out.println("BEM-VINDO AO SIGAVA\n");
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println("1 - Administrador");
        System.out.println("2 - Professor");
        System.out.println("3 - Aluno");
        System.out.println("0 - Sair");
    }

    private static void MenuAdm(){
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println("1 - Gerenciar Professores");
        System.out.println("2 - Gerenciar Alunos");
        System.out.println("3 - Gerenciar Disciplinas");
        System.out.println("0 - Voltar");
    }

    private static void MenuGerenciarProfessores(){
        System.out.println("GERENCIAR PROFESSORES");
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Descadastrar");
        System.out.println("3 - Procurar");
        System.out.println("4 - Atualizar");
        System.out.println("0 - Voltar");
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
        int controleAdm, controleAdm1;
        boolean cadProfAdm;

        do {
            MenuAcesso();
            controleMenu = in.nextInt();
            switch (controleMenu){
                case 1:
                    MenuAdm();
                    controleAdm = in.nextInt();
                    switch (controleAdm){
                        case 1:
                            MenuGerenciarProfessores();
                            controleAdm1 = in.nextInt();
                            switch (controleAdm1){
                                case 1:
                                    cadProfAdm = servidorSigava.cadastrarProfessor(cadastroProfessor(in));
                                    if (cadProfAdm){
                                        System.out.println("Cadastrado com sucesso!");
                                    }else System.out.println("Erro no cadastro!");
                                    break;
                                case 2:
                                    descadastrarProfessor(in, servidorSigava);
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 0:
                                    break;
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
            }
        }while (controleMenu != 0);
    }
}
