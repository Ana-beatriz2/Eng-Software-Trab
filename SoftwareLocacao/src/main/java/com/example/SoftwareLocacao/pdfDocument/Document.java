package com.example.SoftwareLocacao.pdfDocument;

import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Document {
    public Document(String nomeComprador, String dataRetirada, String dataDevolucao, String grupoCarro, float valor, String nomeMotorista){
        com.lowagie.text.Document document = new com.lowagie.text.Document();

        String identificador = GeradorNumeros();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Ana\\Downloads\\SoftwareLocacao\\" +
                    "SoftwareLocacao\\src\\main\\java\\com\\example\\SoftwareLocacao\\pdfDocument\\" + identificador + "_DocumentoFiscal"
                    + nomeComprador +  ".pdf"));

            document.open();

            Paragraph linha = new Paragraph("------------------------------------------------------------------------------");
            linha.setAlignment(Element.ALIGN_CENTER);

            document.add(linha);
            Paragraph paragrafoTitulo = new Paragraph();
            paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
            paragrafoTitulo.add(new Chunk("DOCUMENTO FISCAL - Você Aluga", new Font(Font.HELVETICA)));

            document.add(paragrafoTitulo);
            document.add(linha);
            document.add(new Paragraph("   "));

            Paragraph paragrafoNomeComprador = new Paragraph("Nome do cliente: " + nomeComprador);

            document.add(paragrafoNomeComprador);
            document.add(new Paragraph(" "));

            Paragraph paragrafoNomeMotorista = new Paragraph("Nome do motorista: " + nomeMotorista);

            document.add(paragrafoNomeMotorista);
            document.add(new Paragraph(" "));

            Paragraph paragrafoDataRetirada = new Paragraph("Data de retirada do carro: " + dataRetirada);

            document.add(paragrafoDataRetirada);
            document.add(new Paragraph(" "));

            Paragraph paragrafoDataDevolucao = new Paragraph("Data de devolução do carro: " + dataDevolucao);

            document.add(paragrafoDataDevolucao);
            document.add(new Paragraph(" "));

            Paragraph paragrafoDataGrupo = new Paragraph("Grupo do carro: " + grupoCarro);

            document.add(paragrafoDataGrupo);
            document.add(new Paragraph(" "));

            Paragraph paragrafoValor = new Paragraph("Valor por dia da locação: " + valor);

            document.add(paragrafoValor);
            //document.add(new Paragraph(" "));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        document.close();
    }

    public String GeradorNumeros(){
        Random gerador = new Random();
        String numero = "";
        int conversao;

        for (int i = 0; i < 5; i++) {
            conversao = gerador.nextInt(10);
            numero += Integer.toString(conversao);
        }

        return numero;
    }
}
