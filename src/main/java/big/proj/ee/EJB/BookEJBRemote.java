package big.proj.ee.EJB;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Влад on 21.07.2016.
 */
@Remote
public interface BookEJBRemote {

    List<Book> findBooks();
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Book book);
}
