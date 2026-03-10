========================================================================
PROYECTO DE AUTOMATIZACIÓN: DEMOBLAZE (SCREENPLAY + SERENITY BDD)
========================================================================

Este proyecto automatiza los flujos de registro de usuario y compra de 
productos en el portal DemoBlaze, utilizando el patrón de diseño 
Screenplay, Selenium 4 y Serenity BDD.

------------------------------------------------------------------------
1. REQUISITOS DEL SISTEMA
------------------------------------------------------------------------
* Java JDK: Versión 21 (basado en la configuración del proyecto).
* Gradle: Utilizado para la gestión de dependencias y ejecución.
* Navegador: Google Chrome.
* IDE: IntelliJ IDEA recomendado.

------------------------------------------------------------------------
2. CONFIGURACIÓN DEL ENTORNO (serenity.properties)
------------------------------------------------------------------------
El proyecto está configurado para:
* Autodescarga del WebDriver (webdriver.autodownload=true).
* Navegación en modo incógnito y maximizada.
* Tiempos de espera implícitos de 10 segundos.

------------------------------------------------------------------------
3. ESTRUCTURA DEL PROYECTO (src/main/java)
------------------------------------------------------------------------
* Interactions: 
    - 'Waiting': Maneja pausas explícitas en segundos.
* Questions: 
    - 'UserVerification': Valida el login mediante el texto de bienvenida.
    - 'PurchaseVerification': Valida el mensaje "Thank you for your purchase!".
* Tasks: 
    - 'Register': Registro dinámico con nombres aleatorios y manejo de alertas.
    - 'LogIn': Autenticación del usuario utilizando 'recall' de datos.
    - 'LogInCart': Flujo complejo de login y adición de dos productos.
    - 'MakePurchase': Diligencia el formulario de pedido final.
* UserInterfaces: 
    - 'Home' y 'Cart': Mapeo de elementos mediante ID, XPATH y selectores CSS.
* Utils: 
    - 'Constants': Contiene la data estática (Contraseñas, País, Ciudad, etc.).

------------------------------------------------------------------------
4. ESCENARIOS DE PRUEBA (src/test)
------------------------------------------------------------------------
* Feature ('register.feature'):
    - @Register: Registro exitoso de un nuevo usuario.
    - @Cart: Flujo completo de compra (Login + 2 Productos + Pago).
* Runner ('Register.java'): Ejecuta las pruebas mediante JUnit 4.

------------------------------------------------------------------------
5. INSTRUCCIONES DE EJECUCIÓN
------------------------------------------------------------------------
Desde una terminal en la raíz del proyecto:

A. Ejecutar todos los escenarios:
   gradle clean test aggregate

B. Ejecutar un escenario específico:
   Modificar el tag en 'Register.java' (Ej. tags = "@Register") y ejecutar:
   gradle clean test --tests "co.com.certification.demoblaze.runners.Register"

------------------------------------------------------------------------
6. CONSULTA DE REPORTES
------------------------------------------------------------------------
Serenity genera un reporte HTML detallado con evidencias paso a paso en:
/target/site/serenity/index.html

------------------------------------------------------------------------
7. NOTAS TÉCNICAS
------------------------------------------------------------------------
* Manejo de Alertas: Se utiliza 'Switch.toAlert().andAccept()' tras 
  agregar productos y al registrar usuarios.
* Persistencia: Se emplea 'actor.remember' para guardar el nombre de 
  usuario aleatorio y 'actor.recall' para validarlo posteriormente.

========================================================================
Desarrollado por: Alejandro Roncancio Clavijo
Fecha: Marzo 2026
========================================================================