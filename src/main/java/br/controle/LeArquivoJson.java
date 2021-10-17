package br.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeArquivoJson {

    private static final String URL_JSON = "./carros.json";

    public String readFile() throws IOException{
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(URL_JSON)){
            if(is == null){
                throw new IllegalArgumentException("File not found");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer buffer = new StringBuffer();

            String line = null;

            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();
        }
    }
}
