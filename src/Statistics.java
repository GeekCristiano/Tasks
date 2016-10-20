import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    ArrayList<Integer> data;

    public Statistics(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            data = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {

                data.add(Integer.valueOf(s));
            }
            Collections.sort(data);
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public int getMax() {
        int maxElementIndex = data.size() - 1;
        return data.get(maxElementIndex);
    }

    public int getMin() {
        int minElementIndex = 0;
        return data.get(minElementIndex);
    }

    public double getMedian() {
        return data.size() % 2 == 0 ? (data.get(data.size() / 2 - 1) + data.get(data.size() / 2)) / 2 : data.get((data.size() - 1) / 2);
    }

    public double getAverage() {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum / data.size();
    }

    public double getPercentile(int p) {
        int n = data.size();
        double pos = p * (n + 1) / 100;
        double d = pos - Math.floor(pos);
        if (pos < 1) return getMin();
        else if (pos >= n) return getMax();
        else {

            int lower = data.get((int) Math.floor(pos));
            int upper = data.get((int) Math.ceil(pos));

            return lower + d * (upper - lower);
        }
    }


}
