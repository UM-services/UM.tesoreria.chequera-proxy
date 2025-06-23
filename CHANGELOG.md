# Changelog

Todas las modificaciones importantes de este proyecto se documentarán en este archivo.

## [0.0.1-SNAPSHOT] - 2025-06-19
### Agregado
- Estructura inicial del proyecto Spring Boot 3.5.0
- Configuración de microservicios con Spring Cloud 2025.0.0
- Integración con Eureka Service Discovery
- Endpoints de autenticación con verificación de cuentas Google Mail
- Endpoints para gestión de chequeras y usuarios
- Configuración de CORS diferenciada por ambiente (dev/prod)
- Rate limiting con Resilience4j
- Documentación API con SpringDoc OpenAPI
- Monitoreo con Actuator y métricas Prometheus
- Configuración de Docker para desarrollo y producción
- Scripts para automatización de documentación y wiki
- Configuración de logging estructurado
- Base de datos H2 en memoria para desarrollo

### Configuración técnica
- Java 21
- Spring Boot 3.5.0
- Spring Cloud 2025.0.0
- Puerto por defecto: 8121
- Service discovery: Eureka
- Cache: Caffeine
- Circuit breaker: Resilience4j

### Endpoints implementados
- `GET /api/chequera/backend/auth/verify/{googleMail}` - Verificación de cuentas
- `GET /api/chequera/backend/chequera/status/{personaId}/facultad/{facultadId}` - Estado de chequeras
- `GET /api/chequera/backend/usuarioChequeraFacultad/user/{userId}` - Usuarios por chequera

### Información del commit
- **Commit**: 12e3537
- **Autor**: dqmdz (daniel.quinterospinto@gmail.com)
- **Fecha**: 19 de junio de 2025
- **Mensaje**: "First commit" 