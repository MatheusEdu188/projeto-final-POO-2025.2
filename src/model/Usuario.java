public class Usuario {
    private int id_usuario;
    private String nome;
    private String senha;
    private String cpf;


    public Usuario(){}


    public Usuario(int id_usuario, String nome, String senha, String cpf) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }


    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
