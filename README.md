# ITAU-CATS



##Documentação do projeto 
####Estrutura do projeto 
MVC com Clean Architeture dividido entre os pacotes Controller, Mapper, Model, Service e VO
Banco de dados PostgreSQL

###Tecnologias Usadas
- Java 11
- Spring Boot 2.3.4
- Spring Admin Client
- Gradle
- PostgeSQL 

###Documentação das APIs 
`GET cats/load`

Endpoint que busca na CatsApi para preencher o banco com um elemento
##### Response 
       {
         "id": 1,
         "name": "Abyssinian",
         "origin": "Egypt",
         "temperament": "Active, Energetic, Independent, Intelligent, Gentle"
       }
       
`POST cats/breed`

Endpoint que cria um uma raça

#### Request
       {
         	"name":"Arroz",
         	"origin": "batata",
         	"temperament":"bahia",
         	"photoWithHatList":["asda","asdasd"],
         	"photoWithSunglassList":["basad","asdasd"]
      }

##### Response 
       {
         "id": 1,
         "name": "Abyssinian",
         "origin": "Egypt",
         "temperament": "Active, Energetic, Independent, Intelligent, Gentle"
       } 
       
`GET /breed/{breedId}`

Endpoint que traz todos os dados de uma raça
##### Response 
      {
         "id": 1,
         "name": "Abyssinian",
         "origin": "Egypt",
         "temperament": "Active, Energetic, Independent, Intelligent, Gentle"
      }     
       
`GET cats/breed`

Endpoint que lista todas as raças
##### Response 
       {
         "id": 1,
         "name": "Abyssinian"
       }
       
       
 `GET /cats/temperament/{temperamentName}`
 
 Endpoint que busca as raças filtrando por temperamento
##### Response 
        [
          {
             "id": 1,
             "name": "Abyssinian"
           }
        ]
               
               
`GET cats/origin/{originName}`

 Endpoint que busca as raças filtrando por origem 
##### Response 
        [
              {
                  "id": 1,
                  "name": "Abyssinian"
              }
          ]

### Documentação de como podemos subir uma cópia deste ambiente localmente
##### Estando dentro da pasta do projeto rodar os seguintes comandos
- ./gradlew assemble
- docker-compose up --build

