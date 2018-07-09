package com.example.demo.outros;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;


public class ItextMerge {
	public static void main(String[] args) throws Exception {
		List<InputStream> list = new ArrayList<InputStream>();
		List<byte[]> pdfs = getImages();
		try {
			// Source pdfs
			list.add(new FileInputStream(new File("/temp/1.pdf")));
			list.add(new FileInputStream(new File("/temp/2.pdf")));
			list.add(new FileInputStream(new File("/temp/3.pdf")));
			list.add(new FileInputStream(new File("/temp/4.pdf")));
			list.add(new FileInputStream(new File("/temp/5.pdf")));

			// Resulting pdf
			OutputStream out = new FileOutputStream(new File("/temp/result.pdf"));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			//doMerge(list, out);
			doMerge(pdfs, out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Merge multiple pdf into one pdf
	 * 
	 * @param pdfs
	 *            of pdf input stream
	 * @param outputStream
	 *            output file output stream
	 * @throws DocumentException
	 * @throws IOException
	 */
//	public static void doMerge(List<InputStream> list, OutputStream outputStream)
//			throws DocumentException, IOException {
//		Document document = new Document();
//		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
//		document.open();
//		PdfContentByte cb = writer.getDirectContent();
//
//		for (InputStream in : list) {
//			PdfReader reader = new PdfReader(in);
//			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
//				document.newPage();
//				// import the page from source pdf
//				PdfImportedPage page = writer.getImportedPage(reader, i);
//				// add the page to the destination pdf
//				cb.addTemplate(page, 0, 0);
//			}
//		}
//
//		outputStream.flush();
//		document.close();
//		outputStream.close();
//	}
	public static void doMerge(List<byte[]> pdfs, OutputStream outputStream)
			throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		
		for (byte[] in : pdfs) {
			PdfReader reader = new PdfReader(in);
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				document.newPage();
				// import the page from source pdf
				PdfImportedPage page = writer.getImportedPage(reader, i);
				// add the page to the destination pdf
				cb.addTemplate(page, 0, 0);
			}
		}
		//byte[] bytesPdf = outputStream.toByteArray();
		//System.out.println(bytesPdf.toString());
		outputStream.flush();
		document.close();
		outputStream.close();
	}
	
	public static List<byte[]> getImages() throws Exception{
		List<byte[]> retorno = new ArrayList<>();
		System.out.println("A");
		try (Connection cnWorkflow = DriverManager.getConnection(
				"", "", "")) {

			 String sql = "SELECT top 5 * FROM ";
		
			try (PreparedStatement pstConsultaAux1 = cnWorkflow.prepareStatement(sql)) {

				//pstConsultaAux1.setInt(1, 10);
				ResultSet rsConsultaAux1 = pstConsultaAux1.executeQuery();

				while(rsConsultaAux1.next()) {

					 System.out.println("1");
					 Blob blob = rsConsultaAux1.getBlob("");
					
					 int blobLength = (int) blob.length();
					 byte[] blobAsBytes = blob.getBytes(1, blobLength);
					
					 retorno.add(blobAsBytes);
					
//					 FileOutputStream fos = new
//					 FileOutputStream("c:\\temp\\teste23.pdf");
//					 fos.write(blobAsBytes);
//					 fos.close();
//					 System.out.println("2");
				}

			}
		}
		System.out.println(retorno.size()+" tamanho");
		return retorno;
	}
}
