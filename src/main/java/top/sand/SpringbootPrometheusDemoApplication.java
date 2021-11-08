package top.sand;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.ExecutorServiceMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAsync
public class SpringbootPrometheusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPrometheusDemoApplication.class, args);
    }

    //metric @Async
    @Bean(name = "asyncExecutor")
    public ExecutorService executorService(final MeterRegistry registry) {

        return ExecutorServiceMetrics.monitor(registry, new ThreadPoolExecutor(70, 70, 0L, TimeUnit.MILLISECONDS
                        , new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("async-thread-%d").build(), new ThreadPoolExecutor.DiscardPolicy()),
                "asyncExecutor");
    }

}
