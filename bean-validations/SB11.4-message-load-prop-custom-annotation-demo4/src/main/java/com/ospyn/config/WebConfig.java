package com.ospyn.config;

import java.util.Date;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig class implements WebMvcConfigurer to provide custom configurations
 * for Spring MVC.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Configures a MessageSource bean that is used for resolving messages, with
	 * support for internationalization of validation messages.
	 *
	 * @return a MessageSource configured to load validation messages from a
	 *         resource bundle.
	 */
	@Bean("messageSource")
	public MessageSource loadMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// Base name of the properties file without extension
		messageSource.setBasename("validationMessages");
		return messageSource;
	}

	/**
	 * Configures a LocalValidatorFactoryBean bean that uses the custom
	 * MessageSource for resolving validation messages.
	 *
	 * @return a LocalValidatorFactoryBean configured with a custom MessageSource.
	 */
	@Bean("validator")
	public LocalValidatorFactoryBean customValidator() {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		// Setting the custom message source
		validatorFactoryBean.setValidationMessageSource(loadMessageSource());
		return validatorFactoryBean;
	}

	/**
	 * Overrides the getValidator method to provide a custom Validator
	 * (LocalValidatorFactoryBean) for Spring MVC.
	 *
	 * @return the custom Validator configured to use the custom MessageSource.
	 */
	@Override
	public org.springframework.validation.Validator getValidator() {
		return customValidator();
	}

	/**
	 * Adds custom formatters for specific types, such as Date, to the
	 * FormatterRegistry. This ensures that dates are formatted correctly throughout
	 * the application.
	 *
	 * @param registry the FormatterRegistry where custom formatters are registered.
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// Registering a DateFormatter with the pattern "yyyy-MM-dd" for Date fields
		registry.addFormatterForFieldType(Date.class,
				new org.springframework.format.datetime.DateFormatter("yyyy-MM-dd"));
	}
}
