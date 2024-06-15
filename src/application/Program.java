package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class Program {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Informe o numero do quarto");
		int numQuarto = sc.nextInt();
		System.out.println("Data de Check-In (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data de Check-Out : ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data do check-out eh anterior a do check-In ");
		} else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva.toString());

			System.out.println();
			System.out.println("entre com a data para atualizar: ");
			System.out.println("Data de Check-In (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("\"Erro na reserva: Data do check-out tem que ser posterior a do check-In \"");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data do check-out eh anterior a do check-In ");
			} else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println(reserva.toString());
			}
		}
		sc.close();
	}
}
