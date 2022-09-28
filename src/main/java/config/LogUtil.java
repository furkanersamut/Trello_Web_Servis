package config;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    private LogUtil() {
        BasicConfigurator.configure();
    }

    public static final Logger logger = LogManager.getLogger(LogUtil.class);
}