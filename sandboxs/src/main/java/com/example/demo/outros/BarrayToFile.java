package com.example.demo.outros;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BarrayToFile {

	public static void main(String[] args) throws Exception {

		System.out.println("A");
		try (Connection cnWorkflow = DriverManager.getConnection(
				"url", "user", "pass")) {

			String sql = "SELECT Anexo from  tabela imagem where reg = reg and outro = outro";

			try (PreparedStatement pstConsultaAux1 = cnWorkflow.prepareStatement(sql)) {

//				pstConsultaAux1.setInt(1, 10);
				ResultSet rsConsultaAux1 = pstConsultaAux1.executeQuery();

				if (rsConsultaAux1.next()) {

					System.out.println("1");
					Blob blob = rsConsultaAux1.getBlob("imagem em bytearr");

					int blobLength = (int) blob.length();
					byte[] blobAsBytes = blob.getBytes(1, blobLength);

					FileOutputStream fos = new FileOutputStream("c://temp//teste8.pdf");
					fos.write(blobAsBytes);
					fos.close();
					System.out.println("2");
				}

			}
		}
	}

}
