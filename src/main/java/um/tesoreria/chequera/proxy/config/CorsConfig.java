package um.tesoreria.chequera.proxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Value("${cors.allowed-origins:http://localhost:4200,http://127.0.0.1:4200}")
    private String allowedOrigins;
    
    @Value("${cors.allowed-methods:GET,POST,PUT,DELETE,OPTIONS}")
    private String allowedMethods;
    
    @Value("${cors.allowed-headers:Content-Type,Authorization,X-Requested-With,Accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers}")
    private String allowedHeaders;
    
    @Value("${cors.exposed-headers:Access-Control-Allow-Origin,Access-Control-Allow-Credentials}")
    private String exposedHeaders;
    
    @Value("${cors.max-age:3600}")
    private Long maxAge;
    
    @Value("${cors.allow-credentials:true}")
    private boolean allowCredentials;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns(getAllowedOriginPatterns().toArray(new String[0]))
                .allowedMethods(getAllowedMethods().toArray(new String[0]))
                .allowedHeaders(getAllowedHeaders().toArray(new String[0]))
                .exposedHeaders(getExposedHeaders().toArray(new String[0]))
                .allowCredentials(allowCredentials)
                .maxAge(maxAge);
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Configurar orígenes permitidos
        configuration.setAllowedOriginPatterns(getAllowedOriginPatterns());
        
        // Configurar métodos HTTP permitidos
        configuration.setAllowedMethods(getAllowedMethods());
        
        // Configurar headers permitidos
        configuration.setAllowedHeaders(getAllowedHeaders());
        
        // Configurar headers expuestos
        configuration.setExposedHeaders(getExposedHeaders());
        
        // Configurar credenciales
        configuration.setAllowCredentials(allowCredentials);
        
        // Configurar tiempo máximo de cache
        configuration.setMaxAge(maxAge);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }
    
    private List<String> getAllowedOriginPatterns() {
        return Arrays.asList(allowedOrigins.split(","));
    }
    
    private List<String> getAllowedMethods() {
        return Arrays.asList(allowedMethods.split(","));
    }
    
    private List<String> getAllowedHeaders() {
        return Arrays.asList(allowedHeaders.split(","));
    }
    
    private List<String> getExposedHeaders() {
        return Arrays.asList(exposedHeaders.split(","));
    }
} 