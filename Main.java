public class Main{
	public static void main(String[] args) {
		String url="https://www.worldometers.info/coronavirus/";
		web_explorer webex=new web_explorer(url);
		webex.get_real_time();
	}
}