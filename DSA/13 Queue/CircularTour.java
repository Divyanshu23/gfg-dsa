import java.util.*; 

class CircularTour {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new PetrolPump[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new PetrolPump(sc.nextInt(), sc.nextInt());
        }
        System.out.println(circularTour(arr, n));
        sc.close();
    }

    public static int circularTour(PetrolPump[] arr, int n) {
        int currPetrol;
        int start = 0;
        int end = 1;
        currPetrol = arr[start].petrol - arr[start].distance;

        while(end != start || currPetrol < 0) {
            while(currPetrol < 0 && start != end) {
                currPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1)%n;

                if(start == 0)
                    return -1;
            }

            currPetrol += arr[end].petrol - arr[end].distance;
            end = (end+1)%n;
        }
        return start;
    }

	private static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
	}
} 