import java.util.Random;
import java.util.Scanner;
import java.lang.StringBuilder;



public class OperazioniBanca {

    Scanner input = new Scanner(System.in);
    Banca myBanca = new Banca();
		
    public void InizializzaBanca(){
        
        while (true){
		System.out.println("Benvenuto , vuoi aprire un conto corrente ?");
		System.out.println("Digita 1 per aprirlo, 2 per uscire");
		
		String scelta = input.nextLine();
		String iban = generaIban();
		
        
		    if (scelta.equals("1")) {
			    System.out.println("Iban generato: " + iban);
                break;
		    } else if(scelta.equals("2")) {
			    System.out.println("Programma in chiusura...");
			    System.exit(0);
		    } else {
			    System.out.println("Input Errato");
		    }
        }

       

        while (true){
            System.out.println("Vuoi effettuare delle operazioni ?");
            System.out.println("Digita 1 per confermare, 2 per uscire");
    
            String sceltaOperazioni = input.nextLine();

		    if (sceltaOperazioni.equals("1")) {
                Operazioni();
                break;
		    } else if(sceltaOperazioni.equals("2")) {
			    System.out.println("Programma in chiusura...");
			    System.exit(0);
		    } else {
			    System.out.println("Input Errato");
		    }
        }

	}

    private static String generaIban() {
		Random random = new Random();
		StringBuilder ibanBuilder = new StringBuilder();
		
        ibanBuilder.append("IT");

        for (int i = 0; i < 22; i++) {

            ibanBuilder.append(random.nextInt(10));
        }


		return ibanBuilder.toString();
		
		
		
	}

    private void Operazioni(){



        while(true){
            System.out.println("Quali operazioni vuoi fare?");
            System.out.println("Digita 1 per visualizzare saldo , 2 per effettuare movimenti in entrata, 3 per movimenti in uscita,4 per terminare e uscire del programma");
            String sceltaMovimento = input.nextLine();

            if(sceltaMovimento.equals("1")){
                System.out.println("Il saldo disponibile è " + myBanca.getSaldoDisponibile() + " euro");
                

            }else if (sceltaMovimento.equals("2")){
                System.out.println("A quanto ammonta il movimento in entrata?");
                double movimentoEntrata = input.nextDouble();
                input.nextLine();
                myBanca.setSaldoDisponibile(myBanca.getSaldoDisponibile()+movimentoEntrata);
                System.out.println("Importo movimento in entrata: " + movimentoEntrata + " euro");
                System.out.println("Il saldo disponibile è " + myBanca.getSaldoDisponibile()  + " euro");
                

            }else if (sceltaMovimento.equals("3")){
                System.out.println("A quanto ammonta il movimento in uscita?");
                double movimentoUscita = input.nextDouble();
                input.nextLine();
                myBanca.setSaldoDisponibile(myBanca.getSaldoDisponibile() - movimentoUscita);
                System.out.println("Importo movimento in uscita: " + movimentoUscita + " euro");
                System.out.println("Il saldo disponibile è " + myBanca.getSaldoDisponibile()  + " euro");
                
            } 

            else if (sceltaMovimento.equals("4")){
                System.out.println("Programma in chiusura...");
                System.exit(0);
            } 


            else {
                System.out.println("Input Errato");
            }
        }
    }



    }

