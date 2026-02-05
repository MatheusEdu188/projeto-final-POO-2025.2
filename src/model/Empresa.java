public class Empresa {
    private int id_empresa;
    private String nome;
    private String cnpj;

    public Empresa(){};

    public Empresa(int id_empresa, String nome, String cnpj) {
        this.id_empresa = id_empresa;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}