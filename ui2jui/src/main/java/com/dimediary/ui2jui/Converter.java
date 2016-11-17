package com.dimediary.ui2jui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import com.dimediary.ui2jui.options.Options;
import com.dimediary.ui2jui.util.Mapping;
import com.dimediary.ui2jui.util.Mapping_List;

/**
 * class for converting the ui files into jui files
 *
 * @author eyota
 *
 */
public class Converter {

	/**
	 * converts the ui files into jui files
	 * 
	 * @param options
	 *            options which are given to the application
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	public void convert(final Options options)
			throws ParserConfigurationException, SAXException, IOException, JAXBException, XMLStreamException {
		final Mapping_List mapping_List = this.createMappingList(options);

		final String uiFileText = this.getUiFileText(options);

		String juiFileText = uiFileText;

		juiFileText = this.replaceAll(mapping_List.getMappings(), juiFileText, options);

		this.writeOutput(options, juiFileText);

	}

	private Mapping_List createMappingList(final Options options)
			throws FileNotFoundException, JAXBException, XMLStreamException {
		final File file = new File(Converter.getPathname(options.getMappingXmlPath(), options.getMappingXmlFile()));
		final Mapping_List mapping_List;
		mapping_List = JAXB.unmarshal(file, Mapping_List.class);
		return mapping_List;
	}

	static String getPathname(final String path, final String file) {

		if (path == null) {
			return file;
		} else {
			return path + "\\" + file;
		}

	}

	private String getUiFileText(final Options options) throws IOException {
		String uiFileText = "";
		final String pathname = Converter.getPathname(options.getInputPath(), options.getUiFile());

		FileReader fr;
		fr = new FileReader(new File(pathname));
		final BufferedReader br = new BufferedReader(fr);

		String zeile = "";

		int i = 0;
		while (true) {
			zeile = br.readLine();
			if (zeile == null) {
				break;
			}
			if (i == 0) {
				uiFileText = uiFileText + zeile;
			} else {
				uiFileText = uiFileText + "\n" + zeile;
			}
			i += 1;
		}

		br.close();

		return uiFileText;
	}

	private String replaceAll(final List<Mapping> mappings, String juiFileText, final Options options)
			throws IOException {
		final String pathname = Converter.getPathname("imports/", "Ui" + options.getUiFile().replace("jui", "txt"));
		final FileWriter fileWriter = new FileWriter(new File(pathname));
		final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		for (final Mapping mapping : mappings) {
			if (juiFileText.contains(mapping.getCpp())) {
				juiFileText = juiFileText.replaceAll(mapping.getCpp(), mapping.getJava());
				if (mapping.getImportString() != null) {
					bufferedWriter.write(mapping.getImportString() + "\n");
				}
			}
		}
		bufferedWriter.close();
		return juiFileText;
	}

	private void writeOutput(final Options options, final String juiFileText) throws IOException {
		final String pathname = Converter.getPathname(options.getOutputPath(), options.getUiFile());
		final FileWriter fileWriter = new FileWriter(new File(pathname));
		final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(juiFileText);
		bufferedWriter.close();
	}

}
