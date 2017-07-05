package com.github.amitagarwl.test;

import com.github.amitagarwl.BaseTest;
import com.github.amitagarwl.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by amit.agarwal on 6/28/17.
 */
@Slf4j
public class DummyTest extends BaseTest {


    @Test(enabled = true)
    public void test() {
        log.info("Getting Product name from Sales table" + dao.getProductName("123"));
    }

    @Test(enabled = true)
    public void runScript() {
        log.info("Executing custom shell script");
        try {
            Process process = new ProcessBuilder("src/test/resources/test.sh", Constants.GET_FB_ID).start();
            if (process.exitValue() == 0) {
                log.info("Custom Script executed!");
            } else {
                log.info("Something bad happened!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
