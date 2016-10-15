package com.dimediary.ui2jui;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import com.beust.jcommander.JCommander;
import com.dimediary.ui2jui.options.Options;

public class Ui2Jui {

	public static void main(final String[] args)
			throws ParserConfigurationException, SAXException, IOException, JAXBException, XMLStreamException {
		final Options options = new Options();
		final JCommander jCommander = new JCommander(options, args);
		if (options.isHelp()) {
			jCommander.usage();
		}

		if (options.getJavaFile() != null && options.getJavaPath() != null) {
			final ImportManager manager = new ImportManager();
			manager.manageImports(options);
		} else if (options.getUiFile() != null) {
			final Converter converter = new Converter();
			converter.convert(options);
		}

	}

}
