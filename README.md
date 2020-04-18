Pasos para el despliegle en EAP standalone
1. Modificar el standalone-full.xml
  Agregar en datasources
     <datasource jndi-name="java:jboss/datasources/MysqlDS" pool-name="MysqlDS">
        <connection-url>URL_MYSQL:puerto/schema</connection-url>
        <driver>mysql</driver>
        <security>
            <user-name>user</user-name>
            <password>password</password>
        </security>
      </datasource>
  Agregar en drivers
    <driver name="mysql" module="com.mysql">
        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
    </driver>
2. Crear el modulo asociado al driver
Seguir los pasos de la documentación oficial de EAP 1
https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html/configuration_guide/overview_of_class_loading_and_modules#create_module_manually

