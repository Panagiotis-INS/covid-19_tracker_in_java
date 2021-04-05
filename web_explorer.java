import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.IOException;
public class web_explorer{
	private String url;
	private int cases;
	private int deaths;
	private final String reg_cases="Cases";
	private final String reg_deaths="Deaths";
	//
	private void scrape_cases(){
		try{
			String head=Jsoup.connect(url).get().title().split(reg_cases)[0];
			int i;
			for(i=0;i<head.split(" ").length;i++){}
			cases=Integer.parseInt(head.split(" ")[i-1].replace(",",""));
			//System.out.println(cases);
		}catch(IOException e){
			System.out.println("URL unreachable");
			System.exit(1);
		}
	}
	private void scrape_deaths(){
		try{
			String head=Jsoup.connect(url).get().title().split(reg_deaths)[0];
			int i;
			for(i=0;i<head.split(" ").length;i++){}
			deaths=Integer.parseInt(head.split(" ")[i-1].replace(",",""));
			//System.out.println(deaths);
		}catch(IOException e){
			System.out.println("URL unreachable");
			System.exit(1);
		}
	}
	//
	private void scrape_cases_n_deaths(){
		scrape_cases();
		scrape_deaths();
	}
	//
	public web_explorer(){}
	public web_explorer(String url){
		this.url=url;
		scrape_cases_n_deaths();
	}
	//
	public int get_cases(){
		scrape_cases();
		return cases;
	}
	public int get_deaths(){
		scrape_deaths();
		return deaths;
	}
	//
	public void get_real_time(){
		int tmp_case=cases;
		int tmp_death=deaths;
		System.out.println(java.time.LocalDate.now());  
		System.out.println(java.time.LocalTime.now());
		System.out.println("Covid Cases: "+cases);
		System.out.println("Covid Deaths: "+deaths);
		while(true){
			scrape_deaths();
			if(tmp_death!=deaths || tmp_case!=cases){
				System.out.println(java.time.LocalDate.now());  
				System.out.println(java.time.LocalTime.now());
				System.out.println("Covid Cases: "+cases);
				System.out.println("Covid Deaths: "+deaths);
				tmp_case=cases;
				tmp_death=deaths;
			}
		}
	}
}