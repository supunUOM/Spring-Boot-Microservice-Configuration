=== Maven Dependency ===
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.0.2</version>
</dependency>

=== Configuration based on annotation ===
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "XdotO backend",
                version = "1.0.0",
                description = "Backend end points."
        )
)
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
