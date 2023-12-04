function submitPayment() {
    const amount = document.getElementById("amount").value;
    const paymentMethod = document.getElementById("payment-method").value;
    const isDriver = document.querySelector('input[name="is-driver"]:checked').value;
    const creditCardDetails = document.getElementById("credit-card-details");
    document.getElementById("credit-card-details").classList.add("hidden");
    document.getElementById("driver-details").classList.add("hidden");
    // Oculta todos os detalhes específicos antes de avaliar a escolha do usuário

    if (paymentMethod === "credit-card") {
        creditCardDetails.style.display = "flex";
    } else if (paymentMethod === "pix" || paymentMethod === "cash") {
        creditCardDetails.style.display = "none";
    }
}

function isMotorista() {
    const isDriver = document.querySelector('input[name="is-driver"]:checked').value;
    const driverDetails = document.getElementById("driver-details");
    if(isDriver === "yes"){
        driverDetails.style.display = "none";
    }
    else{
        driverDetails.style.display = "flex";
        alert("Favor, cadastrar o motorista!");
    }
}

function onClickPayment(){
    alert("Pagamento registrado com sucesso!");
}