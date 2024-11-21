package br.com.wavebox.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String senha; // Mantenha o nome como 'senha' se for assim que você está usando

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha; // Certifique-se de que este é o método correto
    }

    public void setSenha(String senha) {
        this.senha = senha; // Certifique-se de que este é o método correto
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    // Adicione métodos para getPassword e setPassword se necessário
    public String getPassword() {
        return senha; // Retorna a senha
    }

    public void setPassword(String senhaCriptografada) {
        this.senha = senhaCriptografada; // Define a senha criptografada
    }
}