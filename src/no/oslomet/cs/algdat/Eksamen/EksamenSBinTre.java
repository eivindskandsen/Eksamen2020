package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }


        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {

        // her har jeg kopiert kode fra 5.2.3 a. Som det står i oppgaven
        // Jeg måtte bare sette foreldrenoden lik q

        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging


    }


    public boolean fjern(T verdi) {

        // kopiert kode fra kompendiumet
        // ordnet foreldre og tilfeller hvor b er null

            if (verdi == null) return false;  // treet har ingen nullverdier

            Node<T> p = rot, q = null;   // q skal være forelder til p

            while (p != null)            // leter etter verdi
            {
                int cmp = comp.compare(verdi,p.verdi);      // sammenligner
                if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
                else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
                else break;    // den søkte verdien ligger i p
            }
            if (p == null) return false;   // finner ikke verdi

            if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
            {
                Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
                if (p == rot){
                    rot = b;
                }
                else if (p == q.venstre) {
                    q.venstre = b;
                    if(b!=null){
                        b.forelder=q;
                    }
                }
                else {
                    q.høyre = b;
                    if(b!=null){
                        b.forelder=q;
                    }

                }
            }
            else  // Tilfelle 3)
            {
                Node<T> s = p, r = p.høyre, tNode; // finner neste i inorden
                while (r.venstre != null)
                {
                    s = r;    // s er forelder til r
                    tNode=r.venstre;
                    r = r.venstre;

                    tNode.forelder=s;
                }

                p.verdi = r.verdi;   // kopierer verdien i r til p

                if (s != p){
                    s.venstre = r.høyre;
                    tNode=r.høyre;
                    if(tNode!=null) {
                        tNode.forelder = s;
                    }
                }
                else {
                    s.høyre = r.høyre;
                    tNode=r.høyre;
                    if(tNode!=null) {
                        tNode.forelder = s;
                    }
                }
            }

            antall--;   // det er nå én node mindre i treet
            return true;
        }


    public int fjernAlle(T verdi) {

    }

    public int antall(T verdi) {

        //prøver meg på nivå traversing
        int antallTall = 0;
        ArrayDeque<Node<T>> queue = new ArrayDeque<>();

        queue.addLast(rot);

        while (!queue.isEmpty()) {
            //tar ut første node


            Node<T> tempNode = queue.removeFirst();

            //legger til tempNode sine barn i køen

            if (tempNode.venstre != null) {
                queue.addLast(tempNode.venstre);
            }
            if (tempNode.høyre != null) {
                queue.addLast(tempNode.høyre);
            }

            if (tempNode.verdi == verdi) {
                antallTall++;
            }


        }
        return antallTall;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {

        // her drev jeg å programmerte litt feil så jeg kopierte litt kode jeg fant fra kompendiummet.
        //det skulle være lov
        while (true) {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {


        Node<T> tempForeldre = p.forelder;



        // om vi er på notroden
        if (tempForeldre == null) {
            return null;
        }
        //om vi er på en høyre node

        if (p == tempForeldre.høyre) {

            return tempForeldre;
        }
        // om vi er venstre node

        if (p == tempForeldre.venstre) {
            if (tempForeldre.høyre == null) {

                return tempForeldre;
            } else if (tempForeldre.høyre != null) {


                return førstePostorden(tempForeldre.høyre);

            }
        }
        return null;

    }

    public void postorden(Oppgave<? super T> oppgave) {

        // finner første postorden
        Node<T> p = førstePostorden(rot);

        //Looper, printer ut og setter p lik nestePostorden av p
        while (p != null) {

            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {


        postordenRecursive(rot, oppgave);


    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {

        if (p == null) {
            return;
        }


        postordenRecursive(p.venstre, oppgave);


        postordenRecursive(p.høyre, oppgave);


        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        ArrayList<T> a = new ArrayList<>();



        ArrayDeque<Node<T>> queue=new ArrayDeque<>();
        queue.addLast(rot);

        Node<T> nodeTemp;

        while(!queue.isEmpty()) {

            nodeTemp=queue.removeFirst();
            a.add(nodeTemp.verdi);

            if(nodeTemp.venstre!=null){
                queue.addLast(nodeTemp.venstre);
            }

            if(nodeTemp.høyre!= null){
                queue.addLast(nodeTemp.høyre);
            }


        }

        return a;

    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {


        EksamenSBinTre<K> binTre= new EksamenSBinTre<>(c);

        /*
        if(data.get(0)!= null) {
            binTre.rot = data.get(0);
        }

        Node<K> p=binTre.rot;
        Node<K> q=binTre.rot.forelder;


         */
        for(K value : data){
            binTre.leggInn(value);
        }

        /*
        // kopierte litt kode fra leggInn

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = c.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }


         */

        return binTre;
    }


} // ObligSBinTre
