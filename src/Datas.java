import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

  public static void main(String[] args) {

    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);

    LocalDate copaDoMundo = LocalDate.of(2018, Month.JUNE, 20);

    System.out.println("Período de tempo");
    Period periodo = Period.between(hoje, copaDoMundo);
    System.out.println(periodo);
    System.out.println(periodo.getYears());
    System.out.println(periodo.getMonths());
    System.out.println(periodo.getDays());

    System.out.println("Acrescentando ou removendo das datas");
    System.out.println(hoje.minusYears(1));
    System.out.println(hoje.minusMonths(4));
    System.out.println(hoje.minusDays(4));

    System.out.println(hoje.plusYears(1));
    System.out.println(hoje.plusMonths(4));
    System.out.println(hoje.plusDays(4));

    System.out.println("Objetos de datas são imutáveis");
    LocalDate proximaCopa = copaDoMundo.plusYears(4);
    System.out.println(proximaCopa);

    System.out.println("Formatando datas");
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataFormatada = proximaCopa.format(formatador);
    System.out.println(dataFormatada);

    System.out.println("Trabalhando com medida de tempo");
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatadorMinutos = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    System.out.println(agora.format(formatadorMinutos));

    System.out.println("Lidando com periodos específicos");
    YearMonth anoMes = YearMonth.of(2016, Month.AUGUST);
    System.out.println(anoMes);

    System.out.println("Lidando com apenas o tempo");
    DateTimeFormatter formatadorDeIntervalo = DateTimeFormatter.ofPattern("hh:mm");
    LocalTime intervalo = LocalTime.now();
    System.out.println(intervalo.format(formatadorDeIntervalo));
  }
}
