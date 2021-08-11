package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class MyServer implements Runnable {

    private static StringBuffer labelString = new StringBuffer("Server is Started .....\n");
    private static DecimalFormat df = new DecimalFormat();
    private static int counter = 0;
    private volatile boolean exit = false;
    private ServerSocket serverSocket;
    Thread thread;

    public MyServer() {
        thread = new Thread(this);
        thread.start();
    }

    static synchronized void appendString(double radius, double area) {
        counter = counter + 1;
        String radiusStr = df.format(radius);
        String areaStr = df.format(area);
        String str = "\nClient " + counter + " :\t\tRadius = " + radiusStr + "\t\tArea = " + areaStr;
        labelString.append(str);
    }

    static String getLabelString() {
        return labelString.toString();
    }

    public void run() {

        try {

            serverSocket = new ServerSocket(9999);
            Socket socket;

            while (!exit) {
                socket = serverSocket.accept();
                new ServerThread(socket);
            }

        } catch (IOException e) {
            System.out.println("Some Error is Occured In My Server .....");
        }

    }

    public void stop() {
        exit = true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.exit(1);
    }

}
