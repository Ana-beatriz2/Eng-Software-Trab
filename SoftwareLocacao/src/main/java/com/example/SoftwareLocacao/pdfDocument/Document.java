package com.example.SoftwareLocacao.pdfDocument;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Document {
    public Document(String nomeComprador, String dataRetirada, String dataDevolucao){
        com.lowagie.text.Document document = new com.lowagie.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Ana\\Downloads\\SoftwareLocacao\\SoftwareLocacao\\src\\main\\java\\com\\example\\SoftwareLocacao\\pdfDocument\\DocumentoFiscal.pdf"));

            document.open();

            Paragraph paragrafoNomeComprador = new Paragraph("Nome do comprador: " + nomeComprador);

            document.add(paragrafoNomeComprador);
            document.add(new Paragraph(" "));

            Paragraph paragrafoDataRetirada = new Paragraph(dataRetirada);

            document.add(paragrafoDataRetirada);
            document.add(new Paragraph(" "));

            Paragraph paragrafoDataDevolucao = new Paragraph(dataDevolucao);

            document.add(paragrafoDataDevolucao);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        document.close();
    }
}
