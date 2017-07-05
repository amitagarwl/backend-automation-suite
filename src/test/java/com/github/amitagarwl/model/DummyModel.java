package com.github.amitagarwl.model;

import com.github.amitagarwl.restclient.RestClient;
import com.github.amitagarwl.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * Created by amit.agarwal on 6/28/17.
 */
@Data
@AllArgsConstructor
public class DummyModel implements Callable<Boolean> {
    private String payload;

    public Boolean call() throws Exception {
        RestClient.postCall(Constants.GET_FB_ID, payload).prettyPrint();
        return true;
    }
}
