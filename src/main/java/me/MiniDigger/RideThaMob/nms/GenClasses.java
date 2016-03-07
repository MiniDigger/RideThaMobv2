package me.MiniDigger.RideThaMob.nms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GenClasses {
	private static final File f = new File("src/main/java/me/MiniDigger/RideThaMob/nms/");
	private static final File orig = new File(f, "RideAbleEntity.java");
	
	public static void main(String[] args) throws IOException {
		System.out.println(f.getAbsolutePath());
		for (File d : f.listFiles()) {
			if (d.getName().startsWith("RideAble")) {
				if (!d.getName().contains("Entity")) {
					try {
						System.out.println("do stuff " + d.getName());
						doStuff(d);
					} catch (Exception e) {
						System.out.println("error " + e.getMessage());
						continue;
					}
				}
			}
		}
	}
	
	private static void doStuff(File file) throws FileNotFoundException {
		Scanner s = new Scanner(orig);
		PrintWriter w = new PrintWriter(file);
		
		while (s.hasNextLine()) {
			w.println(s.nextLine().replaceAll("EntitySkeleton", "Entity" + file.getName().replace(".java", "").replaceAll("RideAble", ""))
					.replaceAll("RideAbleEntity", file.getName().replace(".java", "")).replaceAll("%date%", new SimpleDateFormat().format(new Date())));
		}
		
		w.close();
		s.close();
	}
}
