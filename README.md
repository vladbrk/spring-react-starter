# Spring React Starter
Project-starter. Created on Spring Boot (Security, Jdbc, Jpa) + ReactJs (Routers) + Gradle + Java 13 Modules + Liquibase

##### 0. Set environment

###### 0.1. Install java
> sudo apt-get install -y openjdk-14-jdk

###### 0.2. Install npm
>sudo apt-get install npm 

###### 0.3. Install Gradle
>sudo add-apt-repository ppa:cwchien/gradle
>
>sudo apt-get update
>
>sudo apt-get install gradle
>
>gradle wrapper --gradle-version=6.6
 
###### 0.4. Install Postgresql
>sudo apt-get install -y postgresql-12
>
>sudo -u postgres psql
>
>\password postgres
>
>\q
>
>Change peer to md5 in /etc/postgresql/12/main/pg_hba.conf
>
>service postgresql restart

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