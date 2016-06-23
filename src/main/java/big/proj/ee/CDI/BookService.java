package big.proj.ee.CDI;

import javax.inject.Inject;

/**
 * Created by Влад on 14.06.2016.
 */
@Loggable
public class BookService {

    @Inject@ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, float price, String description){
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
