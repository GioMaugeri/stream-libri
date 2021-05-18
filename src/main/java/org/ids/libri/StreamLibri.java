package org.ids.libri;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import org.ids.libri.Libro.Categoria;
import java.util.Comparator;

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
                .peek(System.out::println)
                .count();
        
    }

    public List<Libro> prezzoCompresoTra12e15(List<Libro> list) {
        return list.stream()
                .filter(s -> s.getPrezzo() >= 12)
                 .filter(s -> s.getPrezzo() <= 15)
                 .peek(System.out::println)
                 .collect(Collectors.toList());
    }

    public List<String> filtraListaTitoliLibriCyberpunkOppureFantasy(List<Libro> list) {
        return list.stream()
                .filter(s->s.getCategoria()==Categoria.CYBERPUNK||s.getCategoria()==Categoria.FANTASY)
                .map(s->s.getTitolo())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public List<Libro> generaListaLibriCyberpunk(int n) {
        return Stream.generate(Libreria::gen)
                .filter(s->s.getCategoria()==Categoria.CYBERPUNK)
                .limit(n)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public boolean checkSePresenteBurningChrome(List<Libro> list) {
        Optional<Libro> r = list.stream()
        .filter(p->p.getTitolo().equals("BurningChrome"))
        .findAny();
        return r.isPresent();
    }

    public int sommaCosti_reduce(List<Libro> list) {
        int somma=list.stream()
        .peek(System.out::println)
        .map(Libro::getPrezzo)
        .reduce(0,Integer::sum);
        return somma;
    }

    public int sommaCosti_sum(List<Libro> list) {
        int somma=list.stream()
        .peek(System.out::println)
        .mapToInt(b->b.getPrezzo())
        .sum();
        return somma;
    }

    public double sommaCostiInDollari(double EUR_USD, List<Libro> list) {
        return list.stream()
                .mapToDouble(b->b.getPrezzo()*EUR_USD)
                .sum();
    }

    public Optional<Libro> libroMenoCaroDa12InSu(List<Libro> list) {
        return list.stream()
                .filter(s->s.getPrezzo() >= 12)
                .peek(System.out::println)
                .min(Comparator.comparing(Libro::getPrezzo));
    }

    public List<Libro> libriOrdinatiPerPrezzo(List<Libro> list) {
        return list.stream()
                .sorted(Comparator.comparing(Libro::getPrezzo))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    // Titolo: "Harry Potter 1" "Harry Potter 2"... "Harry Potter n"
    // categoria: fantasy, prezzo: 15 euro
    public List<Libro> generaLibriHarryPotterDa15Euro(int n) {
        return IntStream.rangeClosed(1, n)
        .mapToObj(i -> new Libro("Harry Potter " + i, Categoria.FANTASY, 15))
        .peek(System.out::println)
        .collect(Collectors.toList());
    }

    public List<Libro> mescolaLista(List<Libro> list) {
        return list.stream()
                .filter(s->s.getPrezzo()>=0)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public Optional<Libro> primoPiuCaroDelPrecedente(List<Libro> list) {
        return IntStream.range(1, list.size())
        .parallel()
        .filter(i -> list.get(i - 1).getPrezzo() < list.get(i).getPrezzo())
        .mapToObj(i -> list.get(i))
        .peek(System.out::println)
        .findFirst();
    }

}
