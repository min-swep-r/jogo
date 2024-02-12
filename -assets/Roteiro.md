<p><a target="_blank" href="https://app.eraser.io/workspace/r0Ycd1dM9fH9k5vtRZ8n" id="edit-in-eraser-github-link"><img alt="Edit in Eraser" src="https://firebasestorage.googleapis.com/v0/b/second-petal-295822.appspot.com/o/images%2Fgithub%2FOpen%20in%20Eraser.svg?alt=media&amp;token=968381c8-a7e7-472a-8ed6-4a6626da5501"></a></p>

### CHECKPOINT 1 –
- [x] Projeto: Crie um diagrama de classe que inclua as principais classes, atributos e métodos. 
- [x] Projeto: Identifique as classes do jogo Campo Minado. 
- [x] Projeto: Identifique os atributos de cada classe. 
- [x] Projeto: Identifique os métodos de acesso dos atributos quando aplicável, incluindo as validações e restrições necessárias.
Ex: public void setColuna(int coluna) { if(coluna >= 0 && coluna < 7) {this.coluna = coluna;}} 
- [x] Projeto: identifique os demais métodos nas diferentes classes criadas. 
- [x] Projeto: Crie um diagrama de classe que inclua todas as classes, atributos e métodos identificados. 
- [x] Projeto: Implemente o código do diagrama criado que represente o clique do usuário numa célula.
Vou dar uma implementada no I/O, para ficar melhor exibido. 

---

### CHECKPOINT 2 –
> Não sei se era o mais correto, mas antes de implementar a herança e o POO no jogo, resolvi deixar o jogo... Jogável!

- [x] Projeto: considerando que uma célula pode ser bomba, vizinha a bomba ou espaço vazio, expanda a classe utilizada para representar cada célula do tabuleiro utilizando o conceito de herança. 
![Figure 1](/.eraser/r0Ycd1dM9fH9k5vtRZ8n___ibsr7NFOmZXGn92bwac608CiSpo2___---figure---_eUfZ5QGyi3kLeZwmqhMY---figure---E1WrAk5PUvAwcqRu-Y96AQ.png "Figure 1")

> Certo, acho que aqui está realmente dificil pra implementar.

- [x] Projeto: Inclua no diagrama de classes, as classes para comunicação com o usuário e que permitirão a execução do jogo. 
- [x] Projeto: permita que o usuário marque uma célula fechada com bandeira (candidata a ter bomba). Células marcadas com bandeira não podem ser abertas se a bandeira não for retirada antes. 
> acabou que aqui eu dei uma pulada, ao tentar lançar o I/O

- [ ] Projeto: ao abrir uma célula que não tem bomba na vizinhança, todas suas células vizinhas devem ser abertas de maneira sucessiva. 
- [ ] Projeto: Implemente o código do diagrama atualizado que seja necessário para que 2 usuários consigam interagir. 
- [ ] Projeto: separe as classes do jogo em pacotes (ao menos dois) 
- [ ] Projeto: revise o código e verifique o nível de encapsulamento de cada classe e se as boas práticas estão sendo respeitadas.
---

### CHECKPOINT 3 –
- [ ] Projeto: crie uma alternativa ao Campo Minado chamada Campo Minado Maluco. Em Campo Minado Maluco, uma célula pode ser ou não maluca. Quando a célula for maluca, o jogador ao marcar a célula como bomba colocando uma bandeira, a célula poderá alterar seu status de bomba com uma probabilidade determinada pelo nível de maluquice do jogo.
 Obs: pense em alguma estratégia para que os vizinhos da célula maluca sejam devidamente notificados para quando abertos exibirem corretamente o número de bombas ao seu redor caso a célula maluca tenha seu status de bomba alterado.
- [ ] Projeto: identifique quais classes podem ser abstratas e faça a devida alteração. 
- [ ] Projeto: adicione uma interface para aumentar o desacoplamento da classe que representa o tabuleiro da classe que representa o jogo. 
- [ ] Projeto: inclua uma classe que represente uma exceção de valor de atributo inválido. Esta classe deve ser capaz de receber em seu construtor uma String que represente uma mensagem associada à situação de exceção eventualmente ocorrida. 
- [ ] Projeto: identifique exceções para cada método set ao verificar se o valor passado para preenchimento é aceitável, e outras possíveis exceções do jogo. 
- [ ] Projeto: Atualize o diagrama de classes considerando diferentes tamanhos de tabuleiro e quantidade de bombas para os níveis inicial, intermediário e difícil. 
- [ ] Projeto: Implemente o diagrama completo dando o tratamento adequado para conseguir o comportamento esperado.
### 
---

### CHECKPOINT 4 – Final Breakthroug
- [ ] Projeto: implemente a informação de recorde do jogo exibindo pelo menos os 10 maiores vencedores. 
- [ ] Projeto: implemente a interface gráfica do jogo.
---




<!--- Eraser file: https://app.eraser.io/workspace/r0Ycd1dM9fH9k5vtRZ8n --->