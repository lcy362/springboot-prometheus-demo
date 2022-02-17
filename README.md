Springboot Prometheus demos for http server, httpclient, thread pool, etc.

Start application , and visit http://localhost:8080/actuator/prometheus , for metrics list.


Currently, there are these metrics:

+ base application metrics, like jvm, tomcat, cpu, system load... just need to import spring-boot-starter-actuator to enable
+ http server histogram, enabled with configs percentiles-histogram.http and autotime
+ metric for httpclient component, refer HttpClientConfiguration, implemented with PoolingHttpClientConnectionManagerMetricsBinder.bind
+ metric for methods, implemented with @Timed, you need to enable the aspect (TimedConfiguration)
+ metric for thread pool of @Async, see main class of the application



关于prometheus是什么，可以参考 https://lichuanyang.top/posts/28288/
