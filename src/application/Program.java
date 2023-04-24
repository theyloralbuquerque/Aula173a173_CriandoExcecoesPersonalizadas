package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		// Vari�vel sdf do tipo SimpleDateFormat para tratar as datas em um formato espec�fico.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("N�mero do quarto: ");
		    Integer numeroDoQuarto = sc.nextInt();
		    System.out.print("Data de check-in (dd/MM/yyyy): ");
		    Date checkIn = sdf.parse(sc.next()); // o que o usu�rio digitar ser� convertido em sdf e armazenado em checkIn.
		    System.out.print("Data de check-out (dd/MM/yyyy): ");
		    Date checkOut = sdf.parse(sc.next()); // o que o usu�rio digitar ser� convertido em sdf e armazenado em checkIn.
		   
	
	    	Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
	    	System.out.println("Reserva : " + reserva);
	    	
	    	System.out.println();
		    System.out.println("Digite os dados para atualizar a reserva:");
		    System.out.print("Data de check-in (dd/MM/yyyy): ");
		    checkIn = sdf.parse(sc.next()); // o que o usu�rio digitar ser� convertido em sdf e armazenado em checkIn.
		    System.out.print("Data de check-out (dd/MM/yyyy): ");
		    checkOut = sdf.parse(sc.next()); // o que o usu�rio digitar ser� convertido em sdf e armazenado em checkIn.
		    
		    reserva.atualizacaoDasDatas(checkIn, checkOut);
		    System.out.println("Reserva : " + reserva);
		}
		catch (ParseException e) {
			System.out.println("A data digitada � inv�lida!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		/*catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
*/
		sc.close();
	}
}