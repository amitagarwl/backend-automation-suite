package com.github.amitagarwl.concurrency;

import com.github.amitagarwl.BaseTest;
import com.github.amitagarwl.model.DummyModel;
import com.github.amitagarwl.utils.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit.agarwal on 6/28/17.
 */
public class ConcurrencyTest extends BaseTest {


    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{{"TEST"}, {"YO"}, {"YOLO"}

        };
    }

    @Test(enabled = true, dataProvider = "testData")
    public void testConcurrency(String payload) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.THREADPOOL_COUNT);
        List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
        for (int i = 0; i < Constants.THREADPOOL_COUNT; i++) {
            tasks.add(new DummyModel(payload));
        }
        executorService.invokeAll(tasks);
        executorService.awaitTermination(1, TimeUnit.SECONDS);

    }


}
