package io.springbatch.batch.job.api;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ApiJobChildConfiguration {

    private final Step apiMasterStep;
    private final JobLauncher jobLauncher;

    @Bean
    public Step jobStep(JobRepository jobRepository, @Qualifier("childJob") Job childJob) {
        return new StepBuilder("jobStep", jobRepository)
                .job(childJob)
                .launcher(jobLauncher)
                .build();
    }

    @Bean
    public Job childJob(JobRepository jobRepository) {
        return new JobBuilder("childJob", jobRepository)
                .start(apiMasterStep)
                .build();
    }
}
