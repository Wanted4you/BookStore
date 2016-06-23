package big.proj.ee.CDI;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Влад on 14.06.2016.
 */
@EightDigits
public class IssnGenerator implements NumberGenerator{

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber(){
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISSN : " + issn);
        return issn;
    }
}
