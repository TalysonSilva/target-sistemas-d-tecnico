package app.quest03;

/*
Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa,
na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser
ignorados no cálculo da média;
 */

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class Quest03 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            Reader reader =  new FileReader(    "D:\\Desafio-Tecnico\\target-sistemas-tecnico\\src\\main\\java\\\\app\\quest03\\faturamento.json");
            JsonObject json = gson.fromJson(reader, JsonElement.class).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("faturamento");

            List<Double> faturamento = new ArrayList<>();

            double minValor = Double.MAX_VALUE;
            double maxValor = Double.MIN_VALUE;
            double soma = 0;

            for (int i = 0; i <jsonArray.size(); i++){

                JsonObject dia = jsonArray.get(i).getAsJsonObject();
                double valor = dia.get("valor").getAsDouble();

                if (valor > 0) {
                    faturamento.add(valor);
                    soma += valor;

                    if (valor < minValor) {
                        minValor = valor;
                    }

                    if (valor > maxValor) {
                        maxValor = valor;
                    }

                }
            }

            //Média mensal
            double media = soma / faturamento.size();

            // Contagem de dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (double valor : faturamento) {
                if (valor > media) {
                    diasAcimaDaMedia += 1;
                }
            }

            // resultados
            System.out.println("Menor valor do faturamento: " + minValor);
            System.out.println("Maior valor de faturamento: " + maxValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        }catch (IOException e) { e.printStackTrace(); }


    }
}
