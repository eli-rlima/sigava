import java.time.DayOfWeek;
import java.time.LocalDate;

public class ClasseTeste {
	public static void main(String[] args) {
		
	LocalDate dataNasc = LocalDate.of(1991, 05, 21);
	LocalDate dataNasci = LocalDate.of(1970, 04, 13);
	
	LocalDate dataInicio = LocalDate.of(2018, 05, 19);
	LocalDate dataFim = LocalDate.of(2018, 05, 21);
	
	LocalDate dataComeco = LocalDate.of(2018, 05, 19);
	LocalDate dataTermino = LocalDate.of(2018, 05, 29);
	
	System.out.println("Impressão do teste Pessoa");
	Pessoa aluno = new Pessoa("Arthur", "arthur@gmail.com", 'M', dataNasc,"arthur123","808057538-00");
	
	
	System.out.println();

	Pessoa aluno1 = new Pessoa();
	aluno1.setNome("Henrique");
	aluno1.setEmail("henrique@gmail.com");
	aluno1.setSexo('M');
	aluno1.setDataNascimento(dataNasci);
	aluno1.setSenha("senha789");
	/**
	 * cpf não pode ser usado como Set, pois só é acesso pelo construtor
	 */
	System.out.println(aluno.toString());
	System.out.println();
	System.out.println(aluno1.toString());
	System.out.println(aluno.equals(aluno1));
	System.out.println();
	
	System.out.println("Impressão do teste Tarefa");
	Tarefa tarefa = new Tarefa("Integrais definidas", dataInicio, dataFim, 01);
	
	Tarefa tarefa1 = new Tarefa();
	tarefa1.setDescricao("Grafos");
	tarefa1.setDataInicio(dataComeco);
	tarefa1.setDataTermino(dataTermino);
	tarefa1.setCodigoTarefa(02);
	System.out.println(tarefa.toString());
	System.out.println();
	System.out.println(tarefa1.toString());
	System.out.println(tarefa.equals(tarefa1));
	
	System.out.println();
	
	
	DayOfWeek diaAula = DayOfWeek.TUESDAY; 
	DayOfWeek diaAula1 = DayOfWeek.THURSDAY;
	
	System.out.println("Impressão do teste Disciplina");
	Disciplina disciplina1 = new Disciplina("POO", dataComeco, diaAula, 4,60);
	disciplina1.setDataFim(disciplina1.gerarDataFim());
	Pessoa professor = new Pessoa();
	professor.setNome("Leandro");
	
	
	Disciplina disciplina2 = new Disciplina();
	disciplina2.setNome("Discreta");
	Pessoa professor2 = new Pessoa();
	professor2.setNome("Maigan");
	disciplina2.setCargaHoraria(30);
	disciplina2.setDataInicio(dataComeco);
	disciplina2.setDataFim(disciplina2.gerarDataFim());
	disciplina2.setDiaAula(diaAula1);
	
	
	System.out.println(disciplina1.toString());
	System.out.println();
	System.out.println(disciplina2.toString());
	System.out.println(disciplina1.equals(disciplina2));
	}
}
