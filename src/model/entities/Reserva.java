package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reserva {
    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date checkOut;
    // A vari�vel sdf � static para que n�o seja necess�rio instanciar um novo SimpleDateFormat para cada objeto que Reservation tiver.
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
	    if (!checkOut.after(checkIn)) { /* Condicional que verifica desde a primeira intera��o com usu�rio se a data de checkOut tem valor
	    								 	anterior a data de checkIn.
	    								 */ 
	    	throw new DomainException("A data de check-out deve ser posterior � data de check-in."); // Lan�amento de exce��o DomainException caso o if seja V. 
	    }
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
        // A classe tipo enumerado TimeUnit permite que convertamos um espa�o de medida de tempo em outro espa�o de medida de tempo.
        // A linha abaixo converte em dias o espa�o de medida de tempo armazenado em dif, passando como argumento dif e a medida que dif est�.
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoDasDatas(Date checkIn, Date checkOut) {
    	Date agora = new Date();
	    // Se checkIn for depois de agora OU checkOut depois de agora.
	    if (checkIn.before(agora) || checkOut.before(agora)) {
	    	throw new DomainException("As datas de atualiza��o da reserva devem ser datas futuras.");
	    }
	    // Se checkOut n�o for depois de checkIn.
	    if (!checkOut.after(checkIn)) {
	    	throw new DomainException("A data de check-out deve ser posterior � data de check-in.");
	    }
	    this.checkIn = checkIn;
	    this.checkOut = checkOut;
	    
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroDoQuarto +
                ", check-in: " +
                sdf.format(checkIn) + // A vari�vel tipo dade checkIn no formato sdf.
                ", check-out: " +
                sdf.format(checkOut) + // A vari�vel tipo dade checkOut no formato sdf.
                ", " + duracao() + // Possso chamar um m�todo dentro do ToString() sem problemas.
                " noites.";
    }
}
