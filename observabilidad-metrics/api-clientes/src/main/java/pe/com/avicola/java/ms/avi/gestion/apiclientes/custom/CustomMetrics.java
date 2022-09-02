package pe.com.avicola.java.ms.avi.gestion.apiclientes.custom;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomMetrics {
	
	private final Counter customCounter;
	
	private final AtomicInteger customGauge;

	public CustomMetrics(MeterRegistry meterRegistry) {
		this.customCounter = meterRegistry.counter("custom_counter");
		this.customGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
	}

	public void getRandomMetricsData() {
		int r=getRandomNumberInRange(0, 100);
		log.info("r -> "+r);
		customGauge.set(r);
		customCounter.increment();
	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max debe ser mayor que min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
