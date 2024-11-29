package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;

        //pegar modeda 100
        while (valor >=100) {
            valor = valor - 100;
            count++;


        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;


        //pegar moeda 50
        while (valor >=50 ) {
            valor = valor - 50;
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;

        //pegar moeda 20
        while (valor >=20) {
            valor = valor - 20;
            count++;
        }

        
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        //pegar moeda 10
        while (valor >=10) {
            valor = valor - 10;
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor >=5) {
            valor = valor - 5;
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor >=2) {
            valor = valor - 2;


            count++;
        }
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            //arruma for 1
            if (troco.papeisMoeda == null) {
                return false; // Caso não Haja Moedas.
            }

            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            //arruma for 2
            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                    break; //sai do for quando encontrar a moeda
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
