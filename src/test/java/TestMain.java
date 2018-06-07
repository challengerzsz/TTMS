import com.bsb.util.MD5Util;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestMain {

    Logger logger = Logger.getLogger(TestMain.class);

    @Test
    public void MD5Encoding() {
        logger.info(MD5Util.MD5EncodeUtf8("123456"));
    }
}
