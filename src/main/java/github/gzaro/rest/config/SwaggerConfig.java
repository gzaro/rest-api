package github.gzaro.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("github.gzaro.rest.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(header())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo header() {
        return new ApiInfoBuilder()
                .title("Simple RESTful API")
                .description("For more details please see <a href=\"https://github.com/gzaro/rest-api\">project repositoty</a>")
                .build();

    }

}
