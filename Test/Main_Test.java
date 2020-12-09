import org.junit.Assert;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    public static Scanner scan = new Scanner(System.in);

    @org.junit.jupiter.api.Test
    void main() {
        long res = 1;
        long r = scan.nextInt();
        long expect = Main.taskRelease(res,r);
        long actual = 4;
        Assert.assertEquals(expect, actual);
    }


}