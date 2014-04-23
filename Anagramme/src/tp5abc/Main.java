package tp5abc;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

                                                                                                                         //L'exemple en commentaire sera de 3 lettres.
    static int tailleMot = 0;
    static char[] caractere = null;
    static ArrayList<Character> listCaractere = new ArrayList<Character>();
    static ArrayList<String> listAnagrammeDunMot = new ArrayList<String>();
    static ArrayList<String> listMot = new ArrayList<String>();
    static HashMap hashMapMotAnagramme = new HashMap();

////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        listMot.add("ABCD");
        listMot.add("EFGH");

        for (int i = 0; i < listMot.size(); i++) {
            tailleMot = listMot.get(i).length();
            caractere = new char[tailleMot];
            faireAnagramme(listMot.get(i));
            hashMapMotAnagramme.put(listMot.get(i), listAnagrammeDunMot.clone());                         //".clone" permet de ne pas supprimer les valeurs,
            listAnagrammeDunMot.clear();                                                                          // quand arrive le ".clear".
            listCaractere.clear();
        }

        for (int i = 0; i < hashMapMotAnagramme.size(); i++) {
            System.out.println(hashMapMotAnagramme.get(listMot.get(i)));
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void faireAnagramme(String mot) {
        int etage = 0;

        for (int i = 0; i < tailleMot; i++) {
            listCaractere.add(mot.charAt(i));                                                                      // liste des caracteres possibles est remplie.
        }

        for (int j = 0; j < tailleMot; j++) {                                                                        //au 1er etage il y a ABC = 3branches.
            caractere[etage] = (Character) listCaractere.get(j);
            listCaractere.remove(j);                                                                                 //enleve du tableau des caracteres possibles.
            anagramme(listCaractere, tailleMot - 1, etage + 1);                                                  //execute la récursivité.
            listCaractere.add(j, mot.charAt(j));                                                                    //Rajoute dans le tableau des caracteres possibles.
        }
    }

    public static void anagramme(ArrayList listCaractere, int taille, int etage) {                           //List des possibles + taille restante + etage actuel.

        if (taille == 1) {                                                                                              //dernier etage = sauvegarde de la branche
            String temp = "";
            for (int k = 0; k < tailleMot - 1; k++) {                                                              //sauvegarde le tableau [A,B,'']+caractere possible,
                temp = temp + caractere[k];                                                                       //represente la branche emprunté.
            }
            temp = temp + listCaractere.get(0);
            listAnagrammeDunMot.add(temp);                                                                      //Ajout de la branche dans la liste d'anagramme
            etage--;
        } else {
            for (int i = 0; i < taille; i++) {                                                                          // 2er etage. Ex => BCD = 3branches.
                caractere[etage] = (Character) listCaractere.get(i);                                            //stock le caratere dans un tableau.
                listCaractere.remove(i);                                                                             //enleve du tableau des caracteres possibles.
                anagramme(listCaractere, taille - 1, etage + 1);                                                  //Descent d'un etage.
                listCaractere.add(i, caractere[etage]);                                                           //remet a la bonne place la bonne lettre de-nouveau disponible.
            }
        }

    }


}
