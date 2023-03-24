import java.util.Locale;


abstract class Catalogo {
    private String codiceISBN; //Creazione della variabile per il codice univoco del catalogo
    private String titolo; //Creazione della variabile per il Titolo del catalogo
    private int annoPubblicazione; //Creazione della variabile per l'anno di pubblicazione del catalogo
    private int numeroPagine; //Creazione della variabile per il numero delle pagine del catalogo

    //creazione del metodo per il catalogo.
    public Catalogo(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine){
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }




    public String getCodiceISBN(){
        return codiceISBN;
    }

    public String getTitolo(){
        return titolo;
    }

    public int getAnnoPubblicazione(){
        return annoPubblicazione;
    }

    public int getNumeroPagine(){
        return numeroPagine;
    }

    //metodo astratto per la stampa dell'elemento nel catalogo.
    public abstract void stampa();
}
