package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Número do quarto: ");
        int number = sc.nextInt();
        System.out.print("Data de check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: A data de check-out deve ser depois da data de check-in.");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
            System.out.println();
            System.out.println("Entre com a data para mudar a reserva: ");
            System.out.print("Data de check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Erro na reserva: " + error);
            } else {
                System.out.println("Reserva: " + reservation);
            }

        }
        sc.close();
    }
}
