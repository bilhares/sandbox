package com.example.demo.outros;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class StampPageXofY {
	
  	public static final String SRC = "/temp/pdfDiretoria.pdf";
    public static final String DEST = "/temp/pdfDiretoriaPaginado.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
    	ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
    	PdfReader reader = new PdfReader(SRC);
    	
    	PdfStamper stamper = new PdfStamper(reader, baos2);
        stamper.close();
        reader.close();
        
    	byte[] baos3 =  paginarPDF(baos2.toByteArray());
    	
 	    FileOutputStream fos = new FileOutputStream("/temp/testePaginacao.pdf");
		fos.write(baos3);
		fos.close();
		System.out.println("2");
    	
    	//System.console(baos3);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new StampPageXofY().manipulatePdf(SRC, DEST);
    }
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        //PdfStamper stamper = new PdfStamper(reader, new  FileOutputStream(dest));
        ByteArrayOutputStream boas = new ByteArrayOutputStream(); 
        PdfStamper stamper = new PdfStamper(reader, boas);
        
        PdfContentByte pagecontent;
        for (int i = 0; i < n; ) {
            pagecontent = stamper.getOverContent(++i);
            ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT,
                    new Phrase(String.format("p�gina %s / %s", i, n)), 120, 40, 0);
        }
        stamper.close();
        reader.close();
    }
    
    public static byte[] paginarPDF(byte[] pdfs) throws IOException, DocumentException {
    	
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        
	        PdfReader reader = new PdfReader(pdfs);
            int n = reader.getNumberOfPages();
            //PdfStamper stamper = new PdfStamper(reader, new  FileOutputStream(dest));
            PdfStamper stamper = new PdfStamper(reader, boas);
        
            PdfContentByte pagecontent;
            for (int i = 0; i < n; ) {
            	pagecontent = stamper.getOverContent(++i);
            	ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT,
            			new Phrase(String.format("p�gina %s / %s", i, n)), 120, 40, 0);
            }
            stamper.close();
            reader.close();
            return boas.toByteArray();
		
    }
}
