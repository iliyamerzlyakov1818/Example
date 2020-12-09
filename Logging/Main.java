import java.util.Scanner;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {


    public static class initLogger {
    }

    private static Logger logger;

    static {
        try (FileInputStream configFile = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Loging_Merzlyakov\\src\\logger_config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(initLogger.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.log(Level.INFO, "Начало работы программы, объявление переменных");
        long m3 = 0;
        long m7 = 0;
        long m21 = 0;
        long max = 0;
        long res;
        logger.log(Level.INFO, "Ввод количества чисел: ");
        int n = scanner.nextInt();
        logger.log(Level.INFO, "Старт работы цикла с предусловием: ");
        for (int i = 1; i < n; i++) {
            int dat = scanner.nextInt();
            if (((dat % 7) == 0) && ((dat % 3) > 0) && (dat > m7)) {
                m7 = dat;
            }
            if (((dat % 3) == 0) && ((dat % 7) > 0) && (dat > m3)) {
                m3 = dat;
            }
            if (((dat % 21) == 0) && (dat > m21)) {
                if (m21 > max) {
                    max = m21;
                    m21 = dat;
                } else {
                    if (dat > max) {
                        max = dat;
                    }
                }
            }
        }
        int r = scanner.nextInt();
        if (m7 * m3 < m21 * max) {
            res = m21 * max;
        } else {
            res = m3 * m7;
        } 
    }

    public static long taskRelease(long res, long r) {
        System.out.println("Вычисленное контрольное значение:" + res);
        logger.log(Level.INFO, "Проверка значений + вариативный вывод");
        if (r == res) {
            System.out.println("Контроль пройден");
        } else System.out.println("Контроль не пройден");
        return res;
    }
}

