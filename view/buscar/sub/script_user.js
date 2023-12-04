function search() {
    // Simulação de pesquisa - substitua isso com lógica real de pesquisa
    const searchTerm = document.getElementById('searchInput').value;
    const resultsDiv = document.getElementById('results');

    // Limpar resultados anteriores
    resultsDiv.innerHTML = '';

    // Exibir resultados de exemplo
    const exampleResults = ['Ana', 'Gustavo', 'Sarah', 'João', 'Maria', 'Pedro', 'Lucas', 'Mariana', 'Gabriel', 'Rafael', 'Larissa', 'Julia', 'Fernanda',];
    exampleResults.forEach(result => {
        const resultElement = document.createElement('p');
        resultElement.textContent = result;
        resultsDiv.appendChild(resultElement);
    });
}