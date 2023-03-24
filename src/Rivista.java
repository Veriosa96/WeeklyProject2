class Rivista extends Catalogo {
    private PeriodicitaRiviste periodicita; //qui andiamo a prendere l'enum creato in precedenza.
    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, PeriodicitaRiviste periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public PeriodicitaRiviste getPeriodicita(){
        return periodicita;
    }

    @Override
    public void stampa() {
        System.out.println("Rivista: " + getTitolo() + " (" + getAnnoPubblicazione() + "), periodicità " + getPeriodicita());
    }
}
