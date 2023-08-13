const btnEscuro = document.getElementById('btnEscuro');
const btnClaro = document.getElementById('btnClaro');

btnEscuro.addEventListener('click', checkedRadio);
btnClaro.addEventListener('click', checkedRadio);

const cssTheme = document.getElementById('color-theme');

function lightToDark() {
    cssTheme.href = "./src/css/color_dark.css";
}

function darkToLight() {    
    cssTheme.href = "./src/css/color_light.css";
}

function checkedRadio() {
  if (btnClaro.checked) {
    darkToLight();
  } else  {
    lightToDark();
  }
}

function checkUserPreference() {
  const prefersLightTheme = window.matchMedia('(prefers-color-scheme: light)').matches;

  if (prefersLightTheme) {
    btnEscuro.checked = false;
    btnClaro.checked = true;
  } else {
    btnClaro.checked = false;
    btnEscuro.checked = true;
  }
  checkedRadio() 
}

checkUserPreference();


const navIco = document.querySelector('#nav-icon1');

navIco.addEventListener('click', function() {
    navIco.classList.toggle('open');
  });

