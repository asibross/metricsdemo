package com.example.metricsdemo;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.ReporterMetrics;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class MyConfig {

	@Bean
	public MeterRegistryCustomizer<MeterRegistry> myMeterRegistryCustomizer(MetricsProperties metricsProps) {
		return registry -> {
			System.out.println("THIS IS NOT CALLED");
		};
	}

	@Bean
	public ReporterMetrics micrometerTracingReporterMetrics(MeterRegistry meterRegistry) {
		final AtomicInteger queuedSpans = meterRegistry.gauge("tracing", new AtomicInteger(0));

		return new ReporterMetrics() {
			@Override
			public void incrementMessages() {

			}

			@Override
			public void incrementMessagesDropped(Throwable cause) {

			}

			@Override
			public void incrementSpans(int quantity) {

			}

			@Override
			public void incrementSpanBytes(int quantity) {

			}

			@Override
			public void incrementMessageBytes(int quantity) {

			}

			@Override
			public void incrementSpansDropped(int quantity) {

			}

			@Override
			public void updateQueuedSpans(int update) {
				queuedSpans.set(update);
			}

			@Override
			public void updateQueuedBytes(int update) {

			}
		};
	}

}
