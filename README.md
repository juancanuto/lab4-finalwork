# LAB4-FINAL WORK
  
    Adriano Mota e Souza
  
    André Maurilio
  
    Juan Canuto Hassam
  
## Nome do grupo
    Grupo 03

## Configurações do projeto
  ### Importando o projeto do repositório
    1 - Escolha ou crie uma nova pasta onde o projeto será armazenado.
    2 - Escolha um console de sua escolha, recomendamos o "gitbash".
    3 - No console, navegue até a pasta anteriormente definida para armazenamento do projeto.
    4 - Execute o comando: git clone https://github.com/juancanuto/lab4-finalwork.git;
    5 - Após ter baixado o projeto, importe-o para uma IDE de sua escolha, recomendamos o eclipse ou o STS(Um eclipse customizado pelo hibernate).
  ### Execução de comandos MAVEN no console
    1 - No console navegar até a pasta do projeto e executar os seguintes comandos
        -mvn clean install
        -mvn liquibase:update
 
  ### Configuração do banco de dados:
    Para este projeto foi escolhido o banco de dados MySQL utilizando-se o cliente MySQL Workbench para acesso ao mesmo.
    1 - Baixar e instalar o software cliente MySQL Workbench para acesso ao banco de dados Mysql.
    2 - Abrir o MySQL Workbench e criar um novo banco de dados chamado "lab04db".
    3 - Criar um usuário chamado "lab04db" como a senha definida como "lab04db", pois estas configurações já estão definidas no   arquivo "Application.properties" e "liquibase.properties" do projeto. 
    Obs: As configurações de usuario e senha definadas nos arquivos "Application.properties" e "liquibase.properties" têm que ser as mesmas das definições de usuário e senha do mysql. 
    4 - Ir até a aba "Schema Privileges" do usuário "lab04db" anteriormente criado e clicar no botão "Add Entry", selecionar "Select ALL" para definir todas as permissões e em seguida confirmar as alterações clicando no botão "Apply".

  ### Rodar os seguintes comandos no mysql workbench
    ALTER USER 'lab04db' IDENTIFIED WITH mysql_native_password BY 'lab04db';
    SET GLOBAL sql_mode=''
    
    OBS: Este comando se faz necessário pois ao subir aplicação uma excessão é gerada impedindo o bom funcionamento do projeto.
    ---------------------------------------------------------------------------------------------------------------------------
    
    
