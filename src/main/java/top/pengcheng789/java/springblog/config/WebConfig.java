package top.pengcheng789.java.springblog.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import top.pengcheng789.java.springblog.controller.ControllerPackageMark;
import top.pengcheng789.java.springblog.service.ServicePackageMark;

/**
 * 配置 DispatcherServlet 上下文
 *
 * CreateDate:2017-08-04
 *
 * @author pen
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
        ControllerPackageMark.class,
        ServicePackageMark.class
})
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{

    private static final String UTF8 = "utf-8";

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Thymeleaf 视图解析器
     */
    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding(UTF8);

        return resolver;
    }

    /**
     * Thymeleaf 模板引擎
     */
    @Bean
    public TemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new LayoutDialect(new GroupingStrategy()));

        return engine;
    }

    /**
     * 配置静态资源的处理
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Thymeleaf 模板解析器
     */
    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver =
                new SpringResourceTemplateResolver();

        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/template/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        return resolver;
    }

}
