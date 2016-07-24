package com.dimediary.ui2jui.options;

import com.beust.jcommander.Parameter;

public class Options {

	@Parameter(names = "--help", help = true)
	private boolean help;

	@Parameter(names = { "--input-path", "-i" }, description = "path where the ui input file exists")
	private String inputPath;

	@Parameter(names = { "--xml", "-x" }, description = "xml file with the mappings for converting", required = true)
	private String mappingXmlFile;

	@Parameter(names = "--xml-path", description = "path where the xml mapping exists")
	private String mappingXmlPath;

	@Parameter(names = { "--output-path", "-o" }, description = "path to put the jui output file")
	private String outputPath;

	@Parameter(names = { "--file", "-f" }, description = "file to convert", required = true)
	private String uiFile;

	public String getInputPath() {
		return this.inputPath;
	}

	public String getMappingXmlFile() {
		return this.mappingXmlFile;
	}

	public String getMappingXmlPath() {
		return this.mappingXmlPath;
	}

	public String getOutputPath() {
		return this.outputPath;
	}

	public String getUiFile() {
		return this.uiFile;
	}

	public Boolean isHelp() {
		return this.help;
	}

}
