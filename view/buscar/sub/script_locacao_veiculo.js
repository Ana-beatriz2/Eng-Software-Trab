function search() {
    // Simulação de pesquisa - substitua isso com lógica real de pesquisa
    const searchTerm = document.getElementById('searchInput').value;
    const resultsDiv = document.getElementById('results');

    // Limpar resultados anteriores
    resultsDiv.innerHTML = '';

    // Exibir resultados de exemplo
    const exampleResults = ['Ana -> Gol 1.0', 'Gustavo -> Civic', 'Sarah -> Virtus', 'João -> Onix', 'Maria -> HB20', 'Pedro -> Celta', 'Lucas -> Palio', 'Mariana -> Uno', 'Gabriel -> Fusca', 'Rafael -> Fiesta', 'Larissa -> Celt'];
    exampleResults.forEach(result => {
        const resultElement = document.createElement('p');
        resultElement.textContent = result;
        resultsDiv.appendChild(resultElement);
    });
}