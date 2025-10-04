import java.util.*;

public class AIRecommendationSystem {
    // Function to calculate cosine similarity between two users
    public static double cosineSimilarity(Map<Integer, Double> userA, Map<Integer, Double> userB) {
        double dot = 0, normA = 0, normB = 0;
        // Calculate dot product for common items
        for (Integer item : userA.keySet()) {
            if (userB.containsKey(item)) {
                dot += userA.get(item) * userB.get(item);
            }
        }
        // Calculate magnitude of each user's rating vector
        for (double r : userA.values()) normA += r * r;
        for (double r : userB.values()) normB += r * r;
        double denom = Math.sqrt(normA) * Math.sqrt(normB);
        return denom == 0 ? 0 : dot / denom; // Return cosine similarity (0–1)
    }
    // Function to predict rating for unrated items
    public static Map<Integer, Double> predictRatings(
            Map<Integer, Double> targetRatings,
            Map<Integer, Map<Integer, Double>> userRatings) {
        Map<Integer, Double> predicted = new HashMap<>();
        // Go through all items rated by at least one user
        Set<Integer> allItems = new HashSet<>();
        for (Map<Integer, Double> ratings : userRatings.values()) {
            allItems.addAll(ratings.keySet());
        }
        // Calculate predicted score for items not yet rated by target user
        for (Integer item : allItems) {
            if (targetRatings.containsKey(item) && targetRatings.get(item) != 0) continue;
            double numerator = 0, denominator = 0;
            // Compare target user with all other users
            for (Integer otherUser : userRatings.keySet()) {
                if (userRatings.get(otherUser) == targetRatings) continue;
                double similarity = cosineSimilarity(targetRatings, userRatings.get(otherUser));
                if (similarity > 0 && userRatings.get(otherUser).containsKey(item)) {
                    numerator += similarity * userRatings.get(otherUser).get(item);
                    denominator += similarity;
                }
            }
            // Avoid division by zero
            double predictedScore = denominator == 0 ? 0 : numerator / denominator;
            predicted.put(item, predictedScore);
        }
        return predicted;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== AI-Based Recommendation System ===");
        // Take number of users and items from user
        System.out.print("Enter number of users: ");
        int users = sc.nextInt();
        System.out.print("Enter number of items: ");
        int items = sc.nextInt();
        // Store all user ratings
        Map<Integer, Map<Integer, Double>> userRatings = new HashMap<>();
        System.out.println("\nEnter ratings (enter 0 if user hasn't rated the item):");
        // Input loop for ratings
        for (int u = 1; u <= users; u++) {
            Map<Integer, Double> ratings = new HashMap<>();
            for (int i = 1; i <= items; i++) {
                System.out.print("User " + u + ", Item " + i + " rating: ");
                ratings.put(i, sc.nextDouble());
            }
            userRatings.put(u, ratings);
        }
        // Choose target user for recommendation
        System.out.print("\nEnter the user ID to recommend for (1-" + users + "): ");
        int targetUser = sc.nextInt();
        // Number of top recommendations to show
        System.out.print("Enter number of recommendations to display: ");
        int topN = sc.nextInt();
        // Get predictions for target user
        Map<Integer, Double> predicted = predictRatings(userRatings.get(targetUser), userRatings);
        // Sort items by predicted score in descending order
        List<Map.Entry<Integer, Double>> sortedPredictions = new ArrayList<>(predicted.entrySet());
        sortedPredictions.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        // Display results
        System.out.println("\n--- Recommendations for User " + targetUser + " ---");
        int count = 0;
        for (Map.Entry<Integer, Double> entry : sortedPredictions) {
            System.out.printf("Item %d | Predicted Score: %.2f\n", entry.getKey(), entry.getValue());
            if (++count == topN) break;
        }
        sc.close();
    }
}
