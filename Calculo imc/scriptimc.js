function calcularImc() {
    var alturaInput = document.getElementById("altura");
    var pesoInput = document.getElementById("peso");
    var imcInput = document.getElementById("imc");
    var altura = alturaInput.value;
    var peso = pesoInput.value;
    var valor = 0;
    if( altura > 0 && peso > 0){
    valor = peso/(altura*altura);
    imcInput.value = parseFloat(valor.toFixed(2));
    }
    else
    {
        alert("Valores inválidos");
    }
}