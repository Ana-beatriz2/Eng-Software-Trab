document.getElementById('pf_radio').addEventListener('click', function() {
  document.getElementById('pessoa_fisica_fields').style.display = 'block';
  document.getElementById('pessoa_juridica_fields').style.display = 'none';
});

document.getElementById('pj_radio').addEventListener('click', function() {
  document.getElementById('pessoa_fisica_fields').style.display = 'none';
  document.getElementById('pessoa_juridica_fields').style.display = 'block';
});