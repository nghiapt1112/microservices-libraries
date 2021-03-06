package com.nghia.libraries.email.infrustructure.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:mail.properties", "classpath:error.info.properties"})
public class EmailAutoConfiguraiton {
    private final Integer INTEGER = 0;
    private final String STR = "";
    private final String BOOLEAN = "FALSE";

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setUsername(env.getProperty("mail.acc", STR));
        mailSender.setPassword(env.getProperty("mail.pwd", STR));
        mailSender.setHost(env.getProperty("mail.smtp.host", STR));
        mailSender.setPort(env.getProperty("mail.smtp.port", Integer.class, INTEGER));

        /**
         * TODO: Config properties for IMAPStore.class
         */
        final Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth", BOOLEAN));
        javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable", BOOLEAN));
        javaMailProperties.put("mail.debug", env.getProperty("mail.debug", BOOLEAN));
        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
//
//    @Bean
//    public TaskExecutor getTaskExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setCorePoolSize(5);
//        taskExecutor.setMaxPoolSize(10);
//        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        return taskExecutor;
//    }
}
