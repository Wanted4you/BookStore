package big.proj.ee.REST;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Влад on 18.09.2016.
 */
@XmlRootElement
@XmlSeeAlso(BookR.class)
public class Books extends ArrayList<BookR>{

    public Books() {
        super();
    }

    public Books(Collection<? extends BookR> c){
        super(c);
    }

    public List<BookR> getBooks(){
        return this;
    }

    public void setBooks(List<BookR> books){
        this.addAll(books);
    }
}
