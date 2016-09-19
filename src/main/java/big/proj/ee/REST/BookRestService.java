package big.proj.ee.REST;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by Влад on 18.09.2016.
 */
@Path("/book")
@Produces({"application/xml","application/json"})
@Consumes({"application/xml", "application/json"})
@Stateless
public class BookRestService {

    @PersistenceContext(unitName = "rest")
    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    @POST
    public Response createBook(BookR bookR){
        if(bookR == null)
            throw new BadRequestException();

        em.persist(bookR);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(bookR.getId())).build();
        return Response.created(bookUri).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id){
        BookR book = em.find(BookR.class, id);

        if(book == null)
            throw new NotFoundException();

        return Response.ok(book).build();
    }

    @GET
    public Response getBooks(){
        TypedQuery<BookR> query = em.createNamedQuery(BookR.FIND_ALL, BookR.class);
        BookR bookR = new BookR(query.getResultList());
        return Response.ok(bookR).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") String id){
        BookR book = em.find(BookR.class, id);

        if(book == null)
            throw new NotFoundException();

        return Response.noContent().build();
    }
}
