import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //creiamo un'istanza del catalogo bibliotecario.
        CatalogoBibliotecario Catalogo = new CatalogoBibliotecario();
    //il prossimo passo è quello di aggiungere alcuni libri e alcune riviste a catalogo.
        Catalogo.aggiungiElemento(new Libro("8817105929","Caraval",2018, 430,"Stephanie Garber","Romanzo"));
        Catalogo.aggiungiElemento(new Libro("8817143448","Legend",2019,496,"Stephanie Garber", "Romanzo"));
        Catalogo.aggiungiElemento(new Libro("8817149993","Fianle",2021,492,"Stephanie Garber","Romanzo"));
        Catalogo.aggiungiElemento(new Rivista("8809866193","Moto. I modelli che hanno fatto la storia",2018,480,PeriodicitaRiviste.MENSILE));


        //Ricerca per ISBN
        Catalogo elemento1 = Catalogo.cercaElementoPerISBN("8817105929");
        System.out.println("Elemento Trovato: " + elemento1.getTitolo());

        //Ricerca degli elementi per anno di pubblicazione
        ArrayList<Catalogo> elencoPerAnno = (ArrayList<Catalogo>) Catalogo.cercaElementoPerAnno(2018);
        System.out.println("Elenco dei libri pubblicati nel"+ elemento1.getAnnoPubblicazione());
        for (Catalogo e : elencoPerAnno){
            System.out.println("- " + e.getTitolo());
        }

        //Ricerca dei libri per autore.
        ArrayList<Libro> libroPerAutore = (ArrayList<Libro>) Catalogo.cercaLibriPerAutore("Stephanie Garber");
        System.out.println("Elenco dei libri di Stephanie Garber presenti nel catalogo: ");
        for (Libro I : libroPerAutore){
            System.out.println("- " + I.getTitolo());
        }

        //Rimozione di un elemento
        Catalogo.rimuoviElemento("8817105929");

        //aggiunta di una rivista
        Rivista riv1 = new Rivista("9798762296816", "MOTO: L’almanacco Completo dei 28+1 Piloti del Motomondiale più Forti di Tutti i Tempi!", 2021,112,PeriodicitaRiviste.SETTIMANALE);
        Catalogo.aggiungiElemento(riv1);

        // ricerca di riviste per periodicità
        ArrayList<Rivista> rivistePerPeriodicita = (ArrayList<Rivista>) Catalogo.cercaRivistePerPeriodicita(PeriodicitaRiviste.MENSILE);
        System.out.println("Elenco delle riviste mensili presenti in catalogo:");
        for(Rivista r : rivistePerPeriodicita) {
            System.out.println("- " + r.getTitolo());
        }

        // salvataggio su file
        Catalogo.salvaCatalogoSuFile("catalogo.txt");

        // caricamento da file
        Catalogo.caricaCatalogoDaFile("catalogo.txt");
    }
}

