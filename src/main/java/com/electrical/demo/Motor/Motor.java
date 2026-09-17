package com.electrical.demo.Motor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static com.electrical.demo.tools.Principal.raizDeTres;
@Table(name ="motor")
@Entity(name = "motor")
@Getter
@Setter
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Enum TipoMotor;
    private Float PotenciaMotor;
    private String CategoriaConjugacao;
    private Float RotacaoNominal;
    private int Frequencia;
    private int TensoesNominais;
    private Float CorrentesNominais;
    private String GrauDeProtecao;
    private Float NumeroDeVezesNominal;
    private Float FatorDePotencia;
    private Float Rendimento;

    public Motor() {
    }

    public Motor(Enum TipoMotor, Float PotenciaMotor, String CategoriaConjugacao, Float RotacaoNominal, int Frequencia, int tensoesNominais,
                 Float CorrentesNominais, String GrauDeProtecao, Float NumeroDeVezesNominal, Float FatorDePotencia, Float Rendimento){
     this.TipoMotor = TipoMotor;
     this.PotenciaMotor = PotenciaMotor;
     this.CategoriaConjugacao = CategoriaConjugacao;
     this.RotacaoNominal = RotacaoNominal;
     this.Frequencia = Frequencia;
     this.TensoesNominais = tensoesNominais;
     this.CorrentesNominais = CorrentesNominais;
     this.GrauDeProtecao = GrauDeProtecao;
     this.NumeroDeVezesNominal = NumeroDeVezesNominal;
     this.FatorDePotencia = FatorDePotencia;
     this.Rendimento = Rendimento;

    }


    public Enum getTipoMotor() {
        return TipoMotor;
    }

    public void setTipoMotor(Enum tipoMotor) {
        TipoMotor = tipoMotor;
    }

    public Float getPotenciaMotor() {
        return PotenciaMotor;
    }

    public void setPotenciaMotor(Float potenciaMotor) {
        PotenciaMotor = potenciaMotor;
    }

    public String getCategoriaConjugacao() {
        return CategoriaConjugacao;
    }

    public void setCategoriaConjugacao(String categoriaConjugacao) {
        CategoriaConjugacao = categoriaConjugacao;
    }

    public Float getRotacaoNominal() {
        return RotacaoNominal;
    }

    public void setRotacaoNominal(Float rotacaoNominal) {
        RotacaoNominal = rotacaoNominal;
    }

    public int getFrequencia() {
        return Frequencia;
    }

    public void setFrequencia(int frequencia) {
        Frequencia = frequencia;
    }

    public int getTensoesNominais() {
        return TensoesNominais;
    }

    public void setTensoesNominais(int tensoesNominais) {
        TensoesNominais = tensoesNominais;
    }

    public Float getCorrentesNominais() {
        return CorrentesNominais;
    }

    public void setCorrentesNominais(Float correntesNominais) {
        CorrentesNominais = correntesNominais;
    }

    public String getGrauDeProtecao() {
        return GrauDeProtecao;
    }

    public void setGrauDeProtecao(String grauDeProtecao) {
        GrauDeProtecao = grauDeProtecao;
    }

    public Float getNumeroDeVezesNominal() {
        return NumeroDeVezesNominal;
    }

    public void setNumeroDeVezesNominal(Float numeroDeVezesNominal) {
        NumeroDeVezesNominal = numeroDeVezesNominal;
    }

    public Float getFatorDePotencia() {
        return FatorDePotencia;
    }

    public void setFatorDePotencia(Float fatorDePotencia) {
        FatorDePotencia = fatorDePotencia;
    }

    public Float getRendimento() {
        return Rendimento;
    }

    public void setRendimento(Float rendimento) {
        Rendimento = rendimento;
    }


    public void SeccaoCabo(double distancia, double numeroCabos, double Resistencia, double Reatancia){

        double cabo = distancia/1000;
        double sin = Math.sqrt(1 - Math.pow(FatorDePotencia, 2));

        distancia = (raizDeTres * CorrentesNominais * cabo *((Resistencia/numeroCabos)*FatorDePotencia+(Reatancia/numeroCabos)*sin
        )/TensoesNominais);

        double totalDistancia = distancia*100;

        System.out.printf("Perda do circuito: %.4f.",totalDistancia );


        if(totalDistancia<= 5){
            System.out.println("\nLigacao circuito dentro das normas da NBR 5410!");
        }else if(totalDistancia<5 && totalDistancia>10){
            System.out.println("\nPerda proxima de 20% do torque e fora da norma!");
        }else if(totalDistancia > 10) {
            System.out.println("\nPerda consideravel do circuito e risco de travamento do motor" +
                    " troque a seccao do cabo!");

        }

    }


    public String toString(){
        return "Tipo do Motor: " + getTipoMotor() + "\nPotencia: " + getPotenciaMotor() + "\nConjugacao: " + getCategoriaConjugacao() +
                "\nRotacao: " + getRotacaoNominal() + "\nFrequencia: " + getFrequencia()+ "\nTensoes Nominais: " + getTensoesNominais() +
                "\nCorrentesNominais" + getCorrentesNominais() + "\nGrau de Protecao: " + getGrauDeProtecao() + "\nNumero de vezes a Corrente" +
                "\nnominal: " + getNumeroDeVezesNominal() + "\nFator de Potencai: " + getFatorDePotencia() + "\nRendimento: " + getRendimento();}



}