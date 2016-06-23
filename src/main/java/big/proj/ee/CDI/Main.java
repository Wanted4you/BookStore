package big.proj.ee.CDI;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by Влад on 14.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Одураченные случайностю", 35.10f, "Книга про роль случайности в жизне");
        System.out.println(book);
        weld.shutdown();
    }
}
