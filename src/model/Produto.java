public class Produto {
    private int id_produto;
    private int quantidade_estoque;
    private String nome;
    private double preco;
    private String categoria;
    private int id_empresa;

    public Produto(){};

    public Produto(int id_produto, int quantidade_estoque, String nome, double preco, String categoria, int id_empresa) {
        this.id_produto = id_produto;
        this.quantidade_estoque = quantidade_estoque;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.id_empresa = id_empresa;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    

    
}
