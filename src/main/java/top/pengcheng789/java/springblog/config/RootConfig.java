package top.pengcheng789.java.springblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import top.pengcheng789.java.springblog.SpringBlogPackageMark;

/**
 * CreateDate:2017-08-04
 *
 * @author pen
 */
@Configuration
@ComponentScan(
        basePackageClasses = {
                SpringBlogPackageMark.class
        }, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                        value = EnableWebMvc.class)
        }
)
public class RootConfig {

}
