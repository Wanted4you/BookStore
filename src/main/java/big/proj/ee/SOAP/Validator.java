package big.proj.ee.SOAP;

import javax.jws.WebService;

/**
 * Created by Влад on 18.09.2016.
 */
@WebService
public interface Validator {

    boolean validate(CreditCard creditCard);
}
