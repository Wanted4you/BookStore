package big.proj.ee;

import big.proj.ee.CDI.Book;
import big.proj.ee.CDI.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Влад on 15.06.2016.
 */
public class BookServiceIT {

    @Test
    public void shouldCheckNumberIsMOCK(){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Доставляе счастье", 25.5f, "Книга об упешном построение бизнеса");

        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }
}
