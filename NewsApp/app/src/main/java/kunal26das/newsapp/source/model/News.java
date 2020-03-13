package kunal26das.newsapp.source.model;

import com.google.gson.annotations.SerializedName;

public class News {

	@SerializedName("sectionName")
	private String sectionName;

	@SerializedName("pillarName")
	private String pillarName;

	@SerializedName("webPublicationDate")
	private String webPublicationDate;

	@SerializedName("apiUrl")
	private String apiUrl;

	@SerializedName("webUrl")
	private String webUrl;

	@SerializedName("isHosted")
	private boolean isHosted;

	@SerializedName("pillarId")
	private String pillarId;

	@SerializedName("webTitle")
	private String webTitle;

	@SerializedName("id")
	private String id;

	@SerializedName("sectionId")
	private String sectionId;

	@SerializedName("type")
	private String type;

	public void setSectionName(String sectionName){
		this.sectionName = sectionName;
	}

	public String getSectionName(){
		return sectionName;
	}

	public void setPillarName(String pillarName){
		this.pillarName = pillarName;
	}

	public String getPillarName(){
		return pillarName;
	}

	public void setWebPublicationDate(String webPublicationDate){
		this.webPublicationDate = webPublicationDate;
	}

	public String getWebPublicationDate(){
		return webPublicationDate;
	}

	public void setApiUrl(String apiUrl){
		this.apiUrl = apiUrl;
	}

	public String getApiUrl(){
		return apiUrl;
	}

	public void setWebUrl(String webUrl){
		this.webUrl = webUrl;
	}

	public String getWebUrl(){
		return webUrl;
	}

	public void setIsHosted(boolean isHosted){
		this.isHosted = isHosted;
	}

	public boolean isIsHosted(){
		return isHosted;
	}

	public void setPillarId(String pillarId){
		this.pillarId = pillarId;
	}

	public String getPillarId(){
		return pillarId;
	}

	public void setWebTitle(String webTitle){
		this.webTitle = webTitle;
	}

	public String getWebTitle(){
		return webTitle;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setSectionId(String sectionId){
		this.sectionId = sectionId;
	}

	public String getSectionId(){
		return sectionId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"sectionName = '" + sectionName + '\'' + 
			",pillarName = '" + pillarName + '\'' + 
			",webPublicationDate = '" + webPublicationDate + '\'' + 
			",apiUrl = '" + apiUrl + '\'' + 
			",webUrl = '" + webUrl + '\'' + 
			",isHosted = '" + isHosted + '\'' + 
			",pillarId = '" + pillarId + '\'' + 
			",webTitle = '" + webTitle + '\'' + 
			",id = '" + id + '\'' + 
			",sectionId = '" + sectionId + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}