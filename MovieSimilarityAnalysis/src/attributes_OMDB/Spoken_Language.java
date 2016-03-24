package attributes_OMDB;

public class Spoken_Language extends Metric {

	public String spokenLangName;
	public int spokenLang_iso_639_1;
	
    public Spoken_Language(String slName, int slIso) {
    	spokenLangName = slName;
    	spokenLang_iso_639_1 = slIso;
    }
    
    public void setSpokenLanguage(String slName){
		spokenLangName = slName;
	}
	
    public String getSpokenLanguage(){
		return spokenLangName;
	}
	
    public void setSpokenLanguageID(int slIso){
		spokenLang_iso_639_1 = slIso;
	}
	
    public int getSpokenLanguageID(){
		return spokenLang_iso_639_1;
	}
}
