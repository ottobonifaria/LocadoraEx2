package domain;

public class Relatorio {

    private String nome;
    private String veiculoAlugado;
    private String dataEmprestimo;
    private String horaEmprestimo;
    private String dataDevolucao;
    private String horaDevolucao;
    private String marca;
    private String modelo;
    private String placa;
    private boolean alugado;

    public Relatorio(String nome, String veiculoAlugado, String dataEmprestimo, String horaEmprestimo,
                     String dataDevolucao, String horaDevolucao, String marca, String modelo, String placa,
                     boolean alugado) {
        this.nome = nome;
        this.veiculoAlugado = veiculoAlugado;
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.horaDevolucao = horaDevolucao;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.alugado = alugado;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(String veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "RelatorioController{" +
                "nome='" + nome + '\'' +
                ", veiculoAlugado='" + veiculoAlugado + '\'' +
                ", dataEmprestimo='" + dataEmprestimo + '\'' +
                ", horaEmprestimo='" + horaEmprestimo + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", horaDevolucao='" + horaDevolucao + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
