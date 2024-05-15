package pl.demo.loadtests.infrastructure.adapters.metrics;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MetricsConfig {

    /**
     * Ports metrics
     */
    public static final String PORTS_IN_METRICS = "application_ports_in";
    public static final String PORTS_OUT_METRICS = "application_ports_out";

    @Bean
    public TimedAspect timedAspect(MeterRegistry meterRegistry) {
        return new TimedAspect(meterRegistry);
    }

}
