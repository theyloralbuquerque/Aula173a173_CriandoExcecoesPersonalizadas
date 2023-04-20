package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		// Variável sdf do tipo SimpleDateFormat para tratar as datas em um formato específico.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
	    Integer numeroDoQuarto = sc.nextInt();
	    System.out.print("Data de check-in (dd/MM/yyyy): ");
	    Date checkIn = sdf.parse(sc.next()); // o que o usuário digitar será convertido em sfd e armazenado em checkIn.
	    System.out.print("Data de check-out (dd/MM/yyyy): ");
	    Date checkOut = sdf.parse(sc.next()); // o que o usuário digitar será convertido em sfd e armazenado em checkIn.
	   
	    Date agora = new Date();
	    // Se checkIn for depois de agora OU checkOut depois de agora.
	    if (checkIn.before(agora) || checkOut.before(agora)) { 
	    	System.out.println("Erro na reserva: As datas da reserva devem ser datas futuras.");	
	    	
	    } else if (!checkOut.after(checkIn)) { // Se checkOut não for depois de checkIn.
	    	System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in.");
	    }
	    // Senão, instanciar a classe Reserva.
	    else {
	    	Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
	    	System.out.println("Reserva : " + reserva);
	    	
	    	System.out.println();
		    System.out.println("Digite os dados para atualizar a reserva:");
		    System.out.print("Data de check-in (dd/MM/yyyy): ");
		    checkIn = sdf.parse(sc.next()); // o que o usuário digitar será convertido em sfd e armazenado em checkIn.
		    System.out.print("Data de check-out (dd/MM/yyyy): ");
		    checkOut = sdf.parse(sc.next()); // o que o usuário digitar será convertido em sfd e armazenado em checkIn.
		    
		    String erro = reserva.atualizacaoDasDatas(checkIn, checkOut);
		    if (erro != null) {
		    	System.out.println(erro);
		    }
		    else {
		    	System.out.println("Reserva : " + reserva);
		    }
	    }		
		sc.close();
	}
}