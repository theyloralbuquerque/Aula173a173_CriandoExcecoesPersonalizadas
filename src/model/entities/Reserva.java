package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date checkOut;
    // A variável sdf é static para que não seja necessário instanciar um novo SimpleDateFormat para cada objeto que Reservation tiver.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duracao() {
                   // getTime() retorna o valor da data em milisegundos.
        long dif = checkOut.getTime() - checkIn.getTime();
        // A classe tipo enumerado TimeUnit permite que convertamos um espaço de medida de tempo em outro espaço de medida de tempo.
        // A linha abaixo converte em dias o espaço de medida de tempo armazenado em dif, passando como argumento dif e a medida que dif está.
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoDasDatas(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroDoQuarto +
                ", check-in: " +
                sdf.format(checkIn) + // A variável tipo dade checkIn no formato sdf.
                ", check-out: " +
                sdf.format(checkOut) + // A variável tipo dade checkOut no formato sdf.
                ", " + duracao() + // Possso chamar um método dentro do ToString() sem problemas.
                " noites.";
    }
}
