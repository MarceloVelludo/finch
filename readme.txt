Essa é uma aplicação web que utiliza spring boot e MongoDb.
Para gerar as configurações iniciais do projeto foi utilizado o spring initializr com as seguintes configurações:
-Maven Project
-Java 8
-Spring Boot 2.2.7

Para rodar a aplicação primeiramente instale o mongoDb e em seguida inicie ele, no linux basta abrir o terminal e digitar mongod.
Após instalar e rodar o mongoDb, clone o projeto e importe na IDE de sua preferência.

Abaixo segue a lista de ingredientes que devem ser adicionados no banco de dados para a aplicação funcionar(Obs: não foi feito tratamento para verificar duplicidades no banco e pode gerar falhas na aplicação.):

-utilizando o método post e o seguinte caminho: localhost:8081/ingredients/saveAll
- Descrição: esse método adiciona na base de dados uma lista de Ingredientes
[{
    "name": "Alface",
	"price": 0.40

},
{
    "name": "Bacon",
	"price": 200

},
{
    "name": "Hamburguer",
	"price": 3.00

},
{
    "name": "Ovo",
	"price": 0.80

},
{
    "name": "Queijo",
	"price": 1.50

}
]

-ainda é possivel utilizar os seguintes caminhos conjuntamente com "/ingredients":
 Método - Caminha - Descrição
 - Get  - "/all" : Retorna todos os ingredients do banco.
 - Get  - "/ByName/{name}": Retorna o ingredient com o nome.
 - Post - "/save": Salva ou atualiza um ingredient.
 - Post - "/saveAll": Salva ou atualiza uma lista de ingredients.
 - Delete - "/delete/{id}": Deleta um ingrediente pelo id.

- Com o caminho "/price" é possivel acessar os seguintes métodos:
Método - Caminha - Descrição
-Get   - "/calcPrice" :  Calcula o preço final apartir de uma lista de nomes dos ingredientes previamente inseridos no Banco.


Algumas considerações sobre o projeto:

Por falta de tempo, considerei que os lanches ja vinham separados em ingredientes. Considerei também que a lista de ingredientes
exibida previamente seria adicionada ao banco de dados antes do método calculo seja chamado,e não fiz tratamentos para
verificar questões de integridade no banco de dados.
Como o valor dos ingredientes sempre é pego do banco de dados, considerei que o problema de inflação foi resolvido pois a api possui métodos
para fazer o update dos dados.
A lôgica das promoções é simplesmente uma checagem em uma lista de ingredientes, a implementação pode ser vista em PriceServiceImpl.
A Implementação dos serviços com os ingredients podem ser vistas em IngredientServiceImpl.
