public class ItemCompra {
    private int id_item_compra;
    private int quantidade;
    private double preco;
    private int id_produto;


    public ItemCompra() {
    }


    public ItemCompra(int id_item_compra, int quantidade, double preco, int id_produto) {
        this.id_item_compra = id_item_compra;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id_produto = id_produto;
    }


    public int getId_item_compra() {
        return id_item_compra;
    }


    public void setId_item_compra(int id_item_compra) {
        this.id_item_compra = id_item_compra;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getId_produto() {
        return id_produto;
    }


    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }



    
    


}
