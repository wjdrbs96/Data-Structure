package Data_Structure.트리.BST.School.탐색과제.B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RBTest {
    public static void main(String[] args) {
        String frame = "C:\\Java\\src\\Data_Structure\\트리\\BST\\School\\탐색과제\\B\\CARRIERS.txt";
        BufferedReader in = null;
        String line;
        RBT<String, String> rbt = new RBT<>();

        try {
            in = new BufferedReader(new FileReader(frame));
            while ((line = in.readLine()) != null) {
                String[] vs = new String[2];
                vs = line.split("\t");
                rbt.insert(vs[0], vs[1]);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Error");
            System.exit(1);
        }
        ;
        System.out.println("Height of the BST : " + rbt.height());
        System.out.println("Key of the root node : " + rbt.getRootKey());

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) {
            System.out.print("Enter your search key : ");
            String search_key = input.next();
            if (rbt.search(search_key) == null) {
                System.out.println("No such key!");
            }
            else {
                System.out.println("=> " + rbt.getValue(rbt.search(search_key)));
            }
        }

        input.close();
    }
}
