package big.proj.ee.SOAP;

import javax.jws.WebService;

/**
 * Created by Влад on 18.09.2016.
 */
@WebService(endpointInterface = "big.proj.ee.SOAP.Validator")
public class CardValidator implements Validator{

    @Override
    public boolean validate(CreditCard creditCard) {

        Character lastDigit = creditCard.getNumber().charAt(
                                creditCard.getNumber().length() - 1);
        return Integer.parseInt(lastDigit.toString()) % 2 == 0;
    }
}
