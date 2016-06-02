package br.com.inpaas.htmlwizard.converter;

import java.io.InputStream;
import java.io.OutputStream;

import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;

public class DOCXConverter implements Converter {

	@Override
	public void convert(InputStream is, OutputStream os) throws ConversionException {

		try {
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

			NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
			wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
			ndp.unmarshalDefaultNumbering();

			XHTMLImporterImpl xHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
			xHTMLImporter.setHyperlinkStyle("Hyperlink");
			wordMLPackage.getMainDocumentPart().getContent()
					.addAll(xHTMLImporter.convert(is, null));

			wordMLPackage.save(os);
		}

		catch (Exception e) {
			throw new ConversionException(e);
		}

	}

}
