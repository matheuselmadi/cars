# Cars API Spring Boot

Aplicação Springboot com acesso a BD que expõe endpoints Rest, exibe uma listagem de veículos em um formato especifico. Possui endpoints para CRUD de carros, marcas e modelos.

## Vercel

Obs: Antes de acessar o vercel, [acesse o link do Backend](https://52.67.153.18:8443/cars/all), para prosseguir com o aviso de segurança devido ao certificado autoassinado SSL gerado para o IP onde o Backend esta hospedado (instância EC2 AWS). Se não fizer esta parte o aplicativo ficara carregando, pois emitira um erro de certificado não confiável.\
Aplicação rodando no Vercel: [Cars](https://cars-fe.vercel.app/)

## Informações

O arquivo [data.sql](https://github.com/matheuselmadi/cars/blob/main/src/main/resources/data.sql) insere dados das tabelas.

É possivel utilziar o banco de dados em Memória H2 substituindo as informações no arquivo [application.properties](https://github.com/matheuselmadi/cars/blob/main/src/main/resources/application.properties):

Substitua as configurações Postgres:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5433/carros
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
```

Por:
```sh
spring.datasource.url=jdbc:h2:mem:carsdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=aaddmm
```

Adicione a linha nas configurações do Hibernate:
```sh
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

Para utilizar HTTPS crie um certificado e altere as configurações(ou remova-as caso nao for utilizar):
```sh
server.port=8443
server.ssl.enabled=true
server.ssl.key-store: /etc/ssl/certs/self-signed-cert.jks
server.ssl.key-store-password: aaddmm
server.ssl.key-alias: certificado2
server.ssl.key-store-type: JKS
```
Faça os ajustes na classe [CorsConfig](https://github.com/matheuselmadi/cars/blob/main/src/main/java/com/ws/cars/config/CorsConfig.java) com a URL de seu Frontend.

## Frontend

Frontend para consumo da api: [Cars-fe](https://github.com/matheuselmadi/cars-fe).
