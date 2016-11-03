package com.dimediary.ui2jui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.dimediary.ui2jui.options.Options;

public class ImportManager {

	public void manageImports(final Options options) throws IOException {

		final String javaImports = this.readImports(options);
		final String javaCode = this.readJavaCode(options, javaImports);

		this.writeCode(options, javaCode);

	}

	private void writeCode(final Options options, final String javaCodeNew) throws IOException {
		final String pathname = Converter.getPathname(options.getJavaPath(), options.getJavaFile());
		final FileWriter fileWriter = new FileWriter(new File(pathname));
		final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(javaCodeNew);
		bufferedWriter.close();
	}

	private String readImports(final Options options) throws IOException {
		return this.readFile("imports/", options.getJavaFile().replace("java", "txt"));
	}

	private String readJavaCode(final Options options, final String javaImports)
			throws FileNotFoundException, IOException {
		final String pathname = Converter.getPathname(options.getJavaPath(), options.getJavaFile());
		String text = "";
		FileReader fr;
		fr = new FileReader(new File(pathname));
		final BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		int i = 0;
		boolean found = false;
		while (true) {
			zeile = br.readLine();
			if (zeile == null) {
				break;
			}
			if (i == 0) {
				text = text + zeile;
			} else {
				if (!found && zeile.contains("package")) {
					found = true;
					text = text + "\n" + zeile;
					text = text + "\n" + javaImports + "\n";
				} else {
					text = text + "\n" + zeile;
				}
			}
			i += 1;
		}
		text = text + "\n";
		br.close();
		return text;
	}

	private String readFile(final String pathname, final String fileName) throws FileNotFoundException, IOException {
		String text = "";
		FileReader fr;
		final File dir = new File(pathname);
		final File[] files = dir.listFiles();

		for (final File file : files) {
			final String actualName = file.getName();
			if (actualName.equalsIgnoreCase(fileName)) {
				fr = new FileReader(file);
				final BufferedReader br = new BufferedReader(fr);
				String line = "";

				final ArrayList<String> lines = new ArrayList<>();
				int i = 0;
				while (true) {
					line = br.readLine();
					if (line == null) {
						break;
					}

					boolean included = false;
					for (final String string : lines) {
						if (string.equals(line)) {
							included = true;
						}
					}
					if (included) {
						continue;
					}

					if (i == 0) {
						text = text + line;
					} else {
						text = text + "\n" + line;
					}
					lines.add(line);
					i += 1;
				}
				text = text + "\n";
				br.close();
				break;
			}
		}

		return text;
	}

}
