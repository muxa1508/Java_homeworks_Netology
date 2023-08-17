package org.example;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.File;
import java.io.IOException;


public class XMLSettings {

    protected boolean loadEnabled;
    protected String loadFileName;
    protected String loadFileFormat;
    protected boolean saveEnabled;
    protected String saveFileName;
    protected String saveFileFormat;
    protected boolean logEnabled;
    protected String logFileName;

    public void checkSettingsXML(File settingsFile) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(settingsFile);
            Node root = document.getDocumentElement();

            read(root);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private void read(Node root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() != Node.TEXT_NODE) {
                NodeList props = currentNode.getChildNodes();
                for (int j = 0; j < props.getLength(); j++) {
                    Node prop = props.item(j);
                    if (prop.getNodeType() != Node.TEXT_NODE) {

                        if (currentNode.getNodeName().equals("load")) {
                            if (prop.getNodeName().equals("enabled")) {
                                this.loadEnabled = Boolean.parseBoolean(prop.getTextContent());
                            }
                            if (prop.getNodeName().equals("fileName")) {
                                this.loadFileName = prop.getTextContent();
                            }
                            if (prop.getNodeName().equals("format")) {
                                this.loadFileFormat = prop.getTextContent();
                            }
                        }

                        if (currentNode.getNodeName().equals("save")) {
                            if (prop.getNodeName().equals("enabled")) {
                                this.saveEnabled = Boolean.parseBoolean(prop.getTextContent());
                            }
                            if (prop.getNodeName().equals("fileName")) {
                                this.saveFileName = prop.getTextContent();
                            }
                            if (prop.getNodeName().equals("format")) {
                                this.saveFileFormat = prop.getTextContent();
                            }
                        }

                        if (currentNode.getNodeName().equals("log")) {
                            if (prop.getNodeName().equals("enabled")) {
                                this.logEnabled = Boolean.parseBoolean(prop.getTextContent());
                            }
                            if (prop.getNodeName().equals("fileName")) {
                                this.logFileName = prop.getTextContent();
                            }
                        }


                    }
                }
            }
        }
    }

    public boolean isLoadEnabled() {
        return loadEnabled;
    }

    public String getLoadFileName() {
        return loadFileName;
    }

    public String getLoadFileFormat() {
        return loadFileFormat;
    }

    public boolean isSaveEnabled() {
        return saveEnabled;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public String getSaveFileFormat() {
        return saveFileFormat;
    }

    public boolean isLogEnabled() {
        return logEnabled;
    }

    public String getLogFileName() {
        return logFileName;
    }
}
