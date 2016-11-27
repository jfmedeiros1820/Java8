import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaString {

  public static void main(String[] args) {
    List<String> palavras = new ArrayList<>();
    palavras.add("alura online");
    palavras.add("caelum");
    palavras.add("casa do código");

    // palavras.sort(String.CASE_INSENSITIVE_ORDER);
    palavras.sort(Comparator.comparing(String::hashCode));

    palavras.forEach(System.out::println);
    startThread();
  }

  public static void startThread() {
    new Thread(() -> System.out.println("Executando um Runnable")).start();
  }
}
