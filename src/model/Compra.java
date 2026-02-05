import java.time.LocalDateTime;


public class Compra {
    private int id_compra;
    private int id_usuario;
    private int id_item_compra;
    private LocalDateTime data_compra;


    public Compra() {
    }


    public Compra(int id_compra, int id_usuario, int id_item_compra, LocalDateTime data_compra) {
        this.id_compra = id_compra;
        this.id_usuario = id_usuario;
        this.id_item_compra = id_item_compra;
        this.data_compra = data_compra;
    }


    public int getId_compra() {
        return id_compra;
    }


    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }


    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public int getId_item_compra() {
        return id_item_compra;
    }


    public void setId_item_compra(int id_item_compra) {
        this.id_item_compra = id_item_compra;
    }


    public LocalDateTime getData_compra() {
        return data_compra;
    }


    public void setData_compra(LocalDateTime data_compra) {
        this.data_compra = data_compra;
    }


    


    

    
}
