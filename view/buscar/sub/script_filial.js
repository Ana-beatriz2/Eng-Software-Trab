function search() {
    // Simulação de pesquisa - substitua isso com lógica real de pesquisa
    const searchTerm = document.getElementById('searchInput').value;
    const resultsDiv = document.getElementById('results');

    // Limpar resultados anteriores
    resultsDiv.innerHTML = '';

    // Exibir resultados de exemplo
    const exampleResults = ['Rio de Janeiro -> Maria da Graça', 'São Paulo -> Vila Maria', 'Paraná -> Curitiba'
    , 'Minas Gerais -> Belo Horizonte', 'Rio Grande do Sul -> Porto Alegre', 'Santa Catarina -> Florianópolis'];
    exampleResults.forEach(result => {
        const resultElement = document.createElement('p');
        resultElement.textContent = result;
        resultsDiv.appendChild(resultElement);
    });
}