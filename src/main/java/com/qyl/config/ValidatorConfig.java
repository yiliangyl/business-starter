package com.qyl.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Author: qyl
 * @Date: 2021/2/6 10:23
 * @Description: validator配置类
 */
//@Configuration
//public class ValidatorConfig {
//
//    @Bean
//    public Validator validator() {
//        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
//                .configure()
//                .addProperty("hibernate.validator.fail_fast", "true")
//                .buildValidatorFactory();
//        return validatorFactory.getValidator();
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        return new MethodValidationPostProcessor();
//    }
//}
