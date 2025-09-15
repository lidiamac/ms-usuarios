# ----------------------------
# 1ª ETAPA: Build da aplicação
# ----------------------------
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas arquivos de dependências para aproveitar cache
COPY pom.xml .
COPY src ./src

# Gera o jar final sem testes
RUN mvn clean package -DskipTests

# ----------------------------
# 2ª ETAPA: Imagem de produção
# ----------------------------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
