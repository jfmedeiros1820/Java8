import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExemploCursos {

  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();
    cursos.add(new Curso("Python", 45));
    cursos.add(new Curso("Javascript", 150));
    cursos.add(new Curso("Java 8", 113));
    cursos.add(new Curso("C", 55));

    cursos.sort(Comparator.comparing(Curso::getAlunos));

    cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .forEach(c -> System.out.println(c.getNome()));

    cursos.stream()
        .filter(c -> c.getAlunos() > 100)
        .map(c -> c.getAlunos())
        .forEach(x -> System.out.println(x));

    cursos.stream()
        .filter(c -> c.getAlunos() > 100)
        .collect(Collectors.toList())
        .forEach(c -> System.out.println(c));

    cursos.stream()
        .filter(c -> c.getAlunos() > 100)
        .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
        .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

    Optional<Curso> optionalCurso = cursos.stream()
        .filter(c -> c.getAlunos() > 100)
        .findAny();

    cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .findFirst()
        .ifPresent(c -> System.out.println(c.getNome()));

    optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

    cursos.stream()
        .mapToInt(c -> c.getAlunos())
        .average();

    System.out.println(cursos.stream()
        .allMatch(c -> c.getAlunos() > 30));

    cursos.parallelStream()
        .filter(c -> c.getAlunos() > 100);
  }
}


class Curso {

  private String nome;
  private int alunos;

  public Curso(String nome, int alunos) {
    this.nome = nome;
    this.alunos = alunos;
  }

  public String getNome() {
    return nome;
  }

  public int getAlunos() {
    return alunos;
  }
}
