# Demo
Plataforma de E-commerce desenvolvida para exercício da matéria de Programação Orientada à objetos do <i>Centro Universitário do Pará</i>(<b><i>CESUPA</i></b>). Essa plataforma possui ligações com uma interface gráfica e arquivos CSV -usados para o transporte das informações submetidas pelo usuário para uma planilha, podendo ser aberta no programa EXCEL-, com o objetivo de melhorar a experiência do usuário com o software. 
<hr>
<h1>Tutorial</h1>
Quando o porgrama for executado, você vai se deparar com uma tela em que você terá que escolher o que deseja gerenciar. Após sua decisão, abrirá a tela de gerenciamento da opção escolhida que contém a lista de produtos/clientes/pedidos registrados no sistema.
<br><br>
Cada interface gráfica possui 4 botões que possuem funções de: <b>adicionar</b>, <b>editar</b>, <b>excluir</b> e <b>voltar ao menu principal</b> (exceto pedidos que não pode editar)
<br><br>

<h2>Botão de adicionar:</h2> 
Este botão tem a função de adicionar um novo objeto à lista(cliente/produto/pedido). Quando acionado, você precisa inserir os valores que são pedidos como nome, id, valor, endereço, etc.
<br><br>

<b>✅Adicionando um Cliente:</b>
<br>
Nome: nome do cliente(String). Ex: "João"<br>
Endereço: Endereço do cliente(String). Ex: "Av. Nazaré, 518"<br>
Cpf do cliente: CPF em que o cliente será registrado(somente números, sem pontos ou traços). Ex: "12345678910"<br>
Saldo: Saldo da conta do cliente (Somente números). Ex: "150" ou "150.5"
<br>
<br>

<b>✅Adicionando um Produto:</b>
<br>
Nome: O produto(Entrada do tipo String). Ex: "Sabonete"<br>
Preço: preço de uma unidade do produto(Somente números). Ex: "2.50"<br>
Quantidade: quantidade do produto (Somente números). Ex: "10"<br>
ID: código de identificação do porduto(somente números). Ex: "123"
CPF: CPF do vendedor é um cpf de alguém que foi registrado como cliente.
<br>
<br>

<b>✅Adicionando um Pedido:</b>
<br>
CPF do cliente: CPF de algum cliente já cadastrado.
ID do produto: ID do produto a ser comprado(produto que já tenha sido registrado)
ID do pedido: Código de indentificação do pedido. Ex: "10"<br>
Quantidade: Quantidade que quer comprar do produto informado(somente números). Ex: "12"

<h2>Botão de Editar:</h2> 
Este botão tem a função de editar um objeto já cadastrado anteriormente na lista(cliente/produto/pedido). Quando acionado, você precisa inserir o valor pedido para que consiga acessar a edição do objeto.
<br><br>

<b>📋Editando um Cliente:</b>
<br>
CPF do cliente: CPF em que o cliente foi registrado(Somente números, sem pontos ou traços). Ex: "123.456.789-10"<br>
<b><i>...Selecionando o que deseja alterar...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja editar, é só colocar a informação atualizada e confirmar
<br><br>

<b>📋Editando um Produto:</b>
<br>
ID do produto: ID em que o produto foi registrado(Somente números). Ex: "123"<br>
<b><i>...Selecionando o que deseja alterar...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja editar, é só colocar a informação atualizada e confirmar
<br><br>

<h2>Botão de Excluir:</h2> 
Este botão tem a função de exluir um objeto já cadastrado anteriormente na lista(cliente/produto/pedido). Quando acionado, você precisa inserir o valor pedido para que consiga excluir o objeto desejado.
<br><br>

<b>❌Excluindo um Cliente:</b>
<br>
CPF do cliente: CPF em que o cliente foi registrado(Somente números, sem pontos ou traços). Ex: "123.456.789-10"<br>
<b><i>...Confirmar se realmente que excluir este cliente...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja, é só esperar pelo aviso de cliente deletado e verificar a lista.
<br><br>

<b>❌Excluindo um Produto:</b>
<br>
ID do produto: ID em que o produto foi registrado(Somente números). Ex: "123"<br>
<b><i>...Confirmar se realmente que excluir este produto...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja, é só esperar pelo aviso de produto deletado e verificar a lista.
<br><br>

<b>❌Excluindo um Pedido:</b>
<br>
ID do pedido: ID em que o produto foi registrado(Somente números). Ex: "123"<br>
<b><i>...Confirmar se realmente que excluir este pedido...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja, é só esperar pelo aviso de pedido deletado e verificar a lista.
<br><br>

<h2>Botão de Importar:</h2> 
Este botão importa um cliente do arquivo CSV e cria um cliente na interface.
<br>
CPF do cliente: CPF em que o cliente foi cadastrado (Somente números). Ex: "12345678910"<br>
<b><i>...Confirmar se realmente que foi cadastrado o cliente...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja, é só esperar pelo aviso de pedido deletado e verificar a lista.
<br><br>


<br><br>

<h2>Botão de Exportar:</h2> 
Este botão exporta os dados do cliente selecionado,por CPF, para o arquivo CSV do objeto. 
<br>
CPF do cliente: CPF em que o cliente foi cadastrado (Somente números). Ex: "12345678910"<br>
<b><i>...Confirmar se realmente que foi cadastrado o cliente...</i></b>
<br>
<b><i>Depois</i></b> de selecionar a opção que deseja, é só esperar pelo aviso de pedido deletado e verificar a lista.
<br><br>

<hr>

<h1>Desenvolvido por:</h1> <h3>Carlos Sandro Gonçalves, Giovanni Gomes, Carolline Mello, Ana Luiza Souto</h3>
