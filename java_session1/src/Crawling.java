import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawling {
    private static String getStockHeader(Document document) {
        Elements stockTableBody = document.select("table.type_2 thead tr");
        StringBuilder builder = new StringBuilder();

        for(Element element : stockTableBody){
            for(Element td : element.select("th")){
                builder.append(td.text());
                builder.append("  ");
            }
        }
        return builder.toString();
    }
    private static String getStockList(Document document) {
        Elements stockTableBody = document.select("table.type_2 tbody tr");
        StringBuilder builder = new StringBuilder();

        for(Element element : stockTableBody){
            for(Element td : element.select("td")){
                String text = "";
                if(td.select(".center a").attr("href").isEmpty()){
                    text = td.text();
                }
                else{
                    text = "https://finance.naver.com" + td.select(".center a").attr("href");
                }
                builder.append(text);
                builder.append("  ");
            }
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Connection connection = Jsoup.connect(stockList);
        
        try{
            Document document = connection.get();
            String thead = getStockHeader(document);
            System.out.println(thead);

            String tbody = getStockList(document);
            System.out.println(tbody);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
