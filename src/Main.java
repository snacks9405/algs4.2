import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    static ArrayList<Request> requests = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner reader;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
            br = new BufferedReader(new FileReader("input2.txt"));
            reader = new Scanner(br);
            while (reader.hasNextLine()) {
                Scanner line = new Scanner(reader.nextLine());
                Request request = new Request(line.nextInt(), line.nextInt(), line.nextInt());
                requests.add(request);
            }

            Collections.sort(requests, (x, y) -> y.cost - x.cost);

            int[] scheduled = new int[requests.size()];
            Request[] results = new Request[requests.size()];
            for (int i = 0; i < requests.size(); i++)
            {
                for (int j
                     = Math.min(requests.size() - 1, requests.get(i).deadline - 1);
                     j >= 0; j--) {
                    if (scheduled[j] == 0)
                    {
                        scheduled[j] = 1;
                        results[j] = requests.get(i);
                        break;
                    }
                }
            }

            int total = 0;
            for (Request request : results) {
                if(request != null) {
                    total += request.cost;
                    System.out.println(request.toString());
                }

            }
            System.out.println("Total: " + total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
