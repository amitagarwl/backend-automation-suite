package com.github.amitagarwl;

import com.github.amitagarwl.config.Config;
import com.github.amitagarwl.dao.MyDao;
import com.github.vivekkothari.YamlParser;
import lombok.extern.slf4j.Slf4j;
import org.skife.jdbi.v2.DBI;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by amit.agarwal on 6/26/17.
 */
@Slf4j
public class BaseTest {

    public static Config config;
    public static MyDao dao;

    @BeforeSuite(alwaysRun = true)
    public void setup() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(
                "/<Path to project>/backend-automation-suite/src/test/resources/automation.yml"));
        config = YamlParser.load(in, Config.class);
        log.info("================== Starting Automation ===================");
        DBI dbi = new DBI(config.getMasterDbConfig().getUrl(), config.getMasterDbConfig().getUsername(),
                config.getMasterDbConfig().getPassword());
        dao = dbi.open(MyDao.class);
        log.info("Creating connection with database!");
        log.info("Starting test case Execution!");
    }

    @AfterSuite(alwaysRun = true)
    public void cleanup() {
        log.info("Closing a connection with database!");
        dao.close();
        log.info("Finished test case Execution!");
    }


}
