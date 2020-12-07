//package fileproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class ReadWriteAppendFile {

	public static void main(String[] args) throws IOException {
		File file;
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		BufferedReader br = null;

		Scanner scan;
		while (true) {
			System.out.println("");
			System.out.println("Please write 'exit' if you want to exit, or any other key to continue");
			System.out.println("Each time you continue, a new line will added to our file and you can see the result");
			scan = new Scanner(System.in);
			if (scan.next().equals("exit")) {
				System.out.println("DONE");

				fw.close();
				bw.close();
				fr.close();
				br.close();

				return;
			}
			try {
				file = new File("sample.txt");
				if (!file.exists()) {
					System.out.println("A new file named 'sample.txt' is created");
					file.createNewFile();
				}

				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				String newSentence = "This is a new line that just added to our file\n";
				bw.write(newSentence);
				bw.close();
				System.out.println("A new line is added to our file");
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				System.out.println("The context of the file is: ");
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
				br.close();
				System.out.println("-------------------------");

			} catch (FileNotFoundException e) {
                System.out.println("Error happend");
			} catch (IOException e) {
                System.out.println("Error happend");
			}

		}

	}

}
