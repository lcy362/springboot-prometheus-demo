package top.sand.service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private MeterRegistry meter;

    @Autowired
    private CloseableHttpClient httpClient;

    @Override
    @Timed
    public void callMethod() {
        System.out.println("callMethod");
        meter.counter("test.metric", "label1", "value1", "label2","value2");
    }

    @Override
    @Async(value = "asyncExecutor")
    public void asyncCall() {
        System.out.println("asynccall");
        try {
            httpClient.execute(new HttpGet("www.google.com"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
