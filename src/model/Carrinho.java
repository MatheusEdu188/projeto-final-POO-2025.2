package model;

public class Carrinho {

    private int id_carrinho;
    private String status;
    private int id_usuario;


    public Carrinho() {
    }


    public Carrinho(int id_carrinho, String status, int id_usuario) {
        this.id_carrinho = id_carrinho;
        this.status = status;
        this.id_usuario = id_usuario;
    }


    public int getId_carrinho() {
        return id_carrinho;
    }


    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    

    
    
}
