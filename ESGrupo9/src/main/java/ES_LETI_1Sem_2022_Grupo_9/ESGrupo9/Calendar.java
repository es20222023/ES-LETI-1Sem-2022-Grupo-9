package ES_LETI_1Sem_2022_Grupo_9.ESGrupo9;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;


public class Calendar {

	public static void getCalendar() throws Exception {
//		FileWriter f = new File("calendar.json");
//		 PrintStream o = new PrintStream(f);
		URL calendarURL = new URL("https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=imsro@iscte.pt&password=aXWvsniEJIyWHxKZ4X4VMovKuXhJEAt7j1u450VOnlnp28QCJIhhwZWCaIP4CWrOGFpden1pjFDY3qQjO549FL3EMNv3lEpXQopNsMJdHdlkIAkGSFmnbYV0LD4Dziwg");
		URLConnection URL = calendarURL.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(URL.getInputStream()));
		File file = new File("JSONCalendar/" + "Calendar"+ ".json");
		String inputLine;
		FileWriter fileWriter = new FileWriter(file,false);
		while ((inputLine = br.readLine()) != null) {
			fileWriter.write(new Gson().toJson(inputLine) + "\n");
			//System.out.println(inputLine);
	}
		fileWriter.close();
		br.close();
		System.out.println("JA ACABEI");
	}
	
	public static void main(String[] args) throws Exception {
        getCalendar();
    }




}