//nella creazione della classe libro andiamo a inserire extends Catalogo in modo tale che Libro prenda le stesse variabili che sono state create all'interno di Catalogo
 class Libro extends Catalogo {
     private String autore;
     private String genere;


     public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
         super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
         this.autore= autore;
         this.genere= genere;
     }

     public String getAutore(){
         return autore;
     }

     public String getGenere(){
         return genere;
     }


     //implementazione del metodo astratto Catalogo per la stampa del libro
     @Override
     public void stampa() {
         System.out.println("Libro: " + getTitolo() + "("+ getAnnoPubblicazione()+ ")" + "di " + getAutore() + "(" + getAnnoPubblicazione() +")");
     }
 }
