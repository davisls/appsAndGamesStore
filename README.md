# Store for Games and Apps

Este é um projeto para avaliação da matéria "Programação Web II" do curso de formnação dev_makers2 realizado pela AdaTech

## Escopo do Projeto

Neste projeto teremos 4 entidades que relacionam entre si, elas são: User, Application, Game e Library.
A ideia do projeto é simular uma loja de apps e jogos, porém, ele não contemplará a parte de pagamento, neste projeto simularemos que todas as aplicações são gratuitas.

### Esquema Relacional do Projeto:

![image](https://user-images.githubusercontent.com/98597951/229142347-d453ff84-df96-494c-b5bb-baafd68ea35c.png)

### Features do projeto

- Teremos dois tipos de usuários, um que será do tipo CREATOR e este poderá cadastrar jogos e aplicativos, enquanto o outro não terá acesso à essas criações e apenas conseguirá resgatar as aplicações para a sua biblioteca.

- Teremos alguns tipos de listagem, como filtrar os jogos ou aplicativos por uma categoria ou por um criador em específico.

- Teremos a entidade Library que contemplará a listagem de todos os jogos e aplicativos de um determinado usuário.

- O vínculo do creator com os jogos e aplicativos se dará por meio do token JWT.

- (Esta não é garantida mas se sobrar um tempo irei implementar) Existira um campo "Friends" nos usuários onde eles poderão adicionar ou remover amigos e também ver as bibliotecas deles.

- Toda a aplicação será protegida via token JWT.
