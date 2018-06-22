package br.ufrpe.sigava.gui;

import br.ufrpe.sigava.negocio.IServidorSigava;
import br.ufrpe.sigava.negocio.beans.Cronograma;
import br.ufrpe.sigava.negocio.beans.Marcacao;
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
        System.out.println("9\t - Procurar Aluno");
        System.out.println("10\t - Procurar Professor");
        System.out.println("11\t - Procurar Disciplina");
        System.out.println("12\t - Procurar Tarefa");
        System.out.println("13\t - Listar Alunos");
        System.out.println("14\t - Listar Professores");
        System.out.println("15\t - Listar Disciplinas");
        System.out.println("16\t - Listar Tarefas");
        System.out.println("17\t - Cronograma");
        System.out.println("18\t - SAIR");
    }

    private static void CriarCronograma(Aluno aluno, IServidorSigava servidorSigava){
        Scanner in = new Scanner(System.in);
        String nomeCrono, nomeDisc, data;
        String dataR[];
        LocalDate dataTermino;
        int numDis, codigoTarefa;
        Cronograma cronograma;
        boolean ver;

        if (aluno.getDisciplinas() == null){
            System.out.println("O aluno não tem disciplinas cadastradas!");
        }
        else{
            for (int i = 0; i < aluno.getDisciplinas().size(); i++){
                System.out.println((i+1)+ "\t - " + aluno.getDisciplinas().get(i).getNome());
            }

            System.out.println("Digite o número da disciplina: ");
            numDis = in.nextInt();

            Disciplina disciplina =aluno.getDisciplinas().get(numDis);
            nomeDisc = disciplina.getNome();

            System.out.println(disciplina.ListarTarefas());

            System.out.println("Digite o código da tarefa: ");
            codigoTarefa = in.nextInt();

            System.out.println("Data de Término (dd/MM/aaaa): ");
            data = in.nextLine();
            dataR = data.split("/");
            dataTermino = LocalDate.parse(dataR[2] + "-" + dataR[1] + "-" + dataR[0]);

            System.out.println("Digite o nome do cronograma: ");
            nomeCrono = in.nextLine();
            in.nextLine();
            cronograma = new Cronograma(nomeCrono);

            ver = servidorSigava.adicionarMarcacao(nomeDisc, nomeCrono, aluno, codigoTarefa, dataTermino);

            if (ver){
                System.out.println("Tarefa adicionada ao cronograma " + nomeCrono);
            }
            else{
                System.out.println("Data de término selecionada maior que o limite!");
            }
        }
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
        in.nextLine();

        System.out.println("Data de Nascimento (dd/MM/aaaa): ");
        data = in.nextLine();
        dataR = data.split("/");
        dataNascimento = LocalDate.parse(dataR[2] + "-" + dataR[1] + "-" + dataR[0]);

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
        dataInicio = LocalDate.parse(dataR[2] + "-" + dataR[1] + "-" + dataR[0]);
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

    static void procurarAluno (IServidorSigava servidor){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o cpf do Aluno: ");
        String cpf = scan.next();
        if (servidor.buscarAluno(cpf) != null);
        System.out.println(servidor.buscarAluno(cpf).toString());
    }

    static void procurarProfessor (IServidorSigava servidor){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o cpf do Professor: ");
        String cpf = scan.next();
        if (servidor.buscarProfessor(cpf) != null);
        System.out.println(servidor.buscarProfessor(cpf).toString());
    }

    static void procurarDisciplina (IServidorSigava servidor){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome da disciplina: ");
        String nome = scan.next();
        if (servidor.buscarDisciplina(nome) != null);
        System.out.println(servidor.buscarDisciplina(nome).toString());
    }

    static void procurarTarefa (IServidorSigava servidor){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o código da tarefa: ");
        int codigo = scan.nextInt();
        if (servidor.buscarTarefa(codigo)!= null);
        System.out.println(servidor.buscarTarefa(codigo).toString());
    }

    static void listarAlunos (IServidorSigava servidor){
        if (servidor.listarAlunos() == null || servidor.listarAlunos().size()<1){
            System.out.printf("Não há alunos no repositório.\n");
        }

        else {
            for (int i = 0; i < servidor.listarAlunos().size() ; i++) {
                System.out.printf(servidor.listarAlunos().get(i).toString());
            }
        }
    }

    static void listarDisciplinas (IServidorSigava servidor){
        if (servidor.listarDisciplinas() == null || servidor.listarDisciplinas().size()<1){
            System.out.printf("Não há disciplinas no repositório.\n");
        }
        else {
            for (int i = 0; i < servidor.listarDisciplinas().size() ; i++) {
                System.out.printf(servidor.listarDisciplinas().get(i).toString());
            }
        }
    }

    static void listarTarefas (IServidorSigava servidor){
        if (servidor.listarTarefas() == null || servidor.listarTarefas().size()<1){
            System.out.printf("Não há tarefas no repositório.\n");
        }
        else {
            for (int i = 0; i < servidor.listarTarefas().size(); i++) {
                System.out.printf(servidor.listarTarefas().get(i).toString());
            }
        }
    }

    static void listarProfessores (IServidorSigava servidor){
        if (servidor.listarProfessores() == null || servidor.listarProfessores().size()<1){
            System.out.printf("Não há professores no repositório.\n");
        }

        else {
            for (int i = 0; i < servidor.listarProfessores().size() ; i++) {
                System.out.printf(servidor.listarProfessores().get(i).toString());
            }
        }
    }

    public static void Sistema(IServidorSigava servidorSigava){
        boolean loop = true;
        do {
            MenuAcesso();
            Scanner in = new Scanner(System.in);
            int controleMenu = in.nextInt();
            switch (controleMenu){
                case 1:
                    //cadastrar Aluno;
                    break;
                case 2:
                    cadastroProfessor(servidorSigava);
                    break;
                case 3:
                    cadastrarDisciplina(servidorSigava);
                    break;
                case 4:
                    //cadastro Tarefa;
                    break;
                case 5:
                    //descadastrar Aluno
                    break;
                case 6:
                    descadastrarProfessor(servidorSigava);
                    break;
                case 7:
                    descadastrarDisciplina(servidorSigava);
                    break;
                case 8:
                    //descadastrar tarefa
                    break;
                case 9:
                    procurarAluno(servidorSigava);
                    break;
                case 10:
                    procurarProfessor(servidorSigava);
                    break;
                case 11:
                    procurarDisciplina(servidorSigava);
                    break;
                case 12:
                    procurarTarefa(servidorSigava);
                    break;
                case 13:
                    listarAlunos(servidorSigava);
                    break;
                case 14:
                    listarProfessores(servidorSigava);
                    break;
                case 15:
                    listarDisciplinas(servidorSigava);
                    break;
                case 16:
                    listarTarefas(servidorSigava);
                    break;
                case 17:
                    //cronograma
                    break;
                case 18:
                    loop = false;
                    break;
                default:
                    System.out.printf("Fora do range do menu.\n");
                    break;

            }


        }while (loop);
    }
}
