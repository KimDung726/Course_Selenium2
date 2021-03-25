package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class.getName());

    /***
     * This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
     * @param nameTestcase: Name of Testcase
     */
    public static void startTestCase(String nameTestcase) {
        info("**********************************************************");
        info(">>>>>>>>>>>>>>>>>>>    " + nameTestcase + "    <<<<<<<<<<<<<<<<<<<");
        info("**********************************************************");
    }

    /***
     * This is to print log for the ending of the test case
     * @param strResult : result of Testcase
     */
    public static void endTestCase(String strResult) {
        info("");
        info("-------------            " + strResult + "        --------------------");
        info("==========================================================");
        info("");
        info("");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
