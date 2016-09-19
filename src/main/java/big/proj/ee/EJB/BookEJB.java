package big.proj.ee.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Влад on 21.07.2016.
 */
@Named
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote{

    @Inject
    private EntityManager em;

    public List<Book> findBooks(){
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
        return query.getResultList();
    }

    public @NotNull Book createBook(@NotNull Book book){
        em.persist(book);
        return book;
    }

    public @NotNull Book updateBook(@NotNull Book book){
        return em.merge(book);
    }

    public void deleteBook(@NotNull Book book){
        em.remove(em.merge(book));
    }

    public Book findBookById(Long id){
        return em.find(Book.class, id);
    }

}
