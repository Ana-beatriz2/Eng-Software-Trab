function goToSearch() {
    const vehicleType = document.getElementById('vehicleType').value;
    if (vehicleType === 'filial') {
        window.location.href = 'sub/filial.html';
    } else if (vehicleType === 'locacao_veiculo') {
        window.location.href = 'sub/locacao_veiculo.html';
    } else if (vehicleType === 'motorista') {
        window.location.href = 'sub/motorista.html';
    } else if (vehicleType === 'usuario') {
        window.location.href = 'sub/user.html';
    } else if (vehicleType === 'veiculo') {
        window.location.href = 'sub/veiculo.html';
    }
}