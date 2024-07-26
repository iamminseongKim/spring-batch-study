package io.springbatch.batch.job.api;

import io.springbatch.batch.listener.JobListener;
import io.springbatch.batch.tasklet.ApiEndTasklet;
import io.springbatch.batch.tasklet.ApiStartTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class ApiJobConfiguration {

    private final ApiStartTasklet apiStartTasklet;
    private final ApiEndTasklet apiEndTasklet;
    private final Step jobStep;

    @Bean
    public Job apiJob(JobRepository jobRepository, @Qualifier("apiStep1") Step step1, @Qualifier("apiStep2") Step step2) {
        return new JobBuilder("apiJob", jobRepository)
                .listener(new JobListener())
                .start(step1)
                .next(jobStep)
                .next(step2)
                .build();
    }

    @Bean
    public Step apiStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("apiStep1", jobRepository)
                .tasklet(apiStartTasklet, transactionManager)
                .build();
    }

    @Bean
    public Step apiStep2(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("apiStep2", jobRepository)
                .tasklet(apiEndTasklet, transactionManager)
                .build();
    }
}
