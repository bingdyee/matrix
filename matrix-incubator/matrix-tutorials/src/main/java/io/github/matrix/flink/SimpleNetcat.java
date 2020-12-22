package io.github.matrix.flink;

import com.google.common.base.Strings;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Noa Swartz
 * @date 2020/12/22
 */
public class SimpleNetcat {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String line;
        while(true) {
            System.out.print("> ");
            if (!Strings.isNullOrEmpty(line = scanner.nextLine())) {
                out.writeUTF(line + "\n");
                out.flush();
            }
        }
    }

}
