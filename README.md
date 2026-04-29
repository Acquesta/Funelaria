# Funelaria

## Rodar docker
docker run -d --name postgres_container -e POSTGRES_USER=usuario_dev -e POSTGRES_PASSWORD=senha_dev -e POSTGRES_DB=meu_banco_de_dados -p 5432:5432 -v postgres_data:/var/lib/postgresql postgres:latest
