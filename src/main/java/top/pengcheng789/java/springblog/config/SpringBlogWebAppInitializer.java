package top.pengcheng789.java.springblog.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置 Spring 上下文
 *
 * CreateDate:2017-08-04
 *
 * @author pen
 */
public class SpringBlogWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                WebConfig.class
        };
    }

}
