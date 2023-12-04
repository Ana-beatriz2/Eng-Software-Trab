/*const formElement = document.getElementById('login-form');

formElement.addEventListener('submit', event => {
    event.preventDefault();

    const formData = new FormData(formElement);
    const data = Object.fromEntries(formData);

    fetch('https://reqres.in/api/users', {
       method: 'POST',
       headers: {
           'Content-Type': 'application/json'
       },
         body: JSON.stringify(data)
    }).then(response => response.json()).then(data => {console.log(data)})
})*/