public interface Reservable {
    //Réserver le doc pour un user
    boolean Reserver(String nomUtilisateur);

    //Annuler le réservation pour un user
    void  annulerReservation();

    boolean estRserve();
    //Nombre maximum de reservation
   public static final int MAX_RESERVATIONS = 5;
}
