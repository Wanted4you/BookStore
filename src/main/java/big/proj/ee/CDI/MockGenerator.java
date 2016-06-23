package big.proj.ee.CDI;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Влад on 14.06.2016.
 */
@Alternative
@ThirteenDigits
public class MockGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber(){
        String mock = "MOCK" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}
