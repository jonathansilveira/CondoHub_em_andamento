package _01_Classes;

public class ModelProp {

    // Variáveis de instância que armazenam os dados da propriedade
    int id;
    private String nome, endereco, cep, cpf, tipo, tamanho, vila_cidade, agrotoxico;

    // Construtor padrão (sem parâmetros)
    public ModelProp() {
    }

    // Construtor com parâmetros para inicializar as variáveis de instância
    public ModelProp(int id, String nome, String endereco, String cep, String cpf, String tipo, String tamanho, String vila_cidade, String agrotoxico) {
        this.nome = nome; // Inicializa o nome da propriedade
        this.endereco = endereco; // Inicializa o endereço da propriedade
        this.cep = cep; // Inicializa o CEP da propriedade
        this.cpf = cpf; // Inicializa o CPF relacionado à propriedade
        this.tipo = tipo; // Inicializa o tipo da propriedade
        this.tamanho = tamanho; // Inicializa o tamanho da propriedade
        this.vila_cidade = vila_cidade; // Inicializa a vila ou cidade onde a propriedade está localizada
        this.agrotoxico = agrotoxico; // Inicializa a informação sobre o uso de agrotóxicos na propriedade
    }

    // Getters (Métodos para acessar os valores das variáveis de instância)

    public int getId() {
        return id; // Retorna o id da propriedade
    }

    public String getNome() {
        return nome; // Retorna o nome da propriedade
    }

    public String getEndereco() {
        return endereco; // Retorna o endereço da propriedade
    }

    public String getCep() {
        return cep; // Retorna o CEP da propriedade
    }

    public String getCpf() {
        return cpf; // Retorna o CPF relacionado à propriedade
    }

    public String getTipo() {
        return tipo; // Retorna o tipo da propriedade
    }

    public String getTamanho() {
        return tamanho; // Retorna o tamanho da propriedade
    }

    public String getVila_Cidade() {
        return vila_cidade; // Retorna a vila ou cidade da propriedade
    }

    public String getAgrotoxico() {
        return agrotoxico; // Retorna a informação sobre o uso de agrotóxicos
    }

    // Setters (Métodos para definir os valores das variáveis de instância)

    public void setId(int id) {
        this.id = id; // Define o id da propriedade
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome da propriedade
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco; // Define o endereço da propriedade
    }

    public void setCep(String cep) {
        this.cep = cep; // Define o CEP da propriedade
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; // Define o CPF relacionado à propriedade
    }

    public void setTipo(String tipo) {
        this.tipo = tipo; // Define o tipo da propriedade
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho; // Define o tamanho da propriedade
    }

    public void setVila_Cidade(String vila_cidade) {
        this.vila_cidade = vila_cidade; // Define a vila ou cidade onde a propriedade está localizada
    }

    public void setAgrotoxico(String agrotoxico) {
        this.agrotoxico = agrotoxico; // Define a informação sobre o uso de agrotóxicos
    }
}
