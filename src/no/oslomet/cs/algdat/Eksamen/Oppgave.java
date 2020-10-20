package no.oslomet.cs.algdat.Eksamen;

import java.util.Comparator;

@FunctionalInterface
public interface Oppgave<T>  // legges under hjelpeklasser
{
    void utførOppgave(T t);    // f.eks. utskrift til konsollet

}
