package stackandqueues.circulartour;

class CircularTour {

    // Method to find the starting point for the circular tour
    public int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;

        int currentSurplus = 0;
        int totalSurplus = 0;
        int startIndex = 0;

        // Traverse through all petrol pumps
        for (int i = 0; i < n; i++) {
            currentSurplus += petrol[i] - distance[i];


            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }

            // Add current surplus to total surplus
            totalSurplus += petrol[i] - distance[i];
        }

        // If totalSurplus is non-negative, then the tour is possible from the startIndex
        return (totalSurplus >= 0) ? startIndex : -1;
    }
}

