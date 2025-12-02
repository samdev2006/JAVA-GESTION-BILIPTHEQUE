public class Main {
    public static void main(String[] args) {
        // Créer un DVD
        DVD monDVD = new DVD("D001", "Inception", "Christopher Nolan", 148);

        // Tester les méthodes
        monDVD.afficherDetails();
        monDVD.emprunter("Alice");
        monDVD.renouveler();
        // ... etc
    }
}