package com.ufes.log;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ufes.service.UsuarioLogadoService;

public class XMLLog implements Ilog {
    @Override
    public void escrever(String nomeUsuario, String data, String hora, int idPedido, String operacao, String nomeCliente) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            java.io.File file = new java.io.File("log.xml");
            if (file.exists()) {
                doc = builder.parse(file);
            } else {
                doc = builder.newDocument();
                Element root = doc.createElement("logs");
                doc.appendChild(root);
            }

            Element root = doc.getDocumentElement();

            Element log = doc.createElement("log");

            Element usuario = doc.createElement("nomeUsuario");
            usuario.appendChild(doc.createTextNode(nomeUsuario));
            log.appendChild(usuario);

            Element dataElem = doc.createElement("data");
            dataElem.appendChild(doc.createTextNode(data));
            log.appendChild(dataElem);

            Element horaElem = doc.createElement("hora");
            horaElem.appendChild(doc.createTextNode(hora));
            log.appendChild(horaElem);

            Element pedidoElem = doc.createElement("idPedido");
            pedidoElem.appendChild(doc.createTextNode(String.valueOf(idPedido)));
            log.appendChild(pedidoElem);

            Element operacaoElem = doc.createElement("operacao");
            operacaoElem.appendChild(doc.createTextNode(operacao));
            log.appendChild(operacaoElem);

            Element clienteElem = doc.createElement("nomeCliente");
            clienteElem.appendChild(doc.createTextNode(nomeCliente));
            log.appendChild(clienteElem);

            root.appendChild(log);

            try (FileWriter writer = new FileWriter("log.xml")) {
                javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
                javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
                transformer.transform(source, result);
            }

        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | javax.xml.transform.TransformerException e) {
            System.err.println("Erro ao escrever no arquivo XML: " + e.getMessage());
        }
    }
}
