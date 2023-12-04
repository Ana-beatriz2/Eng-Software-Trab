function search() {
    // Simulação de pesquisa - substitua isso com lógica real de pesquisa
    const searchTerm = document.getElementById('searchInput').value;
    const resultsDiv = document.getElementById('results');

    // Limpar resultados anteriores
    resultsDiv.innerHTML = '';

    // Exibir resultados de exemplo
    const exampleResults = ['José', 'Pedro', 'João', 'Guilherme', 'Coimbra', 'Nuvem', 'Gabriel Barbosa'];
    exampleResults.forEach(result => {
        const resultElement = document.createElement('p');
        resultElement.textContent = result;
        resultsDiv.appendChild(resultElement);
    });
}