package com.example.tcc2.ui.login;

public class PessoaObj {
    private String dsNome;
    private String dsSobrenome;
    private String dsSenha;
    private String dtNasc;
    private String dsCelular;
    private String dsCpf;
    private String cdUsu;
    private String email;

    public String getNome() {
        return dsNome;
    }

    public void setNome(String nome) {
        this.dsNome = nome;
    }

    public String getSobrenome() {
        return dsSobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.dsSobrenome = sobrenome;
    }


    public String getSenha() {
        return dsSenha;
    }

    public void setSenha(String senha) {
        this.dsSenha = senha;
    }

    public String getNascimento() {
        return dtNasc;
    }

    public void setNascimento(String nascimento) {
        this.dtNasc = nascimento;
    }

    public String getTelefone() {
        return dsCelular;
    }

    public void setTelefone(String telefone) {
        this.dsCelular = telefone;
    }

    public String getCpf() {
        return dsCpf;
    }

    public void setCpf(String cpf) {
        this.dsCpf = cpf;
    }

    public String getCdUsu() {
        return cdUsu;
    }

    public void setCdUsu(String cpf) {
        this.cdUsu = cpf;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}
