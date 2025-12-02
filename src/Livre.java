public class Livre extends Document implements Reservable, Renouvelable {

    // Attributs spécifiques
    private int nombrePages;
    private String reservePar;  // null si pas réservé
    private int nombreRenouvellements;

    // Constructeur
    public Livre(String code, String titre, String auteur, int nombrePages) {
        super(code, titre, auteur);
        this.nombrePages = nombrePages;
        this.reservePar = null;
        this.nombreRenouvellements = 0;
    }

    // ========== IMPLÉMENTATION DE DOCUMENT ==========

    @Override
    public int getDureeEmprunt() {
        return 30;  // 30 jours pour un livre
    }

    @Override
    public void afficherDetails() {
        System.out.println("\n📖 ===== LIVRE =====");
        System.out.println("Code : " + code);
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Pages : " + nombrePages);
        System.out.println("Statut : " + (estEmprunte ? "Emprunté par " + empruntePar : "Disponible"));

        if (reservePar != null) {
            System.out.println("Réservé par : " + reservePar);
        }

        if (estEmprunte) {
            System.out.println("Renouvellements : " + nombreRenouvellements + "/" + MAX_RENOUVELLEMENTS);
        }

        System.out.println("====================\n");
    }

    // ========== IMPLÉMENTATION DE RESERVABLE ==========


    @Override
    public boolean reserver(String nomUtilisateur) {
        // Vérifier si déjà réservé
        if (reservePar != null) {
            System.out.println(" Le livre '" + titre + "' est déjà réservé par " + reservePar);
            return false;
        }

        // Réserver
        reservePar = nomUtilisateur;
        System.out.println(" Livre '" + titre + "' réservé par " + nomUtilisateur);
        return true;
    }

    @Override
    public boolean Reserver(String nomUtilisateur) {
        return false;
    }

    @Override
    public void annulerReservation() {
        if (reservePar == null) {
            System.out.println(" Ce livre n'est pas réservé");
        } else {
            System.out.println(" Réservation annulée pour '" + titre + "'");
            reservePar = null;
        }
    }

    @Override
    public boolean estRserve() {
        return false;
    }

    @Override
    public boolean estReserve() {
        return reservePar != null;
    }

    // ========== IMPLÉMENTATION DE RENOUVELABLE ==========

    @Override
    public boolean renouveler() {
        // Vérifier si on peut renouveler
        if (!peutEtreRenouvele()) {
            if (!estEmprunte) {
                System.out.println(" Le livre n'est pas emprunté");
            } else {
                System.out.println(" Limite de renouvellements atteinte (" + MAX_RENOUVELLEMENTS + " max)");
            }
            return false;
        }

        // Renouveler
        nombreRenouvellements++;
        System.out.println("Livre '" + titre + "' renouvelé (" + nombreRenouvellements + "/" + MAX_RENOUVELLEMENTS + ")");
        System.out.println("Nouvelle durée : " + getDureeEmprunt() + " jours supplémentaires");
        return true;
    }

    @Override
    public boolean peutEtreRenouvele() {

        return estEmprunte && nombreRenouvellements < MAX_RENOUVELLEMENTS;
    }

    // Getter pour nombrePages
    public int getNombrePages() {
        return nombrePages;
    }

    @Override
    public boolean Renouvelable() {
        return false;
    }

    @Override
    public boolean PeutEtreRenouvelable() {
        return false;
    }
}