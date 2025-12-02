public abstract class Document {

    // Attributs communs
    protected String code;
    protected String titre;
    protected String auteur;
    protected boolean estEmprunte;
    protected String empruntePar;

    // Constructeur
    public Document(String code, String titre, String auteur) {
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;
        this.estEmprunte = false;  // Toujours false au début
        this.empruntePar = null;   // Toujours null au début
    }

    // Méthodes abstraites
    public abstract int getDureeEmprunt();
    public abstract void afficherDetails();

    // Méthode concrète : emprunter
    public boolean emprunter(String nomUtilisateur) {
        if (estEmprunte) {
            System.out.println(" Le document '" + titre + "' est déjà emprunté");
            return false;
        } else {
            estEmprunte = true;
            empruntePar = nomUtilisateur;
            System.out.println("Le document" + titre + "' emprunté par " + nomUtilisateur +
                    " pour " + getDureeEmprunt() + " jours");
            return true;
        }
    }

    // Méthode concrète : retourner
    public boolean retourner() {
        if (!estEmprunte) {  // Équivalent à : estEmprunte == false
            System.out.println(" Ce document n'est pas emprunté");
            return false;
        } else {
            System.out.println(" Le document " + titre + "' est retourné par " + empruntePar);
            estEmprunte = false;
            empruntePar = null;
            return true;
        }
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getTitre() {
        return titre;
    }

    public boolean estEmprunte() {
        return estEmprunte;
    }

    public String getAuteur() {
        return auteur;
    }

    public abstract boolean reserver(String nomUtilisateur);

    public abstract boolean estReserve();

    public abstract boolean renouveler();

    public abstract boolean peutEtreRenouvele();
}