package pl.java.scalatech.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.Boxer;
import pl.java.scalatech.domain.Country;

import com.google.common.collect.Sets;
@Configuration
@ComponentScan(basePackages = "pl.java.scalatech.converter", useDefaultFilters = false, includeFilters = { @Filter(Component.class) })
@Slf4j
@Import(ServiceConfig.class)
public class ConversionConfig {

    @Autowired
    private Converter<Boxer,String> boxer2StringConverter;
    @Autowired
    private Converter<Country, String> country2StringConverter;
    @Autowired
    private Converter<String,Boxer> string2BoxerConverter;
    @Autowired
    private Converter<String, Country> string2CountryConverter;

    @SuppressWarnings("unchecked")
    @Bean
    public ConversionService conversionService() {
         
        final ConversionServiceFactoryBean conversionServiceFactoryBean = conversionServiceFactoryBean();
        log.info("+++                 conversionService()   {}  ,  {}   ");
        conversionServiceFactoryBean.setConverters(Sets.newHashSet(boxer2StringConverter, country2StringConverter, string2BoxerConverter,
                string2CountryConverter));

        final ConversionService conversionService = conversionServiceFactoryBean.getObject();
        ConverterRegistry converterRegistry = (ConverterRegistry) conversionService;
        /*
         * ConversionServiceFactory.registerConverters(
         * Sets.newHashSet(string2BoxerConverter(), string2CountryConverter(), country2StringConverter(), boxer2StringConverter()), converterRegistry);
         */

        return conversionService;
    }

    @Bean
    protected ConversionServiceFactoryBean conversionServiceFactoryBean() {
        return new ConversionServiceFactoryBean();
    }

    @Bean
    protected FormattingConversionServiceFactoryBean formattingConversionServiceFactoryBean() {
        return new FormattingConversionServiceFactoryBean();
    }

    @Bean
    public FormattingConversionService formattingConversionService() {
        final FormattingConversionService formattingConversionService = formattingConversionServiceFactoryBean().getObject();
        return formattingConversionService;
    }

   
}