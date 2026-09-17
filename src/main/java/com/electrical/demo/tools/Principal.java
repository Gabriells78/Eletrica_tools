package com.electrical.demo.tools;

import com.electrical.demo.Motor.Motor;
import com.electrical.demo.Motor.TipoMotor;
import com.electrical.demo.repository.motorRepository;

import java.sql.ClientInfoStatus;
import java.util.*;

public class Principal {
    public static double raizDeTres = 1.732;
    public double distancia;
    public double cobreCondutividade = 58 * 1000000;
    public List<Double> cabos= new ArrayList<>();
    private motorRepository motorRepositorio;
    private List<Motor> motores = new ArrayList<>();
    Scanner leitura = new Scanner(System.in);


    Motor motor = new Motor();

    public Principal(motorRepository motor1){
        this.motorRepositorio = motor1;
    }

    public void exibirMenu() throws Exception {


        int opcao;

        do{
            var menu = """
					\n0-Sair.
					1-Cadastrar motor.
					2-Dimensionar Secao Cabo.
					3-Listar motores ja Cadastrados.
					""";
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    Cadastrar_motor();
                    break;
                case 2:
                    DimensionarSecaoCabo();
                    break;
                case 3: Listar_motores();
                break;

            }
        } while (opcao!=0);
    }

    public void Cadastrar_motor(){
        TipoMotor[] tipos = TipoMotor.values();
        System.out.println("Qual E o tipo do motor? ");
        for( int i =0; i < tipos.length; i++){
            System.out.println((i+1)+ "-" + tipos[i]);
        }
        leitura.nextLine();
        System.out.println("Qual a potencia (hp/c) do motor: ");
        motor.setPotenciaMotor(leitura.nextFloat());
        System.out.println("Qual sua categoria de Conjugacao: ");
        motor.setCategoriaConjugacao(leitura.next());
        System.out.println("Qual sua rotacao nominal: ");
        motor.setRotacaoNominal(leitura.nextFloat());
        System.out.println("Qual a frequencia: ");
        motor.setFrequencia(leitura.nextInt());
        System.out.println("Qual a sua tensao de fechamento: ");
        motor.setTensoesNominais(leitura.nextInt());
        System.out.println("Qual sua corrente nominal: ");
        motor.setCorrentesNominais(leitura.nextFloat());
        System.out.println("Qual o seu grau de protecao: ");
        motor.setGrauDeProtecao(leitura.next());
        System.out.println("Quantas vezes a nominal: ");
        motor.setNumeroDeVezesNominal(leitura.nextFloat());
        System.out.println("Qual o fator de potencia: ");
        motor.setFatorDePotencia(leitura.nextFloat());
        System.out.println("Qual o seu rendimento: ");
        motor.setRendimento(leitura.nextFloat());
        System.out.println(motor);

        motorRepositorio.save(motor);

    }

    public void DimensionarSecaoCabo() throws Exception {
        System.out.println("qual a distancia: ");
        distancia = leitura.nextDouble();
//        System.out.println("qual o cosseno do cabo: ");
//        var cosseno = leitura.nextDouble();
        System.out.println("qual o numero de cabos por fase: ");
        var numeroCabos = leitura.nextDouble();
        System.out.println("qual a resistencia por metro do cabo: ");
        var Resistencia = leitura.nextDouble();
        System.out.println("qual a reatancia por metro do cabo: ");
        var Reatancia = leitura.nextDouble();
        motor.SeccaoCabo(distancia,numeroCabos,Resistencia,Reatancia);

    }

    public void Listar_motores() throws Exception {
        motores =  motorRepositorio.findAll();
        motores.stream().forEach(System.out::println);
    }

    public List<Double> getCabos() {
        return cabos;
    }

    public void setCabos(List<Double> cabos) {
        this.cabos = cabos;
    }

}

