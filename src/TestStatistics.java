import java.io.File;

public class TestStatistics {
    public static void main(String[] args) {


        if (args.length == 1) {

            String path = args[0];

            File checkFile = new File(path);
            if (checkFile.exists() && !checkFile.isDirectory()) {

                Statistics statistics = new Statistics(path);
                System.out.println("90 percentile " + statistics.getPercentile(90));
                System.out.println("median " + statistics.getMedian());
                System.out.println("average " + statistics.getAverage());
                System.out.println("max " + statistics.getMax());
                System.out.println("min " + statistics.getMin());

            } else {
                System.out.println("Проверьте корректность заданного пути" +
                        " до файла с тестовыми данными.");
            }

        } else {
            System.out.println("Программа принимает только один аргумент - " +
                    "путь до файла с тестовыми данными.");
        }


    }
}
