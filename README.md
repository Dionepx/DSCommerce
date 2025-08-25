📦 **DSCommerce**
Um projeto Java Spring Boot para simulação de um e-commerce backend, desenvolvido como parte do 
aprendizado em arquitetura em camadas, autenticação JWT e boas práticas de desenvolvimento.

🚀 **Tecnologias Utilizadas**

☕ Java 17+ 

🍃 Spring Boot (Web, Data JPA, Validation, Security, OAuth2, JWT)

🐘 PostgreSQL (produção) + H2 Database (testes)

🧩 Hibernate JPA

🔑 Spring Security + JWT

📦 Maven

🐙 Git/GitHub


⚙️ **Estrutura do Projeto**
com.bootcamp.DSCommerce
 ┣ 📂 config        
 ┣ 📂 controllers  
 ┣ 📂 dto           
 ┣ 📂 entities      
 ┣ 📂 repositories  
 ┣ 📂 services      
 ┣ 📂 exceptions    
 ┗ DsCommerceApplication.java 


 🔐 **Funcionalidades**
 
✅ CRUD de Users, Products e Categories

✅ Relacionamentos N-N (ex: Product ↔ Category)

✅ Sistema de pedidos (Order, OrderItem, Payment)


✅ Autenticação JWT com OAuth2 e refresh tokens

✅ Tratamento de erros com mensagens personalizadas (Validation, ResourceNotFound, Forbidden)

✅ Arquitetura em camadas (Controller → Service → Repository)


📖 **Aprendizados**
- Durante o desenvolvimento, pratiquei:
- Mapeamento objeto-relacional (JPA/Hibernate)
- Validações com Bean Validation
- Criação de DTOs para exposição segura de dados
- Configuração de autenticação e autorização com OAuth2/JWT
- Tratamento centralizado de exceções
- Aprendi a implementar autenticação com JWT e boas práticas de arquitetura em camadas.


▶️ **Como Rodar o Projeto**
1. Clonar o repositório
git clone https://github.com/seuusuario/DSCommerce.git
cd DSCommerce

2. Configurar o banco de dados
No arquivo application.properties, configure as credenciais do PostgreSQL ou use o H2 em memória para testes.

3. Rodar com Maven
./mvnw spring-boot:run

4. Acessar a API
H2 Console: http://localhost:8080/h2-console
, Endpoints REST: http://localhost:8080/products, http://localhost:8080/users

📌 **Próximos Passos**
- Implementar testes automatizados (JUnit/MockMvc)
- Configurar CI/CD no GitHub Actions
- Documentar API com Swagger/OpenAPI
