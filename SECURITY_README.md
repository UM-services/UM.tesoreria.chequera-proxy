# Implementación de Seguridad - Tesorería Chequera Backend

## Descripción

Esta implementación de seguridad está diseñada para trabajar con un frontend Angular 20 que maneja la autenticación con Google. El backend solo verifica si el usuario de Google está autorizado para usar este servicio específico.

## Arquitectura de Seguridad

### Componentes Principales

1. **UsuarioAutorizado**: Entidad que almacena usuarios autorizados del sistema
2. **GoogleAuthService**: Servicio para verificar tokens de Google y validar usuarios
3. **GoogleTokenAuthenticationFilter**: Filtro personalizado para autenticación
4. **SecurityConfig**: Configuración de Spring Security con CORS para Angular

### Flujo de Autenticación

1. El frontend Angular obtiene un token de Google
2. El frontend envía el token al backend en el header `Authorization: Bearer <token>`
3. El backend verifica el token con Google (pendiente de implementación completa)
4. Si el token es válido, se verifica si el email del usuario está en la lista de usuarios autorizados
5. Si está autorizado, se crea una sesión de autenticación

## Configuración Actual

### Para Desarrollo

- Base de datos H2 en memoria
- Usuarios de prueba pre-cargados:
  - `admin@um.edu.ar` (Rol: ADMIN)
  - `tesorero@um.edu.ar` (Rol: TESORERO)
  - `usuario@um.edu.ar` (Rol: USER)

### Endpoints de Seguridad

- `GET /api/chequera/backend/auth/verify`: Verifica la autenticación actual
- `POST /api/chequera/backend/auth/verify-token`: Verifica un token específico

### Endpoints Protegidos

- `GET /api/chequera/backend/facultad/test`: Requiere autenticación y rol válido

## Uso desde Angular

### Configuración del Interceptor HTTP

```typescript
// auth.interceptor.ts
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.authService.getGoogleToken(); // Obtener token de Google
    
    if (token) {
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    
    return next.handle(req);
  }
}
```

### Ejemplo de Llamada

```typescript
// Verificar autenticación
this.http.get('/api/chequera/backend/auth/verify').subscribe(
  (response: any) => {
    if (response.authenticated) {
      console.log('Usuario autenticado:', response.email);
      console.log('Rol:', response.rol);
    }
  }
);

// Llamar endpoint protegido
this.http.get('/api/chequera/backend/facultad/test').subscribe(
  (response: any) => {
    console.log('Respuesta:', response);
  }
);
```

## Implementación Pendiente

### Verificación Real de Tokens de Google

El método `verificarTokenGoogle()` en `GoogleAuthService` necesita ser implementado completamente:

```java
public Optional<UsuarioAutorizado> verificarTokenGoogle(String idToken) {
    try {
        // 1. Verificar el token con Google API
        // 2. Extraer el email del token verificado
        // 3. Buscar el usuario en la base de datos
        // 4. Retornar el usuario si está autorizado
        
        // Implementación pendiente...
        return Optional.empty();
    } catch (Exception e) {
        log.error("Error al verificar token de Google: {}", e.getMessage());
        return Optional.empty();
    }
}
```

### Configuración de Producción

1. **Base de Datos**: Cambiar de H2 a PostgreSQL/MySQL
2. **CORS**: Configurar dominios específicos de Angular
3. **Google Client ID**: Configurar el client ID real de tu aplicación
4. **Logging**: Configurar niveles de log apropiados para producción

## Pruebas

### Usando curl

```bash
# Verificar autenticación (usando email como token para desarrollo)
curl -H "X-User-Email: admin@um.edu.ar" \
     http://localhost:8121/api/chequera/backend/auth/verify

# Llamar endpoint protegido
curl -H "X-User-Email: admin@um.edu.ar" \
     http://localhost:8121/api/chequera/backend/facultad/test
```

### Usando Postman

1. Agregar header: `X-User-Email: admin@um.edu.ar`
2. O agregar header: `Authorization: Bearer admin@um.edu.ar` (para desarrollo)

## Roles y Permisos

- **ADMIN**: Acceso completo a todas las funcionalidades
- **TESORERO**: Acceso a funcionalidades de tesorería
- **USER**: Acceso básico a funcionalidades generales

Los permisos se controlan con anotaciones `@PreAuthorize` en los controladores. 