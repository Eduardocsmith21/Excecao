import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Reserva;

public class Main {
    public static void main(String[] args) throws ParseException /*throws propaga exceção da linha 18, 20*/ {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Número do quarto: ");
        int numero_quarto = sc.nextInt();
        System.out.println("Check-In (dd/mm/yyyy): ");
        Date checkIn = (Date) sdf.parse(sc.next());
        System.out.println("Check-Out (dd/mm/yyyy): ");
        Date checkOut = (Date) sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Check-in");
        }
        else{

            Reserva reserva = new Reserva(numero_quarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
        sc.close();
    }
}