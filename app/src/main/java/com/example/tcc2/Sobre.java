package com.example.tcc2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import mehdi.sakout.aboutpage.AboutPage;

public class Sobre extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription("Com a virtualização do mundo e aumento dos processos online é comum termos que criar usuários e senha em diversas plataformas. Infelizmente, não é possível utilizar sempre mesmo padrão de senha em todas as plataformas. " +
                        "Dependendo da conta que será criada é necessária certa forma de criação da senha, seja numérica, alfanumérica, com caracteres ou não, dentre outras formas. Com isso, não consideramos uma forma prática e confiável de armazenar esses dados, muitas das vezes gravamos na cabeça ou escrevendo num bloco de notas. " +
                        "Considerando o contexto anterior, o presente trabalho apresenta uma plataforma de armazenamento de dados, mais especificadamente contas, em um só lugar. A inserção dos dados é realizada por meio de uma aplicação WEB, é possível inserir dados um a um ou inserir por importação de uma planilha .xlsx. Logo após é realizado um tratamento por ETL que alimenta um banco de dados não relacional, MongoDB, a qual armazena os dados inseridos pelo usuário. " +
                        "E, finalizando, temos uma API que retornar os dados inseridos através da aplicação WEB para que sejam usados e mostrados no aplicativo mobile. ")

                .create();

        setContentView(view);
    }
}
