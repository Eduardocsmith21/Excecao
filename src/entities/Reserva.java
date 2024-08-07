package entities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numero_sala;
    private Date chekIn;
    private Date checkOut;

    //Formatação de data
    private static SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");

    //Construtor
    public Reserva(Integer numero_sala, Date chekIn, Date checkOut){
        this.numero_sala = numero_sala;
        this.chekIn = chekIn;
        this.checkOut = checkOut;
    }

    //Get e Set
    public Date getCheckIn(){
        return chekIn;
    }
    public Date getCheckOut(){
        return checkOut;
    }

    //Implementação do metodo de calculo de horas
    //Usando o long - inteiro mais longo
    public long duracao(){
        long diferenca = checkOut.getTime() - chekIn.getTime(); //Responsavil por pegar adiferença entre as duas datas em milesegundos
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MICROSECONDS); //Conversão de milisegundos para dias
    }

    //Atualização de datas
    public void updateDatas(Date checkIn, Date checkOut){
        this.chekIn = checkIn;
        this.checkOut = checkOut;
    }

    //Saida usando toString
    @Override
    public String toString(){
        return "Número do quarto: " + numero_sala + "Check-In: " + sdf.format(chekIn) + "Check-Out: " + sdf.format(checkOut) + duracao() + "Dias";
    }
}
