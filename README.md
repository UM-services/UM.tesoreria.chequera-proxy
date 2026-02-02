# UM Tesoreria Chequera Proxy

Este proyecto es el backend para la gestión y consulta del estado de chequeras de alumnos de la Universidad de Mendoza. Su objetivo es proveer los datos necesarios para que los usuarios, a través de un frontend, puedan consultar el estado de las chequeras asociadas a diferentes alumnos.

## Características principales
- **Autenticación**: Endpoint para verificación de cuentas de usuario mediante Google Mail
- **Gestión de Chequeras**: Consulta del estado de chequeras por persona y facultad
- **Gestión de Usuarios**: Consulta de usuarios asociados a chequeras por facultad
- **Arquitectura**: Basada en Spring Boot 4.0.2 con microservicios
- **Service Discovery**: Integración con Consul para descubrimiento de servicios
- **Rate Limiting**: Protección contra abuso con Resilience4j
- **Documentación API**: Swagger/OpenAPI integrado
- **Monitoreo**: Actuator y métricas Prometheus habilitadas

## Tecnologías utilizadas
- **Java**: 25
- **Spring Boot**: 4.0.2
- **Spring Cloud**: 2025.1.0
- **Spring Cloud OpenFeign**: Para comunicación entre servicios
- **Spring Cloud Consul**: Service discovery
- **Resilience4j**: Circuit breaker y rate limiting
- **Caffeine**: Cache en memoria
- **Lombok**: Reducción de código boilerplate
- **SpringDoc OpenAPI**: Documentación de API
- **H2 Database**: Base de datos en memoria para desarrollo

## Requisitos
- Java 21+
- Maven 3.6+

## Configuración

### Variables de entorno
- `APP_PORT`: Puerto de la aplicación (default: 8121)
- `APP_LOGGING`: Nivel de logging (default: debug)

### Configuración de CORS
El proyecto incluye configuración de CORS diferenciada por ambiente:
- **Desarrollo**: Permite localhost:4200, localhost:3000
- **Producción**: Configurar dominios específicos en `application-prod.yml`

## Ejecución local

### Desarrollo
```bash
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

### Producción
```bash
./mvnw spring-boot:run -Dspring.profiles.active=prod
```

## Endpoints disponibles

### Autenticación
- `GET /api/chequera/backend/auth/verify/{googleMail}` - Verifica cuenta de usuario

### Chequeras
- `GET /api/chequera/backend/chequera/status/{personaId}/facultad/{facultadId}` - Consulta estado de chequera

### Usuarios
- `GET /api/chequera/backend/usuarioChequeraFacultad/user/{userId}` - Lista usuarios por chequera y facultad

## Monitoreo y métricas
- **Health Check**: `http://localhost:8121/actuator/health`
- **Métricas Prometheus**: `http://localhost:8121/actuator/prometheus`
- **Documentación API**: `http://localhost:8121/swagger-ui.html`
- **H2 Console**: `http://localhost:8121/h2-console` (solo desarrollo)

## Estructura del proyecto
```
src/main/java/um/tesoreria/chequera/backend/
├── ChequeraBackendApplication.java
├── client/
│   └── core/
│       ├── ChequeraClient.java
│       ├── UsuarioChequeraFacultadClient.java
│       └── UsuarioClient.java
├── config/
│   ├── ChequeraClientConfiguration.java
│   └── CorsConfig.java
├── controller/
│   ├── AuthController.java
│   └── client/core/
│       ├── ChequeraController.java
│       └── UsuarioChequeraFacultadController.java
├── model/
│   └── client/core/
│       ├── ArancelTipoDto.java
│       ├── ChequeraCuotaDto.java
│       ├── ChequeraDetailDto.java
│       ├── ChequeraPagoDto.java
│       ├── ChequeraSerieDto.java
│       ├── DomicilioDto.java
│       ├── FacultadDto.java
│       ├── GeograficaDto.java
│       ├── LectivoDto.java
│       ├── MercadoPagoContextDto.java
│       ├── PersonaDto.java
│       ├── ProductoDto.java
│       ├── TipoChequeraDto.java
│       ├── TipoPagoDto.java
│       ├── UsuarioChequeraFacultadDto.java
│       └── UsuarioDto.java
└── service/
    ├── AuthService.java
    └── client/core/
        ├── ChequeraService.java
        └── UsuarioChequeraFacultadService.java
```

## Docker

### Desarrollo
```bash
docker build -f Dockerfile.local -t um-tesoreria-chequera-backend:dev .
```

### Producción
```bash
docker build -t um-tesoreria-chequera-backend:latest .
```

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para sugerencias o mejoras.

## Licencia
[MIT](LICENSE) 