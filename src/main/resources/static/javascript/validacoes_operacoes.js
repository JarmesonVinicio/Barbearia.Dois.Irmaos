    //global
    const cabelo = document.getElementById("cabelo");
    const barba = document.getElementById("barba");
    const sobrancelha = document.getElementById("sobrancelha");
    const hidratacao = document.getElementById("hidratacao");
    const tintura = document.getElementById("tintura");

function validarServicos() {
    // Verificar se nenhum checkbox foi selecionado
    if (!cabelo.checked && !barba.checked && !sobrancelha.checked && !hidratacao.checked && !tintura.checked) {
        alert("Por favor, selecione pelo menos um serviço.");
        return false; // Impede o envio do formulário
    }

    return true; // Permite o envio do formulário
}


//MÉTODO VERIFICADOR DE QUANTIDADE E PRECO UNITÁRIO QUE NÃO PODEM SER MENOR DO QUE ZERO
function impedirValoresNegativos() {
    let quantidade = document.getElementById("quantidade");
    let precounitario = document.getElementById("precounitario");
    
    let q = parseInt(quantidade.value);
    let p = parseInt(precounitario.value);
    console.log(q);
    console.log(p);
    
    
    if(q < 0 || p <= 0){ //quantidade não pode ser valor negativo e preco não pode ser zero e nem negativo
        alert("Quantidade não pode ter valor menor do que zero\nPreço unitário não pode ter valor menor ou igual a zero");
        return false; // Impede o envio do formulário
    }
    return true; // Permite o envio do formulário
}    


function calcularValor(){
    let valorCabelo = 0;
    let valorBarba = 0;
    let valorSobrancelha = 0;
    let valorHidratacao = 0;
    let valorTintura = 0;
    
    console.log(cabelo); // Isso vai mostrar o elemento no console
    if(cabelo && cabelo.checked){
        valorCabelo = 20;
        alert("marcado cabelo");
    }
    if(barba && barba.checked){
        valorBarba = 10;
    }
    if(sobrancelha && sobrancelha.checked){
        valorSobrancelha = 5;
    }
    if(hidratacao && hidratacao.checked){
        valorHidratacao = 30;
    }
    if(tintura && tintura.checked){
        valorTintura = 20;
    }
    
    let valorTotal = valorCabelo + valorBarba + valorSobrancelha + valorHidratacao + valorTintura;
//    alert("VALOR TOTAL É: " + valorTotal);
    
    // Atualiza o valor do campo de texto
    let campoValorTotal = document.getElementById("valorTotal");
    if (campoValorTotal) {
        campoValorTotal.value = `R$ ${valorTotal.toFixed(2)}`;
    }
    
}







