package me.MiniDigger.RideThaMob.nms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.bukkit.entity.EntityType;

import me.MiniDigger.RideThaMob.RideThaMob;

public class GenClasses {
	private static final File orig = new File(
			"Z:/Dev/bukkit-ws/RideThaMob/src/main/java/me/MiniDigger/RideThaMob/nms/RideAbleEntity.java");
	private static final File f = new File("Z:/Dev/bukkit-ws/RideThaMob/src/main/java/me/MiniDigger/RideThaMob/nms/");

	public static void main(String[] args) throws IOException {
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
			w.println(s.nextLine().replaceAll("RideAbleEntity", file.getName().replace(".java", ""))
					.replaceAll("%date%", new SimpleDateFormat().format(new Date())));
		}

		w.close();
		s.close();
	}
}
