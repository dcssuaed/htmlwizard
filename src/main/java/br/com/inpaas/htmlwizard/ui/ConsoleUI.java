package br.com.inpaas.htmlwizard.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import br.com.inpaas.htmlwizard.converter.ConversionException;
import br.com.inpaas.htmlwizard.converter.Converter;
import br.com.inpaas.htmlwizard.converter.ConverterFactory;

public class ConsoleUI {

	public static void main(String[] args) throws ConversionException {
		if(args.length < 2) throw new ConversionException("Invalid arguments list", null);
		
		String inFile = args[0];
		String ouFile = args[1];
		String type = "pdf";
		if(args.length > 2) type = args[2];
		
		try {
			System.out.println(String.format("Converting the file '%s' to '%s'", inFile, type.toUpperCase()));
			
			Converter converter = ConverterFactory.getByTargetType(type);
			converter.convert(new FileInputStream(new File(inFile)), new FileOutputStream(new File(ouFile)));
			
			System.out.println(String.format("%s generated at '%s'", type.toUpperCase(), ouFile));
			
		} catch(Exception e) {
			throw new ConversionException(e);
			
		}
	}
	
}
