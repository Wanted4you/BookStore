package big.proj.ee.JSF;

import big.proj.ee.EJB.Book;
import big.proj.ee.EJB.BookEJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Влад on 12.09.2016.
 */
@Named
@RequestScoped
public class BookController {

    @Inject
    private BookEJB bookEJB;
    private Book bk = new Book();
    private Object book;

    public String doCreateBook(){
        bookEJB.createBook(bk);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "BookR created",
                "Книга" + bk.getTitle() + " была создана с id=" + bk.getId()));
        return "newBook.xhtml";
    }

    public void doFindBookById(){
        bk = bookEJB.findBookById(bk.getId());
    }

    public Book getBk() {
        return bk;
    }
}
