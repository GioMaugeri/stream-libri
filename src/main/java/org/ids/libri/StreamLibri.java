package org.ids.libri;

import java.util.Comparator;
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

    //Dobbiamo contare i libri di cyberpunk
    public long contaLibriCyberpunk(List<Libro> list) {
        return list.stream()
        .filter(e -> String.valueOf(e.getCategoria()).equals("CYBERPUNK"))
        .count();
    }

    public List<Libro> prezzoCompresoTra12e15(List<Libro> list) {
        return list.stream()
                   .filter(s -> s.getPrezzo() >= 12 && s.getPrezzo() <= 15)
                   .collect(Collectors.toList());

    }

    public List<String> filtraListaTitoliLibriCyberpunkOppureFantasy(List<Libro> list) {
        return list.stream()
                   .filter(s -> s.getCategoria() == Categoria.CYBERPUNK || s.getCategoria() == Categoria.FANTASY)
                   .map(s -> s.getTitolo())
                   .collect(Collectors.toList());
    }

    public List<Libro> generaListaLibriCyberpunk(int n) {
        return Stream.generate(Libreria::gen)
                    .filter(s -> s.getCategoria() == Categoria.CYBERPUNK) 
                    .limit(n)
                    .collect(Collectors.toList());
    }

    public boolean checkSePresenteBurningChrome(List<Libro> list) {
        Optional<Libro> r = list.stream()
                        .filter(p -> p.getTitolo().equals("BurningChrome"))
                        .findAny();
        return r.isPresent();
    }

    public int sommaCosti_reduce(List<Libro> list) {
        // reduce(0, (accum, v) -> accum + v);
        return list.stream()
                   .reduce(0, (accum, lista) -> accum + lista.getPrezzo(), (t, u) -> Integer.signum(u));
    }

    public int sommaCosti_sum(List<Libro> list) {
        return list.stream()
                .map(b -> b.getPrezzo())
                .reduce(0, Integer::sum);
    }

    public double sommaCostiInDollari(double EUR_USD, List<Libro> list) {
        return list.stream()
                    .mapToDouble(b -> b.getPrezzo() * EUR_USD)
                    .sum();
        }

    public Optional<Libro> libroMenoCaroDa12InSu(List<Libro> list) {
        Optional<Libro> pmax = list.stream()
                                .filter(x -> x.getPrezzo() >= 12)
                                .min(Comparator.comparing(Libro::getPrezzo));
        return pmax;
    }

    public List<Libro> libriOrdinatiPerPrezzo(List<Libro> list) {
        return list.stream()
                    .sorted(Comparator.comparing(Libro::getPrezzo))
                    .collect(Collectors.toList());
    }

    // Titolo: "Harry Potter 1" "Harry Potter 2"... "Harry Potter n"
    // categoria: fantasy, prezzo: 15 euro
    public List<Libro> generaLibriHarryPotterDa15Euro(int n) {
        return null;
        // return Stream.iterate(n, n -> n +1)
        //              .limit(n)

    }

    public List<Libro> mescolaLista(List<Libro> list) {
        return null;
    }

    public Optional<Libro> primoPiuCaroDelPrecedente(List<Libro> list) {
        return null;
        // return list.stream
        //         .sorted(Comparator.comparing(Libro::getPrezzo))
    }

}
