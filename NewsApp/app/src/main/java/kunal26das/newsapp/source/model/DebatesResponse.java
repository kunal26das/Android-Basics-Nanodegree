package kunal26das.newsapp.source.model;

import com.google.gson.annotations.SerializedName;

public class DebatesResponse {

	@SerializedName("response")
	private NewsResponse newsResponse;

	public void setNewsResponse(NewsResponse newsResponse){
		this.newsResponse = newsResponse;
	}

	public NewsResponse getNewsResponse(){
		return newsResponse;
	}

	@Override
 	public String toString(){
		return 
			"NewsResponse{" + 
			"response = '" + newsResponse + '\'' +
			"}";
		}
}