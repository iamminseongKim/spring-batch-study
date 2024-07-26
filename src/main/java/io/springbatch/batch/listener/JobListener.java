package io.springbatch.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.time.Duration;
import java.util.Objects;

@Slf4j
public class JobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        Duration duration = Duration.between(Objects.requireNonNull(jobExecution.getStartTime()), jobExecution.getEndTime());
        log.info("Job execution time: {} ms", duration.toMillis());
    }
}
