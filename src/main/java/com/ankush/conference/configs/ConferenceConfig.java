package com.ankush.conference.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;

@Configuration
public class ConferenceConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    // for static data serving
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("/WEB-INF/pdf/");
    }

    // for localization
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    // for localization
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    // for localization
    @Bean
    public LocaleResolver localeResolver(){
        var res = new SessionLocaleResolver();
        res.setDefaultLocale(Locale.US);
        return res;
    }

    // way to override view resolver
    @Bean
    public ViewResolver viewResolver(){
        var bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        bean.setOrder(1);
        return bean;
    }

    // view resolver for thymeleaf
    @Bean
    public ViewResolver thymeLeafResolver(){
        var bean = new ThymeleafViewResolver();
        bean.setTemplateEngine(templateEngine());
        bean.setOrder(0);
        return bean;
    }

    // for thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        var tl = new SpringResourceTemplateResolver();
        tl.setApplicationContext(applicationContext);
        tl.setPrefix("/WEB-INF/views/");
        tl.setSuffix(".html");
        return tl;
    }

    // for thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine(){
        var te = new SpringTemplateEngine();
        te.setTemplateResolver(templateResolver());
        te.setEnableSpringELCompiler(true);
        return te;
    }
}
