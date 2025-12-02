public interface Renouvelable {
    boolean Renouvelable();

    boolean PeutEtreRenouvelable();

    public static final int MAX_RENOUVELLEMENTS = 2;


    default void afficherInfoRenouvellement() {
        System.out.println("📌 Maximum de renouvellements : " + MAX_RENOUVELLEMENTS);
    }
}
