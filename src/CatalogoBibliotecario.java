/*import java.util.stream.*;
import java.util.ArrayList;
import java.io.*;


public class CatalogoBibliotecario {

    private ArrayList<Catalogo> catalogo;

    public CatalogoBibliotecario() {
        catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(Libro elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) {
        catalogo.removeIf(elem -> elem.getCodiceISBN().equals(codiceISBN));
    }

    public Catalogo cercaElementoPerISBN(String codiceISBN) {
        return Catalogo.stream()
                .filter(elemento -> elemento.getCodiceISBN().equals(codiceISBN))
                .findFirst().orElse(null);
    }

    public ArrayList<Catalogo> cercaElementoPerAnno(int anno) {
        return Catalogo.stream()
                .filter(elem -> elem.getAnnoPubblicazione() == anno)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Libro> cercaLibriPerAutore(String autore) {
        return catalogo.stream()
                .filter(elem -> elem instanceof Libro && ((Libro)elem).getAutore().equals(autore))
                .map(elem -> (Libro)elem)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Rivista> cercaRivistePerPeriodicita(String periodicita) {
        return catalogo.stream()
                .filter(elem -> elem instanceof Rivista && ((Rivista)elem).getPeriodicita().equals(periodicita))
                .map(elem -> (Rivista)elem)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void salvaCatalogoSuFile(String nomeFile) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            out.writeObject(catalogo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaCatalogoDaFile(String nomeFile) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile))) {
            catalogo = (ArrayList<Catalogo>)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //metodo astratto per la stampa dell'elemento nel catalogo.
    public void stampa(Catalogo catalogo) {
    }
}*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CatalogoBibliotecario {
    private List<Catalogo> elementi;

    public CatalogoBibliotecario() {
        this.elementi = new ArrayList<>();
    }

    public void aggiungiElemento(Catalogo elemento) {
        elementi.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) {
        elementi.removeIf(e -> e.getCodiceISBN().equals(codiceISBN));
    }

    public Catalogo cercaElementoPerISBN(String codiceISBN) {
        return elementi.stream()
                .filter(e -> e.getCodiceISBN().equals(codiceISBN))
                .findFirst()
                .orElse(null);
    }

    public List<Catalogo> cercaElementoPerAnno(int anno) {
        return elementi.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<Libro> cercaLibriPerAutore(String autore) {
        return elementi.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(l -> l.getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public List<Rivista> cercaRivistePerPeriodicita(PeriodicitaRiviste periodicita) {
        return elementi.stream()
                .filter(e -> e instanceof Rivista)
                .map(e -> (Rivista) e)
                .filter(r -> r.getPeriodicita() == periodicita)
                .collect(Collectors.toList());
    }

    public void salvaCatalogoSuFile(String nomeFile) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
        outputStream.writeObject(elementi);
        outputStream.close();
    }

    public void caricaCatalogoDaFile(String nomeFile) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
        elementi = (List<Catalogo>) inputStream.readObject();
        inputStream.close();
    }
}
