:::writing{variant=“standard” id=“12345”}

🚀 Finance AI API

API backend inteligente para gestão de despesas com classificação automática usando Inteligência Artificial.



💡 Funcionalidades

* ✅ Cadastro de despesas
* 🤖 Classificação automática com IA (OpenAI)
* 🔐 Autenticação JWT
* 🗄 Persistência com PostgreSQL
* 🐳 Dockerizado



🛠 Tecnologias

* Java 21
* Spring Boot
* PostgreSQL
* Docker
* OpenAI API
* JWT



📡 Endpoints

🔐 Login

POST /auth/login

💰 Criar despesa

POST /expenses

📋 Listar despesas

GET /expenses



▶️ Como rodar o projeto

./mvnw clean package
docker run postgres
java -jar target/*.jar

🧠 Diferencial

Este projeto utiliza Inteligência Artificial para classificar automaticamente despesas financeiras, simulando um cenário real de aplicação de IA em backend.



👨‍💻 Autor

Vinicius Alves
🔗 LinkedIn: https://linkedin.com/in/viniciusaj14
