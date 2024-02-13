// $(function(){
//     alert("Olá");
// })

$(function(){
    let produtos = getArrayStorage();
    produtos.forEach(prod =>{
        $('#tbProdutos tbody').append(novaTr(prod.nome,prod.preco));
    });

    $('#btAdicionar').click(function(e){
        e.preventDefault();
        novoProdutoTable();
    })
    calcularTotal();
    util();
})

const novoProduto = ()=>{
    const produto ={
        nome:$('#txtProduto').val(),
        preco:$('#txtPreco').val()
    }

    return produto;
}

function novaTr(nome, preco){
    const tr =`
        <tr>
            <td>${nome}</td>
            <td class="cValor">${preco}</td>
            <td><a href="#" onclick="excluirProdutos(this, event)">
                    <i class="fa fa-2x fa-times-rectangle text-dark"></i>
                </a>
            </td>
        </tr>

    `
    return tr;
}

function novoProdutoTable(){
    let produto = novoProduto();
    $('#tbProdutos tbody').append(novaTr(produto.nome, produto.preco));
    carregarProdutoTable();
    calcularTotal();
    util();
}

function carregarProdutoTable(){
    let produtos = [];
    $('#tbProdutos tbody tr').each(function(){
        let coluna = $(this).children();
        let produto ={
            nome: $(coluna[0]).text(),
            preco:$(coluna[1]).text()
        }
        produtos.push(produto);
        localStorage.setItem('listaProdutos', JSON.stringify(produtos));
    })
}


function getArrayStorage(){
    return JSON.parse(localStorage.getItem('listaProdutos'))||[];
}

function excluirProdutos(element, e){
    e.preventDefault();
    let tr = $(element).parents('tr');
    $(tr).remove();
    carregarProdutoTable();
    calcularTotal();
    util();
}

function calcularTotal(){
    let total = 0;
    $("#tbProdutos tbody tr").each(function(index, tr){
        let preco = Number($(this).children('td[class="cValor"]').text());
        total += preco;
    })
    $('#total').text(total);
}


function util(){
    if($('#tbProdutos tbody tr').length === 0){

        $('#tbProdutos').hide();
        $('#container-total').hide();
        $('#container-vazio').show();
    }else{

        $('#tbProdutos').show();
        $('#container-total').show();
        $('#container-vazio').hide();
    }
}