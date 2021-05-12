package org.ids.libri;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.ids.libri.Libro.Categoria;

public class StreamLibri {

    // mi appoggio ad un factory method che genera a rotazione
    // la stessa lista di libri
    public List<Libro> generaListaLibri(int n) {
        return Stream.generate(Libreria::gen)
            .limit(n)
            .collect(Collectors.toList());
    }

    public long contaLibriCyberpunk(List<Libro> list) {
        return list.stream()
                .filter(s->s.getCategoria()==Categoria.CYBERPUNK)
                .count();
        
    }

    public List<Libro> prezzoCompresoTra12e15(List<Libro> list) {
        return list.stream()
                .filter(s -> s.getPrezzo() >= 12)
                 .filter(s -> s.getPrezzo() <= 15)
                 .collect(Collectors.toList());
    }

    public List<String> filtraListaTitoliLibriCyberpunkOppureFantasy(List<Libro> list) {
        return list.stream()
                .filter(s->s.getCategoria()==Categoria.CYBERPUNK||s.getCategoria()==Categoria.FANTASY)
                .map(s->s.getTitolo())
                .collect(Collectors.toList());
    }

    public List<Libro> generaListaLibriCyberpunk(int n) {
        return null;
    }

    public boolean checkSePresenteBurningChrome(List<Libro> list) {
        return true;
    }

    public int sommaCosti_reduce(List<Libro> list) {
        return 0;
    }

    public int sommaCosti_sum(List<Libro> list) {
        return 0;
    }

    public double sommaCostiInDollari(double EUR_USD, List<Libro> list) {
        return 0.0;
    }

    public Optional<Libro> libroMenoCaroDa12InSu(List<Libro> list) {
        return null;
    }

    public List<Libro> libriOrdinatiPerPrezzo(List<Libro> list) {
        return null;
    }

    // Titolo: "Harry Potter 1" "Harry Potter 2"... "Harry Potter n"
    // categoria: fantasy, prezzo: 15 euro
    public List<Libro> generaLibriHarryPotterDa15Euro(int n) {
        return null;
    }

    public List<Libro> mescolaLista(List<Libro> list) {
        return null;
    }

    public Optional<Libro> primoPiuCaroDelPrecedente(List<Libro> list) {
        return null;
    }

}
