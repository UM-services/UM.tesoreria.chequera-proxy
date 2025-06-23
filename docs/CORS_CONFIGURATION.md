# Configuración CORS - Chequera Backend

## Descripción General

Esta aplicación Spring Boot está configurada con CORS (Cross-Origin Resource Sharing) para permitir peticiones desde aplicaciones frontend que se ejecutan en diferentes dominios.

## Configuración Implementada

### 1. Configuración Global (`CorsConfig.java`)

La configuración CORS se maneja globalmente a través de la clase `CorsConfig` que implementa `WebMvcConfigurer`. Esta configuración:

- **Aplica a todos los endpoints** bajo `/api/**`
- **Es configurable** a través de propiedades de Spring
- **Maneja diferentes entornos** (desarrollo, producción)
- **Es segura** y no permite orígenes no autorizados

### 2. Propiedades Configurables

Las siguientes propiedades se pueden configurar en los archivos `application.yml`:

```yaml
cors:
  allowed-origins: http://localhost:4200,http://127.0.0.1:4200
  allowed-methods: GET,POST,PUT,DELETE,OPTIONS
  allowed-headers: Content-Type,Authorization,X-Requested-With,Accept,Origin
  exposed-headers: Access-Control-Allow-Origin,Access-Control-Allow-Credentials
  max-age: 3600
  allow-credentials: true
```

### 3. Entornos de Configuración

#### Desarrollo (`application-dev.yml`)
- **Orígenes permitidos**: `localhost:4200`, `127.0.0.1:4200`, `localhost:3000`
- **Headers más permisivos** para facilitar el desarrollo
- **Logging detallado** para debugging

#### Producción (`application-prod.yml`)
- **Orígenes restrictivos**: Solo dominios específicos de producción
- **Headers mínimos** necesarios para seguridad
- **Logging reducido** para mejor rendimiento

## Uso

### Para Desarrollo
```bash
# Ejecutar con perfil de desarrollo
java -jar app.jar --spring.profiles.active=dev
```

### Para Producción
```bash
# Ejecutar con perfil de producción
java -jar app.jar --spring.profiles.active=prod
```

## Endpoints Configurados

Los siguientes endpoints están configurados para CORS:

- `GET /api/chequera/backend/auth/verify/{email}`
- `GET /api/chequera/backend/usuarioChequeraFacultad/user/{userId}`

## Seguridad

### Buenas Prácticas Implementadas

1. **Orígenes específicos**: No se usa `*` para orígenes permitidos
2. **Headers mínimos**: Solo se permiten los headers necesarios
3. **Configuración por entorno**: Diferentes configuraciones para dev/prod
4. **Credenciales controladas**: `allowCredentials` configurado apropiadamente
5. **Cache limitado**: `maxAge` establecido para evitar cache excesivo

### Configuración para Producción

**IMPORTANTE**: Antes de desplegar en producción, actualiza las siguientes propiedades en `application-prod.yml`:

```yaml
cors:
  allowed-origins: https://tu-dominio-real.com,https://www.tu-dominio-real.com
```

## Troubleshooting

### Error: "CORS Missing Allow Origin"

1. Verifica que el frontend esté haciendo peticiones desde un origen permitido
2. Confirma que el endpoint esté bajo `/api/**`
3. Revisa los logs de Spring Boot para errores CORS

### Error: "CORS preflight request failed"

1. Verifica que el método HTTP esté en `allowed-methods`
2. Confirma que los headers estén en `allowed-headers`
3. Revisa que `allow-credentials` esté configurado correctamente

### Logs de Debug

Para habilitar logs detallados de CORS:

```yaml
logging:
  level:
    org.springframework.web.cors: DEBUG
```

## Personalización

### Agregar Nuevos Orígenes

Edita el archivo de configuración correspondiente:

```yaml
cors:
  allowed-origins: http://localhost:4200,http://127.0.0.1:4200,https://nuevo-origen.com
```

### Agregar Nuevos Headers

```yaml
cors:
  allowed-headers: Content-Type,Authorization,X-Requested-With,Accept,Origin,X-Custom-Header
```

### Configurar Nuevos Endpoints

Si necesitas CORS para endpoints fuera de `/api/**`, modifica `CorsConfig.java`:

```java
registry.addMapping("/nuevo-prefijo/**")
        .allowedOriginPatterns(getAllowedOriginPatterns().toArray(new String[0]))
        // ... resto de configuración
```

## Referencias

- [Spring Boot CORS Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-cors)
- [MDN CORS Guide](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)
- [Spring Security CORS](https://docs.spring.io/spring-security/reference/servlet/integrations/cors.html) 