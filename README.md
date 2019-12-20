# DesafioBackend/xy-inc

Uma API Restul designada para fornecer uma plataforma inteligente para localização de Pontos de interesse(POIs) por receptores GPS.

## Describtion
O projeto é baseado em serviços de:
* Cadastro dos pontos de interesse por nome e coordenadas
* Listagem dos pontos de interesse cadastrados
* Listagem dos POIs próximos a uma coordenada passada como ponto de
  referência juntamente com uma distância máxima de busca
## Build with

* [SpringBoot](https://start.spring.io/) - The web framework used
* [Gradle](https://gradle.org/) - Build Tool Dependency Management
* [MongoDB](https://www.mongodb.com/) - Used to Database

### Prerequisites

* Ter o MongoDB instalado
* IntelliJ IDEA instalado
* Importações necessárias do build Gradle do projeto

### Installing

Clone o projeto xy-inc copiando a url para o seu terminal após ter criado uma pasta para o projeto
```sh
https://github.com/Henriqw3/xy-inc.git
```
Ou faça o dowload do repositório
Importe o projeto para o IntelliJ como modelo Gradle Project externo
<br/>
Após importar dependências,  Run: DeviceplatformApplication.kt

### Running Tests:
- Portas para teste dos 3 serviços:<br/>
```http://localhost:8080/interestpoint/addpoints``` - Criação do ponto de interesse <br/>
```http://localhost:8080/interestpoint/listofpoint``` - lista todos os pontos criados <br/>
```http://localhost:8080/interestpoint/approximatepoints?x=10&y=13&distance=5``` - lista todos os pontos próximos a coordenada <br/>

## Knowledge Used

* `https://play.kotlinlang.org/byExample/overview` - [Learn Kotlin Programming](https://play.kotlinlang.org/byExample/overview)
* `https://felipetoscano.com.br/visao-geral-do-mongodb/`- [MongoDB Overview](https://felipetoscano.com.br/visao-geral-do-mongodb/)
* `https://docs.gradle.org/current/userguide/userguide.html` - [Gradle manual](https://docs.gradle.org/current/userguide/userguide.html)
* [Inicialização Spring com MongoDB](https://medium.com/mariano-z-lopez/painless-spring-boot-tutorial-with-maven-kotlin-mongodb-18c11a08aaae)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

