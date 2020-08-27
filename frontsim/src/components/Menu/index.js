import React from 'react'
import './styles.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import organize from 'images/organize.jpeg';

export default function MenuCpt() {
    return (
        
        <nav class="navbar navbar-expand-lg itens" id="organize">
        <img src={organize} class="navbar-brand logo"></img>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav itens">
            <a class="nav-item nav-link active" href="#home_home">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#home_sim">SIM</a>
            <a class="nav-item nav-link" href="#home_planos">Planos</a>
            <a class="nav-item nav-link" href="#home_contatos">Contatos</a>
            <a class="nav-item nav-link"></a>
            <a class="nav-item nav-link" href="#">Startup</a>
            <a class="nav-item nav-link" href="#">Login</a>
            <a class="nav-item nav-link" href="#">Cadastro</a>

          </div>
        </div>
      </nav>
    )
}