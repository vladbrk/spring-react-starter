# Spring React Starter
Project-starter. Created on Spring Boot (Security, Jdbc, Jpa) + ReactJs (Routers) + Gradle + Java 13 Modules + Liquibase

##### 1. Init npm
Move to /web/src/main/react/web-ui
>npm install

##### 2. Run liquibase migration
>./gradlew update

##### 3. Run app in Local mode
>./gradlew runLocal

##### 4. Run app in Dev mode
>./gradlew runDevFront
>
>./gradlew runDevBack

##### 5. Build jar for prod 
>./gradlew buildProd