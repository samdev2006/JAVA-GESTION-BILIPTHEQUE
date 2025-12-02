public class DVD extends Document implements Renouvelable, Reservable {

    private int dureeMinutes;
    private String realisateur;
    private String reservePar;
    private int nombreRenouvellement;

    // Constructeur
    public DVD(String code, String titre, String realisateur, int dureeMinutes) {
        super(code, titre, realisateur);
        this.dureeMinutes = dureeMinutes;
        this.realisateur = realisateur;
        this.reservePar = null;
        this.nombreRenouvellement = 0;
    }

    @Override
    public int getDureeEmprunt() {
        return 7;
    }

    @Override
    public void afficherDetails() {
        System.out.println("\n ===== DVD =====");
        System.out.println("Code : " + code);
        System.out.println("Titre : " + titre);
        System.out.println("Réalisateur : " + realisateur);
        System.out.println("Durée : " + dureeMinutes + " minutes");
        System.out.println("Statut : " + (estEmprunte ? "Emprunté par " + empruntePar : "Disponible"));

        if (reservePar != null) {
            System.out.println("Réservé par : " + reservePar);
        }

        if (estEmprunte) {
            System.out.println("Renouvellements : " + nombreRenouvellement + "/" + MAX_RENOUVELLEMENTS);
        }

        System.out.println("===================\n");
    }

    // ===== RESERVABLE =====

    @Override
    public boolean reserver(String nomUtilisateur) {
        if (reservePar != null) {
            System.out.println(" DVD '" + titre + "' déjà réservé par " + reservePar);
            return false;
        }

        reservePar = nomUtilisateur;
        System.out.println(" DVD '" + titre + "' réservé par " + nomUtilisateur);
        return true;
    }

    @Override
    public boolean Reserver(String nomUtilisateur) {
        return false;
    }

    @Override
    public void annulerReservation() {
        if (reservePar == null) {
            System.out.println(" Ce DVD n'est pas réservé");
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

    // ===== RENOUVELABLE =====

    @Override
    public boolean peutEtreRenouvele() {
        return estEmprunte && nombreRenouvellement < MAX_RENOUVELLEMENTS;
    }

    @Override
    public boolean renouveler() {
        // Vérifier si on peut renouveler
        if (!peutEtreRenouvele()) {
            if (!estEmprunte) {
                System.out.println(" Ce DVD n'est pas emprunté");
            } else {
                System.out.println(" Limite de renouvellement atteinte");
            }
            return false;
        }

        // Si on peut : incrémenter et afficher
        nombreRenouvellement++;
        System.out.println(" DVD '" + titre + "' renouvelé");
        System.out.println(" Renouvellements : " + nombreRenouvellement + "/" + MAX_RENOUVELLEMENTS);

        return true;
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
